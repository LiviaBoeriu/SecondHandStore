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
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DonationOverviewView extends Tab {

    private Tab tab;
    private GridPane calendarView;
    private Store store;
    private Donation donation;
    private Stage secondStage;
    private Button donabutton;
    private final LocalTime firstSlotStart = LocalTime.of(8, 00);
    private final Duration slotLength = Duration.ofHours(1);
    private final LocalTime lastSlotStart = LocalTime.of(15, 00);
    ArrayList<Donation> donations;
    ArrayList<Donation>confirmeddonations = new ArrayList();
    Button deny;
    Button confirm;
            
        
        
    private class confirmHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent a){
            
            donation.setConfirmed();
            secondStage.close();
            confirmeddonations.add(donation);


        }
    }
    private class denyHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent a){
            donation.setDenied();
            secondStage.close();


        }
    }
    
    //Handler for popup - creting a new stage and putting information
    //and two buttons inside it
    private class donaHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent a) {
            Button x = (Button) a.getSource();
            for (int i = 0; i < donations.size(); i++) {
                
                if(x.getText().equals("Donation ID:" + donations.get(i).getId())){
                    donation = donations.get(i);
                }
                
                    
                
                    
                
            }
            Date getdate = donation.getDate();
            LocalDate ld = getdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            ArrayList<Furniture> items = donation.getItems();
            Label date = new Label("  Afhentnigs dato: " + ld);
            date.setFont(Font.font("Verdana", 14));
            date.setPadding(new Insets(5, 5, 5, 0));
            Label phone = new Label("  Telefonnummer: " + donation.getPhone());
            phone.setFont(Font.font("Verdana", 14));
            phone.setPadding(new Insets(5, 5, 5, 0));
            Label address = new Label("  Adresse: " + donation.getAddress());
            address.setFont(Font.font("Verdana", 14));
            address.setPadding(new Insets(5, 5, 5, 0));
            Label donacontent = new Label("  Hele listen af møbler: ");
            donacontent.setFont(Font.font("Verdana", 18));
            donacontent.setPadding(new Insets(15, 15, 15, 0));
            deny = new Button("Afslå");
            deny.setOnAction(new denyHandler());
            deny.setOnMouseEntered(new enterMouseEnteredHandler());
            deny.setOnMouseExited(new exitMouseExitHandler ());
            deny.setPrefSize(200, 40);
            deny.setStyle("-fx-background-color: Red; -fx-text-fill: White");
            confirm = new Button("Bekræft");
            confirm.setOnAction(new confirmHandler());
            confirm.setPrefSize(200, 40);
            confirm.setStyle("-fx-background-color: Green; -fx-text-fill: White");
            confirm.setOnMouseEntered(new enterConfirmMouseEnteredHandler());
            confirm.setOnMouseExited(new exitConfirmMouseExitHandler());
            HBox botbox = new HBox();
            botbox.setAlignment(Pos.CENTER);
            botbox.getChildren().addAll(deny, confirm);
            
            Label id = new Label("  Donation ID: " + donation.getId());
            id.setFont(Font.font("Verdana", 20));
            id.setPadding(new Insets(10, 10, 10, 0));
            GridPane popupGrid = new GridPane();
            GridPane itemsGrid = new GridPane();
            itemsGrid.setStyle("--fx-grid-lines-visible: true;");
            popupGrid.add(address, 0, 0);
            popupGrid.add(phone, 0, 1);
            popupGrid.add(date, 0, 2);
            popupGrid.add(donacontent, 0, 3);
            popupGrid.add(itemsGrid, 0, 4);
            ColumnConstraints ccPopup = new ColumnConstraints();
            ccPopup.setPercentWidth(100);
            popupGrid.getColumnConstraints().add(ccPopup);
            

            for (int i = 0; i < items.size(); i++) {
                Furniture currentItem = items.get(i);

                Label itemCategory = new Label("  " + currentItem.getCategory());
                itemCategory.setFont(Font.font("Verdana", 14));
                Label itemCondition = new Label(currentItem.getCondition());
                itemCondition.setFont(Font.font("Verdana", 14));
                Label itemBrand = new Label(currentItem.getBrand());
                itemBrand.setFont(Font.font("Verdana", 14));
                itemsGrid.addRow(i + 1, itemCategory, itemCondition, itemBrand);
            }
                for (int i = 0; i < 3; i++) {
                    ColumnConstraints cc = new ColumnConstraints();
                    cc.setPercentWidth(100);
                    cc.setHalignment(HPos.LEFT);
                    itemsGrid.getColumnConstraints().add(cc);

                }
                
                           
            BorderPane popupBorder = new BorderPane();

            popupBorder.setTop(id);
            popupBorder.setCenter(popupGrid);
            popupBorder.setBottom(botbox);

            Scene secondScene = new Scene(popupBorder, 400, 400);

            secondStage = new Stage();
            secondStage.setTitle("Second Stage");
            secondStage.setScene(secondScene);

            secondStage.show();
        }

    }
        
        //handler for the hovering on the deny button
        private class enterMouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            deny.setStyle("-fx-cursor: hand; -fx-background-color: #b20000; -fx-text-fill: white");
            }
        }
        private class exitMouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               deny.setStyle("-fx-background-color: red; -fx-text-fill: white");
            }
        }
        
        //hover for the confirm button
        private class enterConfirmMouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            confirm.setStyle("-fx-cursor: hand; -fx-background-color: #37a30d; -fx-text-fill: white");
            }
        }
        private class exitConfirmMouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               confirm.setStyle("-fx-background-color: green; -fx-text-fill: white");
            }
        }

    public DonationOverviewView() {

        store = MainInterface.getStore();
        donations = store.getDonations();
        HBox hBox = new HBox();
        BorderPane borderPane = new BorderPane();     
        tab = new Tab();
        calendarView = new GridPane();
        tab.setContent(borderPane);
        

        borderPane.setCenter(calendarView);
        borderPane.setBottom(hBox);
        tab.setContent(calendarView);
        calendarView.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");

        //Layout for hBox 
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);

        // Making layout for hBoxbottom
        hBox.setMaxHeight(50);
        hBox.setPrefHeight(70);
        hBox.setFillHeight(false);

        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.minusDays(today.getDayOfWeek().getValue() - 1);
        LocalDate endOfWeek = startOfWeek.plusDays(6);

        for (LocalDate date = startOfWeek; !date.isAfter(endOfWeek); date = date.plusDays(1)) {
            int slotIndex = 1;
            for (int i = 0; i < donations.size(); i++) {
                donation = donations.get(i);

                Date d = donation.getDate();
                LocalDate ld = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if (ld.equals(date) && donation.getStatus() == 1) {
                    donabutton = new Button("Donation ID:" + donation.getId());
                    donabutton.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
                    donabutton.setOnAction(new donaHandler());
                    donabutton.setCursor(Cursor.HAND);
                    donabutton.setTooltip(new Tooltip("Klik for at bekræfte eller afslå donation"));

                    calendarView.add(donabutton, date.getDayOfWeek().getValue(), slotIndex);
                    slotIndex++;
                    
                }

            }
            donation = null;
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
    /**
     * Method for getting the confirmed donations
     * @return confirmeddonation the array list with the confirmed donations
     */
    public ArrayList<Donation> getConfirmedDonations(){
        return confirmeddonations;
    }
}