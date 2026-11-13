package classes;

import attributes.Ability;

import java.util.List;
import java.util.Map;

public class Fighter extends CharacterClass {
    static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Fighting Style", "Second Wind")),
            Map.entry(2, List.of("Action Surge (one use)")),
            Map.entry(3, List.of("Martial Archetype")),
            Map.entry(5, List.of("Extra Attack")),
            Map.entry(9, List.of("Indomitable (one use)")),
            Map.entry(11, List.of("Extra Attack (2)")),
            Map.entry(13, List.of("Indomitable (two uses)")),
            Map.entry(17, List.of("Action Surge (two uses)", "Indomitable (three uses)")),
            Map.entry(20, List.of("Extra Attack (3)"))
    );

    public Fighter(){
        super("Fighter", 2, "1d10", 10);
    }

    @Override
    public void applyArmorProficiencies(List<String> armorProficiencies) {
        String[] items = {"Light armor", "Medium armor", "Heavy armor", "Shields"};
        addBonus(items, armorProficiencies);
    }

    @Override
    public void applyWeaponProficiencies(List<String> weaponProficiencies) {
        String[] items = {"Simple weapons", "Martial weapons"};
        addBonus(items, weaponProficiencies);
    }

    @Override
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows){
        proficiencySavingThrows.add(Ability.STRENGTH);
        proficiencySavingThrows.add(Ability.CONSTITUTION);
    }

    @Override
    public void applyClassPrivileges(int level, List<String> classBonuses) {
        classBonuses.addAll(CLASS_PRIVILEGE.getOrDefault(level, List.of()));
    }
}
