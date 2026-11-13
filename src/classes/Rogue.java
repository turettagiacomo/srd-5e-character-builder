package classes;

import attributes.Ability;

import java.util.List;
import java.util.Map;

public class Rogue extends CharacterClass {
    static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Expertise", "Sneak attack", "Thieves' Cant")),
            Map.entry(2, List.of("Cunning Action")),
            Map.entry(3, List.of("Roguish Archetype")),
            Map.entry(5, List.of("Uncanny Dodge")),
            Map.entry(6, List.of("Expertise")),
            Map.entry(7, List.of("Evasion")),
            Map.entry(11, List.of("Reliable Talent")),
            Map.entry(14, List.of("Blindsense")),
            Map.entry(15, List.of("Slippery Mind")),
            Map.entry(18, List.of("Elusive")),
            Map.entry(20, List.of("Stroke of Luck"))
    );

    public Rogue(){
        super("Rogue", 2, "1d8", 8);
    }

    @Override
    public void applyArmorProficiencies(List<String> armorProficiencies) {
        String[] items = {"Light armor"};
        addBonus(items, armorProficiencies);
    }

    @Override
    public void applyWeaponProficiencies(List<String> weaponProficiencies) {
        String[] items = {"Simple weapons", "Hand crossbow", "Long swords", "Rapiers", "Short swords"};
        addBonus(items, weaponProficiencies);
    }

    @Override
    public void applyToolsProficiencies(List<String> toolsProficiencies) {
        String[] items = {"Thieves' tools"};
        addBonus(items, toolsProficiencies);
    }

    @Override
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows){
        proficiencySavingThrows.add(Ability.DEXTERITY);
        proficiencySavingThrows.add(Ability.INTELLIGENCE);
    }

    @Override
    public void applyEquipment(List<String> equipment) {
        String[] items = {"Thieves' tools"};
        addBonus(items, equipment);
    }

    @Override
    public void applyArmor(List<String> armor) {
        String[] items = {"Leather armor"};
        addBonus(items, armor);
    }

    @Override
    public void applyWeapons(List<String> weapons) {
        String[] items = {"2 daggers"};
        addBonus(items, weapons);
    }

    @Override
    public void applyClassPrivileges(int level, List<String> classBonuses) {
        classBonuses.addAll(CLASS_PRIVILEGE.getOrDefault(level, List.of()));
    }
}
