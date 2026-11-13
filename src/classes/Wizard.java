package classes;

import attributes.Ability;

import java.util.List;
import java.util.Map;

public class Wizard extends CharacterClass {
    static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Spellcasting", "Arcane Recovery")),
            Map.entry(2, List.of("Arcane Tradition")),
            Map.entry(18, List.of("Spell Mastery")),
            Map.entry(20, List.of("Signature Spells"))
    );

    public Wizard(){
        super("Wizard", 2, "1d6", 6);
    }

    @Override
    public void applyWeaponProficiencies(List<String> weaponProficiencies) {
        String[] items = {"Daggers", "Darts", "Slings", "Quarterstaffs", "Light crossbows"};
        addBonus(items, weaponProficiencies);
    }

    @Override
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows){
        proficiencySavingThrows.add(Ability.INTELLIGENCE);
        proficiencySavingThrows.add(Ability.WISDOM);
    }

    @Override
    public void applyEquipment(List<String> equipment) {
        String[]  items = {"Spellbook"};
        addBonus(items, equipment);
    }

    @Override
    public void applyClassPrivileges(int level, List<String> classBonuses) {
        classBonuses.addAll(CLASS_PRIVILEGE.getOrDefault(level, List.of()));
    }

    @Override
    public Ability getSpellcastingAbility() {
        return Ability.INTELLIGENCE;
    }
}
