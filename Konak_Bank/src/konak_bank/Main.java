package konak_bank;

import java.util.ArrayList;

/**
 *
 * @author Martin Koňák
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList();
        Person Pekar = new Person("Pekar");
        Person Svecova = new Person("Svecova");
        Company Skoda = new Company("Skoda");
        clients.add(Pekar);
        clients.add(Svecova);
        clients.add(Skoda);
        
        Pekar.addAccount(1000);
        Pekar.addAccount(500);
        Svecova.addAccount(1200);
        Skoda.addAccount(120);
        
        for(Client c : clients){
            System.out.println(c.getName() + " : " + c.sumAllAccs() + " korun");
        }
    }
}
