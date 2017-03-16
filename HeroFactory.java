/*
 * DungeonCharacterFactory class
 *
**/

public class HeroFactory {
    public Hero createCharacter(int type) {
        Hero hero;
        String name;
        int hitPoints, attackSpeed, damageMin, damageMax;
        double chanceToHit, chanceToBlock;

        switch(type) {
            case 1:     name = "Warrior";
                        hitPoints = 125;
                        attackSpeed = 4;
                        chanceToHit = .8;
                        damageMin = 35;
                        damageMax = 60;
                        chanceToBlock = .2;
                        break;

            case 2:     name = "Sorceress";
                        hitPoints = 75;
                        attackSpeed = 5;
                        chanceToHit = .7;
                        damageMin = 25;
                        damageMax = 50;
                        chanceToBlock = .3;
                        break;

            case 3:     name = "Theif";
                        hitPoints = 75;
                        attackSpeed = 6;
                        chanceToHit = .8;
                        damageMin = 20;
                        damageMax = 40;
                        chanceToBlock = .5;
                        break;

            default:    name = "Theif";
                        hitPoints = 75;
                        attackSpeed = 6;
                        chanceToHit = .8;
                        damageMin = 20;
                        damageMax = 40;
                        chanceToBlock = .5;
                        break;
        }//end switch

        hero = new Hero(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock);
        hero.setAbility(setAbility(type));

        return hero;
    }//end createCharacter
    public IAbility setAbility(int type) {
        switch(type) {
            case 1:     return new WarriorAbility();

            case 2:     return new SorceressAbility();

            case 3:     return new ThiefAbility();

            default:    return new ThiefAbility();
        }//end switch
    }//end setAbility
}
