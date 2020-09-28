package com.ytg123.manhunt;

import com.ytg123.manhunt.config.ManhuntConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Manhunt implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "manhunt";
    public static final String MOD_NAME = "Manhunt Fabric";
    public static ManhuntConfig CONFIG;

    /**
     * Initializes the mod.
     */
    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        AutoConfig.register(ManhuntConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ManhuntConfig.class).getConfig();
        log(Level.INFO, "" + CONFIG.compassBehaviour.name());

        ServerTickEvents.END_SERVER_TICK.register(EventListener.INSTANCE);

        CommandRegistrationCallback.EVENT.register(EventListener.INSTANCE);
    }

    /**
     * Logs a message to the console.
     * @param level The log level
     * @param message The message being logged
     */
    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }
}
