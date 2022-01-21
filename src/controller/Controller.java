package controller;


import Model.MySQLConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;


import java.sql.ResultSet;
import java.sql.SQLException;



import java.io.IOException;
import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

    @FXML
    public Label loginlabel;

    @FXML
    private TextField User;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnlogin;

    @FXML
    private PasswordField password;

    @FXML
    private Button btnregister;


    @FXML
    private PasswordField Userpassword;



    @FXML
    private ImageView icon;

    private
    MySQLConnection connection;



    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        connection = new MySQLConnection();

    }




    @FXML
    public void UserRegister(javafx.event.ActionEvent register) throws Exception {
        if(register.getSource()==btnregister) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Register.fxml"));
            Parent root = loader.load();
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.initModality(Modality.WINDOW_MODAL);
            primaryStage.show();
        }
    }

    public void join(javafx.event.ActionEvent actionEvent) throws IOException {
       if(User.getText().isBlank() == false&& Userpassword.getText().isBlank() ==false ) {
           try {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Segundo.fxml"));
               Parent root = loader.load();
               Scene scene = new Scene(root);
               Stage stage = new Stage();
               stage.initModality(Modality.WINDOW_MODAL);
               stage.setScene(scene);
               stage.show();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
           else{
           loginlabel.setText("Mete um login ai rapa !");

       }

    }


    public void sair(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnSair.getScene().getWindow();
        stage.close();
    }

    public void UserName(javafx.event.ActionEvent actionEvent) {

    }


    @FXML
    void Userpassword(javafx.event.ActionEvent password) {

    }
    public void Validardata()
    {
        MySQLConnection connectNow = new MySQLConnection();
        String verificarogin = "SELECT UserName FROM users;"+ User.getText() + "SELECT Password FROM users;"+ Userpassword.getText();
        try{
            Statement statement= MySQLConnection.querySELECT();
        }
    }


}