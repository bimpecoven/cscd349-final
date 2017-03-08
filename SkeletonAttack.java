public class SkeletonAttack implements IAttack {
    public SkeletonAttack(){}

    public void attack(DungeonCharacter opponent, DungeonCharacter monster) {
        System.out.println(monster.name + " slices his rusty blade at " +
                            opponent.getName() + ":");
    }
}
