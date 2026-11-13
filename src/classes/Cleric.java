package classes;

import attributes.Ability;
import classes.subclasses.ClericSubclass;
import classes.subclasses.Subclass;

import java.util.List;
import java.util.Map;

public class Cleric extends CharacterClass {
    private final Subclass subclass;
    private static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Spellcasting", "Divine domain")),
            Map.entry(2, List.of("Channel Divinity (1/rest)")),
            Map.entry(5, List.of("Destroy Undead (CR 1/2)")),
            Map.entry(6, List.of("Channel Divinity (2/rest)")),
            Map.entry(8, List.of("Destroy Undead (CR 1)")),
            Map.entry(10, List.of("Divine Intervention")),
            Map.entry(11, List.of("Destroy Undead (CR 2)")),
            Map.entry(14, List.of("Destroy Undead (CR 3)")),
            Map.entry(17, List.of("Destroy Undead (CR 4)")),
            Map.entry(18, List.of("Channel Divinity (3/rest)")),
            Map.entry(20, List.of("Divine Intervention Improvement"))
    );

    public Cleric(ClericSubclass subclassInput){
        super("Cleric", 2, "1d8", 8);
        this.subclass = (Subclass) subclassInput;
    }

    @Override
    public void applyArmorProficiencies(List<String> armorProficiencies) {
        String[] items = {"Light armor", "Medium armor", "Shields"};
        addBonus(items, armorProficiencies);
        this.subclass.applyArmorProficiencies(armorProficiencies);
    }

    @Override
    public void applyWeaponProficiencies(List<String> weaponProficiencies) {
        String[] items = {"Simple weapons"};
        addBonus(items, weaponProficiencies);
        this.subclass.applyWeaponProficiencies(weaponProficiencies);
    }

    @Override
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows){
        proficiencySavingThrows.add(Ability.WISDOM);
        proficiencySavingThrows.add(Ability.CHARISMA);
    }

    @Override
    public void applyArmor(List<String> armor){
        String[] items = {"Shield"};
        addBonus(items, armor);
    }

    @Override
    public void applyClassPrivileges(int level, List<String> classBonuses) {
        classBonuses.addAll(CLASS_PRIVILEGE.getOrDefault(level, List.of()));
        this.subclass.applySubclassPrivileges(level, classBonuses);
    }

    @Override
    public Ability getSpellcastingAbility() {
        return Ability.WISDOM;
    }

    @Override
    public void applyKnownSpells(List<String> spells){
        this.subclass.applyKnownSpells(spells);
    }
}
