package com.github.plaskowski.findimmutablesusagesplugin

import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.find.findUsages.JavaFindUsagesHandlerFactory
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.util.containers.stream

class ImmutablePropertyFindUsagesHandlerFactory(private val project: Project) : FindUsagesHandlerFactory() {

    private val javaFindUsagesHandlerFactory: JavaFindUsagesHandlerFactory by lazy {
        EP_NAME.getExtensions(project).stream()
            .filter { factory -> factory::class == JavaFindUsagesHandlerFactory::class }
            .findFirst().get() as JavaFindUsagesHandlerFactory
    }

    override fun canFindUsages(element: PsiElement): Boolean {
        val scanningInProgress = DumbService.isDumb(element.project)
        val isJavaElement = javaFindUsagesHandlerFactory.canFindUsages(element)
        return !scanningInProgress && isJavaElement && (
            ImmutablePropertyFindUsagesHandler.Tester.isValidCandidate(element) ||
                FactoryMethodArgumentFindUsagesHandler.Tester.isValidCandidate(element)
            )
    }

    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler? {
        if (ImmutablePropertyFindUsagesHandler.Tester.isValidCandidate(element)) {
            return ImmutablePropertyFindUsagesHandler(
                element, javaFindUsagesHandlerFactory
            )
        } else if (FactoryMethodArgumentFindUsagesHandler.Tester.isValidCandidate(element)) {
            return FactoryMethodArgumentFindUsagesHandler(
                element, javaFindUsagesHandlerFactory
            )
        }
        return null
    }
}
