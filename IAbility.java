/*
 * Special ability class
 *
**/

public interface IAbility {
    void performAbility(DungeonCharacter opponent, DungeonCharacter hero);
    void attack(DungeonCharacter opponent, DungeonCharacter hero);
    int prompt();
}
