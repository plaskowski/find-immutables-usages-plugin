# find-immutables-usages-plugin

![Build](https://github.com/plaskowski/find-immutables-usages-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## About

<!-- Plugin description -->
This IntelliJ Plugin will help you find where given [immutable](http://immutables.github.io/) property is set via standard `Find usages` action.
<!-- Plugin description end -->

Related:
- https://github.com/immutables/immutables/issues/904
- com.intellij.find.actions.FindUsagesAction
- Template ToDo list (see initial commit)
- https://github.com/mapstruct/mapstruct-idea
- JavaFindUsagesHandler#getSecondaryElements()
- https://plugins.jetbrains.com/docs/intellij/psi-cookbook.html#java-specific
- com.intellij.find.findUsages.CustomUsageSearcher
- https://plugins.jetbrains.com/docs/intellij/find-usages.html

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "find-immutables-usages-plugin"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/plaskowski/find-immutables-usages-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
