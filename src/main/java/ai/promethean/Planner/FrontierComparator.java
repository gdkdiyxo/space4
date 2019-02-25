package ai.promethean.Planner;

import java.util.Comparator;

// Order StateTemplates by lowest f_value
public class FrontierComparator implements Comparator<StateTemplate> {
    public int compare(StateTemplate template1, StateTemplate template2) {
        return (int) Math.signum(template1.getF() - template2.getF());
    }
}
