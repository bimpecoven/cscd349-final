/*
 * DungeonCharacterFactory class
 *
**/

public class HeroFactory {
    public Hero createCharacter(int type) {
        Hero hero;

        switch(type) {
            case 1:     hero = new Hero("Warrior", 125, 4, .8, 35, 60, .2);
                        break;

            case 2:     hero = new Hero("Sorceress", 75, 5, .7, 25, 50, .3);
                        break;

            case 3:     hero = new Hero("Thief", 75, 6, .8, 20, 40, .5);
                        break;

            default:    hero = new Hero("Thief", 75, 6, .8, 20, 40, .5);
                        break;
        }//end switch

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
