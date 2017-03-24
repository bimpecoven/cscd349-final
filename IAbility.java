/**
 * CSCD349 - Final Project
 * Project by: Blake Impecoven and Kyle Rezin
 * Date: March, 2017.
**/

public interface IAbility {
    void performAbility(DungeonCharacter opponent, DungeonCharacter hero);
    void attack(DungeonCharacter opponent, DungeonCharacter hero);
    int prompt();
}
