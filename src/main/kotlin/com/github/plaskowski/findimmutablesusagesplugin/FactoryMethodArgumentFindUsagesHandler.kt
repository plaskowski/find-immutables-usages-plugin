package com.github.plaskowski.findimmutablesusagesplugin

import com.intellij.find.findUsages.JavaFindUsagesHandler
import com.intellij.find.findUsages.JavaFindUsagesHandlerFactory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiParameter

class FactoryMethodArgumentFindUsagesHandler(
    private var element: PsiElement,
    factory: JavaFindUsagesHandlerFactory,
) : JavaFindUsagesHandler(element, factory) {

    override fun getSecondaryElements(): Array<PsiElement> {
        val parameter = element as PsiParameter
        return ImmutablesOrgLibrary.findFactoryMethodBuilderClass(parameter.declarationScope as PsiMethod)
            .flatMap { builderClass -> builderClass.findMutatorsForPropertyWithName(parameter.name) }
            .toTypedArray()
    }

    object Tester {
        fun isValidCandidate(element: PsiElement): Boolean {
            return element is PsiParameter && element.declarationScope is PsiMethod &&
                ImmutablesOrgLibrary.isFactoryMethod(((element.declarationScope) as PsiMethod))
        }
    }
}
