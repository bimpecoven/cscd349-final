/**
 * CSCD349 - Final Project
 * Project by: Blake Impecoven and Kyle Rezin
 * Date: March, 2017.
**/
public class DarkLordAttack implements IAttack{
    public void attack(DungeonCharacter opponent, DungeonCharacter monster) {
        System.out.println(monster.name + " casts a devastating lightning bolt toward's " +
                opponent.getName() + ":");

    }
}
