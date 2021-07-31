package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 * @author sqlitetutorial.net
 */
public class SQLiteJDBCDriverConnection {

    Connection conn = null;

    public static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\OSAMA\\Desktop\\javaPMSProject\\Database.db";
        //conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);
            System.out.println("successful");
            return conn;
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }

    }


  //  Insert data into DataBase
    public void insert(ModelAdmin modelAdmin) {

        String sql = "INSERT INTO Admin(Fname,Lname, Email,password,Mobile) VALUES(?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, modelAdmin.getFfname());
            pstmt.setString(2, modelAdmin.getLlname());
            pstmt.setString(3, modelAdmin.getEemail());
            pstmt.setString(4, modelAdmin.getPpassword());
            pstmt.setString(5, modelAdmin.getMmobile());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Retrieve Data From Database
//    public void selectAll(TableView<ModelAdmin> adminTable , ObservableList<ModelAdmin> data
//            , TableColumn<ModelAdmin ,String > fName ,
//            TableColumn<ModelAdmin ,String > lName,
//            TableColumn<ModelAdmin ,String > email,
//            TableColumn<ModelAdmin ,String > password,
//            TableColumn<ModelAdmin ,String > mobile) {
//
//
//        fName.setCellValueFactory(new PropertyValueFactory<ModelAdmin, String>("firstName"));
//        lName.setCellValueFactory(new PropertyValueFactory<ModelAdmin , String>("lastName"));
//        email.setCellValueFactory(new PropertyValueFactory<ModelAdmin , String>("email"));
//        password.setCellValueFactory(new PropertyValueFactory<ModelAdmin , String>("password"));
//        mobile.setCellValueFactory(new PropertyValueFactory<ModelAdmin , String>("mobile"));
//       // ObservableList<ModelAdmin> data = FXCollections.observableArrayList();
//
//        String sql = "SELECT Fname,Lname, Email,password,Mobile FROM Admin";
//
//        try (Connection conn = connect();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            // loop through the result set
//
//
//            while (rs.next()) {
//                data.add(new ModelAdmin(
//                        rs.getString("Fname"),
//                        rs.getString("Lname"),
//                        rs.getString("Email"),
//                        rs.getString("password"),
//                        rs.getString("Mobile")
//                ));
//                adminTable.setItems(data);
//
////                System.out.println(rs.getString("Fname") + "\t" +
////                        rs.getString("Lname") + "\t" +
////                        rs.getString("Email") + "\t" +
////                        rs.getString("password") + "\t" +
////                        rs.getString("Mobile") + "\t"
////                );
//            }
//
////            adminData.forEach((n) -> {
////
////                System.out.println(n);
////
////            });
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//      //  return adminTable;
//    }
}
