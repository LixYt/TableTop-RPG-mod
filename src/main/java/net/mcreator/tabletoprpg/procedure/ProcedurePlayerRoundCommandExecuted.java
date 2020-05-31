package net.mcreator.tabletoprpg.procedure;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;

import net.mcreator.tabletoprpg.TableTopRPGVariables;
import net.mcreator.tabletoprpg.ElementsTableTopRPG;

import java.util.HashMap;

@ElementsTableTopRPG.ModElement.Tag
public class ProcedurePlayerRoundCommandExecuted extends ElementsTableTopRPG.ModElement {
	public ProcedurePlayerRoundCommandExecuted(ElementsTableTopRPG instance) {
		super(instance, 25);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure PlayerRoundCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PlayerRoundCommandExecuted!");
			return;
		}
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		World world = (World) dependencies.get("world");
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
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new TextComponentString((("Tour de [") + "" + ((((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("0");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText())) + "" + ("]"))))));
		}
	}
}
