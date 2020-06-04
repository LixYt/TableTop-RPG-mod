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
public class ProcedureCommandMentalCommandExecuted extends ElementsTableTopRPG.ModElement {
	public ProcedureCommandMentalCommandExecuted(ElementsTableTopRPG instance) {
		super(instance, 17);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CommandMentalCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure CommandMentalCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CommandMentalCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		World world = (World) dependencies.get("world");
		double value = 0;
		String command = "";
		String resultTxt = "";
		if ((!(world.isRemote))) {
			if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("set"))) {
				entity.getEntityData().setDouble("mental", new Object() {
					int convert(String s) {
						try {
							return Integer.parseInt(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("1");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText())));
				{
					MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
					if (mcserv != null)
						mcserv.getPlayerList()
								.sendMessage(new TextComponentString((("Le mental de ") + "" + ((((entity.getDisplayName().getUnformattedText())) + ""
										+ (((" est d\u00E9finit \u00E0 ") + "" + (Math.round((entity.getEntityData().getDouble("mental")))))))))));
				}
			} else if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("roll"))) {
				if (((TableTopRPGVariables.MapVariables.get(world).lastDice) <= 0)) {
					{
						MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
						if (mcserv != null)
							mcserv.getPlayerList().sendMessage(new TextComponentString("Pas de derner lanc\u00E9..."));
					}
				} else if ((((entity.getEntityData().getDouble("mental")) <= 0) || ((entity.getEntityData().getDouble("mental")) > 95))) {
					{
						MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
						if (mcserv != null)
							mcserv.getPlayerList().sendMessage(new TextComponentString(
									"Mental non ou mal configur\u00E9. Faite un /mental set [valeur comprise entre 1 et 95] "));
					}
				} else {
					if (((TableTopRPGVariables.MapVariables.get(world).lastDice) <= 5)) {
						TableTopRPGVariables.MapVariables.get(world).CurrentResult = (String) "Jet de Mental : R\u00E9ussite critique. ";
						TableTopRPGVariables.MapVariables.get(world).syncData(world);
					} else if (((TableTopRPGVariables.MapVariables.get(world).lastDice) <= ((entity.getEntityData().getDouble("mental"))
							+ (TableTopRPGVariables.MapVariables.get(world).modifier)))) {
						TableTopRPGVariables.MapVariables.get(world).CurrentResult = (String) "Jet de Mental : R\u00E9ussite. ";
						TableTopRPGVariables.MapVariables.get(world).syncData(world);
					} else if (((TableTopRPGVariables.MapVariables.get(world).lastDice) > 95)) {
						TableTopRPGVariables.MapVariables.get(world).CurrentResult = (String) "Jet de Mental : Echec critique. ";
						TableTopRPGVariables.MapVariables.get(world).syncData(world);
					} else {
						TableTopRPGVariables.MapVariables.get(world).CurrentResult = (String) "Jet de Mental : Echec. ";
						TableTopRPGVariables.MapVariables.get(world).syncData(world);
					}
					{
						MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
						if (mcserv != null)
							mcserv.getPlayerList()
									.sendMessage(new TextComponentString((((resultTxt)) + ""
											+ (((Math.round((TableTopRPGVariables.MapVariables.get(world).lastDice))) + ""
													+ (((" pour ") + "" + (((Math.round(((entity.getEntityData().getDouble("mental"))
															+ (TableTopRPGVariables.MapVariables.get(world).modifier))))
															+ ""
															+ (((" (") + "" + (((Math.round((entity.getEntityData().getDouble("mental")))) + ""
																	+ (((" + Modifier ") + ""
																			+ (((Math.round((TableTopRPGVariables.MapVariables.get(world).modifier)))
																					+ "" + (")"))))))))))))))))));
					}
					TableTopRPGVariables.MapVariables.get(world).modifier = (double) 0;
					TableTopRPGVariables.MapVariables.get(world).syncData(world);
					TableTopRPGVariables.MapVariables.get(world).lastDice = (double) 0;
					TableTopRPGVariables.MapVariables.get(world).syncData(world);
					{
						java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
						$_dependencies.put("world", world);
						ProcedureRunDisplayEchec.executeProcedure($_dependencies);
					}
				}
			} else if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("get"))) {
				{
					MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(
								new TextComponentString((("Mental : ") + "" + (Math.round((entity.getEntityData().getDouble("mental")))))));
				}
			}
		}
	}
}
