import java.util.HashMap;
import java.util.Map;

/**
 * CSCD349 - Final Project
 * Project by: Blake Impecoven and Kyle Rezin
 * Date: March, 2017.
**/
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
