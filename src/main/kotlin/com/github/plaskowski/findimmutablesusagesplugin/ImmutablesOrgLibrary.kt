package com.github.plaskowski.findimmutablesusagesplugin

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiMethod
import com.intellij.psi.impl.source.PsiClassReferenceType
import com.intellij.psi.search.searches.ClassInheritorsSearch

object ImmutablesOrgLibrary {

    fun parseImmutableProperty(propertyGetterInDefinition: PsiMethod): ImmutablesOrgProperty {
        return ImmutablesOrgProperty(propertyGetterInDefinition)
    }

    fun findImmutableImplementations(property: ImmutablesOrgProperty): Iterable<ImmutablesOrgGeneratedImplementationClass> {
        val definitionClass = property.definitionClass
        val candidates = listOf(definitionClass) + ClassInheritorsSearch.search(definitionClass, false)
        return candidates
            .filter { psiClass -> psiClass.getAnnotation("org.immutables.value.Value.Immutable") != null }
            .flatMap { annotatedClass -> ClassInheritorsSearch.search(annotatedClass, false) }
            .filter { subClass -> subClass.getAnnotation("org.immutables.value.Generated") != null }
            .map { ImmutablesOrgGeneratedImplementationClass(it) }
    }
}

class ImmutablesOrgProperty(val propertyGetterInDefinition: PsiMethod) {
    val name = propertyGetterInDefinition.name.replace("get", "").decapitalize()
    val definitionClass: PsiClass = propertyGetterInDefinition.containingClass!!
}

class ImmutablesOrgGeneratedImplementationClass(private val implementationClass: PsiClass) {

    fun findBuilderClass(): ImmutablesOrgBuilderClass? {
        return implementationClass.methods
            .filter { psiMethod -> psiMethod.name == "builder" }
            .map { psiMethod -> psiMethod.returnType }
            .filterIsInstance<PsiClassReferenceType>()
            .map { psiClassReferenceType -> psiClassReferenceType.resolve() }
            .firstOrNull()
            ?.let { ImmutablesOrgBuilderClass(it) }
    }

    fun findWitherMethodsForProperty(property: ImmutablesOrgProperty): List<PsiMethod> {
        return implementationClass.allMethods
            .filter { psiMethod -> !psiMethod.parameterList.isEmpty }
            .filter { psiMethod -> psiMethod.name.contains(property.name, true) }
            .filter { psiMethod -> psiMethod != property.propertyGetterInDefinition }
    }
}

class ImmutablesOrgBuilderClass(private val builderClass: PsiClass) {

    fun findMethodsRelatedToProperty(property: ImmutablesOrgProperty): List<PsiMethod> {
        return builderClass.methods
            ?.filter { psiMethod -> psiMethod.name.contains(property.name, true) }
            .orEmpty()
    }
}
