package classes;

import attributes.Ability;

import java.util.List;
import java.util.Map;

public class Bard extends CharacterClass {
    static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Spellcasting", "Bardic inspiration (d6)")),
            Map.entry(2, List.of("Jack of All Trades", "Song of Rest (d6)")),
            Map.entry(3, List.of("Bard college", "Expertise")),
            Map.entry(5, List.of("Bardic inspiration (d8)", "Font of Inspiration")),
            Map.entry(6, List.of("Countercharm")),
            Map.entry(9, List.of("Song of rest (d8)")),
            Map.entry(10, List.of("Bardic inspiration (d10)", "Expertise", "Magical Secrets")),
            Map.entry(13, List.of("Song of Rest (d10)")),
            Map.entry(14, List.of("Magical secrets")),
            Map.entry(15, List.of("Bardic Inspiration (d12)")),
            Map.entry(17, List.of("Song of Rest (d12)")),
            Map.entry(18, List.of("Magical Secrets")),
            Map.entry(20, List.of("Superior Inspiration"))
    );

    public Bard(){
        super("Bard", 2, "1d8", 8);
    }

    @Override
    public void applyArmorProficiencies(List<String> armorProficiencies) {
        String[] items = {"Light armor"};
        addBonus(items, armorProficiencies);
    }

    @Override
    public void applyWeaponProficiencies(List<String> weaponProficiencies) {
        String[] items = {"Simple weapons", "Hand crossbows", "Long swords", "Short swords", "Rapiers"};
        addBonus(items, weaponProficiencies);
    }

    @Override
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows){
        proficiencySavingThrows.add(Ability.DEXTERITY);
        proficiencySavingThrows.add(Ability.CHARISMA);
    }

    @Override
    public void applyArmor(List<String> armor){
        String[] items = {"Leather armor"};
        addBonus(items, armor);
    }

    @Override
    public void applyWeapons(List<String> weapons) {
        String[] items = {"Dagger"};
        addBonus(items, weapons);
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