package classes;

import attributes.Ability;
import classes.subclasses.Subclass;
import classes.subclasses.WarlockSubclass;

import java.util.List;
import java.util.Map;

public class Warlock extends CharacterClass {
    private final Subclass subclass;
    static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Otherworldly Patron", "Pact Magic")),
            Map.entry(2, List.of("Eldritch Invocations")),
            Map.entry(3, List.of("Pact Boon")),
            Map.entry(11, List.of("Mystic Arcanum (6th level)")),
            Map.entry(13, List.of("Mystic Arcanum (7th level)")),
            Map.entry(15, List.of("Mystic Arcanum (8th level)")),
            Map.entry(17, List.of("Mystic Arcanum (9th level)")),
            Map.entry(20, List.of("Eldritch Master"))
    );

    public Warlock(WarlockSubclass subclassInput) {
        super("Warlock", 2, "1d8", 8);
        subclass = (Subclass)  subclassInput;
    }

    @Override
    public void applyArmorProficiencies(List<String> armorProficiencies) {
        String[] items = {"Light armor"};
        addBonus(items, armorProficiencies);
    }

    @Override
    public void applyWeaponProficiencies(List<String> weaponProficiencies) {
        String[] items = {"Simple weapons"};
        addBonus(items , weaponProficiencies);
    }

    @Override
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows){
        proficiencySavingThrows.add(Ability.WISDOM);
        proficiencySavingThrows.add(Ability.CHARISMA);
    }

    @Override
    public void applyArmor(List<String> armors) {
        String[] items = {"Leather armor"};
        addBonus(items, armors);
    }

    @Override
    public void applyWeapons(List<String> weapons) {
        String[] items = {"2 daggers"};
        addBonus(items, weapons);
    }

    @Override
    public void applyClassPrivileges(int level, List<String> classBonuses) {
        classBonuses.addAll(CLASS_PRIVILEGE.getOrDefault(level, List.of()));
        this.subclass.applySubclassPrivileges(level, classBonuses);
    }

    @Override
    public Ability getSpellcastingAbility() {
        return Ability.CHARISMA;
    }

    @Override
    public void applyKnownSpells(List<String> spells){
        this.subclass.applyKnownSpells(spells);
    }
}
