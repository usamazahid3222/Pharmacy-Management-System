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
import javafx.scene.text.Text;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.scene.control.Label;

import javax.swing.*;


public class ControllerAdminDashBoard implements Initializable {

    private Stage stage;
    Connection conn = null;

    ResultSet rs = null;
    PreparedStatement pst = null;


   @FXML private AnchorPane apDashboard;
   @FXML private Label adminText;
   @FXML private Label cashierText;
   @FXML private Label totalMedicineText;

   @FXML
   private TableView <ModelMedicine> medicineAdmin;
    ObservableList<ModelMedicine> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<ModelMedicine, String> name1;
    @FXML
    private TableColumn<ModelMedicine, Integer> stock1;
    @FXML
    private TableColumn<ModelMedicine, Double> purchasePrice;
    @FXML
    private TableColumn<ModelMedicine, Double> salePrice;
    @FXML
    private TableColumn<ModelMedicine, Double> pricePcs;
    @FXML
    private TableColumn<ModelMedicine, String> Manufac;







    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn =  SQLiteJDBCDriverConnection.connect();
       pickData();
        System.out.println(" Successfull");
        countAdmin();
        countCashier();
        countMedicine();
    }

    public void start() {

        try {

            stage = Main.stage;
            Parent root = FXMLLoader.load(getClass().getResource("ViewAdminDashBoard.fxml"));
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToFirstStage() {
        ControllerFirstStage controllerFirstStage = new ControllerFirstStage();
        controllerFirstStage.start();
    }

    public void goToCashier() throws IOException{

        apDashboard.getChildren().clear();
        Parent root = FXMLLoader.load(getClass().getResource("ViewApCashier.fxml"));
        apDashboard.getChildren().setAll(root);

    }

    public void goToadmin() throws IOException{

        apDashboard.getChildren().clear();
        Parent root = FXMLLoader.load(getClass().getResource("ViewApAdmin.fxml"));
        apDashboard.getChildren().setAll(root);

//        SQLiteJDBCDriverConnection sqLiteJDBCDriverConnection= new SQLiteJDBCDriverConnection();
//        sqLiteJDBCDriverConnection.selectAll();

//        ControllerApAdmin controllerApAdmin = new ControllerApAdmin();
//        controllerApAdmin.pickData();

    }

    public void loadMedicineOnDashBoard(){


    }
    public void goToMedicine() throws IOException{

        apDashboard.getChildren().clear();
        Parent root = FXMLLoader.load(getClass().getResource("ViewApMedicine.fxml"));
        apDashboard.getChildren().setAll(root);

    }

    public void goToDashBoard() {
        start();
    }

    public void goToCreateAccount() {
        ControllerCreateAccount controllerCreateAccount = new ControllerCreateAccount();
        controllerCreateAccount.start();
    }

    @FXML
    private void countAdmin(){
        int adminCount=0;
        conn =  SQLiteJDBCDriverConnection.connect();
        String sql= "select Email from Admin";;

        try (
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
//                System.out.println(rs.getString("Fname") + "\t" +
//                        rs.getString("Lname") + "\t" +
//                        rs.getString("Email") + "\t" +
//                        rs.getString("password") + "\t" +
//                        rs.getString("Mobile") + "\t");
                        adminCount =adminCount +1;
            }
            String adminValue=String.valueOf(adminCount);
           adminText.setText(adminValue);
           // System.out.println("nepaali"+adminCount);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//

    }

    @FXML
    private void countCashier(){
        int adminCount=0;
        conn =  SQLiteJDBCDriverConnection.connect();
        String sql= "select  Email  from cashier";;

        try (
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                adminCount =adminCount +1;
            }
            String adminValue=String.valueOf(adminCount);
            cashierText.setText(adminValue);
            // System.out.println("nepaali"+adminCount);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//

    }

    @FXML
    private void countMedicine(){
        int adminCount=0;
        conn =  SQLiteJDBCDriverConnection.connect();
        String sql= "select Name from medicine";

        try (
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                adminCount =adminCount +1;
            }
            String adminValue=String.valueOf(adminCount);
            totalMedicineText.setText(adminValue);
            // System.out.println("nepaali"+adminCount);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//

    }
    @FXML
    private void pickData(){
        name1.setCellValueFactory(new PropertyValueFactory<ModelMedicine, String>("nname"));
        stock1.setCellValueFactory(new PropertyValueFactory<ModelMedicine, Integer>("sstock"));
        purchasePrice.setCellValueFactory(new PropertyValueFactory<ModelMedicine, Double>("purprice"));
        salePrice.setCellValueFactory(new PropertyValueFactory<ModelMedicine, Double>("salprice"));
        pricePcs.setCellValueFactory(new PropertyValueFactory<ModelMedicine, Double>("prpc"));
        Manufac.setCellValueFactory(new PropertyValueFactory<ModelMedicine, String>("manu"));


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
                medicineAdmin.setItems(data);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database retreive error: " + e);
        }

    }





}
