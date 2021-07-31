package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerAdmin implements Initializable {

    private Stage stage;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst= null;

    @FXML private TextField emailTF;
    @FXML private PasswordField passwordPF;
   // @FXML private Button signInButton;

    public void initialize(URL url, ResourceBundle rb) {
        conn = SQLiteJDBCDriverConnection.connect();
    }

    // Function For Access To The Admin Panel
    public void start() {

        try {
            stage = Main.stage;
            Parent root = FXMLLoader.load(getClass().getResource("ViewAdmin.fxml"));
            stage.setScene(new Scene(root));
//            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function For . Go To start of The program
    public void goToFirstStage() {
        ControllerFirstStage controllerFirstStage = new ControllerFirstStage();
        controllerFirstStage.start();
    }

    public void goToAdminDashBoard() {
        ControllerAdminDashBoard controllerAdminDashBoard = new ControllerAdminDashBoard();
      //  controllerAdminDashBoard.countAdmin();
        controllerAdminDashBoard.start();
    }

    public void adminSignIn(){

        String user , pass;
            boolean check = false;
            String query = "select * from Admin";
            try{
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
                while(rs.next()){
                    user=rs.getString("Email");
                    pass=rs.getString("password");



                    if((emailTF.getText()).equals(user) && (passwordPF.getText().equals(pass))){
                        check= true;
                      goToAdminDashBoard();
                    }



                }
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,"error" +e);
            }

        if(check ==false){
                JOptionPane.showMessageDialog(null," Incorrect Password or Email ");
            }


//        String savedData;
//        int index=0;
//
//        String path = new String("AdminEmailAndPassword.txt");
//
//        File file = new File(path);
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            BufferedReader bReader = new BufferedReader(new InputStreamReader(fis));
//            while((savedData=bReader.readLine())!=null) {
//                if(emailTF.getText().equalsIgnoreCase(savedData)) {
//                    savedData=bReader.readLine();
//                    if (passwordPF.getText().equals(savedData)){
//                        goToAdminDashBoard();
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
//
  }

/*    public void goToTwo() {
        ControllerTwo controllerTwo = new ControllerTwo();
        controllerTwo.start();
    }*/
}
