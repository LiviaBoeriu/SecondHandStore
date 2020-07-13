import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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

public class ViewLogin extends BorderPane {
    
    public final TextField userTextField;
    public final PasswordField pwBox;
    public Button loginButton;
    public Button backButton;
    public Label incorrectPass;
    public Label incorrectUser;
    public Label incorrectUserAndPass;
    
    //hover effect for buttons
        //handler for the hovering on the login button
        private class enterMouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            loginButton.setStyle("-fx-cursor: hand; -fx-background-color: #6495ed;");
            }
        }
        private class exitMouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               loginButton.setStyle("-fx-background-color: LightBlue;");
            }
        }
        
        //handler for the hovering on the back button
        private class enterBackMouseEnteredHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) { 
            backButton.setStyle("-fx-cursor: hand; -fx-background-color: #6495ed;");
            }
        }
        private class exitBackMouseExitHandler implements EventHandler<MouseEvent> {

            @Override
            public void handle(MouseEvent event) {
               backButton.setStyle("-fx-background-color: LightBlue;");
            }
        }
        
        
    private class BackButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            Stage window = MainInterface.getStage();
            Scene firstScene = MainInterface.getFrontPageScene();
            window.setScene(firstScene);
        }
    }
    
    private class LoginButtonHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
            if(incorrectUser.isVisible() || incorrectPass.isVisible() || incorrectUserAndPass.isVisible()) {
               incorrectUser.setVisible(false);   
               incorrectPass.setVisible(false);
               incorrectUserAndPass.setVisible(false);
            }
            if ((userTextField.getText()).equals("leder")&& (pwBox.getText()).equals("12345")) {
                Scene adminScene = MainInterface.getAdminScene();
                Stage window = MainInterface.getStage();
                window.setScene(adminScene);
            }
            else if ((userTextField.getText()).equals("leder") && !(pwBox.getText()).equals("12345")) {
                System.out.println("Din adgangskode er forkert");
                incorrectPass.setVisible(true);
            }
            else if (!(userTextField.getText()).equals("leder") && (pwBox.getText()).equals("12345")) {
                System.out.println("Dit brugernavn er forkert");
                incorrectUser.setVisible(true);
            }
            else {
                System.out.println("Brugernavn og adgangskode er forkert");
                incorrectUserAndPass.setVisible(true);
            }
        }
     }

    public ViewLogin() {
        BorderPane viewLogin = new BorderPane();
        GridPane viewGrid = new GridPane();
        viewLogin.setCenter(viewGrid);
        viewGrid.setAlignment(Pos.CENTER);
        viewGrid.setHgap(10);
        viewGrid.setVgap(10);
        viewGrid.setPadding(new Insets(25, 25, 25, 25));
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(Priority.NEVER);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.NEVER);
        viewGrid.getColumnConstraints().addAll(column1, column2);

        Label userNameLabel = new Label("Brugernavn:");
        viewGrid.add(userNameLabel, 0, 1);
        
        userTextField = new TextField();
        userTextField.setTooltip(new Tooltip("Skriv dit brugernavn"));
        viewGrid.add(userTextField, 1, 1);
        userTextField.setPrefSize(10, 10);
        userTextField.setPromptText("Indtast dit brugernavn her");
                
        Label passwordLabel = new Label("Adgangskode:");
        viewGrid.add(passwordLabel, 0, 2);

        pwBox = new PasswordField();
        pwBox.setTooltip(new Tooltip("Skriv din adgangskode"));
        viewGrid.add(pwBox, 1, 2);
        pwBox.setPromptText("Indtast dit kodeord her");

        loginButton = new Button("Login");
        loginButton.setTooltip(new Tooltip("Gå til næste side"));
        
        backButton = new Button("Tilbage");
        backButton.setTooltip(new Tooltip("Gå tilbage til den forrige side"));
        
        incorrectPass = new Label("Din adgangskode er forkert");
        incorrectPass.setVisible(false);
        incorrectUser = new Label("Dit brugernavn er forkert");
        incorrectUser.setVisible(false);
        incorrectUserAndPass = new Label("Dit brugernavn" + System.lineSeparator() + "eller din adgangskode er forkert");
        incorrectUserAndPass.setVisible(false);
        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(backButton,loginButton);
        viewGrid.add(hbBtn, 1, 4);
        
        StackPane textInfo = new StackPane();
        textInfo.setAlignment(Pos.CENTER);
        textInfo.getChildren().addAll(incorrectPass, incorrectUser, incorrectUserAndPass);
        viewGrid.add(textInfo, 1, 5);

        viewLogin.setCenter(viewGrid);
        
        loginButton.setStyle("-fx-background-color: LightBlue");
        loginButton.setOnAction(new LoginButtonHandler()); 
        loginButton.setOnMouseEntered(new enterMouseEnteredHandler());
        loginButton.setOnMouseExited(new exitMouseExitHandler());
        backButton.setStyle("-fx-background-color: LightBlue");
        backButton.setOnAction(new BackButtonHandler());
        backButton.setOnMouseEntered(new enterBackMouseEnteredHandler());
        backButton.setOnMouseExited(new exitBackMouseExitHandler());
        
        setCenter(viewLogin); 
        loginButton.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
        backButton.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
        userNameLabel.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
        passwordLabel.setFont(Font.font("System Regular",FontWeight.NORMAL, 15));
    }
    
    public Button getLoginButton() {
        return this.loginButton;
    }
}




