public class GremlinAttack implements IAttack {
    public GremlinAttack(){}

    public void attack(DungeonCharacter opponent, DungeonCharacter monster) {
        System.out.println(monster.name + " jabs his kris at " +
                            opponent.getName() + ":");
    }
}
