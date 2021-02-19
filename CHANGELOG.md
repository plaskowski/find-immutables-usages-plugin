<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# find-immutables-usages-plugin Changelog

## [Unreleased]
### Added

### Changed

### Deprecated

### Removed

### Fixed

### Security
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
