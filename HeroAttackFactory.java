import java.util.HashMap;
import java.util.Map;

/**
 * Created by bimpecoven on 3/22/17.
 */
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
