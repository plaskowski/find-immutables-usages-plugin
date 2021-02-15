package com.github.plaskowski.findimmutablesusagesplugin

import com.github.plaskowski.findimmutablesusagesplugin.ImmutablesOrgLibrary.isImmutablePropertyGetter
import com.github.plaskowski.findimmutablesusagesplugin.ImmutablesOrgLibrary.parseImmutableProperty
import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.find.findUsages.JavaFindUsagesHandlerFactory
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import com.intellij.util.containers.stream
import org.jetbrains.annotations.NotNull

class ImmutablePropertyFindUsagesHandlerFactory(private val project: Project) : FindUsagesHandlerFactory() {

    private val javaFindUsagesHandlerFactory: JavaFindUsagesHandlerFactory by lazy {
        FindUsagesHandlerFactory.EP_NAME.getExtensions(project).stream()
            .filter { factory -> factory::class == JavaFindUsagesHandlerFactory::class }
            .findFirst().get() as JavaFindUsagesHandlerFactory
    }

    override fun canFindUsages(element: PsiElement): Boolean {
        val scanningInProgress = DumbService.isDumb(element.project)
        val isJavaElement = javaFindUsagesHandlerFactory.canFindUsages(element)
        return !scanningInProgress && isJavaElement && isImmutablePropertyGetter(element)
    }

    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler? {
        return ImmutablePropertyFindUsagesHandler(
            parseImmutableProperty(element as @NotNull PsiMethod),
            javaFindUsagesHandlerFactory
        )
    }
}
