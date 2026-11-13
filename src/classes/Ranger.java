package classes;

import attributes.Ability;

import java.util.List;
import java.util.Map;

public class Ranger extends CharacterClass {
    static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Favored Enemy", "Natural Explorer")),
            Map.entry(2, List.of("Fighting Style", "Spellcasting")),
            Map.entry(3, List.of("Ranger Archetype", "Primeval Awareness")),
            Map.entry(5, List.of("Extra Attack")),
            Map.entry(6, List.of("Favored Enemy Improvement", "Natural Explorer Improvement")),
            Map.entry(8, List.of("Land's Stride")),
            Map.entry(10, List.of("Natural Explorer Improvement", "Hide in Plain Sight")),
            Map.entry(14, List.of("Favored Enemy Improvement", "Vanish")),
            Map.entry(18, List.of("Feral Senses")),
            Map.entry(20, List.of("Foe Slayer"))
    );

    public Ranger(){
        super("Ranger", 2, "1d10", 10);
    }

    @Override
    public void applyArmorProficiencies(List<String> armorProficiencies) {
        String[] items = {"Light armor", "Medium armor", "Shields"};
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
        proficiencySavingThrows.add(Ability.DEXTERITY);
    }

    @Override
    public void applyWeapons(List<String> weapons) {
        String[] items = {"Long bow", "Quiver of 20 arrows"};
        addBonus(items, weapons);
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
