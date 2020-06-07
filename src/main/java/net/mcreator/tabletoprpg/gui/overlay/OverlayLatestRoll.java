
package net.mcreator.tabletoprpg.gui.overlay;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;

import net.mcreator.tabletoprpg.TableTopRPGVariables;
import net.mcreator.tabletoprpg.ElementsTableTopRPG;

@ElementsTableTopRPG.ModElement.Tag
public class OverlayLatestRoll extends ElementsTableTopRPG.ModElement {
	public OverlayLatestRoll(ElementsTableTopRPG instance) {
		super(instance, 11);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new GUIRenderEventClass());
	}
	public static class GUIRenderEventClass {
		@SubscribeEvent(priority = EventPriority.NORMAL)
		@SideOnly(Side.CLIENT)
		public void eventHandler(RenderGameOverlayEvent event) {
			if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
				int posX = (event.getResolution().getScaledWidth()) / 2;
				int posY = (event.getResolution().getScaledHeight()) / 2;
				EntityPlayer entity = Minecraft.getMinecraft().player;
				World world = entity.world;
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				if ((((TableTopRPGVariables.MapVariables.get(world).lastDice) > 0)
						|| ((TableTopRPGVariables.MapVariables.get(world).modifier) != 0))) {
					GlStateManager.disableDepth();
					GlStateManager.depthMask(false);
					GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
							GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
					GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
					GlStateManager.disableAlpha();
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("tabletoprpg:textures/black_box3.png"));
					Minecraft.getMinecraft().ingameGUI.drawTexturedModalRect(posX + 74, posY + -119, 0, 0, 256, 256);
					GlStateManager.depthMask(true);
					GlStateManager.enableDepth();
					GlStateManager.enableAlpha();
					GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
					Minecraft.getMinecraft().fontRenderer.drawString("Dernier lanc\u00E9 : ", posX + 93, posY + -109, -1);
					Minecraft.getMinecraft().fontRenderer.drawString("Modifier : ", posX + 93, posY + -89, -1);
					Minecraft.getMinecraft().fontRenderer.drawString("" + (TableTopRPGVariables.MapVariables.get(world).modifier) + "", posX + 173,
							posY + -89, -1);
					Minecraft.getMinecraft().fontRenderer.drawString("" + (TableTopRPGVariables.MapVariables.get(world).lastDice) + "", posX + 173,
							posY + -109, -1);
				}
			}
		}
	}
}
