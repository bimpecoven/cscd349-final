/*
 * DungeonCharacterFactory class
 *
**/

public class MonsterFactory {
    public Monster createCharacter(int type) {
        Monster monster;

        switch(type) {
            case 1:     monster = new Monster("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
                        break;

            case 2:     monster = new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
                        break;

            case 3:     monster = new Monster("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
                        break;

            default:    monster = new Monster("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
                        break;
        }//end switch

        monster.setAttack(setAbility(type));
        return monster;
    }
    public IAttack setAbility(int type) {
        switch(type) {
            case 1:     return new OgreAttack();

            case 2:     return new GremlinAttack();

            case 3:     return new SkeletonAttack();

            default:    return new SkeletonAttack();
        }//end switch
    }
}
