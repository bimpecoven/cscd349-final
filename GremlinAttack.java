/**
 * CSCD349 - Final Project
 * Project by: Blake Impecoven and Kyle Rezin
 * Date: March, 2017.
**/
public class GremlinAttack implements IAttack {

    public void attack(DungeonCharacter opponent, DungeonCharacter monster) {
        System.out.println(monster.name + " jabs his kris at " +
                            opponent.getName() + ":");
    }
}
