package com.github.plaskowski.findimmutablesusagesplugin

import com.github.plaskowski.findimmutablesusagesplugin.ImmutablesOrgLibrary.findImmutableImplementations
import com.intellij.find.findUsages.JavaFindUsagesHandler
import com.intellij.find.findUsages.JavaFindUsagesHandlerFactory
import com.intellij.psi.PsiElement

class ImmutablePropertyFindUsagesHandler(
    private val property: ImmutablesOrgProperty,
    factory: JavaFindUsagesHandlerFactory,
) : JavaFindUsagesHandler(property.propertyGetterInDefinition, factory) {

    override fun getSecondaryElements(): Array<PsiElement> {
        return findImmutableImplementations(property)
            .flatMap { o -> findModifiers(o) }
            .toTypedArray()
    }

    private fun findModifiers(immutableClass: ImmutablesOrgGeneratedImplementationClass): List<PsiElement> {
        val builderClass = immutableClass.findBuilderClass()
        val builderMethods = builderClass?.findMethodsRelatedToProperty(property).orEmpty()
        val witherMethods = immutableClass.findWitherMethodsForProperty(property)
        return builderMethods + witherMethods
    }
}
