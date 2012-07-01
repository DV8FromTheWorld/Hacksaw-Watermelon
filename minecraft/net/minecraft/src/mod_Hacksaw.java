package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;
import net.minecraft.src.forge.NetworkMod;
import java.io.File;

public class mod_Hacksaw extends NetworkMod{

	
	//config not working yet
	static Configuration configuration = new Configuration(new File(Minecraft.getMinecraftDir(), "config/HacksawCore.cfg"));
	
	@Override
	public String getVersion() {
		return "v0.0";
	}

	@Override
	public void load() {
		System.out.println("Hey, i got loaded right yo!"); //for testing purposes only
	}
	
	public boolean clientSideRequired()
    {
        return true;
    }

	
	public boolean serverSideRequired()
    {
        return false;
    }
	
}
