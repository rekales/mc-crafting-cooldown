package com.krei.craftingcooldown;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = CraftingCooldown.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue ENABLED = BUILDER
            .comment("Whether to enable the crafting cooldown feature")
            .define("enabled", true);

    private static final ModConfigSpec.DoubleValue MULTIPLIER = BUILDER
            .comment("Cooldown time multiplier")
            .defineInRange("multiplier", 1.0, 0, 100);


    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean enabled;
    public static double multiplier;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        enabled = ENABLED.get();
        multiplier = MULTIPLIER.get();
    }
}
