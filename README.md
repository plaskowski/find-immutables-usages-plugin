# find-immutables-usages-plugin

![Build](https://github.com/plaskowski/find-immutables-usages-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/16135.svg)](https://plugins.jetbrains.com/plugin/16135)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/16135.svg)](https://plugins.jetbrains.com/plugin/16135)

## About

<!-- Plugin description -->
This IntelliJ Plugin helps with [immutables.org](http://immutables.github.io/) by extending 'Find Usages' for immutable property getter.

**Note** this is not an official immutables.org plugin (there was no official plugin as of Feb 2021).
<!-- Plugin description end -->

<img src="src/main/resources/META-INF/pluginIcon.svg" width="100" height="100">

![Example](example_screenshot.png)

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Immutables.org Support"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/plaskowski/find-immutables-usages-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Roadmap

- [X] ~~Set the Plugin ID in the above README badges.~~
- [X] ~~Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).~~
- [ ] Support @Builder.Factory 
- [ ] support other features like:
  - @Builder.Constructor,
  - @Value.Style
- [ ] support less common cases like:
  - having ``@Value.Immutable`` on interface that extends the public interface (the one containing properties signatures)

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
