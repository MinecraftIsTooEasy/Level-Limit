package org.moddedmite.mitemod.lvllimit;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fi.dy.masa.malilib.config.ConfigTab;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.SimpleConfigs;
import fi.dy.masa.malilib.config.options.*;
import fi.dy.masa.malilib.util.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class LvlLimitConfig extends SimpleConfigs {
    public static final ConfigInteger PLAYER_MAX_LEVEL = new ConfigInteger("lvllimt.max_level", 200, Integer.MIN_VALUE, Integer.MAX_VALUE, false, "");
    public static final ConfigInteger PLAYER_MIN_LEVEL = new ConfigInteger("lvllimt.min_level", -40, Integer.MIN_VALUE, Integer.MAX_VALUE, false, "");
    
    private static final LvlLimitConfig Instance;
    public static final List<ConfigBase<?>> general;
    
    public static final List<ConfigTab> tabs = new ArrayList<>();
    
    public LvlLimitConfig() {
        super("Level-Limit", null,null);
    }
    
    static {
        general = List.of(PLAYER_MAX_LEVEL, PLAYER_MIN_LEVEL);
        tabs.add(new ConfigTab("General", general));
        Instance = new LvlLimitConfig();
    }
    
    @Override
    public List<ConfigTab> getConfigTabs() {
        return tabs;
    }
    
    public static LvlLimitConfig getInstance() {
        return Instance;
    }
    
    @Override
    public void save() {
        JsonObject root = new JsonObject();
        ConfigUtils.writeConfigBase(root, "general", general);
        JsonUtils.writeJsonToFile(root, this.optionsFile);
    }
    
    @Override
    public void load() {
        if (!this.optionsFile.exists()) {
            this.save();
        } else {
            JsonElement jsonElement = JsonUtils.parseJsonFile(this.optionsFile);
            if (jsonElement != null && jsonElement.isJsonObject()) {
                JsonObject root = jsonElement.getAsJsonObject();
                ConfigUtils.readConfigBase(root, "general", general);
            }
        }
    }
}
