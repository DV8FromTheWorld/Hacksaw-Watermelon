package net.minecraft.src.hacksaw.core.items;

import net.minecraft.src.Item;
import net.minecraft.src.forge.ITextureProvider;

public class ItemChefKnife extends Item implements ITextureProvider{

	public int Sharpness;
	
	protected ItemChefKnife(int i, int j) {
		super(i);
		this.setMaxStackSize(1);
		
		Sharpness = j;
	}
	
	public int getKnifeSharpness(){
		return Sharpness;
	}

	public String getTextureFile(){
		return "hacksaw/textures/items/ItemChefKnife.png";
		
	}
}
