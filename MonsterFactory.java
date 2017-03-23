/*
 * DungeonCharacterFactory class
 *
**/

public class MonsterFactory {
    public Monster createCharacter(int type) {
        Monster monster;
        String name;
        int hitPoints, attackSpeed, damageMin, damageMax, minHeal, maxHeal;
        double chanceToHit, chanceToHeal;

        switch(type) {
            case 1:     name = "Oscar the Ogre";
                        hitPoints = 200;
                        attackSpeed = 2;
                        chanceToHit = .6;
                        chanceToHeal = .1;
                        damageMin = 30;
                        damageMax = 50;
                        minHeal = 30;
                        maxHeal = 50;
                        break;

            case 2:     name = "Gnarltooth the Gremlin";
                        hitPoints = 70;
                        attackSpeed = 5;
                        chanceToHit = .8;
                        chanceToHeal = .4;
                        damageMin = 15;
                        damageMax = 30;
                        minHeal = 20;
                        maxHeal = 40;
                        break;

            case 3:     name = "Sargath the Skeleton";
                        hitPoints = 100;
                        attackSpeed = 3;
                        chanceToHit = .8;
                        chanceToHeal = .3;
                        damageMin = 30;
                        damageMax = 50;
                        minHeal = 30;
                        maxHeal = 50;
                        break;

            case 4:     name = "Oswald the Orc";
                        hitPoints = 175;
                        attackSpeed = 3;
                        chanceToHit = .7;
                        chanceToHeal = .1;
                        damageMin = 25;
                        damageMax = 55;
                        minHeal = 20;
                        maxHeal = 45;
                        break;

            case 5:     name = "Darius the Dark Lord";
                        hitPoints = 225;
                        attackSpeed = 4;
                        chanceToHit = .8;
                        chanceToHeal = .3;
                        damageMin = 45;
                        damageMax = 60;
                        minHeal = 35;
                        maxHeal = 55;
                        break;

            default:    name = "Sargath the Skeleton";
                        hitPoints = 100;
                        attackSpeed = 3;
                        chanceToHit = .8;
                        chanceToHeal = .3;
                        damageMin = 30;
                        damageMax = 50;
                        minHeal = 30;
                        maxHeal = 50;
                        break;
        }//end switch

        monster = new Monster(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);
        monster.setAttack(setAbility(monster.name));
        return monster;
    }
    public IAttack setAbility(String type) {
        switch(type) {
            case "Oscar the Ogre":          return new OgreAttack();

            case "Gnarltooth the Gremlin":  return new GremlinAttack();

            case "Sargath the Skeleton":    return new SkeletonAttack();

            case "Oswald the Orc":          return new OrcAttack();

            case "Darius the Dark Lord":    return new DarkLordAttack();

            default:    return new SkeletonAttack();
        }//end switch
    }
}
