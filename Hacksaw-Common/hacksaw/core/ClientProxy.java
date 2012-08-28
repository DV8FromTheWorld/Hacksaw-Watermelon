package hacksaw.core;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{

	@Override
	public void preloadTextures(){
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/items.png");
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/food.png");
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/crops.png");
		MinecraftForgeClient.preloadTexture("/hacksaw/textures/seeds.png");
	}
	
}
