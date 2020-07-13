import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * The class containing the admin view with a tabs structure (donation overview
 * and route plan) 
 * @author Martin
 */

public class AdminView extends BorderPane {
    
    //Defining the attributes needed to make the adminview
    private BorderPane border;
    private TabPane tabs;
    private DonationOverviewView overview;
    private SchedulerView scheduler;
    private Label label1;
    private Button help;
    private HBox hBoxTop;
    private HBox hBoxBottom;
    private Region region1;
    private Region region2;
    private Label label2;
    private Button logout;
    private VBox vBoxLeft;
    private VBox vBoxRight;
    
    //Class helphandler contains the event for the help button
    private class helpHandler implements EventHandler<ActionEvent>{
    
    @Override
    public void handle(ActionEvent event){
            BorderPane popoutHelp = new BorderPane();
            GridPane questions = new GridPane();
            Label firstQuestion = new Label(" 1. Hvordan bekræfter jeg en donation?");
            firstQuestion.setFont(Font.font("Verdana", 20));
            firstQuestion.setPadding(new Insets(10,0,10,0));
            Label firstAnswer = new Label(" For at bekræfte en ny donation skal du først \n finde den i kalenderen og trykke på den. \n Dette åbner en popup-menu, hvor du kan se \n donationens indhold. I bunden af popup-menuen \n er der to knapper, afslå og bekræft. \n Ved at trykke på bekræft, bekræftes donationen.");
            firstAnswer.setFont(Font.font("Verdana", 14));
            Label secondQuestion = new Label(" 2. Hvordan laver jeg en ruteplan?");
            secondQuestion.setPadding(new Insets(10,0,10,0));
            secondQuestion.setFont(Font.font("Verdana", 20));
            Label secondAnswer = new Label(" For at lave en ruteplan, skal du først have \n en eller flere bekræftede donationer (Se smpørgsmål 1). \n Hvis du har bekræftede donationer, kan du \n gå til Ruteplanlægger og se dem. Ved at trykke på donationerne, \n markerer du at du vil lave en ruteplan for dem, \n hvis dette ikke er tilfældet kan du trykke igen for at afmarkere. \n Når du har markereret donationer, kan du trykke på den lastbil, \n der skal afhente dem og dette laver en ruteplan.");
            secondAnswer.setFont(Font.font("Verdana", 14));
            questions.add(firstQuestion, 0, 0);
            questions.add(firstAnswer, 0, 1);
            questions.add(secondQuestion, 0, 2);
            questions.add(secondAnswer, 0, 3);
            
            //to add more here and stylize
            
            popoutHelp.setCenter(questions);

            Scene secondScene = new Scene(popoutHelp, 500, 500);

            Stage secondStage = new Stage();
            secondStage.setTitle("Help");
            secondStage.setScene(secondScene);

            secondStage.show();
    }
    
}
    
    //functionality for the logoutHandler
    private class logoutHandler implements EventHandler<ActionEvent>{
    
    @Override
    public void handle(ActionEvent event){
        Stage window = MainInterface.getStage();
        Scene loginScene = MainInterface.getLoginScene();
        window.setScene(loginScene);
    }  
}
    
        //hover effect for logout button
        private class logoutMouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            logout.setStyle("-fx-cursor: hand; -fx-background-color: #6495ed");
            }
        }
        private class logoutMouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               logout.setStyle("-fx-background-color: LightBlue");
            }
        }
        
        //hover effect for help button
        private class helpMouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            help.setStyle("-fx-cursor: hand; -fx-background-color: #6495ed");
            }
        }
        private class helpMouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               help.setStyle("-fx-background-color: LightBlue");
            }
        }
        
/**     
 * Creates a new constructor AdminView layout
 */
public AdminView(){
    //New instances of borderpane, tabpane, text and button to structure
    //the borderpane
    border = new BorderPane();
    tabs = new TabPane();
    hBoxTop = new HBox();
    hBoxBottom = new HBox();
    overview = new DonationOverviewView();
    overview.setText("Donationsoversigt");
    //@@@@@@@@@ The name scheduler might have to be changed 
    scheduler = new SchedulerView();
    scheduler.setText("Ruteplanlægger");
    label1 = new Label (" ");// creates an empty label to add in the right corner in HBox when using region
    label2 = new Label("Leder-adgang");
    help = new Button("Brug for hjælp?");
    logout = new Button("Log ud");
    region1 = new Region();
    region2 = new Region();
    vBoxLeft = new VBox();
    vBoxRight = new VBox();
    
    hBoxTop.getChildren().addAll(label1, label2, logout);
    hBoxBottom.getChildren().add(help);
    
    //Adding panels to the borderpane and setting alignments using region
    border.setTop(hBoxTop);
    border.setCenter(tabs);
    border.setBottom(hBoxBottom);
    border.setLeft(vBoxLeft);
    border.setRight(vBoxRight);
    
        HBox.setHgrow(region1, Priority.ALWAYS);
        HBox.setHgrow(region2, Priority.ALWAYS);
        
        HBox hBox = new HBox(label1, region1, label2, region2, logout);
    
    //Aligning help button in the hBoxBottom to the right
    hBoxBottom.setAlignment(Pos.CENTER_RIGHT);
    hBoxBottom.setPadding(new Insets(20, 50, 50, 50));
                
    // Making layout for hBoxTop
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(20, 50, 50, 50));
        hBox.setMaxHeight(70);
        hBox.setPrefHeight(70);
        hBox.setFillHeight(false);
        
    // Making layout for hBoxTop
        vBoxLeft.setAlignment(Pos.CENTER_LEFT);
        vBoxLeft.setMaxWidth(70);
        vBoxLeft.setPrefWidth(70);
        vBoxLeft.setFillWidth(false);
    
    // Making layout for hBoxTop
        vBoxRight.setAlignment(Pos.CENTER_RIGHT);
        vBoxRight.setMaxWidth(70);
        vBoxRight.setPrefWidth(70);
        vBoxRight.setFillWidth(false);
    
    // Makeing layout for label2 "Admin View"
        label2.setFont(Font.font ("Verdana",30));
        logout.setStyle("-fx-background-color: LightBlue");
        help.setStyle("-fx-background-color: LightBlue");
    
    //Setting an image for the help button
    Image questionMark = new Image(getClass().getResourceAsStream("/images/questionMark.png"));
    help.setGraphic(new ImageView(questionMark));
    
    //Couples the help and logout button to the eventlistener
    help.setOnAction(new helpHandler()); 
    help.setOnMouseEntered(new helpMouseEnteredHandler());
    help.setOnMouseExited(new helpMouseExitHandler());
    logout.setOnAction(new logoutHandler());
    logout.setOnMouseEntered(new logoutMouseEnteredHandler());
    logout.setOnMouseExited(new logoutMouseExitHandler());
    
    //Adding tabs to the tabpane
    tabs.getTabs().addAll(overview, scheduler);
        
    overview.setClosable(false);
    scheduler.setClosable(false);
    
    //Composing the layout
    setTop(hBox);
    setCenter(tabs);
    setBottom(hBoxBottom);
    setLeft(vBoxLeft);
    setRight(vBoxRight);
    
    //making the object bigger
    logout.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
    help.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));    
}




}
