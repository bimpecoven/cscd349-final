/*
 * Special ability class
 *
**/

public interface IAbility {
    public void performAbility(DungeonCharacter opponent, DungeonCharacter hero);
    public void attack(DungeonCharacter opponent, DungeonCharacter hero);
    public int prompt();
}
