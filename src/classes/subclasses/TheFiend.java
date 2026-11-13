package classes.subclasses;

import java.util.List;

public class TheFiend extends Subclass implements WarlockSubclass{
    public TheFiend() {
        super("The Fiend");
    }

    @Override
    public void applySubclassBonuses(List<String> subclassBonuses) {
        subclassBonuses.add("Dark one's blessing");
    }
}
