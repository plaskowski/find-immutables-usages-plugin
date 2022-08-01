<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# find-immutables-usages-plugin Changelog

## [Unreleased]
### Added
- Compatibility with Intellij 2022.2

## [0.5.3]
### Added
- Compatibility with Intellij 2021.3
- Updated dependencies along plugin template boilerplate

## [0.5.1]
### Added
- Compatibility with Intellij 2021.1

## [0.5.0]
### Added
- Support @Builder.Factory method parameters

## [0.4.1]
### Fixed
- NoSuchElementException on value class without builder

## [0.4.0]
### Added
- Support @Value.Immutable on subclass

## [0.3.1]
### Fixed
- Exclude unrelated methods like hasCode() by checking parameters count

## [0.3.0]
### Added
- Enhance 'Find Usages' action on property getter in interface/abstract class
  that has `@Value.Immutable` to look also for builder methods and `with*()` methods
  that provide value for that property

## 0.0.1
### Added
- Initial scaffold created from [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)
