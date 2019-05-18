import java.util.Arrays;

public class DrugstoreDemo implements iFilter{
    int clientCounter;
    Client[] clients;
    public static void main(String[] args) {
        // You should add an eventlistener to the add button,
        // so that everytime you want to register a client
        // you call the registerClient(); method

        // For the filtering methods, an eventlistener should
        // be added to an Age/gender choiceBox that calls the
        // filterByAge(); or filterByGender(); method.

    }
    public void filterByAge(){
        int[] ages = new int[clients.length];
        for(int i = 0; i < clientCounter; i++){
            ages[i] = clients[i].getAge();
            Arrays.sort(ages);
        }
    }
    public void filterByGender(){
        int sortedClients = 0;
        int i;
        for(i = 0; i < clientCounter; i++){
            if(clients[i].getGender().equals("Male")){
                Client c = clients[i];
                // ObservableList[sortedClients].add(c);
                // In the GUI add the object to the first 
                // position of the observable list
                sortedClients++;
            }else{
                for(i = sortedClients; i < clients.length; i++){
                    Client c = clients[i];
                    // ObservableList[sortedClients].add(c);
                    // Add the remaining female clients
                    // to the observable list
                    sortedClients++;
                }
            }
        }
    }
    public void registerClient(){
        // This is an example, but in the GUI
        // you should be getting the data from the
        // textFields.
        Client c = new Client();
        c.setName("Ricardo");
        c.setAge(18);
        c.setGender("Male");
        c.setDisease("Flu");
        c.setMedicineBought("Something");
        clientCounter++;
    }
}