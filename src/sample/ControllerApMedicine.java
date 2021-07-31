package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;

public class ControllerApMedicine implements Initializable {

    ObservableList<ModelMedicine> data = FXCollections.observableArrayList();
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private AnchorPane medicinepane;
    @FXML
    private Tab viewmed;
    @FXML
    private Tab addmed;
    @FXML
    private TableView<ModelMedicine> medtable;
    @FXML
    private TableColumn<ModelMedicine, String> name;
    @FXML
    private TableColumn<ModelMedicine, Integer> stock;
    @FXML
    private TableColumn<ModelMedicine, Double> prprice;
    @FXML
    private TableColumn<ModelMedicine, Double> slprice;
    @FXML
    private TableColumn<ModelMedicine, Double> prpcs;
    @FXML
    private TableColumn<ModelMedicine, String> manufac;
    @FXML
    private TextField medicineNameTF;
    @FXML
    private TextField purchasePriceTF;
    @FXML
    private TextField manufacturerTF;
    @FXML
    private TextField pcsPriceTF;
    @FXML
    private TextField salePriceTF;
    @FXML
    private TextField stockTF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      conn =  SQLiteJDBCDriverConnection.connect();
       pickData();
        System.out.println(" Successfull");
    }

    public void pickData() {

      conn =  SQLiteJDBCDriverConnection.connect();

        name.setCellValueFactory(new PropertyValueFactory<ModelMedicine, String>("nname"));
        stock.setCellValueFactory(new PropertyValueFactory<ModelMedicine, Integer>("sstock"));
        prprice.setCellValueFactory(new PropertyValueFactory<ModelMedicine, Double>("purprice"));
        slprice.setCellValueFactory(new PropertyValueFactory<ModelMedicine, Double>("salprice"));
        prpcs.setCellValueFactory(new PropertyValueFactory<ModelMedicine, Double>("prpc"));
        manufac.setCellValueFactory(new PropertyValueFactory<ModelMedicine, String>("manu"));


        try {
            String query = "select * from medicine";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                data.add(new ModelMedicine(
                        rs.getString("Name"),
                        rs.getInt("Stock"),
                        rs.getDouble("Purchase Price"),
                        rs.getDouble("Sale Price"),
                        rs.getDouble("P/Pcs"),
                        rs.getString("Manufacturer")

                ));
                medtable.setItems(data);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database retreive error: " + e);
        }


    }

    @FXML
    private void saveMedicine() {

        try {
            String query = "insert into medicine values(?,?,?,?,?,?)";
            pst = conn.prepareStatement(query);

            pst.setString(1, medicineNameTF.getText());
            pst.setString(2, stockTF.getText());
            pst.setString(3, purchasePriceTF.getText());
            pst.setString(4, salePriceTF.getText());
            pst.setString(5, pcsPriceTF.getText());
            pst.setString(6, manufacturerTF.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, " SuccessFully Added to Database");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!" + e);
        }
//
//
    }
}
