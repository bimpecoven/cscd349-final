import java.util.HashMap;
import java.util.Map;

/**
 * Created by bimpecoven on 3/22/17.
 */
public class MonsterAttackFactory {
    private Map<String, IAttack> attacks = new HashMap<String, IAttack>();

    public IAttack getAttack(String attackName) {
        IAttack attack = attacks.get(attackName);

        if(attack == null) {
            attack = new MonsterFactory().setAbility(attackName);
            attacks.put(attackName, attack);
        }//end if
        return attack;
    }//end get
}//end class
