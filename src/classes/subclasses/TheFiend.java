package classes.subclasses;

import java.util.List;
import java.util.Map;

public class TheFiend extends Subclass implements WarlockSubclass{
    private static final Map<Integer, List<String>> SUBCLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Dark One's Blessing")),
            Map.entry(6, List.of("Dark One's Own Luck")),
            Map.entry(10, List.of("Fiendish Resilience")),
            Map.entry(14, List.of("Hurl Through Hell"))
    );

    public TheFiend() {
        super("The Fiend");
    }

    @Override
    public void applySubclassPrivileges(int level, List<String> classBonuses){
        classBonuses.addAll(SUBCLASS_PRIVILEGE.getOrDefault(level, List.of()));
    }
}
