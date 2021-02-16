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
- https://plugins.jetbrains.com/intellij-platform-explorer
- [scala plugin](https://github.com/JetBrains/intellij-scala/blob/3b5c8039c90d315f53a258ca58a3b237949eeebc/scala/scala-impl/resources/META-INF/scala-plugin-common.xml)
- my question on Slack https://jetbrains-platform.slack.com/archives/C5U8BM1MK/p1613464009450100
- [LombokFieldFindUsagesHandlerFactory](https://github.com/mplushnikov/lombok-intellij-plugin/blob/ff0ac206568b3fd2ee238a0b6efed7ae01a3f8bf/src/main/java/de/plushnikov/intellij/plugin/extension/LombokFieldFindUsagesHandlerFactory.java)

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
