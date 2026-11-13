package classes;

import attributes.Ability;

import java.util.List;
import java.util.Map;

public class Monk extends CharacterClass {
    static final Map<Integer, List<String>> CLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Unarmored Defence", "Martial arts")),
            Map.entry(2, List.of("Ki", "Unarmored Movement")),
            Map.entry(3, List.of("Monastic Tradition", "Deflect Missiles")),
            Map.entry(4, List.of("Slow Fall")),
            Map.entry(5, List.of("Extra Attack", "Stunning Strike")),
            Map.entry(6, List.of("Ki-empowered Strikes")),
            Map.entry(7, List.of("Evasion", "Stillness of Mind")),
            Map.entry(9, List.of("Unarmored Movement Improvement")),
            Map.entry(10, List.of("Purity of Body")),
            Map.entry(13, List.of("Tongue of the Sun and Moon")),
            Map.entry(14, List.of("Diamond Soul")),
            Map.entry(15, List.of("Timeless Body")),
            Map.entry(18, List.of("Empty Body")),
            Map.entry(20, List.of("Perfect Self"))
    );

    public Monk(){
        super("Monk", 2, "1d8", 8);
    }

    @Override
    public void applyWeaponProficiencies(List<String> weaponProficiencies) {
        String[] items = {"Simple weapons", "Short swords"};
        addBonus(items, weaponProficiencies);
    }

    @Override
    public void applyProficiencySavingThrows(List<Ability> proficiencySavingThrows){
        proficiencySavingThrows.add(Ability.DEXTERITY);
        proficiencySavingThrows.add(Ability.STRENGTH);
    }

    @Override
    public void applyWeapons(List<String> weapons) {
        String[] items = {"10 darts"};
        addBonus(items, weapons);
    }

    @Override
    public void applyClassPrivileges(int level, List<String> classBonuses) {
        classBonuses.addAll(CLASS_PRIVILEGE.getOrDefault(level, List.of()));
    }
}
