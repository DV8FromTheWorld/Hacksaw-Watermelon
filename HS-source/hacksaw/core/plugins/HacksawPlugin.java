package hacksaw.core.plugins;

import hacksaw.core.util.HacksawLogger;
import cpw.mods.fml.common.network.NetworkMod;


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
			//@allaryin, this needs to be reworked due to FML changes
			//HacksawLogger.log(getClass().getSimpleName()+" - Found "+plugin_name+" version "+mod.getVersion() );
			return mod;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
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
