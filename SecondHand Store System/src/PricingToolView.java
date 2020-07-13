import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PricingToolView extends BorderPane {
    //get the store
    Store store = MainInterface.getStore();	

    //get the donation list from the store
    ArrayList<Donation> donationList = store.getDonations();
    
    //create the container for the top part
    BorderPane containerTop = new BorderPane();
    //create the HBox for the header and the label
    StackPane header = new StackPane();
    Label headerText = new Label("Prissætningsguide");
   
    StackPane backButtonPane = new StackPane();
    Button backButton = new Button("Tilbage");
    //container for the search elements
    BorderPane containerSearch = new BorderPane();
    HBox containerDonationButton = new HBox();
    
    //creating the center border pane
    BorderPane centerPane = new BorderPane();
    //creating a donationView object for the header of the table
    DonationView donationView = new DonationView();
    
    //creating elements for the search HBox
    Label donationLabel = new Label("Donations ID: ");
    TextField donationInput = new TextField();
    Button searchDonationButton = new Button("Søg");
    
    //button for yes/no test
    GridPane donationGridContents = new GridPane();
    GridPane donationGrid = new GridPane();
    
    //Function that returns a donation containing a list of furniture items
    public void getDonation() {
        Donation donation = null;
        // get the input value from the UI field
        String furnitureInputIdValue = donationInput.getText();

        // we must check if there is a value in the input field
        if (furnitureInputIdValue.length() != 0) {
            /**
             * can throw exception if the inserted 
             * value is not an integer but the field has a value
             */ 
            int inputValue = Integer.parseInt(furnitureInputIdValue);
            //going through the donation list to get the individual donations
            for (int i = 0; i < donationList.size(); i++) {
                // check if we have an item with that id in the store
                if (donationList.get(i).getId() == inputValue) {
                    // if so we add it in the 'item' variable
                    donation = donationList.get(i);
                    // we break the for loop because we found it
                    break;
                }
            }
            /**
             * getting the data from the donation 
             * found if the value returned is not null
             */
            if (donation != null) {  // if we found an item with that id
                ArrayList<Furniture> donationItems = donation.getItems();

                for (int i = 0; i < donationItems.size(); i++) {
                    Furniture currentItem = donationItems.get(i);
                    Label itemCategory = new Label(currentItem.getCategory());
                    Label itemCondition = new Label(currentItem.getCondition());
                    Label itemBrand = new Label(currentItem.getBrand());
                    Label itemEstimatePrice = new Label(Double.toString(currentItem.getEstimatedPrice()));
                    
                    //setting the font of the labels
                    itemCategory.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
                    itemCondition.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
                    itemBrand.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
                    itemEstimatePrice.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
                    
                    donationGrid.addRow(i + 1, itemCategory, itemCondition, itemBrand, itemEstimatePrice);
                    GridPane.setHalignment(itemCategory, HPos.CENTER);
                    GridPane.setHalignment(itemCondition, HPos.CENTER);
                    GridPane.setHalignment(itemBrand, HPos.CENTER);
                    GridPane.setHalignment(itemEstimatePrice, HPos.CENTER);

                    donationGrid.setVgap(10);
                    donationGrid.setHgap(10);
                    donationGridContents = donationGrid;
                }
            } else {
                System.out.println("Donationen er IKKE fundet!"); 
            }
        } else {
            System.out.println("Please fill in the input.");
        }
    }
	
    
	//Creating the mouse event handler for the search item button 
	EventHandler<javafx.scene.input.MouseEvent> searchDonation = 
	   new EventHandler<javafx.scene.input.MouseEvent>() { 
	   
	   @Override 
	   public void handle(javafx.scene.input.MouseEvent e) {
               if(!donationGridContents.getChildren().isEmpty()) {
                   donationGridContents.getChildren().clear();
               } 
               getDonation();
	   } 
	   
	};
	//Creating event handler for key pressed enter on the field
	EventHandler<javafx.scene.input.KeyEvent> keyEventHandler = 
		new EventHandler<javafx.scene.input.KeyEvent>() { 
	   
	    @Override 
	    public void handle(javafx.scene.input.KeyEvent e) {
                if(!donationGridContents.getChildren().isEmpty()) {
                   donationGridContents.getChildren().clear();
                } 
	    	if (e.getCode().equals(KeyCode.ENTER)) {
                    getDonation();	  
	    	}
	    } 
	};
        
        private class backMouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            backButton.setStyle("-fx-cursor: hand; -fx-background-color: #6495ed");
            }
        }
        private class backMouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               backButton.setStyle("-fx-background-color: LightBlue");
            }
        }
                
        //Handler for the back button
        private class BackButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            Stage window = MainInterface.getStage();
            Scene firstScene = MainInterface.getFirstScene();
            window.setScene(firstScene);
        }
    }
                
	public PricingToolView () {
            //setting the constraints for the donationGrid panel
            ColumnConstraints column1 = new ColumnConstraints();
            column1.setHgrow(Priority.SOMETIMES);
            ColumnConstraints column2 = new ColumnConstraints();
            column2.setHgrow(Priority.SOMETIMES);
            ColumnConstraints column3 = new ColumnConstraints();
            column3.setHgrow(Priority.SOMETIMES);
            ColumnConstraints column4 = new ColumnConstraints();
            column4.setHgrow(Priority.SOMETIMES);
            
            //adding them to the panel
            donationGrid.getColumnConstraints().addAll(column1, column2, column3, column4); 
            
            //setting things on the centerPane
            centerPane.setTop(donationView);
            centerPane.setCenter(donationGrid);
            
            //setting the elements in the top container
            containerTop.setCenter(header);
            
     
           //setting things in the top containers
            containerTop.setTop(backButtonPane);
            containerTop.setBottom(containerSearch);
            
            //setting the elements to the search container 
            containerSearch.setCenter(containerDonationButton);
 
            //adding the nodes to the panes
            backButtonPane.getChildren().add(backButton);
            containerDonationButton.getChildren().addAll(donationLabel, donationInput, searchDonationButton);
            header.getChildren().addAll(headerText);
            
            //setting the alignment of the elements
            backButton.setAlignment(Pos.TOP_RIGHT);
            headerText.setAlignment(Pos.CENTER);
            header.setAlignment(Pos.CENTER);
            containerDonationButton.setAlignment(Pos.CENTER);
            backButtonPane.setAlignment(Pos.TOP_RIGHT);
            donationGrid.setAlignment(Pos.CENTER);
            
            backButton.setStyle("-fx-background-color: LightBlue");
            //define event handlers
            searchDonationButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, searchDonation);
            donationInput.addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED, keyEventHandler);
            backButton.setOnAction(new BackButtonHandler());
            backButton.setOnMouseEntered(new backMouseEnteredHandler());
            backButton.setOnMouseExited(new backMouseExitHandler());

            //setting tooltips for the items
            backButton.setTooltip(new Tooltip("Gå tilbage til forrige side"));
            donationInput.setTooltip(new Tooltip("Skriv donations ID"));
            
            //setting the font on buttons
            backButton.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
            searchDonationButton.setFont(Font.font("System Regular",FontWeight.NORMAL, 13));
            donationInput.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
            
            //Add the style class from the css file to the container for setting the style
            containerTop.getStyleClass().add("container");
            header.getStyleClass().add("header");
            headerText.getStyleClass().add("headerText");
            donationGridContents.getStyleClass().add("donationTable");
            donationView.getStyleClass().add("donationView");
            donationLabel.getStyleClass().add("generalTextModification");
            containerSearch.getStyleClass().add("containerSearch");
            
            //setting the elements on the main page view
            this.setTop(containerTop);
            this.setCenter(centerPane);
            
            setTop(containerTop);
            setCenter(centerPane);
	} 
}
