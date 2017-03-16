/**
 * Created by bimpecoven on 3/16/17.
 */
public class ClericAbility implements IAbility {

    public void performAbility(DungeonCharacter opponent, DungeonCharacter hero)
    {
        int hPoints;

        hPoints = (int)(Math.random() * (hero.damageMax - hero.damageMin + 1)) + hero.damageMin;
        hero.addHitPoints(hPoints);
        System.out.println(hero.name + " added [" + hPoints + "] points.\n"
                + "Total hit points remaining are: "
                + hero.hitPoints);
        System.out.println();

    }//end increaseHitPoints method

    //-----------------------------------------------------------------
    public void attack(DungeonCharacter opponent, DungeonCharacter hero)
    {
        System.out.println(hero.name + " swings a weak staff at " +
                opponent.getName() + ":");
    }//end override of attack method

    public int prompt() {
        System.out.println("1. Attack Opponent");
        System.out.println("2. Increase Hit Points");
        System.out.print("Choose an option: ");
        int choice = Keyboard.readInt();
        return choice;
    }
}
