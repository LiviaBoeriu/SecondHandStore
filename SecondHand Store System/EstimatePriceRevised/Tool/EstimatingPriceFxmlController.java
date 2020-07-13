/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tool;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author boeri
 */
public class EstimatingPriceFxmlController implements Initializable {
    
     public Button donationSearchButton;
     public TextField donationTextField;
     public GridPane donationGridPane;
     
     public void handleSearchButtonClick() {
// this is a reference to the store
		Store store = EstimatingPriceTool.getStore();		
                Donation donation = null;

                ArrayList<Donation> donationList = store.getDonations();

		// get the input value from the UI field
		String furnitureInputIdValue = donationTextField.getText();
	   
		// we must check if there is a value in the input field
		if (furnitureInputIdValue.length() != 0) {
                    // can throw exception if the inserted value is not an integer but the filed has a value
                    int inputValue = Integer.parseInt(furnitureInputIdValue);

                    for (int i = 0; i < donationList.size(); i++) {
                        // check if we have an item with that id in the store
                        if (donationList.get(i).getId() == inputValue) {
                                // if so we add it in the 'item' variable
                                donation = donationList.get(i);
                                // we break the for loop because we found it
                                break;
                        }
                    }
		   
                    if (donation != null) {  // if we found an item with that id
                        //get the donation details
                        
                        int donationId = donation.getId();
                        ArrayList<Furniture> donationItems = donation.getItems();

                        //set grid with donation items
                        
                        if (!donationGridPane.getChildren().isEmpty()) {
                            donationGridPane.getChildren().clear();
                            for (int i = 0; i < donationItems.size(); i++) {

                            Furniture currentItem = donationItems.get(i);
                               
                            Label itemCategory = new Label(currentItem.getCategory());
                            Label itemCondition = new Label(currentItem.getCondition());
                            Label itemBrand = new Label(currentItem.getBrand());
                            Label itemEstimatePrice = new Label(Double.toString(currentItem.getEstimatedPrice()));
                             
                            donationGridPane.addRow(i, itemCategory, itemCondition, itemBrand, itemEstimatePrice);
                            donationGridPane.setVisible(true);
                            }
                        }
                                                
		   } else {
			   System.out.println("Donation NOT found!");
//                           donationIdTextField.setText(" - ");
//                           donationAddressTextField.setText(" - ");
//                           donationDateTextField.setText(" - ");
		   }
		} else {
		   System.out.println("Please fill in the input.");
		}
	}
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
