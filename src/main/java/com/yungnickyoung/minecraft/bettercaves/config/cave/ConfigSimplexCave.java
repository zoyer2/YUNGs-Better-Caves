package com.yungnickyoung.minecraft.bettercaves.config.cave;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigSimplexCave {
    public final ForgeConfigSpec.ConfigValue<Integer> caveBottom;
    public final ForgeConfigSpec.ConfigValue<Double> yCompression;
    public final ForgeConfigSpec.ConfigValue<Double> xzCompression;
    public final ForgeConfigSpec.ConfigValue<String> caveFrequency;

    public ConfigSimplexCave(final ForgeConfigSpec.Builder builder) {
        builder.push("Type 2 Caves (Simplex)");

        caveBottom = builder
                .comment(" The minimum y-coordinate at which caves start generating.")
                .worldRestart()
                .define("Cave Bottom Altitude", 1);

        yCompression = builder
                .comment(" Changes height of caves. Lower value = taller caves with steeper drops.")
                .worldRestart()
                .defineInRange("Vertical Compression", 3.0f, 0f, 20f);

        xzCompression = builder
                .comment(" Changes width of caves. Lower value = wider caves.")
                .worldRestart()
                .defineInRange("Horizontal Compression", 1.0f, 0f, 20f);

        caveFrequency = builder
                .comment(" Determines how frequently Type 2 Caves spawn. If this is anything but VeryCommon (the default), vanilla caves will " +
                        "replace some of the areas where Type 2 Caves would have generated.\n However, if vanilla caves are disabled, " +
                        "then these areas will instead not have any caves at all.\n Accepted values: None, Rare, Common, VeryCommon")
                .worldRestart()
                .define("Type 2 Cave Frequency", "VeryCommon");

        builder.pop();
    }
}
