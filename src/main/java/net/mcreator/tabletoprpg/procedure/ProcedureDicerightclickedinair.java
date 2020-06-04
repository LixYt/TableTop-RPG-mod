package net.mcreator.tabletoprpg.procedure;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.tabletoprpg.TableTopRPGVariables;
import net.mcreator.tabletoprpg.ElementsTableTopRPG;

@ElementsTableTopRPG.ModElement.Tag
public class ProcedureDicerightclickedinair extends ElementsTableTopRPG.ModElement {
	public ProcedureDicerightclickedinair(ElementsTableTopRPG instance) {
		super(instance, 3);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Dicerightclickedinair!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure Dicerightclickedinair!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Dicerightclickedinair!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		double random6 = 0;
		double NumberOfDice = 0;
		double total = 0;
		double diceSize = 0;
		String output = "";
		String playerName = "";
		if ((!(world.isRemote))) {
			if ((((TableTopRPGVariables.MapVariables.get(world).CurrentPlayer)).equals((entity.getDisplayName().getUnformattedText())))) {
				diceSize = (double) new Object() {
					int convert(String s) {
						try {
							return Integer.parseInt(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((((itemstack).getDisplayName()).substring((int) 4, (int) (((itemstack).getDisplayName())).length())));
				total = (double) 0;
				NumberOfDice = (double) (((itemstack)).getCount());
				while (((NumberOfDice) >= 1)) {
					random6 = (double) 0;
					while (((random6) <= 0)) {
						random6 = (double) ((new java.util.Random()).nextInt((int) (diceSize) + 1));
					}
					output = (String) (((output)) + "" + ((((new java.text.DecimalFormat("#").format((random6)))) + "" + (", "))));
					total = (double) ((total) + (random6));
					NumberOfDice = (double) ((NumberOfDice) - 1);
				}
				output = (String) ((output).substring((int) 0, (int) (((output)).length() - 2)));
				{
					MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
					if (mcserv != null)
						mcserv.getPlayerList()
								.sendMessage(new TextComponentString((((entity.getDisplayName().getFormattedText())) + ""
										+ (((" roll ") + "" + ((((new java.text.DecimalFormat("#").format((((itemstack)).getCount())))) + ""
												+ ((("d") + "" + ((((new java.text.DecimalFormat("#").format((diceSize)))) + ""
														+ ((("and get : ") + "" + ((new java.text.DecimalFormat("#").format((total)))))))))))))))));
				}
				{
					MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new TextComponentString(((" Detailed result : ") + "" + ((output)))));
				}
				TableTopRPGVariables.MapVariables.get(world).lastDice = (double) (total);
				TableTopRPGVariables.MapVariables.get(world).syncData(world);
			} else {
				{
					MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
					if (mcserv != null)
						mcserv.getPlayerList()
								.sendMessage(new TextComponentString(
										(((entity.getDisplayName().getUnformattedText())) + "" + (((", ce n'est pas ton tour mais celui de [") + ""
												+ ((((TableTopRPGVariables.MapVariables.get(world).CurrentPlayer)) + "" + ("]"))))))));
				}
			}
		}
	}
}
