# SRD 5.1 Character Builder

This project is a tool to create playable and non-playable characters for Dungeons and Dragons. It follows the public documentation SRD 5.1 and uses the rules of the fifth edition (5e).

## Example

```text
===================================================
                 CHARACTER SHEET
===================================================
Name: Hubris
Class: Fighter
Background: Acolyte
Race: Human
Alignment: True Neutral

---------------------------------------------------
ABILITY SCORES:
STRENGTH       : 16 (+3)
DEXTERITY      : 15 (+2)
CONSTITUTION   : 14 (+2)
INTELLIGENCE   : 9 (-1)
WISDOM         : 11 (+0)
CHARISMA       : 13 (+1)
---------------------------------------------------
Proficiency Bonus: +2

---------------------------------------------------
SAVING THROW PROFICIENCIES:
- STRENGTH
- CONSTITUTION

---------------------------------------------------
SKILLS:
[ ] ACROBATICS          : +2
[ ] ANIMAL HANDLING     : +0
[ ] ARCANA              : -1
[o] ATHLETICS           : +5
[ ] DECEPTION           : +1
[ ] HISTORY             : -1
[o] INSIGHT             : +2
[ ] INTIMIDATION        : +1
[ ] INVESTIGATION       : -1
[ ] MEDICINE            : +0
[ ] NATURE              : -1
[ ] PERCEPTION          : +0
[ ] PERFORMANCE         : +1
[ ] PERSUASION          : +1
[o] RELIGION            : +1
[ ] SLEIGHT OF HAND     : +2
[ ] STEALTH             : +2
[ ] SURVIVAL            : +0

---------------------------------------------------
Passive Perception: 10

---------------------------------------------------
OTHER PROFICIENCIES & LANGUAGES:
Languages: Common, Elvish, Gnomish, Dwarvish
Weapons: Simple weapons, Martial weapons
Armor: Light armor, Medium armor, Heavy armor, Shields
Tools: 

---------------------------------------------------
COMBAT STATS:
AC: 18
Initiative: 2
Speed: 9.0 m.
Hit Points: 12 / 12
Hit Dice: 1d10

---------------------------------------------------
INVENTORY & EQUIPMENT:
Equipped Armor: Chain mail & Shield
Weapons: Greatsword, Light crossbow and 20 bolts
Inventory: Dungeoneer's pack, Emblem, 5 sticks of incense, Vestments, Common clothes, Belt pouch with 15gp

---------------------------------------------------
FEATURES & TRAITS:
Resistances: 
Class/Race/Background Features: 
- Fighting style
- Second wind
- Shelter of the faithful

DISADVANTAGES & PENALTIES:
- Disadvantage in stealth check

---------------------------------------------------
PHYSICAL TRAITS:
Age: 27 | Height: 183 | Weight: 73,0
Eyes: Blue | Skin: Pale | Hair: Blonde

---------------------------------------------------
You are not a spellcaster.
===================================================

Do you want to save this character? (Y/N): n

The sun rises outside, and Hubris wakes up to a strange sound...
```

## Project status

At present, the program guides the user through all the complicated steps of the D&D 5e character creation for a level 1 character. It starts with the choice of the race and optional subrace. Then it lets the user select the class and all its features, such as weapons, equipment and subclass. After that there's the choice of the background and the physical details. The program also gives the user the choice of setting up the stats with any of the three methods. Under the hood it also handles all the math of the abilities, skills, armor class and hit points. After everything the program prints the character sheet.

It is also possible to save the character as a `.dat` file and load it later.

## How to run it

To run the code you need to have installed Java 16 or later on your PC. To check, run this in a terminal:

```bash
java --version
```

If you have a supported version installed, you'll see something like `java version "21.0.12"`. If not, you can install it from the Oracle website.

Once a supported Java version is installed, clone the repository by running this in a shell or in cmd:

```bash
git clone https://github.com/turettagiacomo/srd-5e-character-builder
```

Then go to the directory `srd-5e-character-builder\src` either with File Explorer or from the command line:

```bash
cd .\srd-5e-character-builder\src
```

After doing that, compile `App.java` from the command line:

```bash
javac App.java
```

Finally, run the program:

```bash
java App
```

## Architectural Choices

### Races, Classes and Backgrounds

The project uses a strict object-oriented structure that simplifies the addition or removal of races, classes and backgrounds. In fact, if I needed to add a new race, class or background, I would only need to create the class that extends the corresponding superclass and add the choice in `App` once, in most cases. Some classes and races have special bonuses: in those cases, some methods in `PlayerCharacter` need to be modified.

### Interfaces

To implement subraces and subclasses I've used interfaces for each category (e.g. `DwarvenSubrace`). This makes the `App` code simpler since, when the user has to choose between the possible subraces or subclasses, the code creates an object of the type of the interface instead of the type of the subrace/subclass.

```java
// ...
DwarvenSubrace subDwarf = null;
// ...
subDwarf = new HillDwarf();
```

If I hadn't used the interface, I would have needed to verify that `HillDwarf` was actually a dwarven subrace. The only downside is that this strategy requires having a total of three interfaces for the classes and four for the races. When the level-up feature is implemented this cost will grow to an interface for each class plus four for the races.
      
### App, utility class and printing

The most complex part of the project that makes all the rest functional is divided into two different classes. `App` is responsible for the interaction with the user and calls `PlayerCharacter` whenever the character sheet needs to be modified. Then there's `MenuPrinter`, which contains the vast majority of the possible user choices and the required methods to print that information.

This architecture implements the principle of separation of concerns, since it separates the roles within the program flow.

### PlayerCharacter

At the core of the project is `PlayerCharacter`. This class manages the interaction between `App` and the character details and is also responsible for all the calculations needed for the character.

## Roadmap

The next release will be a refactor of the system behind the class features since, at the current state, it does not scale to multiple levels. The problem lies in each class because the features are hard-coded inside `applyClassBonuses`. To support leveling up past level one, the refactor will be done through the use of maps, where the key is the level and each level is associated with a list of features.

After that, I'm looking forward to implementing the new level-up mechanic in a separate branch. To do this I'll create a new method in `PlayerCharacter` that will be called right before saving the character in `App`. The level-up feature will also require rethinking the order of loading and saving the character since a user could load a character just to level it up or save it before leveling up and then level up.

## License

The source code in this repository is released under the MIT license (see [LICENSE](LICENSE)). The material taken from the SRD 5.1 is not relicensed and remains under the Creative Commons Attribution 4.0 International License, as stated below.

This work includes material taken from the System Reference Document 5.1 (“SRD 5.1”) by Wizards of
the Coast LLC and available at https://dnd.wizards.com/resources/systems-reference-document. The
SRD 5.1 is licensed under the Creative Commons Attribution 4.0 International License available at
https://creativecommons.org/licenses/by/4.0/legalcode.

