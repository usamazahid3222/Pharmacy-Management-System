package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class ControllerCashierDashboard implements Initializable{

    private Stage stage;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML ScrollPane scrollPan;


    @FXML
    private Button startsale;
    @FXML
    private TableView<ModelMedicine> medicinetable;
    ObservableList<ModelMedicine> data = FXCollections.observableArrayList();
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
    private TableView<SaleData> saletable;
    ObservableList<SaleData> data1 = FXCollections.observableArrayList();
    @FXML
    private TableColumn<SaleData, String> name1;
    @FXML
    private TableColumn<SaleData, Double> prpcs1;
    @FXML
    private TableColumn<SaleData, String> quantity1;
    @FXML
    private TableColumn<SaleData, Double> total1;
    @FXML
    private TextField search;
    @FXML
    private TextField date;
    @FXML
    private TextField quantity;
    @FXML
    private TextField all;
    @FXML
    private Label all1;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn =  SQLiteJDBCDriverConnection.connect();
        pickData();
        System.out.println(" Successfull");
    }

    public void start() {

        try {
            stage = Main.stage;
            Parent root = FXMLLoader.load(getClass().getResource("ViewCashierDashboard.fxml"));
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToPrintBill(ActionEvent event) throws IOException {
        Stage window=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewPrintBill.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void goToMainStage(){
        ControllerFirstStage controllerFirstStage = new ControllerFirstStage();
        controllerFirstStage.start();
    }

    @FXML
    private void pickData(){
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
                medicinetable.setItems(data);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database retreive error: " + e);
        }

    }


    String medname;
    Double d = 0.0;
    Double d1 = 0.0;


    public void show() {

        name1.setCellValueFactory(new PropertyValueFactory<SaleData, String>("nname"));
        prpcs1.setCellValueFactory(new PropertyValueFactory<SaleData, Double>("prpc"));
        quantity1.setCellValueFactory(new PropertyValueFactory<SaleData, String>("quan"));
        total1.setCellValueFactory(new PropertyValueFactory<SaleData, Double>("total"));

        String query = "select * from medicine";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                medname = rs.getString("Name");

                if ((search.getText()).equals(medname)) {
                    String quantity1 = quantity.getText();
                    int quantity2 = Integer.parseInt(quantity1);
                    data1.add(new SaleData(
                            rs.getString("Name"),
                            rs.getDouble("P/Pcs"),
                            quantity.getText(),
                            d = d + (quantity2* (rs.getDouble("P/Pcs")))
                    ));
                    d1 = d + d1;
                    all.setText(d1.toString());
                    all1.setText(d1.toString());
                    d = 0.0;

                    saletable.setItems(data1);

                }
            }

            pst.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        }
    }


}
