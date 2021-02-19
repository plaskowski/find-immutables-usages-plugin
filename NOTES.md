
## Regressions considerations
- collection property has many setter methods in both builder and immutable impl.

## Improvement ideas

Related methods lookup:
- exclude any inherited methods as we are interested only in generated methods
  - how it fits "abstract class" case and default methods in super interface?

## Related resources

- https://github.com/immutables/immutables/issues/904
- com.intellij.find.actions.FindUsagesAction
- https://github.com/mapstruct/mapstruct-idea
- JavaFindUsagesHandler#getSecondaryElements()
- https://plugins.jetbrains.com/docs/intellij/psi-cookbook.html#java-specific
- com.intellij.find.findUsages.CustomUsageSearcher
- https://plugins.jetbrains.com/docs/intellij/find-usages.html
- https://plugins.jetbrains.com/intellij-platform-explorer
- [scala plugin](https://github.com/JetBrains/intellij-scala/blob/3b5c8039c90d315f53a258ca58a3b237949eeebc/scala/scala-impl/resources/META-INF/scala-plugin-common.xml)
- my question on Slack https://jetbrains-platform.slack.com/archives/C5U8BM1MK/p1613464009450100
- [LombokFieldFindUsagesHandlerFactory](https://github.com/mplushnikov/lombok-intellij-plugin/blob/ff0ac206568b3fd2ee238a0b6efed7ae01a3f8bf/src/main/java/de/plushnikov/intellij/plugin/extension/LombokFieldFindUsagesHandlerFactory.java)

