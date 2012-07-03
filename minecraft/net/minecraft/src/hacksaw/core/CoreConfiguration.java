package net.minecraft.src.hacksaw.core;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.ModLoader;
import net.minecraft.src.mod_Hacksaw;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.Property;

public class CoreConfiguration extends Configuration {
	public static final String USE_VANILLA_RECIPES = "useVanillaRecipes";
	
	private static CoreConfiguration INSTANCE = null;
	public static CoreConfiguration getInstance() {
		return INSTANCE;
	}

	private CoreConfiguration(File file) {
		super(file);
	}
	
	public static void init( String path ) {
		if( INSTANCE != null ) {
			ModLoader.getLogger().warning("[Hacksaw] blocked attempt to reinit config");
			return;
		}
		
		final File file = new File(Minecraft.getMinecraftDir(), path);
		INSTANCE = new CoreConfiguration(file);
		INSTANCE.load();
		INSTANCE.populateDefaults();
		INSTANCE.save();
	}
	
	private void populateDefaults() {
		Property prop = getOrCreateBooleanProperty(USE_VANILLA_RECIPES, Configuration.CATEGORY_GENERAL, false);
		prop.comment = "Should we keep vanilla bread and meat recipes? (default: false)";
		
		// TODO: read default id's from a separate file?
		getOrCreateIntProperty("multigrain.bread", Configuration.CATEGORY_ITEM, 384);
		getOrCreateIntProperty("flat.bread", Configuration.CATEGORY_ITEM, 385);
	}
	
	public static boolean getPreference( String propName ) {
		Property prop = INSTANCE.generalProperties.get(propName);
		if( prop != null && prop.isBooleanValue() ) {
			return prop.getBoolean(false);
		}
		return false;
	}
	
	@Override
	public void save() {
		/*
		 * BC does it this way
		 * 
		Property version = null;
		if( !generalProperties.containsKey("version") ) {
			version = new Property();
			version.name = "version";
			generalProperties.put("version", version);
		} else {
			version = generalProperties.get("version");
		}
		version.value = mod_Hacksaw.version();
		*/
		// i'm doing it this way
		Property version = getOrCreateProperty("version", Configuration.CATEGORY_GENERAL, mod_Hacksaw.version());
		super.save();
	}
}
