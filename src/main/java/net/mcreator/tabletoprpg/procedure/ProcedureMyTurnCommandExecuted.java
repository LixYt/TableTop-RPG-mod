package net.mcreator.tabletoprpg.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.tabletoprpg.TableTopRPGVariables;
import net.mcreator.tabletoprpg.ElementsTableTopRPG;

@ElementsTableTopRPG.ModElement.Tag
public class ProcedureMyTurnCommandExecuted extends ElementsTableTopRPG.ModElement {
	public ProcedureMyTurnCommandExecuted(ElementsTableTopRPG instance) {
		super(instance, 27);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MyTurnCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MyTurnCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		TableTopRPGVariables.MapVariables.get(world).CurrentPlayer = (String) (entity.getDisplayName().getFormattedText());
		TableTopRPGVariables.MapVariables.get(world).syncData(world);
		System.out.println((entity.getDisplayName().getFormattedText()));
		System.out.println(((entity.getDisplayName().getFormattedText())).length());
	}
}
