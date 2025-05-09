package io.enderdev.endermodpacktweaks;

import com.cleanroommc.configanytime.ConfigAnytime;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Tags.MOD_ID, name = Tags.MOD_ID, category = Tags.MOD_ID)
public class EMTConfig {

    public enum Difficulty {
        PEACEFUL(0),
        EASY(1),
        NORMAL(2),
        HARD(3);

        private final int value;

        Difficulty(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Gamemode {
        SURVIVAL(0),
        CREATIVE(1),
        ADVENTURE(2),
        SPECTATOR(3);

        private final int value;

        Gamemode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum ListType {
        BLACKLIST,
        WHITELIST
    }

    @Config.Name("Modpack Tweaks")
    @Config.LangKey("config.endermodpacktweaks")
    @Config.Comment("Made with <3 by Ender-Development")
    public static final Modpack MODPACK = new Modpack();

    public static class Modpack {

        @Config.RequiresMcRestart
        @Config.Name("[01] Modpack Name")
        @Config.Comment("The name of the modpack.")
        public String modpackName = "";

        @Config.RequiresMcRestart
        @Config.Name("[02] Modpack Version")
        @Config.Comment("The version of the modpack.")
        public String modpackVersion = "";

        @Config.RequiresMcRestart
        @Config.Name("[03] Modpack Author")
        @Config.Comment("The author of the modpack.")
        public String modpackAuthor = "";

        @Config.Name("Crash Info")
        @Config.LangKey("config.endermodpacktweaks.crash_info")
        @Config.Comment("Add additional modpack information to the crash report.")
        public final CrashInfo CRASH_INFO = new CrashInfo();

        public static class CrashInfo {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable Crash Info")
            @Config.Comment({
                    "Enable the Crash Info feature. This adds additional information to the crash report.",
                    "It tries to read the information from the manifest file of the modpack.",
                    "Alternatively, you can provide the information in the config file."
            })
            public boolean enable = true;

            @Config.RequiresMcRestart
            @Config.Name("[02] Read from Manifest")
            @Config.Comment({
                    "Read the information from the manifest file of the modpack.",
                    "This will override the config values."
            })
            public boolean readFromManifest = true;
        }

        @Config.Name("Material Tweaker")
        @Config.LangKey("config.endermodpacktweaks.material_tweaker")
        @Config.Comment("A tool is not to your linkings? Tweak it to your likings!")
        public final MaterialTweaker MATERIAL_TWEAKER = new MaterialTweaker();

        public static class MaterialTweaker {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable Material Tweaker")
            @Config.Comment("Enable the Material Tweaker feature. This allows you to tweak the materials of the game.")
            public boolean enable = false;

            @Config.Name("[02] Tweak Stacksize")
            @Config.Comment({
                    "Tweak the stacksize of items.",
                    "Format: modid:itemid;stacksize"
            })
            public String[] stacksize = new String[]{};

            @Config.Name("[03] Tweak Durability")
            @Config.Comment({
                    "Tweak the durability of items.",
                    "Format: modid:itemid;durability"
            })
            public String[] durability = new String[]{};

            @Config.Name("[04] Tweak Harvest Level")
            @Config.Comment({
                    "Tweak the harvest level of items.",
                    "Format: modid:itemid;harvestlevel"
            })
            public String[] harvestLevel = new String[]{};

            @Config.Name("[05] Tweak Enchantability")
            @Config.Comment({
                    "Tweak the enchantability of items.",
                    "Format: modid:itemid;enchantability"
            })
            public String[] enchantability = new String[]{};

            @Config.Name("[06] Tweak Efficiency")
            @Config.Comment({
                    "Tweak the efficiency of items.",
                    "Format: modid:itemid;efficiency"
            })
            public String[] efficiency = new String[]{};

            @Config.Name("[07] Tweak Attack Damage")
            @Config.Comment({
                    "Tweak the attack damage of items.",
                    "Format: modid:itemid;attackdamage"
            })
            public String[] attackDamage = new String[]{};

            @Config.Name("[08] Tweak Attack Speed")
            @Config.Comment({
                    "Tweak the attack speed of items.",
                    "Format: modid:itemid;attackspeed"
            })
            public String[] attackSpeed = new String[]{};

            @Config.Name("[09] Tweak Armor Protection")
            @Config.Comment({
                    "Tweak the protection of armor.",
                    "Format: modid:itemid;protection"
            })
            public String[] armorProtection = new String[]{};

            @Config.Name("[10] Tweak Armor Toughness")
            @Config.Comment({
                    "Tweak the toughness of armor.",
                    "Format: modid:itemid;toughness"
            })
            public String[] armorToughness = new String[]{};
        }

        @Config.Name("Options Menu Buttons")
        @Config.LangKey("config.endermodpacktweaks.options_menu_buttons")
        @Config.Comment("Link everything related to the modpack in the options and main menu.")
        public final OptionsMenuButtons OPTIONS_MENU_BUTTONS = new OptionsMenuButtons();

        public static class OptionsMenuButtons {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable Options Menu Buttons")
            @Config.Comment("Enable the Options Menu Buttons feature. This adds additional buttons to the options menu.")
            public boolean enable = false;

            @Config.Name("Changelog Button")
            @Config.LangKey("config.endermodpacktweaks.options_menu_buttons.changelog")
            public final OptionsMenuButton CHANGELOG_BUTTON = new OptionsMenuButton("Changelog", "");

            @Config.Name("Donation Button")
            @Config.LangKey("config.endermodpacktweaks.options_menu_buttons.donation")
            public final OptionsMenuButton DONATION_BUTTON = new OptionsMenuButton("Donation", "");

            @Config.Name("GitHub Button")
            @Config.LangKey("config.endermodpacktweaks.options_menu_buttons.github")
            public final OptionsMenuButton GITHUB_BUTTON = new OptionsMenuButton("GitHub", "");

            @Config.Name("Discord Button")
            @Config.LangKey("config.endermodpacktweaks.options_menu_buttons.discord")
            public final OptionsMenuButton DISCORD_BUTTON = new OptionsMenuButton("Discord", "");

            @Config.Name("Twitch Button")
            @Config.LangKey("config.endermodpacktweaks.options_menu_buttons.twitch")
            public final OptionsMenuButton TWITCH_BUTTON = new OptionsMenuButton("Twitch", "");

            @Config.Name("Youtube Button")
            @Config.LangKey("config.endermodpacktweaks.options_menu_buttons.youtube")
            public final OptionsMenuButton YOUTUBE_BUTTON = new OptionsMenuButton("Youtube", "");

            public static class OptionsMenuButton {
                @Config.Name("[01] Enable Button")
                public boolean enable;

                @Config.Name("[02] Button Text")
                public String buttonText;

                @Config.Name("[03] Button URL")
                public String url;

                OptionsMenuButton(String name, String url) {
                    this.enable = false;
                    this.buttonText = name;
                    this.url = url;
                }
            }
        }

        @Config.Name("Server Message")
        @Config.LangKey("config.endermodpacktweaks.server_message")
        @Config.Comment("Similar to something that Nomifactory came up with.")
        public final ServerMessage SERVER_MESSAGE = new ServerMessage();

        public static class ServerMessage {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable Server Message")
            @Config.Comment("Enable the Server Message feature. This adds a message to the server console when the server starts.")
            public boolean enable = true;

            @Config.Name("[02] Server Name")
            @Config.Comment("The name of the server. Only used if 'Enable Server Message' is enabled.")
            public String serverName = "Minecraft";
        }

        @Config.Name("Sync Time")
        @Config.LangKey("config.endermodpacktweaks.sync_time")
        @Config.Comment("Never see the light of day again. (If you only play at night.)")
        public final SyncTime SYNC_TIME = new SyncTime();

        public static class SyncTime {
            @Config.RequiresWorldRestart
            @Config.Name("[01] Enable Sync Time")
            @Config.Comment("Enable the Sync Time feature. This synchronizes the world time with the system time of the server.")
            public boolean enable = false;

            @Config.Name("[02] Sleeping")
            @Config.Comment("Should sleeping be disabled?")
            public boolean sleeping = false;
        }
    }

    @Config.Name("Minecraft")
    @Config.LangKey("config.endermodpacktweaks.minecraft")
    @Config.Comment("The block game everyone loves.")
    public static final Minecraft MINECRAFT = new Minecraft();

    public static class Minecraft {

        @Config.Name("Boss Bar Tweaks")
        @Config.LangKey("config.endermodpacktweaks.minecraft.boss_bar")
        @Config.Comment("Replace the boring old boss bars with something more fancy.")
        public final BossBar BOSS_BAR = new BossBar();

        public static class BossBar {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable Boss Bar Tweaks")
            @Config.Comment("Enable tweaks for the Boss Bar. This requires AssetMover.")
            public boolean enable = false;
        }

        @Config.Name("Client Tweaks")
        @Config.LangKey("config.endermodpacktweaks.minecraft.client")
        @Config.Comment("Disable various Client elements.")
        public final Client CLIENT = new Client();

        public static class Client {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable Client Tweaks")
            @Config.Comment("Enable tweaks for the client.")
            public boolean enable = false;

            @Config.Name("[02] Disable Inventory Crafting")
            @Config.Comment({
                    "This tweak disables the crafting grid in the player inventory.",
                    "Useful for modpacks that want to make the player use a crafting table",
                    "or want to realize crafting in a different way."
            })
            public boolean disableInventoryCrafting = false;

            @Config.RequiresWorldRestart
            @Config.Name("[03] Disable Item Names")
            @Config.Comment("This tweak disables the rendering of item names above the hotbar.")
            public boolean disableItemNames = false;

            @Config.RequiresMcRestart
            @Config.Name("[04] Max Render Distance")
            @Config.Comment({
                    "Set the maximum render distance of the client.",
                    "I'm not responsible for any performance issues this may cause.",
                    "nor if your pc goes up in flames. (The Minecraft default is 16)"
            })
            @Config.RangeInt(min = 2, max = Integer.MAX_VALUE)
            public int maxRenderDistance = 32;

            @Config.Name("[05] Hide Name Tags")
            @Config.Comment("Hide the name tags of entities.")
            public boolean hideNameTags = false;

            @Config.Name("[06] Disable Auto Jump")
            @Config.Comment("Disable the auto jump feature. It never should have been added in the first place.")
            public boolean disableAutoJump = false;

            @Config.Name("[07] Additional Master Volume")
            @Config.Comment("Adds an additional master volume slider to the main options menu.")
            public boolean additionalMasterVolume = false;

            @Config.Name("[08] Hide Potion Icons")
            @Config.Comment("Hide the potion icons in the top right corner.")
            public boolean hidePotionIcons = false;

            @Config.Name("[09] Hide Crosshair")
            @Config.Comment("Hide the crosshair.")
            public boolean hideCrosshair = false;

            @Config.Name("[10] Hide Armor Bar")
            @Config.Comment("Hide the armor bar.")
            public boolean hideArmorBar = false;

            @Config.Name("[11] Hide Health Bar")
            @Config.Comment("Hide the health bar.")
            public boolean hideHealthBar = false;

            @Config.Name("[12] Hide Hunger Bar")
            @Config.Comment("Hide the hunger bar.")
            public boolean hideHungerBar = false;

            @Config.Name("[13] Hide Experience Bar")
            @Config.Comment("Hide the experience bar.")
            public boolean hideExperienceBar = false;

            @Config.Name("[14] Hide Air Bar")
            @Config.Comment("Hide the air bar.")
            public boolean hideAirBar = false;

            @Config.Name("[15] Disable FOV Change")
            @Config.Comment("Disable the FOV change.")
            public boolean disableFovChange = false;
        }

        @Config.Name("Dragon Tweaks")
        @Config.LangKey("config.endermodpacktweaks.minecraft.dragon")
        @Config.Comment("Tweaks for the initial Dragon Fight.")
        public final Dragon DRAGON = new Dragon();

        public static class Dragon {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable Dragon Tweaks")
            @Config.Comment("Allow you to customize the Ender Dragon Fight Mechanic.")
            public boolean enable = false;

            @Config.Name("[02] Kill Dragon")
            @Config.Comment({
                    "This tweak kills the first dragon when the player enters the end for the first time.",
                    "Useful for modpacks that want to make the dragon fight non-free."
            })
            public boolean killDragon = false;

            @Config.Name("[03] Drop Dragon Egg")
            @Config.Comment("Should the auto killed dragon drop the dragon egg?")
            public boolean dropEgg = false;

            @Config.Name("[04] Replace the first Dragon Egg")
            @Config.Comment("Replace the dragon egg block with another block.")
            public String eggBlock = "minecraft:dragon_egg";

            @Config.Name("[05] Create End Portal")
            @Config.Comment("Should the auto killed dragon create the end portal back to the overworld?")
            public boolean createPortal = false;

            @Config.Name("[06] Create End Gateway")
            @Config.Comment("Should the auto killed dragon create an end gateway?")
            public boolean createGateway = false;

            @Config.Name("[07] Multiple Dragon Egg")
            @Config.Comment("Should every dragon drop an egg?")
            public boolean multipleEgg = false;

            @Config.Name("[08] Disable End Portal")
            @Config.Comment("Should spawning the end portal when killing the dragon be disabled?")
            public boolean disablePortal = false;

            @Config.Name("[09] Disable End Gateway")
            @Config.Comment("Should spawning the end gateway when killing the dragon be disabled?")
            public boolean disableGateway = false;
        }

        @Config.Name("End Gateway Tweaks")
        @Config.LangKey("config.endermodpacktweaks.minecraft.end_gateway")
        @Config.Comment("Tweak the End Gateway to your liking.")
        public final EndGateway END_GATEWAY = new EndGateway();

        public static class EndGateway {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable End Gateway Tweaks")
            @Config.Comment({
                    "This tweak allows you to customize the End Gateway.",
                    "You can change the blocks that make up the End Gateway."
            })
            public boolean enable = false;

            @Config.Name("[02] Replace Air")
            @Config.Comment("Replace the air block in the End Gateway.")
            public String air = "minecraft:air";

            @Config.Name("[03] Replace Bedrock")
            @Config.Comment("Replace the bedrock block in the End Gateway.")
            public String bedrock = "minecraft:bedrock";

            @Config.Name("[04] Replace End Gateway")
            @Config.Comment("Replace the end gateway with a new structure.")
            public boolean replaceGateway = false;

            @Config.Name("[05] End Gateway Structure")
            @Config.Comment("The structure that replaces the end gateway.")
            public String gatewayStructure = "endermodpacktweaks:end_gateway";

            @Config.Name("[06] End Gateway Distance from End Portal")
            @Config.Comment("The distance the end gateway is placed from the end portal.")
            @Config.RangeDouble(min = 96.0, max = 256.0)
            public double gatewayDistance = 96.0;

            @Config.Name("[07] End Gateway Height")
            @Config.Comment("The height the end gateway is placed at.")
            @Config.RangeInt(min = 0, max = 255)
            public int gatewayHeight = 75;
        }

        @Config.Name("End Island Tweaks")
        @Config.LangKey("config.endermodpacktweaks.minecraft.end_island")
        @Config.Comment("Tweak the End Island to your liking.")
        public final EndIsland END_ISLAND = new EndIsland();

        public static class EndIsland {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable End Island Tweaks")
            @Config.Comment({
                    "This tweak allows you to customize the End Island.",
                    "You can change the blocks that make up the End Island."
            })
            public boolean enable = false;

            @Config.Name("[02] Island Size")
            @Config.Comment("Increase the size of the End Island.")
            @Config.RangeInt(min = 0, max = 32)
            public int islandSize = 4;

            @Config.Name("[03] Replace End Stone")
            @Config.Comment("Replace the end stone block in the End Island.")
            public String endStone = "minecraft:end_stone";
        }

        @Config.Name("End Portal Tweaks")
        @Config.LangKey("config.endermodpacktweaks.minecraft.end_portal")
        @Config.Comment("Tweak the End Portal to your liking.")
        public final EndPodium END_PODIUM = new EndPodium();

        public static class EndPodium {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable End Podium Tweaks")
            @Config.Comment({
                    "This tweak allows you to customize the End Portal.",
                    "You can change the blocks that make up the End Portal."
            })
            public boolean enable = false;

            @Config.Name("[02] Replace Bedrock")
            @Config.Comment({
                    "Replace the bedrock block in the End Portal.",
                    "Replacing the bedrock makes it impossible to respawn the Ender Dragon."
            })
            public String bedrock = "minecraft:bedrock";

            @Config.Name("[03] Replace End Stone")
            @Config.Comment("Replace the end stone block in the End Portal.")
            public String endStone = "minecraft:end_stone";

            @Config.Name("[04] Replace Torch")
            @Config.Comment("Replace the torch block in the End Portal.")
            public String torch = "minecraft:torch";

            @Config.Name("[05] Replace Air")
            @Config.Comment("Replace the air block in the End Portal.")
            public String air = "minecraft:air";

            @Config.Name("[06] Replace End Portal")
            @Config.Comment("Replace the end portal with a new structure.")
            public boolean replacePortal = false;

            @Config.Name("[07] End Portal Structure (Inactive)")
            @Config.Comment("The structure that replaces the inactive end portal.")
            public String portalStructure = "endermodpacktweaks:end_portal";

            @Config.Name("[08] End Portal Structure (Active)")
            @Config.Comment("The structure that replaces the active end portal.")
            public String activePortalStructure = "endermodpacktweaks:end_portal_active";
        }

        @Config.Name("Obsidian Spike Tweaks")
        @Config.LangKey("config.endermodpacktweaks.minecraft.obsidian_spike")
        @Config.Comment("Tweak the Obsidian Spikes in the End.")
        public final ObsidianSpike OBSIDIAN_SPIKE = new ObsidianSpike();

        public static class ObsidianSpike {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable Obsidian Spike Tweaks")
            @Config.Comment({
                    "This tweak allows you to customize the Obsidian Spike.",
                    "Obsidian Spikes are the large Pillars of Obsidian that generate in the End.",
                    "You can change the blocks that make up the Obsidian Spike."
            })
            public boolean enable = false;

            @Config.Name("[02] Replace Obsidian")
            @Config.Comment("Replace the obsidian block in the Obsidian Spike.")
            public String obsidian = "minecraft:obsidian";

            @Config.Name("[03] Replace Air")
            @Config.Comment("Replace the air block in the Obsidian Spike.")
            public String air = "minecraft:air";

            @Config.Name("[04] Replace Iron Bars")
            @Config.Comment("Replace the iron bars block in the Obsidian Spike.")
            public String ironBars = "minecraft:iron_bars";

            @Config.Name("[05] Replace Obsidian Spike")
            @Config.Comment({
                    "Replace the obsidian spike with a new structure.",
                    "!!! NOT YET IMPLEMENTED !!!"
            })
            public boolean replaceSpike = false;

            @Config.Name("[06] Obsidian Spike Structure")
            @Config.Comment({
                    "The structure that replaces the obsidian spike.",
                    "!!! NOT YET IMPLEMENTED !!!"
            })
            public String spikeStructure = "endermodpacktweaks:obsidian_spike";

            @Config.Name("[07] Obsidian Spike Distance from End Portal")
            @Config.Comment("The distance the obsidian spike is placed from the end portal.")
            @Config.RangeDouble(min = 42.0, max = 128.0)
            public double spikeDistance = 42.0;

            @Config.Name("[08] Obsidian Spike Base Height")
            @Config.Comment("The base height of the obsidian spike.")
            @Config.RangeInt(min = 10, max = 255)
            public int spikeHeight = 76;

            @Config.Name("[09] Obsidian Spike Base Radius")
            @Config.Comment("The base radius of the obsidian spike.")
            @Config.RangeInt(min = 2, max = 10)
            public int spikeRadius = 2;

            @Config.Name("[10] Obsidian Spike Count")
            @Config.Comment("The number of obsidian spikes around the end portal.")
            @Config.RangeInt(min = 1, max = 32)
            public int spikeCount = 10;

            @Config.Name("[11] Obsidian Spike Guard")
            @Config.Comment("Should the obsidian spikes be always guarded?")
            public boolean alwaysGuarded = false;

            @Config.Name("[12] Obsidian Spike Guard Chance")
            @Config.Comment({
                    "The 1 in x chance that the obsidian spikes are guarded.",
                    "Set to 0 to disable guarded spikes altogether."
            })
            @Config.RangeInt(min = 0, max = 100)
            public int guardChance = 5;
        }

        @Config.Name("Nether Portal Tweaks")
        @Config.LangKey("config.endermodpacktweaks.minecraft.nether_portal")
        @Config.Comment("Tweak the Nether Portal to your liking.")
        public final NetherPortal NETHER_PORTAL = new NetherPortal();

        public static class NetherPortal {
            @Config.RequiresMcRestart
            @Config.Name("[01] Nether Portal Tweaks")
            @Config.Comment("Enable Nether Portal Tweaks")
            public boolean enable = false;

            @Config.Name("[02] Nether Portal Creation")
            @Config.Comment("Allow Nether Portal Creation")
            public boolean canBeCreated = true;

            @Config.Name("[03] End Nether Portal")
            @Config.Comment("Allow Nether Portal Creation in the End")
            public boolean canBeCreatedInEnd = false;

            @Config.Name("[04] No Entity Traverse")
            @Config.Comment("Disallow Entities to enter Nether Portals")
            public boolean disallowTraverse = false;
        }

        @Config.Name("Player Effects")
        @Config.LangKey("config.endermodpacktweaks.minecraft.player_effects")
        @Config.Comment("Apply potion effects depending on different hunger and health conditions.")
        public final PlayerEffects PLAYER_EFFECTS = new PlayerEffects();

        public static class PlayerEffects {
            @Config.RequiresMcRestart
            @Config.Name("[01] Enable Player Effects Tweaks")
            @Config.Comment("Enable tweaks for the player effects.")
            public boolean enable = false;

            @Config.RequiresMcRestart
            @Config.Name("[02] Health Potion Effects")
            @Config.Comment({
                    "Add additional potion effects to the player depending on the health.",
                    "The health bounds must be between 0% and 100% of max health.",
                    "FORMAT: lower_bound;upper_bound;effect;amplifier",
                    "Example: 0;5;minecraft:slowness;2"
            })
            public String[] healthPotions = new String[]{};

            @Config.RequiresMcRestart
            @Config.Name("[03] Hunger Potion Effects")
            @Config.Comment({
                    "Add additional potion effects to the player depending on the hunger level.",
                    "The hunger bounds must be between 0 and 20.",
                    "FORMAT: lower_bound;upper_bound;effect;amplifier",
                    "Example: 0;5;minecraft:slowness;2"
            })
            public String[] hungerPotions = new String[]{};
        }

        @Config.Name("World Tweaks")
        @Config.LangKey("config.endermodpacktweaks.minecraft.world")
        @Config.Comment("Tweaks for world generation and world settings.")
        public final World WORLD = new World();

        public static class World {
            @Config.Name("[01] Enable World Tweaks")
            @Config.Comment("Enable world tweaks")
            public boolean enable = false;

            @Config.Name("[02] Difficulty")
            @Config.LangKey("config.endermodpacktweaks.minecraft.world.difficulty")
            public final DifficultyCategory DIFFICULTY = new DifficultyCategory();

            @Config.Name("[03] Gamemode")
            @Config.LangKey("config.endermodpacktweaks.minecraft.world.gamemode")
            public final GamemodeCategory GAMEMODE = new GamemodeCategory();

            public static class DifficultyCategory {
                @Config.Name("[01] Force Difficulty")
                @Config.Comment("Force the difficulty to a specific value")
                public boolean force = false;

                @Config.Name("[02] Forced Difficulty")
                @Config.Comment("The difficulty the world should be forced to")
                public Difficulty difficulty = Difficulty.NORMAL;

                @Config.Name("[03] Lock Difficulty")
                @Config.Comment("Prevent players from changing the difficulty")
                public boolean lock = false;
            }

            public static class GamemodeCategory {
                @Config.Name("[01] Force Gamemode")
                @Config.Comment("Force the gamemode to a specific value")
                public boolean force = false;

                @Config.Name("[02] Forced Gamemode")
                @Config.Comment("The gamemode the world should be forced to")
                public Gamemode gamemode = Gamemode.SURVIVAL;

                @Config.Name("[03] Allow Cheats")
                @Config.Comment("Allow cheats in the world")
                public boolean cheats = true;

                @Config.Name("[04] Hardcore Mode")
                @Config.Comment("Enable hardcore mode")
                public boolean hardcore = false;
            }
        }
    }

    @Config.Name("Astral Sorcery")
    @Config.LangKey("config.endermodpacktweaks.astral_sorcery")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/astral-sorcery")
    public static final AstralSorcery ASTRAL_SORCERY = new AstralSorcery();

    public static class AstralSorcery {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Astral Sorcery Tweaks")
        @Config.Comment("Enable tweaks for the Astral Sorcery mod.")
        public boolean enable = false;

        @Config.Name("[02] Allow Fake Players")
        @Config.Comment("Allow Fake Players to interact with the Astral Sorcery mod.")
        public boolean allowFakePlayer = false;
    }

    @Config.Name("Backpack Opener")
    @Config.LangKey("config.endermodpacktweaks.bp_opener")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/backpack-opener")
    public static final BpOpener BP_OPENER = new BpOpener();

    public static class BpOpener {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Backpack Opener Tweaks")
        @Config.Comment("Enable tweaks for the Backpack Opener mod.")
        public boolean enable = false;

        @Config.Name("[02] Valid Items")
        @Config.Comment({
                "A list of valid items that can be used with the Backpack Opener.",
                "Format: modid:itemid;boolean",
                "Boolean: true = does the item require sneaking, false = no sneaking required"
        })
        public String[] validItems = new String[]{};
    }

    @Config.Name("Better End")
    @Config.LangKey("config.endermodpacktweaks.better_end")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/betterendforge-backport")
    public static final BetterEnd BETTER_END = new BetterEnd();

    public static class BetterEnd {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Better End Tweaks")
        @Config.Comment("Enable tweaks for the Better End mod.")
        public boolean enable = true;
    }

    @Config.Name("Crissaegrim")
    @Config.LangKey("config.endermodpacktweaks.crissaegrim")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/crissaegrim")
    public static final Crissaegrim CRISSAEGRIM = new Crissaegrim();

    public static class Crissaegrim {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Crissaegrim Tweaks")
        @Config.Comment("Enable tweaks for the Crissaegrim mod.")
        public boolean enable = true;

        @Config.Name("[02] Disable Random Drop")
        @Config.Comment("Disable the random drop of the Crissaegrim.")
        public boolean disableRandomDrop = false;

        @Config.Name("[03] Override Special Mob")
        @Config.Comment("Override the mob that can drop the Crissaegrim.")
        public String specialMob = "quark:wraith";

        @Config.Name("[04] Override Special Mob Chance")
        @Config.Comment("The chance that the special mob drops the Crissaegrim.")
        @Config.RangeDouble(min = 0.0, max = 1.0)
        public double specialMobChance = 0.01;
    }

    @Config.Name("Dark Utilities")
    @Config.LangKey("config.endermodpacktweaks.dark_utils")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/dark-utilities")
    public static final DarkUtils DARK_UTILS = new DarkUtils();

    public static class DarkUtils {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Dark Utils Tweaks")
        @Config.Comment("Enable tweaks for the Dark Utils mod.")
        public boolean enable = false;

        @Config.Name("[02] Vector Plate Item Only")
        @Config.Comment("Vector Plates can only move items.")
        public boolean vectorPlateItemOnly = false;

        @Config.Name("[03] Override Vector Plate Collision Box")
        @Config.Comment({
                "This tweak increases the height of the collision box of the vector plate.",
                "This tweak was added so Item Physics can render the item on top of the vector plate."
        })
        public boolean overrideVectorPlateCollisionBox = false;

        @Config.Name("[04] Vector Plates Insert - front")
        @Config.Comment("Vector Plates can insert items into the inventory in front of them.")
        public boolean vectorPlatesInsertFront = false;

        @Config.Name("[05] Vector Plates Insert - below")
        @Config.Comment("Vector Plates can insert items into the inventory below them.")
        public boolean vectorPlatesInsertBelow = false;
    }

    @Config.Name("Default World Generator")
    @Config.LangKey("config.endermodpacktweaks.default_world_generator")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/default-world-generator-ssp")
    public static final DefaultWorldGenerator DEFAULT_WORLD_GENERATOR = new DefaultWorldGenerator();

    public static class DefaultWorldGenerator {
        @Config.Name("[01] Enable Default World Generator Port Tweaks")
        @Config.Comment({
                "This fixes the glitched button texture in the default world generator screen,",
                "which appears when using a wide screen by giving it a fixed width."
        })
        public boolean enable = true;
    }

    @Config.Name("Dynamic Surroundings: HUDs")
    @Config.LangKey("config.endermodpacktweaks.ds_huds")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/dynamic-surroundings-huds")
    public static final DSHUDs DSHUDS = new DSHUDs();

    public static class DSHUDs {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Dynamic Surroundings HUD Tweaks")
        @Config.Comment("Enable tweaks for the Dynamic Surroundings HUDs.")
        public boolean enable = false;

        @Config.Name("[02] Potion HUD Hide List Type")
        @Config.Comment("Should the potion HUD be a blacklist or a whitelist?")
        public ListType potionHUDHideListType = ListType.BLACKLIST;

        @Config.Name("[03] Potion HUD Hide List")
        @Config.Comment({
                "A list of potion effects that depending on the list type are hidden or shown.",
                "FORMAT: modid:potionid",
                "EXAMPLE: minecraft:night_vision"
        })
        public String[] potionHUDHideList = new String[]{};
    }

    @Config.Name("Elenai Dodge 2")
    @Config.LangKey("config.endermodpacktweaks.elenai_dodge")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/elenai-dodge-2")
    public static final ElenaiDodge ELENAI_DODGE = new ElenaiDodge();

    public static class ElenaiDodge {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Elenai Dodge 2 Tweaks")
        @Config.Comment("Enable tweaks for the Elenai Dodge 2 mod.")
        public boolean enable = false;

        @Config.Name("[02] Enable Simple Difficulty Integration")
        @Config.Comment("Enable the integration with the Simple Difficulty mod.")
        public boolean enableSimpleDifficulty = false;

        @Config.Name("[03] Simple Difficulty: Thirst Exhaustion on Dodge")
        @Config.Comment("How much thirst should be added when the player dodges.")
        @Config.RangeDouble(min = 0.0, max = 40.0)
        public double thirst = 6.0;

        @Config.Name("[04] Simple Difficulty: Thirst Threshold")
        @Config.Comment("The threshold at which the dodge should be canceled.")
        @Config.RangeInt(min = 0, max = 20)
        public int thirstThreshold = 6;

        @Config.Name("[05] Simple Difficulty: Stamina Regeneration")
        @Config.Comment("The minimum thirst level required to regenerate stamina.")
        @Config.RangeInt(min = 0, max = 20)
        public int dodgeRegeneration = 8;

        @Config.Name("[06] Simple Difficulty: Stamina Regeneration Rate")
        @Config.Comment("How much longer (in ticks) it takes to regenerate stamina for each missing thirst level.")
        @Config.RangeInt(min = 0, max = 100)
        public int dodgeRegenerationRate = 10;

        @Config.Name("[07] Simple Difficulty: Thirst Exhaustion on Stamina Regeneration")
        @Config.Comment("How much thirst should be added when the player regenerates stamina.")
        @Config.RangeDouble(min = 0.0, max = 40.0)
        public double thirstRegeneration = 0.2;
    }

    @Config.Name("Ender Storage")
    @Config.LangKey("config.endermodpacktweaks.ender_storage")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/ender-storage-1-12-continuation")
    public static final EnderStorage ENDER_STORAGE = new EnderStorage();

    public static class EnderStorage {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Ender Storage Tweaks")
        @Config.Comment({
                "Enable tweaks for the Ender Storage mod.",
                "This tweak fixes the crash report spam caused by the Ender Storage mod.",
                "https://github.com/igentuman/EnderStorage-continuation/issues/19",
                "This fix is still heavy WIP and currently breaks Ender Tanks! Use with caution!"
        })
        public boolean enable = false;
    }

    @Config.Name("First Aid")
    @Config.LangKey("config.endermodpacktweaks.first_aid")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/first-aid")
    public static final FirstAid FIRST_AID = new FirstAid();

    public static class FirstAid {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable First Aid Tweaks")
        @Config.Comment("Enable tweaks for the First Aid mod.")
        public boolean enable = false;

        @Config.Name("[02] Disable Tutorial Message")
        @Config.Comment("Disable the tutorial message that appears when joining a world.")
        public boolean disableTutorial = false;

        @Config.Name("[03] Overhaul HUD placement")
        @Config.Comment("This centers the HUD on the x-axis.")
        public boolean centerHUD = false;
    }

    @Config.Name("Flux Networks")
    @Config.LangKey("config.endermodpacktweaks.flux_networks")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/flux-networks")
    public static final FluxNetworks FLUX_NETWORKS = new FluxNetworks();

    public static class FluxNetworks {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Flux Networks Tweaks")
        @Config.Comment("Enable tweaks for the Flux Networks mod.")
        public boolean enable = false;

        @Config.RequiresMcRestart
        @Config.Name("[02] Fix IC2 Energy Limit")
        @Config.Comment("Sets the maximum energy limit for IC2 Energy to Max Integer.")
        public boolean fixIC2EnergyLimit = false;

        @Config.RequiresMcRestart
        @Config.Name("[03] Override IC2 Sink Tier")
        @Config.Comment("Override the IC2 Sink Tier.")
        @Config.RangeInt(min = 1)
        public int ic2SinkTier = 4;

        @Config.RequiresMcRestart
        @Config.Name("[04] Override IC2 Source Tier")
        @Config.Comment("Override the IC2 Source Tier.")
        @Config.RangeInt(min = 1)
        public int ic2SourceTier = 4;
    }

    @Config.Name("Game Stages")
    @Config.LangKey("config.endermodpacktweaks.game_stages")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/game-stages")
    public static final GameStages GAME_STAGES = new GameStages();

    public static class GameStages {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Game Stages Tweaks")
        @Config.Comment("Enable tweaks for the Game Stages mod.")
        public boolean enable = false;

        @Config.Name("[02] Disable Item Stages Tooltip")
        @Config.Comment("Disable the Tooltip that is displayed when hovering over a staged item.")
        public boolean disableTooltip = false;

        @Config.Name("[03] Localize Stage Names")
        @Config.Comment({
                "Allow localization of stages. This works by adding a localization key",
                "to each game stage in the format of 'emt.game_stages.<stage_name>'"
        })
        public boolean localizeRecipeStages = false;

        @Config.Name("[04] Recipe Stages Tooltip X-Offset")
        @Config.Comment("Set the X-Offset of the recipe stages tooltip.")
        public int recipeStagesTooltipXOffset = 0;

        @Config.Name("[05] Recipe Stages Tooltip Y-Offset")
        @Config.Comment("Set the Y-Offset of the recipe stages tooltip.")
        public int recipeStagesTooltipYOffset = 0;
    }

    @Config.Name("Item Physics")
    @Config.LangKey("config.endermodpacktweaks.item_physics")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/itemphysic")
    public static final ItemPhysics ITEM_PHYSICS = new ItemPhysics();

    public static class ItemPhysics {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Item Physics Tweaks")
        @Config.Comment("Enable tweaks for the Item Physics mod.")
        public boolean enable = false;

        @Config.Name("[02] Improved Item Tooltip")
        @Config.Comment({
                "This tweak overhauls the item tooltip that is displayed when using the alternative pickup mode.",
                "It adds the stack size to the tooltip as well as coloring it based on the rarity of the item."
        })
        public boolean improveTooltip = true;

        @Config.Name("[03] Reach Distance")
        @Config.Comment("Set the pickup range to the reach distance of the player.")
        public boolean reachDistance = true;
    }

    @Config.Name("Lightweight Blood Mechanics")
    @Config.LangKey("config.endermodpacktweaks.lightweight_blood_mechanics")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/lightweight-blood-mechanics")
    public static final Lbm LBM = new Lbm();

    public static class Lbm {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Lightweight Blood Mechanics Tweaks")
        @Config.Comment("Enable tweaks for the Lightweight Blood Mechanics mod.")
        public boolean enable = false;

        @Config.Name("[02] Blood Overlay X-Offset")
        @Config.Comment("Set the X-Offset of the Blood Overlay.")
        public int bloodXOffset = 0;

        @Config.Name("[03] Blood Overlay Y-Offset")
        @Config.Comment("Set the Y-Offset of the Blood Overlay.")
        public int bloodYOffset = 0;

        @Config.Name("[04] Always Show Blood Overlay")
        @Config.Comment("Always show the Blood Overlay.")
        public boolean alwaysShowBloodOverlay = false;

        @Config.Name("[05] Blood Overlay Background Color")
        @Config.Comment("Set the background color of the Blood Overlay.")
        public int bloodBackgroundColor = 2005401600;

        @Config.Name("[06] Blood Overlay Foreground Color")
        @Config.Comment("Set the foreground color of the Blood Overlay.")
        public int bloodForegroundColor = 2013200384;

        @Config.Name("[07] Blood Overlay Height")
        @Config.Comment("Set the height of the Blood Overlay.")
        @Config.RangeInt(min = 0)
        public int bloodHeight = 30;

        @Config.Name("[08] Blood Overlay Width")
        @Config.Comment("Set the width of the Blood Overlay.")
        @Config.RangeInt(min = 0)
        public int bloodWidth = 5;

        @Config.Name("[09] Blood Icon X-Offset")
        @Config.Comment("Set the X-Offset of the Blood Icon.")
        public int bloodIconXOffset = 0;

        @Config.Name("[10] Blood Icon Y-Offset")
        @Config.Comment("Set the Y-Offset of the Blood Icon.")
        public int bloodIconYOffset = 0;
    }

    @Config.Name("Matter Overdrive")
    @Config.LangKey("config.endermodpacktweaks.matter_overdrive")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/matter-overdrive-community-edition")
    public static final MatterOverdrive MATTER_OVERDRIVE = new MatterOverdrive();

    public static class MatterOverdrive {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Matter Overdrive Tweaks")
        @Config.Comment("Enable tweaks for the Matter Overdrive mod.")
        public boolean enable = false;

        @Config.Name("[02] Always Show Matter Info")
        @Config.Comment("Always show the matter info without sneaking.")
        public boolean alwaysShowMatterInfo = false;
    }

    @Config.Name("Multi Builder Tool")
    @Config.LangKey("config.endermodpacktweaks.multi_builder_tool")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/multi-builder-tool")
    public static final MultiBuilderTool MULTI_BUILDER_TOOL = new MultiBuilderTool();

    public static class MultiBuilderTool {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Multi Builder Tool Tweaks")
        @Config.Comment({
                "This tweak fixes issues with the Multi Builder Tool mod.",
                "Crash with Flux Networks: https://github.com/igentuman/multi-builder-tool/issues/11"
        })
        public boolean enable = true;
    }

    @Config.Name("Perfect Spawn")
    @Config.LangKey("config.endermodpacktweaks.perfect_spawn")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/perfect-spawn")
    public static final PerfectSpawn PERFECT_SPAWN = new PerfectSpawn();

    public static class PerfectSpawn {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Perfect Spawn Tweaks")
        @Config.Comment({
                "This tweaks moves the PerfectSpawn config file to the config directory.",
                "It also creates a new config file if it doesn't exist."
        })
        public boolean enable = true;
    }

    @Config.Name("Pickle Tweaks")
    @Config.LangKey("config.endermodpacktweaks.pickle_tweaks")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/pickle-tweaks")
    public static final PickleTweaks PICKLE_TWEAKS = new PickleTweaks();

    public static class PickleTweaks {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Pickle Tweaks")
        @Config.Comment("Enable tweaks for the Pickle Tweaks mod.")
        public boolean enable = false;

        @Config.Name("[02] Always Show Tool Info")
        @Config.Comment("Always show the tool info without sneaking.")
        public boolean alwaysShowToolInfo = false;

        @Config.Name("[03] Always Show Sword Info")
        @Config.Comment("Always show the sword info without sneaking.")
        public boolean alwaysShowSwordInfo = false;

        @Config.Name("[04] Always Show Hoe Info")
        @Config.Comment("Always show the hoe info without sneaking.")
        public boolean alwaysShowHoeInfo = false;

        @Config.Name("[05] Always Show Bow Info")
        @Config.Comment("Always show the bow info without sneaking.")
        public boolean alwaysShowBowInfo = false;
    }

    @Config.Name("Potion Core")
    @Config.LangKey("config.endermodpacktweaks.potion_core")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/potion-core")
    public static final PotionCore POTION_CORE = new PotionCore();

    public static class PotionCore {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Potion Core Tweaks")
        @Config.Comment("Enable tweaks for the Potion Core mod.")
        public boolean enable = false;

        @Config.Name("[02] Render Offset")
        @Config.Comment("Set the render offset of the HUD renderer.")
        public int renderOffset = -3;
    }

    @Config.Name("Pyrotech")
    @Config.LangKey("config.endermodpacktweaks.pyrotech")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/pyrotech")
    public static final Pyrotech PYROTECH = new Pyrotech();

    public static class Pyrotech {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Pyrotech Tweaks")
        @Config.Comment("Enable tweaks for the Pyrotech mod.")
        public boolean enable = false;

        @Config.Name("[02] Random Rocks")
        @Config.Comment("Enable random rocks in the world.")
        public boolean randomRocks = false;

        @Config.Name("[03] Rock Weight")
        @Config.Comment("The weight of rocks in the world.")
        public final RockWeight ROCK_WEIGHT = new RockWeight();

        public static class RockWeight {
            @Config.Name("[01] Weight: rock_stone")
            @Config.Comment("The weight of Stone Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int stone = 100;

            @Config.Name("[02] Weight: rock_granite")
            @Config.Comment("The weight of Granite Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int granite = 0;

            @Config.Name("[03] Weight: rock_diorite")
            @Config.Comment("The weight of Diorite Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int diorite = 0;

            @Config.Name("[04] Weight: rock_andesite")
            @Config.Comment("The weight of Andesite Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int andesite = 0;

            @Config.Name("[05] Weight: rock_dirt")
            @Config.Comment("The weight of Dirt Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int dirt = 0;

            @Config.Name("[06] Weight: rock_sand")
            @Config.Comment("The weight of Sand Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int sand = 0;

            @Config.Name("[07] Weight: rock_sandstone")
            @Config.Comment("The weight of Sandstone Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int sandstone = 0;

            @Config.Name("[08] Weight: rock_wood_chips")
            @Config.Comment("The weight of Wood Chips Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int wood_chips = 0;

            @Config.Name("[09] Weight: rock_limestone")
            @Config.Comment("The weight of Limestone Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int limestone = 0;

            @Config.Name("[10] Weight: rock_sand_red")
            @Config.Comment("The weight of Red Sand Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int sand_red = 0;

            @Config.Name("[11] Weight: rock_sandstone_red")
            @Config.Comment("The weight of Red Sandstone Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int sandstone_red = 0;

            @Config.Name("[12] Weight: rock_mud")
            @Config.Comment("The weight of Mud Rocks.")
            @Config.RangeInt(min = 0, max = 1000)
            public int mud = 0;
        }
    }

    @Config.Name("Quark")
    @Config.LangKey("config.endermodpacktweaks.quark")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/quark-rotn-edition")
    public static final Quark QUARK = new Quark();

    public static class Quark {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Quark Tweaks")
        @Config.Comment("Enable tweaks for the Quark mod.")
        public boolean enable = false;

        @Config.Name("[02] Always show the Usage Ticker")
        @Config.Comment("Stops the Usage Ticker from disappearing.")
        public boolean alwaysShowUsageTicker = false;

        @Config.Name("[03] Armor Y-Offset")
        @Config.Comment("Set the Y-Offset of the Armor Part of the Usage Ticker.")
        public int armorYOffset = 0;

        @Config.Name("[04] Tool Y-Offset")
        @Config.Comment("Set the Y-Offset of the Tool Part of the Usage Ticker.")
        public int itemYOffset = 0;

        @Config.Name("[05] Enable End Stone Speleothems")
        @Config.Comment("Add and generate End Stone Speleothems.")
        public boolean enableEndSpeleothems = false;

        @Config.Name("[06] Enable Obsidian Speleothems")
        @Config.Comment("Add and generate Obsidian Speleothems.")
        public boolean enableObsidianSpeleothems = false;
    }

    @Config.Name("Reskillable")
    @Config.LangKey("config.endermodpacktweaks.reskillable")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/reskillable-fork")
    public static final Reskillable RESKILLABLE = new Reskillable();

    public static class Reskillable {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Reskillable Tweaks")
        @Config.Comment("Enable tweaks for the Reskillable mod.")
        public boolean enable = true;

        @Config.Name("[02] Max Level")
        @Config.Comment("Set the max level of the sum of all skills a player can have. Set to 0 to disable.")
        @Config.RangeInt(min = 0)
        public int maxLevel = 0;
    }

    @Config.Name("Rustic")
    @Config.LangKey("config.endermodpacktweaks.rustic")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/rustic")
    public static final Rustic RUSTIC = new Rustic();

    public static class Rustic {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Rustic Tweaks")
        @Config.Comment("Set to false to disable Rustic tweaks")
        public boolean enable = false;

        @Config.Name("[02] Berry Bush generation spread")
        @Config.Comment("Tweaking the max radius Rustic's berry bushes try to generate in per patch")
        @Config.RangeInt(min = 1, max = 16)
        public int maxWildberrySpread = 7;

        @Config.Name("[03] Override Berry Bush placement")
        @Config.Comment("Set to true to override Rustic's berry bush placement")
        public boolean overrideBerryBushPlacement = false;

        @Config.Name("[04] Valid Berry Bush blocks")
        @Config.Comment("List of blocks that Rustic's berry bushes can be placed on")
        public String[] listBerryBushBlocks = new String[]{
                "minecraft:grass",
                "minecraft:dirt",
                "minecraft:farmland",
                "rustic:fertile_soil"
        };

        @Config.Name("[05] Override Berry Bush biome blacklist")
        @Config.Comment("Set to true to override Rustic's berry bush biome blacklist")
        public boolean overrideBerryBushBiomeBlacklist = false;

        @Config.Name("[06] Berry Bush biomes blacklist")
        @Config.Comment("List of biomes that Rustic's berry bushes won't be generated in")
        public String[] listBiomesBlacklist = new String[]{
                "COLD",
                "SNOWY",
                "SANDY",
                "SAVANNA",
                "MESA",
                "MUSHROOM",
                "NETHER",
                "END",
                "DEAD",
                "WASTELAND",
        };

        @Config.Name("[07] Enable Rustic WorldGen in Flat Worlds")
        @Config.Comment("Set to true to enable Rustic WorldGen in flat worlds")
        public boolean enableWorldGenInFlat = false;

        @Config.Name("[08] Toughness Overlay X-Offset")
        @Config.Comment("Set the X-Offset of the Armor Toughness Overlay.")
        public int armorToughnessXOffset = 0;

        @Config.Name("[09] Toughness Overlay Y-Offset")
        @Config.Comment("Set the Y-Offset of the Armor Toughness Overlay.")
        public int armorToughnessYOffset = 0;

        @Config.Name("[10] Armor Overlay X-Offset")
        @Config.Comment("Set the X-Offset of the Armor Overlay.")
        public int armorXOffset = 0;

        @Config.Name("[10] Armor Overlay Y-Offset")
        @Config.Comment("Set the Y-Offset of the Armor Overlay.")
        public int armorYOffset = 0;
    }

    @Config.Name("Simple Difficulty")
    @Config.LangKey("config.endermodpacktweaks.simple_difficulty")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/simpledifficulty-for-underdog")
    public static final SimpleDifficulty SIMPLE_DIFFICULTY = new SimpleDifficulty();

    public static class SimpleDifficulty {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Simple Difficulty Tweaks")
        @Config.Comment("Set to false to disable Simple Difficulty tweaks.")
        public boolean enable = false;

        @Config.Name("[02] Thirstbar X-Offset")
        @Config.Comment("Set the X-Offset of the Thirstbar.")
        public int thirstbarXOffset = 82;

        @Config.Name("[03] Thirstbar Y-Offset")
        @Config.Comment("Set the Y-Offset of the Thirstbar.")
        public int thirstbarYOffset = -53;

        @Config.RequiresMcRestart
        @Config.Name("[04] Temperature Potion Effects")
        @Config.Comment({
                "Add additional potion effects to the player depending on the temperature.",
                "The temperature bounds must be between 0 and 25.",
                "FORMAT: lower_bound;upper_bound;effect;amplifier",
                "Example: 0;5;minecraft:slowness;2"
        })
        public String[] temperaturePotions = new String[]{};

        @Config.RequiresMcRestart
        @Config.Name("[05] Thirst Potion Effects")
        @Config.Comment({
                "Add additional potion effects to the player depending on the thirst level.",
                "The thirst bounds must be between 0 and 20.",
                "FORMAT: lower_bound;upper_bound;effect;amplifier",
                "Example: 0;5;minecraft:slowness;2"
        })
        public String[] thirstPotions = new String[]{};

        @Config.Name("[06] Thirst on Respawn")
        @Config.Comment("Set the thirst level of the player on respawn.")
        @Config.RangeInt(min = 0, max = 20)
        public int respawnThirst = 20;

        @Config.Name("[07] Thirst Saturation on Respawn")
        @Config.Comment("Set the thirst saturation of the player on respawn.")
        @Config.RangeInt(min = 0, max = 20)
        public int respawnThirstSaturation = 6;

        @Config.Name("[08] Cold Resistance Upper Limit")
        @Config.Comment("Set the upper limit of the cold resistance effect to block temperature effects.")
        @Config.RangeInt(min = 0, max = 25)
        public int coldResistanceUpperLimit = 12;

        @Config.Name("[09] Heat Resistance Lower Limit")
        @Config.Comment("Set the lower limit of the heat resistance effect to block temperature effects.")
        @Config.RangeInt(min = 0, max = 25)
        public int heatResistanceLowerLimit = 13;
    }

    @Config.Name("Tool Progression")
    @Config.LangKey("config.endermodpacktweaks.tool_progression")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/tool-progression")
    public static final ToolProgression TOOL_PROGRESSION = new ToolProgression();

    public static class ToolProgression {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable Tool Progression Tweaks")
        @Config.Comment({
                "This tweak allows changes how the configuration file of the mod are generated.",
                "It creates a few subdirectories and moves the configuration files into them."
        })
        public boolean enable = true;
    }

    @Config.Name("WAILA / HWYLA")
    @Config.LangKey("config.endermodpacktweaks.waila")
    @Config.Comment("https://www.curseforge.com/minecraft/mc-mods/hwyla")
    public static final Waila WAILA = new Waila();

    public static class Waila {
        @Config.RequiresMcRestart
        @Config.Name("[01] Enable WAILA Tweaks")
        @Config.Comment("Enable tweaks for the WAILA mod.")
        public boolean enable = false;

        @Config.RequiresMcRestart
        @Config.Name("[02] Override Block Name")
        @Config.Comment({
                "Override a block name with the name of another block.",
                "This feature mimics the Monster Egg Block behavior.",
                "FORMAT: [what block to replace];[what block to replace with]",
                "FORMAT: modid:blockid:metadata;modid:blockid:metadata",
                "EXAMPLE: minecraft:trapped_chest;minecraft:chest",
                "NOTE: this doesn't change the block preview that's displayed, only the name.",
        })
        public String[] overrideBlockName = new String[]{};
    }

    @Mod.EventBusSubscriber(modid = Tags.MOD_ID)
    public static class ConfigEventHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Tags.MOD_ID)) {
                ConfigManager.sync(Tags.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }

    static {
        ConfigAnytime.register(EMTConfig.class);
    }
}
