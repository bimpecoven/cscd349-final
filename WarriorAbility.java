public class WarriorAbility implements IAbility {

    public WarriorAbility(){}

    public void performAbility(DungeonCharacter opponent, DungeonCharacter hero)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(hero.name + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(hero.name + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

	public void attack(DungeonCharacter opponent, DungeonCharacter hero)
	{
		System.out.print(hero.name + " swings a mighty sword at " +
							opponent.getName() + ":\n");
	}//end override of attack method

    public int prompt() {
        System.out.println("1. Attack Opponent");
        System.out.println("2. Crushing Blow on Opponent");
        System.out.print("Choose an option: ");
        int choice = Keyboard.readInt();
        return choice;
    }

}
