package classes.subclasses;

import java.util.List;
import java.util.Map;

public class DraconicBloodline extends Subclass implements SorcererSubclass {
    private final String damageType;
    private static final Map<Integer, List<String>> SUBCLASS_PRIVILEGE = Map.ofEntries(
            Map.entry(1, List.of("Dragon Ancestor", "Draconic Resilience")),
            Map.entry(6, List.of("Elemental Affinity")),
            Map.entry(14, List.of("Dragon Wings")),
            Map.entry(18, List.of("Draconic Presence"))
    );

    public DraconicBloodline(String ancestry) {
        super("Draconic ancestry");
        switch (ancestry.toLowerCase()) {
            case "black":
                damageType = "Acid";
                break;
            case "blue":
                damageType = "Lightning";
                break;
            case "brass":
                damageType = "Fire";
                break;
            case "bronze":
                damageType = "Lightning";
                break;
            case "copper":
                damageType = "Acid";
                break;
            case "gold":
                damageType = "Fire";
                break;
            case "green":
                damageType = "Poison";
                break;
            case "red":
                damageType = "Fire";
                break;
            case "silver":
                damageType = "Cold";
                break;
            case "white":
                damageType = "Cold";
                break;
            default:
                throw new IllegalArgumentException("No such ancestry");
        }
    }

    @Override
    public void applySubclassPrivileges(int level, List<String> classBonuses){
        classBonuses.addAll(SUBCLASS_PRIVILEGE.getOrDefault(level, List.of()));
    }
}
