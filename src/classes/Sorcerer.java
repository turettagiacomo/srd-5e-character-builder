package classes;

import attributes.Ability;
import classes.subclasses.SorcererSubclass;
import classes.subclasses.Subclass;

import java.util.List;
import java.util.Map;

public class Sorcerer extends CharacterClass {
    private final Subclass subclass;
    static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Spellcasting", "Sorcerous Origin")),
            Map.entry(2, List.of("Font of magic")),
            Map.entry(3, List.of("Metamagic")),
            Map.entry(10, List.of("Metamagic (extra option)")),
            Map.entry(17, List.of("Metamagic (extra option)")),
            Map.entry(20, List.of("Sorcerous Restoration"))
    );

    public Sorcerer(SorcererSubclass subclassInput){
        super("Sorcerer", 2, "1d6", 6);
        this.subclass = (Subclass) subclassInput;
    }

    @Override
    public void applyWeaponProficiencies(List<String> weaponProficiencies) {
        String[] items = {"Daggers", "Darts", "Slings", "Quarterstaffs", "Light crossbows"};
        addBonus(items, weaponProficiencies);
    }

    @Override
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows){
        proficiencySavingThrows.add(Ability.CHARISMA);
        proficiencySavingThrows.add(Ability.CONSTITUTION);
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
    public void applyResistances(List<String> resistances){
        this.subclass.applyResistances(resistances);
    }
}