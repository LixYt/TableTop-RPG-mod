package net.mcreator.tabletoprpg.procedure;

import net.minecraft.world.World;

import net.mcreator.tabletoprpg.TableTopRPGVariables;
import net.mcreator.tabletoprpg.ElementsTableTopRPG;

@ElementsTableTopRPG.ModElement.Tag
public class ProcedureRunDisplayEchec extends ElementsTableTopRPG.ModElement {
	public ProcedureRunDisplayEchec(ElementsTableTopRPG instance) {
		super(instance, 30);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure RunDisplayEchec!");
			return;
		}
		World world = (World) dependencies.get("world");
		TableTopRPGVariables.MapVariables.get(world).DisplayResult = (boolean) (true);
		TableTopRPGVariables.MapVariables.get(world).syncData(world);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		TableTopRPGVariables.MapVariables.get(world).DisplayResult = (boolean) (true);
		TableTopRPGVariables.MapVariables.get(world).syncData(world);
		TableTopRPGVariables.MapVariables.get(world).CurrentResult = (String) "";
		TableTopRPGVariables.MapVariables.get(world).syncData(world);
		TableTopRPGVariables.MapVariables.get(world).lastDice = (double) 0;
		TableTopRPGVariables.MapVariables.get(world).syncData(world);
		TableTopRPGVariables.MapVariables.get(world).lastDice = (double) 0;
		TableTopRPGVariables.MapVariables.get(world).syncData(world);
	}
}
