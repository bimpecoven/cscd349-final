/**
 * Created by bimpecoven on 3/16/17.
 */
public class OrcAttack implements IAttack{
    public void attack(DungeonCharacter opponent, DungeonCharacter monster) {
        System.out.println(monster.name + " swings a spiked club toward's " +
                opponent.getName() + ":");

    }
}
