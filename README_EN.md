<div align="center">

<img src="src/main/resources/icon.png" alt="EMI AE2 Shift-Click Craft" width="128" height="128">

# EMI AE2 Shift-Click Craft

English | [中文](README.md)

</div>

---

Next to an AE2 terminal, Shift+clicking a recipe in EMI does not fill the crafting grid — you have to open the recipe first and then press the plus button. This mod removes that step.

## Why it does not work out of the box

EMI sends `CRAFTABLE` for Shift+click transfers, but AE2's terminals (crafting terminal, wireless crafting terminal, pattern encoding terminal) only run their own transfer logic for the plus button's `FILL_BUTTON`. `CRAFTABLE` falls back to the default logic, which wants every ingredient in your inventory and gives up as soon as the materials are sitting in the ME network.

## What you get

Shift+click an EMI recipe in any AE2-family terminal:

- Materials in the ME network → filled into the crafting grid / encoded into the pattern
- Missing materials → the same missing-ingredient feedback as the plus button; hold Ctrl to auto-submit what is missing

No config, no GUI. Client-side only, the server does not need it.

## Terminals it works in

- AE2 Crafting Terminal
- AE2 Wireless Crafting Terminal
- AE2 Pattern Encoding Terminal
- Any third-party terminal extending AE2's `AbstractRecipeHandler`

## How it works

One Mixin: inside `canCraft`, `CRAFTABLE` is passed off as `FILL_BUTTON`. `craft()` does not look at the type, so once `canCraft` passes, what runs is AE2's own fill-and-dispatch logic — no transfer code is rewritten.

## Versions and branches

One repository, one branch per game version, each branch a standalone project:

| Branch | Game version | Loader |
|---|---|---|
| [`1.21.1`](../../tree/1.21.1) | 1.21.1 | NeoForge 21.1.x |
| [`1.20.1`](../../tree/1.20.1) | 1.20.1 | Forge 47.x |
| `26.1.2` | 26.1.2 | NeoForge (not available yet, see below) |

There is no 26.1.2 build because AE2's 26.1 line dropped its EMI integration entirely. In the 26.1.12-beta jar, `appeng/integration/modules/` only holds curios, igtooltip, itemlists, jade and wthit — no JEI, no EMI — and there is no `EmiCraftContext` anywhere in the repository source. The `AbstractRecipeHandler` this mod patches simply is not there. It can be revisited once AE2 brings EMI support back.

## Requirements

- Minecraft 1.20.1, Forge 47.x
- AE2 **15.4.10 or newer** — that is where native EMI support was added to AE2, and earlier builds do not have the code path this mod patches
- EMI 1.1.18+

The 1.21.1 branch is NeoForge 21.1.x + AE2 19.2.x.

## Building

Drop the EMI jar into `libs/` (the download link is in `libs/README.md`), then:

```bash
./gradlew build
# Output: build/libs/
```

AE2 comes from ModMaven (`appeng:appliedenergistics2-forge`), nothing to place by hand. EMI has to be a local jar: it is published on Emi's own maven (TerraformersMC only forwards to `repo.sleeping.town`), which is often unreachable from mainland China, and Maven Central does not carry it.

**This branch needs a JDK 17.** Forge 1.20.1's toolchain insists on JDK 17, a JDK 21 alone will not build it. Gradle does not scan self-managed folders like `F:\Java`, so list the path in your **user-level** `~/.gradle/gradle.properties` — keep it out of the repository: `org.gradle.java.installations.paths=/path/to/jdk-17`.

To change versions: swap the jar in `libs/` for EMI, edit `ae2_version` for AE2, edit `forge_version` for Forge.

## License

[MIT](LICENSE)
