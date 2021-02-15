package com.github.plaskowski.findimmutablesusagesplugin

import com.github.plaskowski.findimmutablesusagesplugin.ImmutablesOrgLibrary.findImmutableImplementation
import com.intellij.find.findUsages.JavaFindUsagesHandler
import com.intellij.find.findUsages.JavaFindUsagesHandlerFactory
import com.intellij.psi.PsiElement

class ImmutablePropertyFindUsagesHandler(
    private val property: ImmutablesOrgProperty,
    factory: JavaFindUsagesHandlerFactory,
) : JavaFindUsagesHandler(property.propertyGetterInDefinition, factory) {

    override fun getSecondaryElements(): Array<PsiElement> {
        val immutableClass = findImmutableImplementation(property) ?: return emptyArray()
        val builderClass = immutableClass.findBuilderClass()
        val builderMethods = builderClass?.findMethodsRelatedToProperty(property).orEmpty()
        val witherMethods = immutableClass.findWitherMethodsForProperty(property)
        return (builderMethods + witherMethods).toTypedArray()
    }
}
