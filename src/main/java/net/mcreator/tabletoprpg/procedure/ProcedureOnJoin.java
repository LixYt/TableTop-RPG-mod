package net.mcreator.tabletoprpg.procedure;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.tabletoprpg.item.ItemRequestTurn;
import net.mcreator.tabletoprpg.item.ItemPhysiqueRoll;
import net.mcreator.tabletoprpg.item.ItemMentalRoll;
import net.mcreator.tabletoprpg.item.ItemLogiqueRoll;
import net.mcreator.tabletoprpg.item.ItemDice9;
import net.mcreator.tabletoprpg.item.ItemDice7;
import net.mcreator.tabletoprpg.item.ItemDice5;
import net.mcreator.tabletoprpg.item.ItemDice3;
import net.mcreator.tabletoprpg.item.ItemDice100;
import net.mcreator.tabletoprpg.item.ItemDice10;
import net.mcreator.tabletoprpg.ElementsTableTopRPG;

@ElementsTableTopRPG.ModElement.Tag
public class ProcedureOnJoin extends ElementsTableTopRPG.ModElement {
	public ProcedureOnJoin(ElementsTableTopRPG instance) {
		super(instance, 24);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OnJoin!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		String command = "";
		if (((entity.getEntityData().getDouble("physique")) == 0)) {
			entity.getEntityData().setDouble("physique", 0);
		}
		if (((entity.getEntityData().getDouble("logique")) == 0)) {
			entity.getEntityData().setDouble("logique", 0);
		}
		if (((entity.getEntityData().getDouble("mental")) == 0)) {
			entity.getEntityData().setDouble("mental", 0);
		}
		if (((!((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).capabilities.isCreativeMode : false))
				&& (entity instanceof EntityPlayer))) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clear();
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemDice100.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemRequestTurn.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemPhysiqueRoll.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemLogiqueRoll.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemMentalRoll.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemDice3.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemDice5.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemDice7.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemDice9.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemDice10.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.player;
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", (int) entity.posX);
		dependencies.put("y", (int) entity.posY);
		dependencies.put("z", (int) entity.posZ);
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
