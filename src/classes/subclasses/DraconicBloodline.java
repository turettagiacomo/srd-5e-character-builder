package classes.subclasses;

import java.util.List;

public class DraconicBloodline extends Subclass implements SorcererSubclass {
    private final String damageType;

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
    public void applySubclassBonuses(List<String> subclassBonuses) {
        subclassBonuses.add("Draconic resilience");
    }
}
