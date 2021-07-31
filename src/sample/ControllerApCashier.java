package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.jws.WebParam;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerApCashier implements Initializable {


    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;


    @FXML
    private TableView<ModelCashier> cashierTable;
    @FXML
    private TableColumn<ModelCashier, String> fName;
    @FXML
    private TableColumn<ModelCashier, String> lName;
    @FXML
    private TableColumn<ModelCashier, String> email;
    @FXML
    private TableColumn<ModelCashier, String> password;
    @FXML
    private TableColumn<ModelCashier, String> mobile;

    final ObservableList<ModelCashier> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pickData();
        System.out.println(" Successfull");
    }


    public void pickData() {



        conn = SQLiteJDBCDriverConnection.connect();

        fName.setCellValueFactory(new PropertyValueFactory<ModelCashier, String>("ffname"));
        lName.setCellValueFactory(new PropertyValueFactory<ModelCashier, String>("llname"));
        email.setCellValueFactory(new PropertyValueFactory<ModelCashier, String>("eemail"));
        password.setCellValueFactory(new PropertyValueFactory<ModelCashier, String>("ppassword"));
        mobile.setCellValueFactory(new PropertyValueFactory<ModelCashier, String>("mmobile"));

        try {
            String sql = "select * from cashier";
            //String query = "select Fname,Lname, Email,password,Mobile from Admin";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                data.add(new ModelCashier(
                        rs.getString("Fname"),
                        rs.getString("Lname"),
                        rs.getString("Email"),
                        rs.getString("Password"),
                        rs.getString("Mobile")
                ));
                cashierTable.setItems(data);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database retreive error: " + e);
        }
    }
}
