/**
 * Created by bimpecoven on 3/16/17.
 */
public class DwarfAbility implements IAbility{

    public void performAbility(DungeonCharacter opponent, DungeonCharacter hero)
    {
        if (Math.random() <= .4)
        {
            int blowPoints = (int)(Math.random() * 76) + 100;
            System.out.println(hero.name + " lands a WAR HAMMER SMASH for " + blowPoints
                    + " damage!");
            opponent.subtractHitPoints(blowPoints);
        }//end blow succeeded
        else
        {
            System.out.println(hero.name + " failed to land a war hammer smash");
            System.out.println();
        }//blow failed

    }//end crushingBlow method

    public void attack(DungeonCharacter opponent, DungeonCharacter hero)
    {
        System.out.print(hero.name + " swings a hefty war hammer at " +
                opponent.getName() + ":\n");
    }//end override of attack method

    public int prompt() {
        System.out.println("1. Attack Opponent");
        System.out.println("2. War Hammer Smash on Opponent");
        System.out.print("Choose an option: ");
        int choice = Keyboard.readInt();
        return choice;
    }
}
