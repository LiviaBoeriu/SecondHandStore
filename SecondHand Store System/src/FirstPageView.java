import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Livia Boeriu
 */
public class FirstPageView extends BorderPane {
        BorderPane firstPageBorder = new BorderPane();
        VBox vboxPane = new VBox(20);
        HBox hboxPane = new HBox();
        Button adminLogin = new Button("Leder-adgang");
        Button regularUserLogin = new Button("Frivillig personale-adgang");
        Label headerTitel = new Label("Genbrugsbutik");
             
        
        private class adminMouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            adminLogin.setStyle("-fx-cursor: hand; -fx-background-color: #6495ed");
        }
}
        private class adminMouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               adminLogin.setStyle("-fx-background-color: LightBlue");
            }
        }
        
        private class regularMouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            regularUserLogin.setStyle("-fx-cursor: hand; -fx-background-color: #6495ed");
        }
}
        private class regularMouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               regularUserLogin.setStyle("-fx-background-color: LightBlue");
            }
        }
        private class AdminViewHandler implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent event){
            Stage window = MainInterface.getStage();
            Scene loginScene = MainInterface.getLoginScene();
            window.setScene(loginScene);
            }
        }
        
        private class RegularViewHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                Stage window = MainInterface.getStage();
                Scene overviewScene = MainInterface.getOverviewScene();
                window.setScene(overviewScene);
            }
        }

        public FirstPageView() {
            //set up for the height and width of the buttons in the first page
            adminLogin.setPrefHeight(80);
            adminLogin.setPrefWidth(250);
            regularUserLogin.setPrefHeight(80);
            regularUserLogin.setPrefWidth(250);
        
            //align the VBox on the center
            vboxPane.setAlignment(Pos.CENTER);
            hboxPane.setAlignment(Pos.CENTER);
            
            adminLogin.setStyle("-fx-background-color: LightBlue");
            regularUserLogin.setStyle("-fx-background-color: LightBlue");
        
            //set the firstPageBorder to the center
            firstPageBorder.setCenter(vboxPane);
            firstPageBorder.setTop(hboxPane);
           
            //add the children to the vBox
            vboxPane.getChildren().addAll(adminLogin, regularUserLogin);
            hboxPane.getChildren().add(headerTitel);
            
            // Making layout for hBoxTop
            hboxPane.setAlignment(Pos.CENTER);
            hboxPane.setMaxHeight(150);
            hboxPane.setPrefHeight(150);
            hboxPane.setFillHeight(false);
            
            // Makeing layout for headerTitel "Genbrugsbutik"
            headerTitel.setFont(Font.font ("Verdana",30));
           
            adminLogin.setOnMouseClicked(new FirstPageView.AdminViewHandler());
            regularUserLogin.setOnAction(new FirstPageView.RegularViewHandler());
            adminLogin.setOnMouseEntered(new adminMouseEnteredHandler());
            adminLogin.setOnMouseExited(new adminMouseExitHandler());
            regularUserLogin.setOnMouseEntered(new regularMouseEnteredHandler());
            regularUserLogin.setOnMouseExited(new regularMouseExitHandler());
            
            adminLogin.setTooltip(new Tooltip("Gå til leder-adgangen"));
            regularUserLogin.setTooltip(new Tooltip("Gå til prissætningsguiden"));
            
            setCenter(firstPageBorder);
            adminLogin.setFont(Font.font("System Regular",FontWeight.NORMAL, 17));
            regularUserLogin.setFont(Font.font("System Regular",FontWeight.NORMAL, 17));
            hboxPane.setStyle("-fx-background-color: #E5EBE9");
            
            
            
        }      
}
