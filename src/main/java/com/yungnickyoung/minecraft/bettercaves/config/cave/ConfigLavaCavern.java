package com.yungnickyoung.minecraft.bettercaves.config.cave;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigLavaCavern {
    public final ForgeConfigSpec.ConfigValue<Integer> caveTop;
    public final ForgeConfigSpec.ConfigValue<Integer> caveBottom;
    public final ForgeConfigSpec.ConfigValue<Double> yCompression;
    public final ForgeConfigSpec.ConfigValue<Double> xzCompression;
    public final ForgeConfigSpec.ConfigValue<String> caveFrequency;

    public ConfigLavaCavern(final ForgeConfigSpec.Builder builder) {
        builder.push("Lava Caverns");

        caveTop = builder
                .comment(" The top y-coordinate at which Lava Caverns start generating. Note that caverns will attempt " +
                        "to close off anyway if this value is greater than the surface y-coordinate.")
                .worldRestart()
                .define("Top Generation Altitude", 30);

        caveBottom = builder
                .comment(" The bottom y-coordinate at which Lava Caverns stop generating.")
                .worldRestart()
                .define("Bottom Generation Altitude", 1);

        yCompression = builder
                .comment(" Changes height of caves. Lower value = taller caves with steeper drops.")
                .worldRestart()
                .defineInRange("Vertical Compression", 1.0f, 0f, 20f);

        xzCompression = builder
                .comment(" Changes width of caves. Lower value = wider caves.")
                .worldRestart()
                .defineInRange("Horizontal Compression", 1.0f, 0f, 20f);

        caveFrequency = builder
                .comment(" Determines how frequently Lava Caverns spawn." +
                        "\n Accepted values: None, Rare, Normal, Common, VeryCommon")
                .worldRestart()
                .define("Lava Cavern Frequency", "Normal");

        builder.pop();
    }
}
