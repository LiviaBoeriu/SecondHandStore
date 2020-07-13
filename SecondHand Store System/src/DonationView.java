import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  This class provides the structure for the table containing the donation 
 *  table head.
 *  @author Livia
 */
public class DonationView extends BorderPane {
    
    //Create a new grid pane
    static GridPane donationView = new GridPane();
    
    //Create the items that will be added to the pane
    Label category = new Label("Kategori");
    Label condition = new Label("Tilstand");
    Label brand = new Label("Mærke");
    Label estimatePrice = new Label("Estimeret pris");
    
    /**
     * This is the constructor of the donation view interface
     */
    public DonationView() {
        category.getStyleClass().add("generalTextModification");
        condition.getStyleClass().add("generalTextModification");
        brand.getStyleClass().add("generalTextModification");
        estimatePrice.getStyleClass().add("generalTextModification");
        
        //set the columnConstraints for the 4 columns
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(Priority.ALWAYS);
        column1.setFillWidth(true);
               
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        column2.setFillWidth(true);
        
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setHgrow(Priority.ALWAYS);
        column3.setFillWidth(true);
        
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setHgrow(Priority.ALWAYS);
        column4.setFillWidth(true);
        
        //add the constraints to the Grid Pane
        donationView.getColumnConstraints().addAll(column1, column2, column3, column4); 
        GridPane.setHalignment(category, HPos.CENTER);
        GridPane.setHalignment(condition, HPos.CENTER);
        GridPane.setHalignment(brand, HPos.CENTER);
        GridPane.setHalignment(estimatePrice, HPos.CENTER);
        
        donationView.setAlignment(Pos.CENTER);

        donationView.add(category, 0, 0); //col = 0; row = 0;
        donationView.add(condition, 1, 0);
        donationView.add(brand, 2, 0);
        donationView.add(estimatePrice, 3, 0);
        
        donationView.setGridLinesVisible(true);

        this.setCenter(donationView);
    } 
}      

