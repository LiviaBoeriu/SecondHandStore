import java.text.ParseException;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainInterface extends Application{
    //created a stage called window
    static Stage window;
     
    //created the scenes for the stage
    public static Scene firstScene, loginScene, overviewScene, adminScene; 
   
    static Store store = new Store();
    
    @Override
    public void start(Stage primaryStage) throws Exception {   
        //assigned the primaryStage as the window
        window = primaryStage;
                
        //set the title of the window
        primaryStage.setTitle("Genbrugsbutik");
        
        //assigned the first page view as the first scene
        FirstPageView firstPageView = new FirstPageView();
        firstScene = new Scene(firstPageView, 1800, 1000);
        
        //style border pane and create elements for the regular view
        BorderPane layout = new BorderPane();
        layout.setStyle("-fx-background-color: white;");
        
        AdminView adminView = new AdminView();
        adminScene = new Scene(adminView, 1800, 1000);
        
        PricingToolView pricingTool = new PricingToolView();
        overviewScene = new Scene(pricingTool, 1800, 1000);
 
        ViewLogin viewLogin = new ViewLogin();
        loginScene = new Scene(viewLogin, 1800, 1000);

        //set the default scene as the first scene
        window.setScene(firstScene);
        
        //showed/displayed the primary stage
        primaryStage.show();
        overviewScene.getStylesheets().add("newCascadeStyleSheet.css");
        firstScene.getStylesheets().add("newCascadeStyleSheet.css");
        adminScene.getStylesheets().add("newCascadeStyleSheet.css");
        loginScene.getStylesheets().add("newCascadeStyleSheet.css");
    }
	
    public static void main(String[] args) throws ParseException {
        
        ArrayList<Furniture> donationItems1 = new ArrayList<>(); 
        ArrayList<Furniture> donationItems2 = new ArrayList<>(); 
        ArrayList<Furniture> donationItems3 = new ArrayList<>();
        ArrayList<Furniture> donationItems4 = new ArrayList<>();
        ArrayList<Furniture> donationItems5 = new ArrayList<>(); 
        ArrayList<Furniture> donationItems6 = new ArrayList<>();
        ArrayList<Furniture> donationItems7 = new ArrayList<>();
        ArrayList<Furniture> donationItems8 = new ArrayList<>();
        ArrayList<Furniture> donationItems9 = new ArrayList<>();
        ArrayList<Furniture> donationItems10 = new ArrayList<>();
        ArrayList<Furniture> donationItems11 = new ArrayList<>(); 
        ArrayList<Furniture> donationItems12 = new ArrayList<>();
        ArrayList<Furniture> donationItems13 = new ArrayList<>();
        ArrayList<Furniture> donationItems14 = new ArrayList<>();
        ArrayList<Furniture> donationItems15 = new ArrayList<>(); 
        ArrayList<Furniture> donationItems16 = new ArrayList<>();
        ArrayList<Furniture> donationItems17 = new ArrayList<>();
        ArrayList<Furniture> donationItems18 = new ArrayList<>();
        
        Store myStore = getStore();

        Furniture coffeeTable = new Furniture("Bord", "Dårlig", "Ikea");
        Furniture sofa = new Furniture("Sofa", "Dårlig", "Bilka");
        Furniture armChair = new Furniture("Stol", "God", "Bilka");
        Furniture bookcase = new Furniture("Bord", "Meget god", "Bilka");
        Furniture desk = new Furniture ("Bord", "God", "Bilka");
        Furniture diningTable = new Furniture ("Bord", "God", "Bilka");
        Furniture barstool = new Furniture ("Stol", "Meget god", "Bilka");
        Furniture coffeeTable1 = new Furniture ("Bord", "God", "Ikea");
        Furniture diningTable1 = new Furniture("Bord", "Dårlig", "Ikea");
        Furniture sofa1 = new Furniture("Bord", "Dårlig", "Bilka");
        Furniture officeChair = new Furniture("Stol", "God", "Bilka");
        Furniture diningChair = new Furniture("Stol", "Meget god", "Bilka");
        Furniture gardenChair = new Furniture ("Stol", "God", "Bilka");
        Furniture armChair2 = new Furniture ("Stol", "God", "Bilka");
        Furniture barstool1 = new Furniture ("Stol", "Meget god", "Bilka");
        Furniture sofaTable2 = new Furniture ("Bord", "God", "Ikea");
      
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
        donationItems7.add(desk);
        donationItems7.add(armChair2);
        donationItems7.add(diningChair);
        donationItems8.add(diningTable1);
        donationItems8.add(bookcase);
        donationItems8.add(barstool);
        donationItems8.add(officeChair);
        donationItems9.add(desk);
        donationItems9.add(armChair2);
        donationItems9.add(sofa1);
        donationItems9.add(diningTable1);
        donationItems9.add(bookcase);
        donationItems9.add(armChair);
        donationItems9.add(coffeeTable);
        donationItems10.add(diningTable1);
        donationItems10.add(sofa1);
        donationItems11.add(officeChair);
        donationItems11.add(diningChair);
        donationItems11.add(gardenChair);
        donationItems12.add(coffeeTable);
        donationItems12.add(sofa);
        donationItems12.add(sofa1);
        donationItems13.add(desk);
        donationItems13.add(diningTable);
        donationItems13.add(barstool);
        donationItems14.add(coffeeTable1);
        donationItems15.add(gardenChair);
        donationItems15.add(armChair2);
        donationItems16.add(officeChair);
        donationItems16.add(desk);
        donationItems16.add(armChair2);
        donationItems16.add(sofa1);
        donationItems16.add(diningTable1);
        donationItems16.add(bookcase);
        donationItems16.add(armChair);
        donationItems17.add(coffeeTable);
        donationItems17.add(diningTable1);
        donationItems17.add(sofa1);
        donationItems18.add(coffeeTable);
        donationItems18.add(sofa);
        
        
        Donation donation1 = new Donation("Istedgade 8, 2.th, 9000 Aalborg", 12563567, "13/12/2018", donationItems1);
        Donation donation2 = new Donation("Boulevarden 11, 1.tv, 9000 Aalborg", 21664345, "10/12/2018", donationItems2);
        Donation donation3 = new Donation("Løkkegade 28, 4.th, 9000 Aalborg", 84362977, "14/12/2018", donationItems3);
        Donation donation4 = new Donation("Priorgade 3, 1.th, 9000 Aalborg", 83469812, "13/12/2018", donationItems4);
        Donation donation5 = new Donation("Danmarksgade 41, 9000 Aalborg", 23144836, "13/12/2018", donationItems5);
        Donation donation6 = new Donation("Slotsgade 8, 9000 Aalborg", 73625985, "15/01/2019", donationItems6);
        Donation donation7 = new Donation("Stendisvej 8, 9220 Aalborg Øst", 45678926, "12/12/2018", donationItems7);
        Donation donation8 = new Donation("Algade 12, 1.tv, 9000 Aalborg", 21904875, "12/12/2018", donationItems8);
        Donation donation9 = new Donation("Vesterbro 31, 5.th, 9000 Aalborg", 84362977, "10/12/2018", donationItems9);
        Donation donation10 = new Donation("Mylius Erichsens Vej 3, 1.th, 9220 Aalborg", 83139812, "10/12/2018", donationItems10);
        Donation donation11 = new Donation("Danmarksgade 41, 9000 Aalborg", 53144836, "14/12/2018", donationItems11);
        Donation donation12 = new Donation("Østerbrobrygge 31, 9000 Aalborg", 43565875, "12/12/2018", donationItems12);
        Donation donation13 = new Donation("Rydemøllevej 12, 9200 Aalborg SV", 12563567, "13/12/2018", donationItems13);
        Donation donation14 = new Donation("Havregade 25, 3.tv, 9220 Aalborg Øst", 21664345, "10/12/2018", donationItems14);
        Donation donation15 = new Donation("Korsgade 3, 4.th, 9000 Aalborg", 84362977, "14/12/2018", donationItems15);
        Donation donation16 = new Donation("Bispensgade 3, 2.th, 9000 Aalborg", 83469812, "13/12/2018", donationItems16);
        Donation donation17 = new Donation("Hjortevej 41, 9200 Aalborg SV", 23144836, "13/12/2018", donationItems17);
        Donation donation18 = new Donation("Mælkestien 8, 9000 Aalborg", 73625985, "12/12/2018", donationItems18);

        
        myStore.addDonation(donation1);
        myStore.addDonation(donation2);
        myStore.addDonation(donation3);
        myStore.addDonation(donation4);
        myStore.addDonation(donation5);
        myStore.addDonation(donation6);
        myStore.addDonation(donation7);
        myStore.addDonation(donation8);
        myStore.addDonation(donation9);
        myStore.addDonation(donation10);
        myStore.addDonation(donation11);
        myStore.addDonation(donation12);
        myStore.addDonation(donation13);
        myStore.addDonation(donation14);
        myStore.addDonation(donation15);
        myStore.addDonation(donation16);
        myStore.addDonation(donation17);
        myStore.addDonation(donation18);

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
        System.out.println("Donation 7 ID: " + donation7.getId());
        System.out.println("Donation 8 ID: " + donation8.getId());
        System.out.println("Donation 9 ID: " + donation9.getId());
        System.out.println("Donation 10 ID: " + donation10.getId());
        System.out.println("Donation 11 ID: " + donation11.getId());
        System.out.println("Donation 12 ID: " + donation12.getId());
        
        System.out.println("Donations dato: " + donation1.getDate());
        System.out.println("Number of items in archive: " + myStore.getArchiveItems().size());

        launch(args);
    }
    
    /**
     * Method for getting the global store from the system
     * @return store 
     */
    public static Store getStore () {
        return store;
    }  
    
    /**
     * Method for getting the admin scene from the main view
     * @return adminScene
     */
    public static Scene getAdminScene() {
        return adminScene;
    }
    
    /**
     * Method for getting the first page scene from the main view
     * @return firstScene
     */
    public static Scene getFrontPageScene() {
        return firstScene;
    }
    
    /**
     * Method for getting the overview scene from the main view
     * @return overviewScene
     */
    public static Scene getOverviewScene() {
        return overviewScene;
    }
    
    /**
     * Method for getting the first scene from the main view
     * @return firstSccene
     */
    public static Scene getFirstScene() {
        return firstScene;
    }
    
    /**
     * Method for getting the login scene from the main view
     * @return loginScene
     */
    public static Scene getLoginScene() {
        return loginScene;
    }
    
    /**
     * Method for getting the stage from the main view
     * @return window
     */
    public static Stage getStage() {
        return window;
    }
    
    
}
