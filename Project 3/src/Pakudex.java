import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

public class Pakudex {
    private int capacity;
    private int[] info = new int[3];
    private Pakudex [] amount;
    private List<String> pakuriType = new ArrayList<>();
    private HashMap<String, Pakuri> pakuriStored = new HashMap<String, Pakuri>();


    public Pakudex() // default constructor, when called the default capacity for the Pakudex will be 20
    {
        amount = new Pakudex[20];
    }

    public Pakudex(int capacity) { // initializes object to contain capacity objects when full
        amount = new Pakudex[capacity];
    }

    public int getSize() { // returns the number of pakuri that are stored in the Pakudex
        return pakuriType.size();
    }

    public int getCapacity() { // returns the max number of pakuri that the Pakudex can hold
        return amount.length;
    }

    public String[] getSpeciesArray() { // returns string array that contains the type of pakuri stored in the Pakudex, when there are no species added, returns null
        if (pakuriType.size() == 0) {
            return null;
        }
        String[] list = new String[pakuriType.size()];
        return pakuriType.toArray(list);
    }

    public void setSpeciesArray(String species) { // pairs species with pakuri
        Pakuri pakuri = new Pakuri(species);
        pakuriStored.put(species, pakuri);
        pakuriType.add(species);
    }

    public int[] getStats(String species) { // returns int array that has attack, defense, and speed info at the value 0, 1, 2
                                            // if species is not in Pakudex, returns null
        if (pakuriStored.containsKey(species))
        {
            Pakuri pakuri = pakuriStored.get(species);
            info[0] = pakuri.getAttack();
            info[1] = pakuri.getDefense();
            info[2] = pakuri.getSpeed();
            return info;
        }

        else
        {
            System.out.println("Error: No such Pakuri!");
            return null;
        }
    }

    public void sortPakuri() { // sorts the pakuri into the Pakudex
        Collections.sort(this.pakuriType);
    }

    public boolean addPakuri(String species) { // adds species to Pakudex if there is room left in the Pakudex
        if (getSpeciesArray() == null || !Arrays.asList(this.getSpeciesArray()).contains(species))
        {
            setSpeciesArray(species);
            return true;
        }

        else
        {
            return false;
        }
    }

    public boolean evolveSpecies(String pakuriType) { // tries to evolve species that are in the Pakudex
        if (this.getSpeciesArray() != null && Arrays.asList(this.getSpeciesArray()).contains(pakuriType))
        {
            Pakuri pakuri = new Pakuri(pakuriType);
            pakuri.evolve();
            pakuriStored.put(pakuriType, pakuri);
            return true;
        }
        else
        {
            return false;
        }
    }
}
