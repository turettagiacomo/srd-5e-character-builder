package classes.subclasses;

import java.util.List;
import java.util.Map;

public class LifeDomain extends Subclass implements ClericSubclass{
    private static final Map<Integer, List<String>> SUBCLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Disciple of life")),
            Map.entry(2, List.of("Channel Divinity: Preserve Life")),
            Map.entry(6, List.of("Blessed Healer")),
            Map.entry(8, List.of("Divine Strike")),
            Map.entry(17, List.of("Supreme Healing"))
    );

    public LifeDomain() {
        super("Life domain");
    }

    @Override
    public void applyKnownSpells(List<String> spells) {
        String[] items = {"Bless", "Cure Wounds"};
        addBonus(items, spells);
    }

    @Override
    public void applyArmorProficiencies(List<String> armorProficiencies) {
        String[] items = {"Heavy armor"};
        addBonus(items, armorProficiencies);
    }

    @Override
    public void applySubclassPrivileges(int level, List<String> classBonuses){
        classBonuses.addAll(SUBCLASS_PRIVILEGE.getOrDefault(level, List.of()));
    }
}
