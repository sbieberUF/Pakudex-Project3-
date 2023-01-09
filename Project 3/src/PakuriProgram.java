import java.util.Scanner;

public class PakuriProgram {

    public static Integer pakudexCap; // capacity for Pakudex
    public static void main(String[] args) {

        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        Scanner scanner = new Scanner(System.in);
        while (!false) // Capacity for Pakudex
        {
            System.out.print("Enter max capacity of the Pakudex: ");

            try
            {
                Object capacity = scanner.next();
                pakudexCap = Integer.parseInt(capacity.toString());
                if (pakudexCap<0) {
                    System.out.println("Please enter a valid size.");
                    continue;
                }
                break;
            }

            catch (Exception object) {
                System.out.println("Please enter a valid size.");
            }
        }

        System.out.println(" ");
        System.out.println("The Pakudex can hold" + " " + pakudexCap + " " + "species of Pakuri."); // prints max # of Pakuri

        Pakudex pakudex = new Pakudex();
        if (pakudexCap != null) {
            pakudex = new Pakudex(pakudexCap);
        }

        while(!false) { // Pakudex Menu
            int menu;
            System.out.println(" ");
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.println(" ");
            System.out.print("What would you like to do? ");

            try {
                Object object = scanner.next();
                menu = Integer.parseInt(object.toString());
            }
            catch(Exception object) {
                System.out.println("Unrecognized menu selection!");
                continue;
            }

            switch (menu) {
                case 1: // Lists the Pakuri(s)
                    if (pakudex.getSpeciesArray() != null)
                    {
                        System.out.println("Pakuri In Pakudex:");
                        for(int i=0; i < pakudex.getSpeciesArray().length; i++)
                        {
                            System.out.println((i+1) + "." + " " + pakudex.getSpeciesArray()[i]);
                        }
                    }

                    else
                    {
                        System.out.println("No Pakuri in Pakudex yet!");
                    }
                    break;

                    case 2: // Shows Pakuri
                    System.out.print("Enter the name of the species to display: ");

                    Object object = scanner.next();
                    String species = object.toString();
                    int[] info = pakudex.getStats(species);

                    if ((info != null) && (info.length != 0))
                    {
                        System.out.println("Species: " + species);
                        System.out.println("Attack: " + info[0]);
                        System.out.println("Defense: " + info[1]);
                        System.out.println("Speed: " + info[2]);
                    }
                    break;

                case 3: // Adds Pakuri
                    if (pakudex.getSize() >= pakudex.getCapacity())
                    {
                        System.out.println("Error: Pakudex is full!");
                        break;
                    }

                    System.out.println("Enter the name of the species to add: ");
                    Object object2 = scanner.next();
                    String pakuriName = object2.toString();

                    if (!pakudex.addPakuri(pakuriName))
                    {
                        System.out.println("Error: Pakudex already contains this species!");

                    }
                    else
                    {
                        System.out.println("Pakuri species " + pakuriName + " successfully added!");
                    }
                    break;

                case 4: // Sorts Pakuri(s)
                    System.out.print("Enter the name of the species to evolve: ");
                    Object object3 = scanner.next();
                    String pakuriEvolve = object3.toString();

                    if (pakudex.evolveSpecies(pakuriEvolve))
                    {
                        System.out.println(pakuriEvolve + " has evolved!");
                    }
                    else
                    {
                        System.out.println("Error: No such Pakuri!");
                    }
                    break;

                case 5: // Sorts Pakuris
                    pakudex.sortPakuri();
                    System.out.println("Pakuri have been sorted!");
                    break;

                case 6: // Exits the program
                    System.out.println("Thanks for using Pakudex! Bye!");
                    System.exit(-1);

                default: // If #1-6 is not input and something else it, outputs this
                    System.out.println("Unrecognized menu selection!");
                    break;
            }
        }

    }

}


