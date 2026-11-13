package classes;

import attributes.Ability;

import java.util.List;
import java.util.Map;

public class Paladin extends CharacterClass {
    static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Divine Sense", "Lay on Hands")),
            Map.entry(2, List.of("Fighting Style", "Spellcasting", "Divine Smite")),
            Map.entry(3, List.of("Divine Health", "Sacred Oath")),
            Map.entry(5, List.of("Extra Attack")),
            Map.entry(6, List.of("Aura of Protection")),
            Map.entry(10, List.of("Aura of Courage")),
            Map.entry(11, List.of("Improved Divine Smite")),
            Map.entry(14, List.of("Cleansing Touch")),
            Map.entry(18, List.of("Aura Improvements"))
    );

    public Paladin(){
        super("Paladin", 2, "1d10", 10);
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
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows) {
        proficiencySavingThrows.add(Ability.WISDOM);
        proficiencySavingThrows.add(Ability.CHARISMA);
    }

    @Override
    public void applyArmor(List<String> armor) {
        String[] items = {"Chain mail"};
        addBonus(items, armor);
    }

    @Override
    public void applyClassPrivileges(int level, List<String> classBonuses) {
        classBonuses.addAll(CLASS_PRIVILEGE.getOrDefault(level, List.of()));
    }

    @Override
    public Ability getSpellcastingAbility() {
        return Ability.CHARISMA;
    }
}
