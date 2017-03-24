/**
 * CSCD349 - Final Project
 * Project by: Blake Impecoven and Kyle Rezin
 * Date: March, 2017.
**/
public class SkeletonAttack implements IAttack {

    public void attack(DungeonCharacter opponent, DungeonCharacter monster) {
        System.out.println(monster.name + " slices his rusty blade at " +
                            opponent.getName() + ":");
    }
}
