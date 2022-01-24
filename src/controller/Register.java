package controller;

import Model.MySQLConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {

    @FXML
    private TextField email;

    @FXML
    private Button btnRegister;

    @FXML
    private TextField user;

    @FXML
    private PasswordField pass1;

    @FXML
    private PasswordField pass2;


    @FXML
    private Label passLable;


    @FXML
    void Mail(ActionEvent event) {

    }

    @FXML
    void Register(ActionEvent event) {
        if (pass1.getText().equals(pass2.getText()))
        {
            registerUser();
            passLable.setText("");
        }else {
            passLable.setText("Passwords não combinam.");
        }

    }

    @FXML
    void UserName(ActionEvent event) {

    }

    @FXML
    void password(ActionEvent event) {

    }

    @FXML
    void confirmPassword(ActionEvent event) {

    }

    public void registerUser()
    {
        MySQLConnection connectNow= new MySQLConnection();
        Connection connection = connectNow.setConnection();

        String User= user.getText();
        String Email= email.getText();
        String Password=pass1.getText();

        String insertField="INSERT INTO users  (UserName, Email , Password) VALUE('";
        String insertValue=User+"','" + Email+"','" + Password+"')";
        String insertToRegister= insertField +  insertValue;
        try {
            Statement statement =connection.createStatement();
            statement.executeUpdate(insertToRegister);
            passLable.setText("Utilizador registado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
