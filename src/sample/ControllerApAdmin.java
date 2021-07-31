package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;



public class ControllerApAdmin implements Initializable {




    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;


//package sample;
//
//import javafx.beans.property.SimpleStringProperty;





    @FXML private TableView<ModelAdmin> adminTable ;
    @FXML private TableColumn<ModelAdmin ,String > fName ;
    @FXML private TableColumn<ModelAdmin ,String > lName;
    @FXML private TableColumn<ModelAdmin ,String > email;
    @FXML private TableColumn<ModelAdmin ,String > password;
    @FXML private TableColumn<ModelAdmin ,String > mobile;

   final ObservableList <ModelAdmin> data = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb){
    pickData();
    System.out.println(" Successfull");
    }


    public void pickData() {

//        SQLiteJDBCDriverConnection sqLiteJDBCDriverConnection = new SQLiteJDBCDriverConnection();
//        sqLiteJDBCDriverConnection.selectAll(adminTable,data,fName,lName,email,password,mobile);

        conn = SQLiteJDBCDriverConnection.connect();

        fName.setCellValueFactory(new PropertyValueFactory<ModelAdmin, String>("ffname"));
        lName.setCellValueFactory(new PropertyValueFactory<ModelAdmin, String>("llname"));
        email.setCellValueFactory(new PropertyValueFactory<ModelAdmin, String>("eemail"));
        password.setCellValueFactory(new PropertyValueFactory<ModelAdmin, String>("ppassword"));
        mobile.setCellValueFactory(new PropertyValueFactory<ModelAdmin, String>("mmobile"));

        try {
            String sql = "select * from Admin";
            //String query = "select Fname,Lname, Email,password,Mobile from Admin";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                data.add(new ModelAdmin(
                        rs.getString("Fname"),
                        rs.getString("Lname"),
                        rs.getString("Email"),
                        rs.getString("password"),
                        rs.getString("Mobile")
                ));
                adminTable.setItems(data);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database retreive error: " + e);
        }

//        fName.setCellValueFactory(new PropertyValueFactory<ModelAdmin, String>("firstName"));
//        lName.setCellValueFactory(new PropertyValueFactory<ModelAdmin , String>("lastName"));
//        email.setCellValueFactory(new PropertyValueFactory<ModelAdmin , String>("email"));
//        password.setCellValueFactory(new PropertyValueFactory<ModelAdmin , String>("password"));
//        mobile.setCellValueFactory(new PropertyValueFactory<ModelAdmin , String>("mobile"));

        //String sql = "select Fname,Lname,Email,password,Mobile from Admin";

   }

}
