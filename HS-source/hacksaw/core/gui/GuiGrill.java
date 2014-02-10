package hacksaw.core.gui;

import org.lwjgl.opengl.GL11;

import hacksaw.core.containers.ContainerGrill;
import hacksaw.core.tileentities.TileEntityGrill;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiGrill extends GuiContainer
{

    public GuiGrill(InventoryPlayer inventoryPlayer, TileEntityGrill te)
    {
        super(new ContainerGrill(inventoryPlayer, te));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
            //draw text and stuff here
            //the parameters for drawString are: string, x, y, color
            fontRenderer.drawString("Tiny", 8, 6, 4210752);
            //draws "Inventory" or your regional equivalent
            fontRenderer.drawString("Grill", 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                    int par3) {
            //draw your Gui here, only thing you need to change is the path
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.renderEngine.bindTexture(new ResourceLocation("hacksaw", "textures/gui/grill.png"));
            int x = (width - xSize) / 2;
            int y = (height - ySize) / 2;
            this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

}
