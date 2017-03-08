public class ThiefAbility implements IAbility {

    public ThiefAbility(){}

    public void performAbility(DungeonCharacter opponent, DungeonCharacter hero)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								hero.getName() + " gets an additional turn.");
			hero.increaseTurns();
			hero.attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    hero.attack(opponent);

	}//end surpriseAttack method

    public void attack(DungeonCharacter opponent, DungeonCharacter hero) {
        
    }

    public int prompt() {
        System.out.println("1. Attack Opponent");
        System.out.println("2. Surprise Attack");
        System.out.print("Choose an option: ");
        int choice = Keyboard.readInt();
        return choice;
    }
}
