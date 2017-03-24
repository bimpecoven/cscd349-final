import java.util.HashMap;
import java.util.Map;

/**
 * CSCD349 - Final Project
 * Project by: Blake Impecoven and Kyle Rezin
 * Date: March, 2017.
**/
public class HeroAttackFactory {
    private Map<String, IAbility> abilities = new HashMap<String, IAbility>();

    public IAbility getAbility(String abilityName) {
        IAbility ability = abilities.get(abilityName);

        if(ability == null) {
            ability = new HeroFactory().setAbility(abilityName);
            abilities.put(abilityName, ability);
        }//end if
        return ability;
    }//end get
}//end class
