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

            case 4:     name = "Dwarf";
                        hitPoints = 150;
                        attackSpeed = 7;
                        chanceToHit = .7;
                        damageMin = 45;
                        damageMax = 75;
                        chanceToBlock = .1;
                        break;

            case 5:     name = "Cleric";
                        hitPoints = 95;
                        attackSpeed = 3;
                        chanceToHit = .9;
                        damageMin = 35;
                        damageMax = 50;
                        chanceToBlock = .2;
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

            case 4:     return new DwarfAbility();

            case 5:     return new ClericAbility();

            default:    return new ThiefAbility();
        }//end switch
    }//end setAbility
}
