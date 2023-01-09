public class Pakuri {

    private int attack;
    private int defense;
    private int speed;
    private String species;

    public Pakuri(String species) {
        setSpecies(species);
        setAttack((getSpecies().length() * 7) + 9);
        setDefenseLevel((getSpecies().length() * 5) + 17);
        setSpeed((getSpecies().length() * 6) + 13);
    }

    public String getSpecies() { // returns the species of the pakuri
        return species;
    }

    public int getAttack() { // returns the attack value of the pakuri
        return attack;
    }

    public int getDefense() // returns the defense value of the pakuri
    {
        return defense;
    }

    public int getSpeed() { // returns the speed of the pakuri
        return speed;
    }

    public void setAttack(int newAttack) // changes the attack value of the pakuri to newAttack
    {
        attack = newAttack;
    }

    public void setDefenseLevel(int newDefense) {
        defense = newDefense;
    }

    public void setSpeed(int newSpeed) { // sets new speed of the pakuri
        speed = newSpeed;
    }


    public void setSpecies(String newSpecies) { // sets species of the pakuri
        species = newSpecies;
    }

    public void evolve() { // evolves the pakuri by doubling the attack (*2), quadrupling the defense (*4), and triple the speed (*3)
        setAttack(getAttack() * 2);
        setDefenseLevel(getDefense() * 4);
        setSpeed(getSpeed() * 3);
    }
}



