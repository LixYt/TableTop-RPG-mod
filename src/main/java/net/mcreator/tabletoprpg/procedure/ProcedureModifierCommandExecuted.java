package net.mcreator.tabletoprpg.procedure;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import net.mcreator.tabletoprpg.TableTopRPGVariables;
import net.mcreator.tabletoprpg.ElementsTableTopRPG;

import java.util.HashMap;

@ElementsTableTopRPG.ModElement.Tag
public class ProcedureModifierCommandExecuted extends ElementsTableTopRPG.ModElement {
	public ProcedureModifierCommandExecuted(ElementsTableTopRPG instance) {
		super(instance, 13);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ModifierCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure ModifierCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ModifierCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		World world = (World) dependencies.get("world");
		if ((!(world.isRemote))) {
			if ((((TableTopRPGVariables.MapVariables.get(world).CurrentPlayer)).equals((entity.getDisplayName().getUnformattedText())))) {
				TableTopRPGVariables.MapVariables.get(world).modifier = (double) new Object() {
					int convert(String s) {
						try {
							return Integer.parseInt(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("0");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()));
				TableTopRPGVariables.MapVariables.get(world).syncData(world);
			} else {
				{
					MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(
								new TextComponentString((((entity.getDisplayName().getUnformattedText())) + "" + (", ce n'est pas ton tour !"))));
				}
			}
		}
	}
}
