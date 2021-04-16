package com.github.plaskowski.findimmutablesusagesplugin

import com.github.plaskowski.findimmutablesusagesplugin.ImmutablesOrgLibrary.findImmutableImplementations
import com.intellij.find.findUsages.JavaFindUsagesHandler
import com.intellij.find.findUsages.JavaFindUsagesHandlerFactory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import org.jetbrains.annotations.NotNull

class ImmutablePropertyFindUsagesHandler(
    element: PsiElement,
    factory: JavaFindUsagesHandlerFactory,
) : JavaFindUsagesHandler(element, factory) {

    private val property = ImmutablesOrgLibrary.parseImmutableProperty(element as @NotNull PsiMethod)

    override fun getSecondaryElements(): Array<PsiElement> {
        return findImmutableImplementations(property)
            .flatMap { o -> findModifiers(o) }
            .toTypedArray()
    }

    private fun findModifiers(immutableClass: ImmutablesOrgGeneratedImplementationClass): List<PsiElement> {
        val builderClass = immutableClass.findBuilderClass()
        val builderMethods = builderClass?.findMutatorsForProperty(property).orEmpty()
        val witherMethods = immutableClass.findWitherMethodsForProperty(property)
        return builderMethods + witherMethods
    }

    object Tester {
        fun isValidCandidate(element: PsiElement): Boolean {
            return element is PsiMethod && element.containingClass != null && element.parameterList.isEmpty
        }
    }
}
