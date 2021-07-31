package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerCashier implements Initializable {
    private Stage stage;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    //@FXML private Button signIn;
    @FXML
    private TextField emailTF;
    @FXML
    private PasswordField passwordPF;

    public void initialize(URL url, ResourceBundle rb) {
        conn = SQLiteJDBCDriverConnection.connect();
    }

    public void start() {

        try {
            stage = Main.stage;
            Parent root = FXMLLoader.load(getClass().getResource("ViewCashier.fxml"));
            stage.setScene(new Scene(root));
//            stage.close();
//            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToFirstStage() {
        ControllerFirstStage controllerFirstStage = new ControllerFirstStage();
        controllerFirstStage.start();
    }

    public void goToCashierDashboard() {
        ControllerCashierDashboard controllerCashierDashboard = new ControllerCashierDashboard();
        controllerCashierDashboard.start();
    }


    public void cashierSignIn() {

        String user, pass;
        boolean check = false;
        String query = "select * from Admin";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                user = rs.getString("Email");
                pass = rs.getString("Password");


                if ((emailTF.getText()).equals(user) && (passwordPF.getText().equals(pass))) {
                    check = true;
                    goToCashierDashboard();
                }


            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        }

        if (check == false) {
            JOptionPane.showMessageDialog(null, " Incorrect Password or Email ");
        }

//        String savedData;
//
//        String path = new String("CashierEmailAndPassword.txt");
//
//        File file = new File(path);
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            BufferedReader bReader = new BufferedReader(new InputStreamReader(fis));
//            while((savedData=bReader.readLine())!=null) {
//                if(emailTF.getText().equalsIgnoreCase(savedData)) {
//                    savedData=bReader.readLine();
//                    if (passwordPF.getText().equals(savedData)){
//                        goToCashierDashboard();
//                    }
//                    else {
//                        System.out.println("Email or Password in incorrect!");
//                    }
//                }
//            }
//        } catch (FileNotFoundException fnfe) {
//            System.out.println("File " + file.getAbsolutePath() + " not found");
//        } catch (IOException ie) {
//            System.out.println("Exception Caught : " + ie);
//        }
//    }
    }
}