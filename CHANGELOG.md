# Changelog

## [0.4.2] - 2025-04-07

- 🆕 added a server greeting message
- 🆕 added main menu / options buttons for related pack links (e.g. Discord, GitHub, etc.)
- 🧰 fixed potion effects crashing when a potion is registered after my mod
- 🧰 fixed boss bars without a custom texture not rendering the boss name
- 🧰 fixed the bossbar of the Frostmaw using the wrong texture
- 👾 refactored how I obtain the modpack info for future features (this may cause some formatting issues in existing configs)

## [0.4.1] - 2025-04-06

- 🆕 added a tweak to item stages to remove the tooltip
- 🆕 added a tweak to game stages related mods to localize stage names
- 🧰 fixed localization of a few config options
- 🧰 fixed potion effects of various conditions
- 🧰 fixed temperature potion effects not respecting the heat/cold resistance potion

## [0.4.0] - 2025-03-31

- 🆕 added a few mixins to Pyrotech to allow ignition items that extend the base FlintAndSteelItem
- 🆕 added a tweak to apply potion effects to the player based on hunger and health
- 🧰 fixed MatterOverdrive mixin

## [0.3.1] - 2025-03-27

- 🆕 added tweaks for Pickle Tweaks to always render certain tooltips
- 🆕 added tweaks for Matter Overdrive to always render certain tooltips
- 🆕 added another tweak to Reskillable to allow setting a max level for the player

## [0.3.0] - 2025-03-24

- 🆕 added render offset tweak to potion core
- 🆕 added a config to let HWYLA _lie_ to you
- 🧰 fixed Crissaegrim mixins

## [0.2.1] - 2025-03-20

- 🆕 added more client tweaks
- 🆕 added more tweaks to Simple Difficulty
- 🆕 added tweaks for Dynamics Surroundings HUDs
- 🆕 added a warning screen (similar to Universal Tweaks) when using a mod that this mod replaces
- 🧰 fixed Quark Usage Ticker
- 🧰 fixed Rustic mixins
- ⚙ reworked the dependencies
- ⚙ improved assetmover implementation

## [0.2.0] - 2025-03-18

- 🆕 moved all features to a separate file to make it easier to maintain [FEATURES](https://github.com/Ender-Development/EnderModpackTweaks/FEATURES.md)
- ⚙ added [AssetMover](https://www.curseforge.com/minecraft/mc-mods/assetmover) as dependency, this way minecraft yells if it is missing

## [0.1.0] - 2025-03-15

- Initial release