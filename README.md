# TableTop-RPG-mod
This is a very simple mod to help me master Tabletop RPG games.
It's build for MC 1.12.2 as for now, it's the version with a lot of updated mods.

#Dev environement
This has been created using MCreator using version 2020-2 (higher version are not compatible 1.12.2).
Download it here : mcreator.net/
Required plugins : 
- "ItemStack variables and procedures" for 2020-2
- "Simple RNG plugin" for 2020-2
- A fix plugin of my own to fixe the 'Get display name of provided entity' bug (i'm gonna release it soon or later)

#French dev
As long as i made this mod for my personnal use, there is a lot of french stuff in it. 
For instance, hero caracteristics are written in french : Physique = Strengh, Logique = Logic, and Mental = Moral resilience.

#How it works
Each player has to set each caracteristics by using :
- /physique set [1-95]
- /mental set [1-95]
- /logique set [1-95]
If it's not done, player will be able to roll dice but not to roll caracteristic.

To roll a dice, it requires that Game Master (in creative mode) set the play round using /play PlayerName

Then player can roll a dice using appropriate tool item dice (d3 d5 d7 d9 d10 or d100).
To roll multiple dice in same time, you need to stack items. For instance to roll 2d10 stack 2 dice10 then right click.

Then use the "physique", "mental" or "logique" item to test it.
If a player get from GM a bonus or a malus he must do /modifier [value].

As long as no item (physique, mental or logique) is used, roll result and modifier stay displayed on screen.
When the player use one of them : 
- it display the success/fail result + overlay
- then it reset dice result and currrent modifier
