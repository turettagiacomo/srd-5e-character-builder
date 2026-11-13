package classes;

import attributes.Ability;

import java.util.List;
import java.util.Map;

public class Druid extends CharacterClass {
    static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Druidic", "Spellcasting")),
            Map.entry(2, List.of("Wild shape", "Druid circle")),
            Map.entry(4, List.of("Wild Shape Improvement")),
            Map.entry(8, List.of("Wild Shape Improvement")),
            Map.entry(18, List.of("Timeless Body", "Beast Spells")),
            Map.entry(20, List.of("Archdruid"))
    );

    public Druid(){
        super("Druid", 2, "1d8", 8);
    }

    @Override
    public void applyArmorProficiencies(List<String> armorProficiencies) {
        String[] items = {"Light armor", "Medium armor", "Shields"};
        addBonus(items, armorProficiencies);
    }

    @Override
    public void applyWeaponProficiencies(List<String> weaponProficiencies) {
        String[] items = {"Clubs", "Daggers", "Darts", "Javelins", "Maces", "Quarterstaffs", "Scimitars", "Sickles", "Slings", "Spears"};
        addBonus(items, weaponProficiencies);
    }

    @Override
    public void applyToolsProficiencies(List<String> toolsProficiencies) {
        String[] items = {"Herbalism tools"};
        addBonus(items, toolsProficiencies);
    }

    @Override
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows){
        proficiencySavingThrows.add(Ability.INTELLIGENCE);
        proficiencySavingThrows.add(Ability.WISDOM);
    }


    @Override
    public void applyEquipment(List<String> equipment) {
        String[] items = {"Explorer's pack"};
        addBonus(items, equipment);
    }

    @Override
    public void applyArmor(List<String> armor) {
        String[]  items = {"Leather armor"};
        addBonus(items, armor);
    }

    @Override
    public void applyClassPrivileges(int level, List<String> classBonuses) {
        classBonuses.addAll(CLASS_PRIVILEGE.getOrDefault(level, List.of()));
    }

    @Override
    public Ability getSpellcastingAbility() {
        return Ability.WISDOM;
    }
}
