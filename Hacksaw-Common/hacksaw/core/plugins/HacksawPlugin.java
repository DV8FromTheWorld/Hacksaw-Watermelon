package hacksaw.core.plugins;

import hacksaw.core.util.HacksawLogger;
import net.minecraft.src.forge.NetworkMod;

public abstract class HacksawPlugin {
	protected NetworkMod mod;
	protected String plugin_name;
	protected boolean loaded = false;

	public HacksawPlugin( String className, String pluginName ) {
		plugin_name = pluginName;
		mod = loadMod( className );
		if( mod == null ) {
			HacksawLogger.log("Not loading "+plugin_name+" integration" );
		} else {
			HacksawLogger.log("Loading "+plugin_name+" integration plugin" );
			loaded = true;
			init();
		}
	}

	private NetworkMod loadMod( String className ) {
		Class<NetworkMod> clazz = null;
		try {
			clazz = (Class<NetworkMod>) Class.forName( className );
			NetworkMod mod = clazz.newInstance();
			HacksawLogger.log(getClass().getSimpleName()+" - Found "+plugin_name+" version "+mod.getVersion() );
			return mod;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( ClassNotFoundException e ) {
		}
		return null;
	}

	public boolean isLoaded() {
		return loaded;
	}

	abstract public void init();

}
