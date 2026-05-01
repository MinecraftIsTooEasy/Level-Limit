package org.moddedmite.mitemod.lvllimit;

import fi.dy.masa.malilib.config.ConfigManager;
import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.ModResourceManager;

public class LvlLimitMod implements ModInitializer {
    public void onInitialize() {
        LvlLimitEvent.register();
        LvlLimitConfig.getInstance().load();
        ConfigManager.getInstance().registerConfig(LvlLimitConfig.getInstance());
        ModResourceManager.addResourcePackDomain("lvllimit");
    }
}
