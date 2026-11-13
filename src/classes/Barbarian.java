package classes;

import attributes.Ability;

import java.util.List;
import java.util.Map;

public class Barbarian extends CharacterClass {

    private static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Rage", "Unarmored defence")),
            Map.entry(2, List.of("Reckless Attack", "Danger Sense")),
            Map.entry(3, List.of("Primal Path")),
            Map.entry(5, List.of("Extra Attack", "Fast Movement")),
            Map.entry(7, List.of("Feral Instinct")),
            Map.entry(9, List.of("Brutal Critical (1 die)")),
            Map.entry(11, List.of("Relentless Rage")),
            Map.entry(13, List.of("Brutal Critical (2 dice)")),
            Map.entry(15, List.of("Persistent Rage")),
            Map.entry(17, List.of("Brutal Critical (3 dice)")),
            Map.entry(18, List.of("Indomitable Might")),
            Map.entry(20, List.of("Primal Champion"))
    );

    public Barbarian(){
        super("Barbarian", 2, "1d12", 12);
    }

    @Override
    public void applyArmorProficiencies(List<String> armorProficiencies) {
        String[] items = {"Light armor", "Medium armor", "Shield"};
        addBonus(items, armorProficiencies);
    }

    @Override
    public void applyWeaponProficiencies(List<String> weaponProficiencies) {
        String[]  items = {"Simple weapons", "Martial weapons"};
        addBonus(items, weaponProficiencies);
    }

    @Override
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows){
        proficiencySavingThrows.add(Ability.STRENGTH);
        proficiencySavingThrows.add(Ability.CONSTITUTION);
    }

    @Override
    public void applyEquipment(List<String> equipment) {
        String[] items = {"Explorer's pack"};
        addBonus(items, equipment);
    }

    @Override
    public void applyWeapons(List<String> weapons) {
        String[] items = {"4 javelins"};
        addBonus(items, weapons);
    }

    @Override
    public void applyClassPrivileges(int level, List<String> classBonuses){
        classBonuses.addAll(CLASS_PRIVILEGE.getOrDefault(level, List.of()));
    }
}
