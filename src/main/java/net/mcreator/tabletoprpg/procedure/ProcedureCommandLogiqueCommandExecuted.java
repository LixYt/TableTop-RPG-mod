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
public class ProcedureCommandLogiqueCommandExecuted extends ElementsTableTopRPG.ModElement {
	public ProcedureCommandLogiqueCommandExecuted(ElementsTableTopRPG instance) {
		super(instance, 15);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CommandLogiqueCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure CommandLogiqueCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CommandLogiqueCommandExecuted!");
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
				entity.getEntityData().setDouble("logique", new Object() {
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
								.sendMessage(new TextComponentString((("La Logique de ") + "" + ((((entity.getDisplayName().getFormattedText())) + ""
										+ (((" est d\u00E9finit \u00E0 ") + "" + (Math.round((entity.getEntityData().getDouble("logique")))))))))));
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
				} else if ((((entity.getEntityData().getDouble("logique")) <= 0) || ((entity.getEntityData().getDouble("logique")) > 95))) {
					{
						MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
						if (mcserv != null)
							mcserv.getPlayerList().sendMessage(new TextComponentString(
									"Logique non ou mal configur\u00E9. Faite un /logique set [valeur comprise entre 1 et 95] "));
					}
				} else {
					if (((TableTopRPGVariables.MapVariables.get(world).lastDice) <= 5)) {
						resultTxt = (String) "Jet de Logique : R\u00E9ussite critique. ";
						TableTopRPGVariables.MapVariables.get(world).CurrentResult = (String) "reussite-critique";
						TableTopRPGVariables.MapVariables.get(world).syncData(world);
					} else if (((TableTopRPGVariables.MapVariables.get(world).lastDice) <= ((entity.getEntityData().getDouble("logique"))
							+ (TableTopRPGVariables.MapVariables.get(world).modifier)))) {
						resultTxt = (String) "Jet de logique : R\u00E9ussite. ";
						TableTopRPGVariables.MapVariables.get(world).CurrentResult = (String) "reussite";
						TableTopRPGVariables.MapVariables.get(world).syncData(world);
					} else if (((TableTopRPGVariables.MapVariables.get(world).lastDice) > 95)) {
						resultTxt = (String) "Jet de Logique : Echec critique. ";
						TableTopRPGVariables.MapVariables.get(world).CurrentResult = (String) "echec-critique";
						TableTopRPGVariables.MapVariables.get(world).syncData(world);
					} else {
						resultTxt = (String) "Jet de Logique : Echec. ";
						TableTopRPGVariables.MapVariables.get(world).CurrentResult = (String) "echec";
						TableTopRPGVariables.MapVariables.get(world).syncData(world);
					}
					{
						MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
						if (mcserv != null)
							mcserv.getPlayerList()
									.sendMessage(new TextComponentString((((resultTxt)) + ""
											+ (((Math.round((TableTopRPGVariables.MapVariables.get(world).lastDice))) + ""
													+ (((" pour ") + "" + (((Math.round(((entity.getEntityData().getDouble("logique"))
															+ (TableTopRPGVariables.MapVariables.get(world).modifier))))
															+ ""
															+ (((" (") + "" + (((Math.round((entity.getEntityData().getDouble("logique")))) + ""
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
								new TextComponentString((("Logique : ") + "" + (Math.round((entity.getEntityData().getDouble("logique")))))));
				}
			}
		}
	}
}
