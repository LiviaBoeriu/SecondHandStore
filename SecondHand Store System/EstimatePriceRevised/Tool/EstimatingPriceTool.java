/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tool;

import java.text.ParseException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Livia
 */
public class EstimatingPriceTool extends Application{
    
    Stage window;
    
    static Store store = new Store();
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {   
        
        //assigned the primaryStage as the window
        window = primaryStage;
        
        Parent root = FXMLLoader.load(getClass().getResource("EstimatingPriceFxml.fxml"));
        
        Scene scene = new Scene(root);

        //set the title of the window
        primaryStage.setTitle("Second Hand Shop");
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    public static void main(String[] args) throws ParseException {
        
        ArrayList<Furniture> donationItems1 = new ArrayList<>(); 
        ArrayList<Furniture> donationItems2 = new ArrayList<>(); 
        ArrayList<Furniture> donationItems3 = new ArrayList<>();
        ArrayList<Furniture> donationItems4 = new ArrayList<>();
        ArrayList<Furniture> donationItems5 = new ArrayList<>(); 
        ArrayList<Furniture> donationItems6 = new ArrayList<>(); 
        
        Store myStore = getStore();

        Furniture coffeeTable = new Furniture("Table", "Poor", "Ikea");
        Furniture sofa = new Furniture("Sofa", "Poor", "Bilka");
        Furniture armChair = new Furniture("Chair", "Good", "Bilka");
        Furniture bookcase = new Furniture("Table", "Excellent", "Bilka");
        Furniture desk = new Furniture ("Table", "Good", "Bilka");
        Furniture diningTable = new Furniture ("Table", "Good", "Bilka");
        Furniture barstool = new Furniture ("Chair", "Excellent", "Bilka");
        Furniture coffeeTable1 = new Furniture ("Table", "Good", "Ikea");
        Furniture diningTable1 = new Furniture("Table", "Poor", "Ikea");
        Furniture sofa1 = new Furniture("Table", "Poor", "Bilka");
        Furniture officeChair = new Furniture("Chair", "Good", "Bilka");
        Furniture diningChair = new Furniture("Chair", "Excellent", "Bilka");
        Furniture gardenChair = new Furniture ("Chair", "Good", "Bilka");
        Furniture armChair2 = new Furniture ("Chair", "Good", "Bilka");
        Furniture barstool1 = new Furniture ("Chair", "Excellent", "Bilka");
        Furniture sofaTable2 = new Furniture ("Table", "Good", "Ikea");

        donationItems1.add(coffeeTable);
        donationItems1.add(sofa);
        donationItems2.add(armChair);
        donationItems2.add(bookcase);
        donationItems2.add(desk);
        donationItems2.add(diningTable);
        donationItems3.add(barstool);
        donationItems3.add(coffeeTable1);
        donationItems3.add(diningTable1);
        donationItems4.add(sofa1);
        donationItems4.add(officeChair);
        donationItems5.add(diningChair);
        donationItems5.add(gardenChair);
        donationItems5.add(armChair2);
        donationItems6.add(barstool1);
        donationItems6.add(sofaTable2);

        Donation donation1 = new Donation("Istedgade 8, 2.th, 9000 Aalborg", 12563567, "24/11/2018", donationItems1);
        Donation donation2 = new Donation("Boulevarden 11, 1.tv, 9000 Aalborg", 21664345, "03/12/2018", donationItems2);
        Donation donation3 = new Donation("Løkkegade 28, 4.th, 9000 Aalborg", 84362977, "07/12/2018", donationItems3);
        Donation donation4 = new Donation("Priorgade 3, 1.th, 9000 Aalborg", 83469812, "10/12/2018", donationItems4);
        Donation donation5 = new Donation("Danmarksgade 41, 9000 Aalborg", 23144836, "13/12/2018", donationItems5);
        Donation donation6 = new Donation("Slotsgade 8, 9000 Aalborg", 73625985, "06/01/2019", donationItems6);
        
        myStore.addDonation(donation1);
        myStore.addDonation(donation2);
        myStore.addDonation(donation3);
        myStore.addDonation(donation4);
        myStore.addDonation(donation5);
        myStore.addDonation(donation6);

        System.out.println(sofaTable2.getEstimatedPrice());

        //adding items to donation 1 
        donationItems1.add(sofaTable2);
        
        //adding items to donation 2 
        donationItems2.add(sofa);
        donationItems2.add(officeChair);
        donationItems2.add(diningChair);
        
        //add items to donation 3
        donationItems3.add(sofa);
        donationItems3.add(officeChair);
        donationItems3.add(diningChair);
        donationItems3.add(sofaTable2);
        donationItems3.add(barstool1);

        
        System.out.println("Donation 1 ID: " + donation1.getId());
        System.out.println("Donation 2 ID: " + donation2.getId());
        System.out.println("Donation 3 ID: " + donation3.getId());
        System.out.println("Donation 4 ID: " + donation4.getId());
        System.out.println("Donation 5 ID: " + donation5.getId());
        System.out.println("Donation 6 ID: " + donation6.getId());

        System.out.println("Number of items in archive: " + myStore.getArchiveItems().size());
        
        
        launch(args);
        
    }
        public static Store getStore () {
        return store;
    } 
}
