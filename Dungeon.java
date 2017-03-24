/**
 * CSCD349 - Final Project
 * Project by: Blake Impecoven and Kyle Rezin
 * Date: March, 2017.
**/

import java.util.Random;

/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */



/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class Dungeon
{
    public static void main(String[] args)
	{
        HeroFactory heroFactory = new HeroFactory();
        MonsterFactory monsterFactory = new MonsterFactory();
        HeroAttackFactory heroAttackFactory = new HeroAttackFactory();
        MonsterAttackFactory monsterAttackFactory = new MonsterAttackFactory();

		Hero[] theHeros;
		Monster[] theMonsters;

		do
		{
		    theHeros = chooseHeros(heroFactory, heroAttackFactory);
		    theMonsters = generateMonsters(monsterFactory, monsterAttackFactory, theHeros.length);
			battle(theHeros, theMonsters);

		} while (playAgain());

    }//end main method

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
	public static Hero[] chooseHeros(HeroFactory heroFactory, HeroAttackFactory heroAttackFactory)
	{
        System.out.println("How many Heroes would you like? (3 - 9)");
        int heroCount = Keyboard.readInt();
        while(heroCount < 3 || heroCount > 9) {
            System.out.println("Invalid number of heroes. Choose a number between 3 and 9.");
            heroCount = Keyboard.readInt();
        }//end while

        Hero[] heroes = new Hero[heroCount];

        for(int x = 0; x < heroCount; x++) {

            int choice = -1;
            Hero hero;

            System.out.println("Choose a hero:\n" +
                    "1. Warrior\n" +
                    "2. Sorceress\n" +
                    "3. Thief\n" +
                    "4. Dwarf\n" +
                    "5. Cleric");
            choice = Keyboard.readInt();
            while (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Enter a valid number.");
                choice = Keyboard.readInt();
            }

            hero = heroFactory.createCharacter(choice);
            hero.setAbility(heroAttackFactory.getAbility(hero.getName()));
            hero.readName();
            heroes[x] = hero;
        }//end for
        return heroes;
	}//end chooseHero method

/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
a polymorphic reference (Monster) to accomplish this task.
---------------------------------------------------------------------*/
	public static Monster[] generateMonsters(MonsterFactory monsterFactory, MonsterAttackFactory monsterAttackFactory, int count)
	{
        Monster[]monsters = new Monster[count];
        Random randMonster = new Random();

        for(int x = 0; x < count; x++) {

            int choice;

            choice = randMonster.nextInt(5) + 1;
            Monster monster = monsterFactory.createCharacter(choice);
            monster.setAttack(monsterAttackFactory.getAttack(monster.getName()));
            monsters[x] = monster;
        }//end for
        return monsters;
	}//end generateMonster method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		return (again == 'Y' || again == 'y');
	}//end playAgain method


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(Hero[] theHeros, Monster[] theMonsters)
	{
		char pause = 'p';
		System.out.println("The Heroes battle the Monsters!");

		//do battle
		while (isTeamAlive(theHeros) && isTeamAlive(theMonsters) && pause != 'q')
		{
            for(int rounds = 0; rounds < theHeros.length; rounds++) {
                int target = rounds;

                // Heroes attack first.
                if(theHeros[rounds].isAlive()) {
                    while(!theMonsters[target].isAlive()) {
                        target++;
                        target = target % theMonsters.length;
                    }//end while
                    System.out.println("---------------------------------------------");
                    System.out.println(theHeros[rounds].name + " battles " + theMonsters[target].name);
                    System.out.println("---------------------------------------------");
                    theHeros[rounds].battleChoices(theMonsters[target]);
                }//end if

                // Monsters turn if it's alive.
                if(theMonsters[rounds].isAlive() && isTeamAlive(theMonsters)) {
                    target = rounds;
                    while(!theHeros[target].isAlive()) {
                        target++;
                        target = target % theHeros.length;
                    }//end while
                    theMonsters[rounds].attack(theHeros[target]);
                }//end if
            }//end for

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = Keyboard.readChar();

		}//end battle loop

		if (!isTeamAlive(theMonsters))
		    System.out.println(" The Heroes were victorious!");
		else if (!isTeamAlive(theHeros))
			System.out.println("The Heroes were defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method

    /*
     *  This method checks a passed in array of dungeon characters.
     *  It then traverses the array and looks to see if any characters on the team are alive.
    **/
    public static boolean isTeamAlive(DungeonCharacter[] passedIn) {
        for(int x = 0; x < passedIn.length; x++) {
            if(passedIn[x].isAlive()) {
                return true;
            }//end if
        }//end for

        return false;
    }//end isTeamAlive

    public static int aliveCount(DungeonCharacter[] passedIn) {
        int count = 0;
        for(int x = 0; x < passedIn.length; x++) {
            if(passedIn[x].isAlive()) {
                count++;
            }//end if
        }//end for
        return count;
    }//end

}//end Dungeon class
