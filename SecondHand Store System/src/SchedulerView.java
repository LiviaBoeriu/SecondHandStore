import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class SchedulerView extends Tab {

    private Store store;
    private Donation donation;
    ArrayList<Donation> donations;
    private GridPane calendarView;
    ArrayList<Donation> toggleddonations = new ArrayList();
    private final LocalTime firstSlotStart = LocalTime.of(8, 00);
    private final Duration slotLength = Duration.ofHours(1);
    private final LocalTime lastSlotStart = LocalTime.of(15, 00);
    Button update;
    Button truck1;
    Button truck2;
    BorderPane routeBorder; 

    
    private class toggledonationHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
             ToggleButton x = (ToggleButton) event.getSource();
             if(x.isSelected() == true){
                for (int i = 0; i < donations.size(); i++) {
                
                if(x.getText().equals("Donation ID:" + donations.get(i).getId())){
                    donation = donations.get(i);
                    toggleddonations.add(donation);
                }
        }
                
    }
             else if(x.isSelected() == false){
                 for (int i = 0; i < donations.size(); i++) {
                
                if(x.getText().equals("Donation ID:" + donations.get(i).getId())){
                    donation = donations.get(i);
                    toggleddonations.remove(donation);
                }
                 
             }
    }
    }
        
        
    }
    
    private class updateHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.minusDays(today.getDayOfWeek().getValue() - 1);
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        
        for (LocalDate date = startOfWeek; !date.isAfter(endOfWeek); date = date.plusDays(1)) {
            int slotIndex = 1;
            for (int i = 0; i < donations.size(); i++) {
                donation = donations.get(i);
                
                Date d = donation.getDate();
                LocalDate ld = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                
                if (ld.equals(date) && donation.getStatus() == 2) {
                    ToggleButton donabutton = new ToggleButton("Donation ID:" + donation.getId());
                    donabutton.setFont(Font.font("System Regular", FontWeight.NORMAL, 15));
                    donabutton.setOnAction(new toggledonationHandler());

                    calendarView.add(donabutton, date.getDayOfWeek().getValue(), slotIndex);
                    slotIndex++;
                }

            }
        }
        }
    }
            
    private class truck1Handler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if(!toggleddonations.isEmpty()){
            Date getdate = toggleddonations.get(0).getDate();
            LocalDate ld = getdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER);
            
            Label routeplan = new Label("Ruteplan for Lastbil 1 d. " + ld);
            routeplan.setUnderline(true);
            routeplan.setAlignment(Pos.CENTER);
            routeplan.setPadding(new Insets(20, 20, 20, 20));
            routeplan.setFont(Font.font("Verdana", 30));
            
            Label donationID = new Label("   Donation ID:");
            donationID.setPadding(new Insets(20, 20, 20, 20));
            donationID.setFont(Font.font("Verdana", 25));
            
            Label donationAddress = new Label("Adresse:");
            donationAddress.setPadding(new Insets(20, 20, 20, 20));
            donationAddress.setFont(Font.font("Verdana", 25));
            
            Label donationPhone = new Label("Telefonnummer:");
            donationPhone.setPadding(new Insets(20, 20, 20, 20));
            donationPhone.setFont(Font.font("Verdana", 25));
            
            hbox.getChildren().addAll(routeplan);
            GridPane routeGrid = new GridPane();
            routeGrid.add(donationID, 0, 0);
            routeGrid.add(donationAddress, 1, 0);
            routeGrid.add(donationPhone, 2, 0);
            routeBorder = new BorderPane();
            HBox hboxbottom = new HBox();
            hboxbottom.setPadding(new Insets(20, 20, 20, 20));
            
            Button print = new Button("Print ruteplan");
            print.setStyle("-fx-background-color: LightBlue");
            print.setPadding(new Insets(20, 20, 20, 20));
            print.setFont(Font.font("Verdana", 40));
            print.setAlignment(Pos.CENTER);
            print.setPrefSize(400, 100);
            print.setCursor(Cursor.HAND);
            print.setOnAction(new printButtonHandlerTruck1());

            
            hboxbottom.getChildren().add(print);
            hboxbottom.setAlignment(Pos.CENTER);
            
            routeBorder.setTop(hbox);
            routeBorder.setCenter(routeGrid);
            routeBorder.setBottom(hboxbottom);

            
            
            for (int i = 0; i < toggleddonations.size(); i++) {
                Donation dona = toggleddonations.get(i);
                
                Label donaID = new Label("    " + dona.getId());
                donaID.setFont(Font.font("Verdana", 20));
                donaID.setPadding(new Insets(20, 20, 20, 20));
                Label donaAddress = new Label("" + dona.getAddress());
                donaAddress.setPadding(new Insets(20, 20, 20, 20));
                donaAddress.setFont(Font.font("Verdana", 20));
                Label donaPhone = new Label("" + dona.getPhone());
                donaPhone.setFont(Font.font("Verdana", 20));
                donaPhone.setPadding(new Insets(20, 20, 20, 20));
                routeGrid.addRow(i +1, donaID, donaAddress, donaPhone);
            }
            for (int i = 0; i < 3; i++) {
                    ColumnConstraints cc = new ColumnConstraints();
                    cc.setPercentWidth(100);
                    cc.setHalignment(HPos.LEFT);
                    routeGrid.getColumnConstraints().add(cc);

            }
            Scene secondScene = new Scene(routeBorder, 1400, 800);
            Stage secondStage = new Stage();
            secondStage.setTitle("Second Stage");
            secondStage.setScene(secondScene);

            secondStage.show();

                }
            
    }
}
    
        
    private class printButtonHandlerTruck1 implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
                        
            Printer printer = Printer.getDefaultPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM); 
            
                PrinterAttributes attr = printer.getPrinterAttributes();
                PrinterJob job = PrinterJob.createPrinterJob();
                double scaleX = pageLayout.getPrintableWidth() / routeBorder.getBoundsInParent().getWidth();
                double scaleY = pageLayout.getPrintableHeight() / routeBorder.getBoundsInParent().getHeight();
                Scale scale = new Scale(scaleX, scaleY);
                routeBorder.getTransforms().add(scale);
                
            if (job != null) {
                boolean success = job.printPage(pageLayout, routeBorder);
               
               if (success) {
                    job.endJob();                    
               }
            }
            
        }
        
    }
    
    private class truck2Handler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if(!toggleddonations.isEmpty()){
            Date getdate = toggleddonations.get(0).getDate();
            LocalDate ld = getdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER);
            
            Label routeplan = new Label("Ruteplan for Lastbil 2 d. " + ld);
            routeplan.setUnderline(true);
            routeplan.setAlignment(Pos.CENTER);
            routeplan.setPadding(new Insets(20, 20, 20, 20));
            routeplan.setFont(Font.font("Verdana", 30));
            
            Label donationID = new Label("Donation ID:");
            donationID.setPadding(new Insets(20, 20, 20, 20));
            donationID.setFont(Font.font("Verdana", 25));
            
            Label donationAddress = new Label("Adresse:");
            donationAddress.setPadding(new Insets(20, 20, 20, 20));
            donationAddress.setFont(Font.font("Verdana", 25));
            
            Label donationPhone = new Label("Telefonnummer:");
            donationPhone.setPadding(new Insets(20, 20, 20, 20));
            donationPhone.setFont(Font.font("Verdana", 25));
            
            hbox.getChildren().addAll(routeplan);
            GridPane routeGrid = new GridPane();
            routeGrid.add(donationID, 0, 0);
            routeGrid.add(donationAddress, 1, 0);
            routeGrid.add(donationPhone, 2, 0);
            HBox hboxbottom = new HBox();
            hboxbottom.setPadding(new Insets(20, 20, 20, 20));

            BorderPane routeBorder = new BorderPane();
            routeBorder.setPrefSize(595, 842);
            
            Button print = new Button("Print ruteplan");
            print.setStyle("-fx-background-color: LightBlue");
            print.setPadding(new Insets(20, 20, 20, 20));
            print.setFont(Font.font("Verdana", 40));
            print.setPrefSize(400, 100);
            print.setAlignment(Pos.CENTER);
            hboxbottom.getChildren().add(print);
            hboxbottom.setAlignment(Pos.CENTER);
            
            routeBorder.setTop(hbox);
            routeBorder.setCenter(routeGrid);
            routeBorder.setBottom(hboxbottom);

            
            
            for (int i = 0; i < toggleddonations.size(); i++) {
                Donation dona = toggleddonations.get(i);
                
                Label donaID = new Label("" + dona.getId());
                donaID.setFont(Font.font("Verdana", 20));
                donaID.setPadding(new Insets(20, 20, 20, 20));
                Label donaAddress = new Label("" + dona.getAddress());
                donaAddress.setPadding(new Insets(20, 20, 20, 20));
                donaAddress.setFont(Font.font("Verdana", 20));
                Label donaPhone = new Label("" + dona.getPhone());
                donaPhone.setFont(Font.font("Verdana", 20));
                donaPhone.setPadding(new Insets(20, 20, 20, 20));
                routeGrid.addRow(i +1, donaID, donaAddress, donaPhone);
            }
            for (int i = 0; i < 3; i++) {
                    ColumnConstraints cc = new ColumnConstraints();
                    cc.setPercentWidth(100);
                    cc.setHalignment(HPos.CENTER);
                    routeGrid.getColumnConstraints().add(cc);

            }
            Scene secondScene = new Scene(routeBorder, 1400, 800);
            Stage secondStage = new Stage();
            secondStage.setTitle("Second Stage");
            secondStage.setScene(secondScene);

            secondStage.show();

                }

        }

    }
        
        //hover effect for the update button
        private class updateMouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            update.setStyle("-fx-cursor: hand; -fx-background-color: #0fc14d");
            }
        }
        private class exitMouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               update.setStyle("-fx-background-color: LightGreen");
            }
        }
        
        //hover effect for truck1 button
        private class truck1MouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            truck1.setStyle("-fx-cursor: hand; -fx-background-color: #6495ed");
            }
        }
        private class truck1MouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               truck1.setStyle("-fx-background-color: LightBlue");
            }
        }
        
        //hover effect for truck 2
        private class truck2MouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            truck2.setStyle("-fx-cursor: hand; -fx-background-color: #6495ed");
            }
        }
        private class truck2MouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               truck2.setStyle("-fx-background-color: LightBlue");
            }
        }
        
    public SchedulerView() {

        Tab tab = new Tab();
        store = MainInterface.getStore();
        donations = store.getDonations();
        
        update = new Button("Opdater");
        update.setOnMouseEntered(new updateMouseEnteredHandler());
        update.setOnMouseExited(new exitMouseExitHandler());
        update.setPadding(new Insets(10, 10, 10, 10));
        update.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
        
        calendarView = new GridPane();
        calendarView.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        
        truck1 = new Button("Lastbil 1");
        truck1.setPadding(new Insets(10, 10, 10, 10));
        truck1.setCursor(Cursor.HAND);
        truck1.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
        truck1.setOnMouseEntered(new truck1MouseEnteredHandler());
        truck1.setOnMouseExited(new truck1MouseExitHandler());
        
        truck2 = new Button("Lastbil 2");
        truck2.setCursor(Cursor.HAND);
        truck2.setPadding(new Insets(10, 10, 10, 10));
        truck2.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
        truck2.setOnMouseEntered(new truck2MouseEnteredHandler());
        truck2.setOnMouseExited(new truck2MouseExitHandler());
        
        hBox.getChildren().addAll(truck1, truck2, update);
        BorderPane borderPane = new BorderPane();
        tab.setContent(borderPane);

        borderPane.setCenter(calendarView);
        borderPane.setBottom(hBox);

        //Layout for hBox 
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        
        update.setPrefWidth(100);
        update.setPrefHeight(50);
        update.setStyle("-fx-background-color: LightGreen");
        update.setAlignment(Pos.CENTER);
        update.setOnAction(new updateHandler());

        truck1.setPrefWidth(100);
        truck1.setPrefHeight(50);
        truck1.setStyle("-fx-background-color: LightBlue");
        truck1.setAlignment(Pos.CENTER);
        truck1.setOnAction(new truck1Handler());

        truck2.setPrefWidth(100);
        truck2.setPrefHeight(50);
        truck2.setStyle("-fx-background-color: LightBlue");
        truck2.setAlignment(Pos.CENTER);
        truck2.setOnAction(new truck2Handler());

        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.minusDays(today.getDayOfWeek().getValue() - 1);
        LocalDate endOfWeek = startOfWeek.plusDays(6);

        for (LocalDate date = startOfWeek; !date.isAfter(endOfWeek); date = date.plusDays(1)) {
            int slotIndex = 1;
            for (int i = 0; i < donations.size(); i++) {
                donation = donations.get(i);
                
                Date d = donation.getDate();
                LocalDate ld = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                
                if (ld.equals(date) && donation.getStatus() == 2) {
                    ToggleButton donabutton = new ToggleButton("Donation ID:" + donation.getId());
                    donabutton.setFont(Font.font("System Regular", FontWeight.NORMAL, 15));
                    donabutton.setOnAction(new toggledonationHandler());

                    calendarView.add(donabutton, date.getDayOfWeek().getValue(), slotIndex);
                    slotIndex++;
                }

            }
        }

        //Populating the column with days of the week
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("E\nMMM d");

        for (LocalDate date = startOfWeek; !date.isAfter(endOfWeek); date = date.plusDays(1)) {
            Label label = new Label(date.format(dayFormatter));
            label.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
            label.setPadding(new Insets(1));
            label.setTextAlignment(TextAlignment.CENTER);
            GridPane.setHalignment(label, HPos.CENTER);
            calendarView.add(label, date.getDayOfWeek().getValue(), 0);
        }

        //Populating the row with timeslots
        int slotIndex = 1;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
        for (LocalDateTime startTime = today.atTime(firstSlotStart);
                !startTime.isAfter(today.atTime(lastSlotStart));
                startTime = startTime.plus(slotLength)) {
            Label label = new Label(startTime.format(timeFormatter));
            label.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
            label.setPadding(new Insets(2));
            GridPane.setHalignment(label, HPos.CENTER);
            calendarView.add(label, 0, slotIndex);
            slotIndex++;

        }
        //Adding constraints to the grid
        int numRows = 9;
        int numColumns = 8;
        for (int row = 0; row < numRows; row++) {
            RowConstraints rc = new RowConstraints(40);
            rc.setPercentHeight(80);
            rc.setValignment(VPos.CENTER);
            calendarView.getRowConstraints().add(rc);
        }
        for (int col = 0; col < numColumns; col++) {
            ColumnConstraints cc = new ColumnConstraints(40);
            cc.setPercentWidth(80);
            cc.setHalignment(HPos.CENTER);
            calendarView.getColumnConstraints().add(cc);
        }
        setContent(borderPane);
        
 
        
        
    }
    

}
