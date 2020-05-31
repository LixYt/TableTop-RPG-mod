
package net.mcreator.tabletoprpg.gui.overlay;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.tabletoprpg.TableTopRPGVariables;
import net.mcreator.tabletoprpg.ElementsTableTopRPG;

@ElementsTableTopRPG.ModElement.Tag
public class OverlayTourDePlayer extends ElementsTableTopRPG.ModElement {
	public OverlayTourDePlayer(ElementsTableTopRPG instance) {
		super(instance, 26);
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
				if ((!(((TableTopRPGVariables.MapVariables.get(world).CurrentPlayer)).equals("")))) {
					Minecraft.getMinecraft().fontRenderer.drawString("Tour de " + (TableTopRPGVariables.MapVariables.get(world).CurrentPlayer) + "",
							posX + -111, posY + -114, -10092544);
				}
			}
		}
	}
}
