package net.mcreator.tabletoprpg.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.tabletoprpg.TableTopRPGVariables;
import net.mcreator.tabletoprpg.ElementsTableTopRPG;

import java.util.HashMap;

@ElementsTableTopRPG.ModElement.Tag
public class ProcedurePlayCommandExecuted extends ElementsTableTopRPG.ModElement {
	public ProcedurePlayCommandExecuted(ElementsTableTopRPG instance) {
		super(instance, 31);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PlayCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure PlayCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PlayCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		World world = (World) dependencies.get("world");
		if (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).capabilities.isCreativeMode : false)) {
			TableTopRPGVariables.MapVariables.get(world).CurrentPlayer = (String) (new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText());
			TableTopRPGVariables.MapVariables.get(world).syncData(world);
			TableTopRPGVariables.MapVariables.get(world).lastDice = (double) 0;
			TableTopRPGVariables.MapVariables.get(world).syncData(world);
			TableTopRPGVariables.MapVariables.get(world).modifier = (double) 0;
			TableTopRPGVariables.MapVariables.get(world).syncData(world);
		}
	}
}
