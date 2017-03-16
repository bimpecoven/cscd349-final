/**
 * Created by bimpecoven on 3/16/17.
 */
public class DarkLordAttack implements IAttack{
    public void attack(DungeonCharacter opponent, DungeonCharacter monster) {
        System.out.println(monster.name + " casts a devastating lightning bolt toward's " +
                opponent.getName() + ":");

    }
}
