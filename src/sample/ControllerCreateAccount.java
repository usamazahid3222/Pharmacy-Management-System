package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerCreateAccount implements Initializable {

    private Stage stage;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = SQLiteJDBCDriverConnection.connect();

    }


    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;
    @FXML
    private ChoiceBox<String> code;
    @FXML
    private TextField mobile;
    @FXML
    private Button createbtn1;
    @FXML
    private RadioButton adminacc;
    @FXML
    private RadioButton cashacc;
    @FXML
    private ToggleGroup AccountType;
    @FXML
    private Button bk;

    public void start() {

        try {
            stage = Main.stage;
            Parent root = FXMLLoader.load(getClass().getResource("ViewCreateAccount.fxml"));
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToAdminDashboard() {
        ControllerAdminDashBoard controllerAdminDashBoard = new ControllerAdminDashBoard();
        controllerAdminDashBoard.start();
    }

    @FXML
    private void countrycode() {

        code.getItems().add("+91");
        code.getItems().add("+92");
        code.getItems().add("+93");
        code.getItems().add("+94");
        code.getItems().add("+95");
        code.getItems().add("+96");
        code.getItems().add("+97");
        code.getItems().add("+98");
        code.getItems().add("+99");
        code.getItems().add("+90");

        //Set Default Valut
        code.setValue("+92");
    }

    @FXML
    private void createAccount() {


        if(!password.getText().equals(confirmPassword.getText())){
            JOptionPane.showMessageDialog(null,"Password does not match ");

        }

        else {
            if(AccountType.getSelectedToggle()==adminacc) {
                ModelAdmin modelAdmin = new ModelAdmin();
                modelAdmin.admindata(firstName.getText(), lastName.getText(), email.getText(), password.getText(), code.getValue()+mobile.getText());
                SQLiteJDBCDriverConnection sqLiteJDBCDriverConnection = new SQLiteJDBCDriverConnection();
                sqLiteJDBCDriverConnection.insert(modelAdmin);
                JOptionPane.showMessageDialog(null, " SuccessFully Added to Database");
                goToAdminDashboard();
            }
            else if(AccountType.getSelectedToggle()==cashacc){
                    try{
                        String query = "insert into cashier values(?,?,?,?,?)";
                        pst = conn.prepareStatement(query);

                        pst.setString(1,firstName.getText());
                        pst.setString(2,lastName.getText());
                        pst.setString(3,email.getText());
                        pst.setString(4,password.getText());
                        pst.setString(5,code.getValue()+mobile.getText());
                        pst.execute();
                        JOptionPane.showMessageDialog(null, " SuccessFully Added to Database");
                        goToAdminDashboard();
                    }
                    catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(null,"Error!"+e);
                    }
                }
        }



        /*try{
            String query = "insert into Admin values(?,?,?,?,?)";
            pst = conn.prepareStatement(query);

            pst.setString(1,firstName.getText());
            pst.setString(2,lastName.getText());
            pst.setString(3,email.getText());
            pst.setString(4,password.getText());
            pst.setString(5,mobile.getText());


            pst.execute();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error!"+e);
        }*/

    }
}
