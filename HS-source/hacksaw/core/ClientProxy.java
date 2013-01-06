package hacksaw.core;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	
	public static File path = Minecraft.getMinecraftDir();
	
	@Override
	public void preloadTextures(){
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/items.png");
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/food.png");
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/crops.png");
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/seeds.png");
	}
	
}
