package com.zaixiayesheng.ae2_emi_quick_fill;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AE2: EMI Quick Fill — main mod entry point.
 *
 * <p>Client-side only: no blocks, items, packets or registry entries. Everything is done by
 * {@link com.zaixiayesheng.ae2_emi_quick_fill.mixin.Ae2AbstractRecipeHandlerMixin}.
 *
 * <p>{@code displayTest = "IGNORE_ALL_VERSION"} in {@code neoforge.mods.toml} keeps the server list
 * from flagging the mod as missing on servers that do not have it.
 *
 * <p>This is the 1.20.1 Forge branch: the loader classes are {@code net.minecraftforge.*}, and
 * Forge's {@code @Mod} has no {@code dist} parameter, so the annotation below is plain. Client-only
 * behaviour comes from the {@code "client"} section of the mixin config.
 *
 * @author zaixiayesheng (在下叶笙)
 */
@Mod(EmiAe2ShiftCraft.MOD_ID)
public final class EmiAe2ShiftCraft {

    /** Mod identifier, must match {@code mod_id} in gradle.properties and neoforge.mods.toml. */
    public static final String MOD_ID = "ae2_emi_quick_fill";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public EmiAe2ShiftCraft(IEventBus modEventBus) {
        LOGGER.info("AE2: EMI Quick Fill loaded — shift-click a recipe to pull it into any AE2 terminal.");
    }
}
