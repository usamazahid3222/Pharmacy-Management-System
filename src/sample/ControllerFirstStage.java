package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFirstStage {
    private Stage stage;

    public void start() {

        try {
            stage = Main.stage;
            Parent root = FXMLLoader.load(getClass().getResource("ViewFirstStage.fxml"));
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToAdmin() {
        ControllerAdmin controllerAdmin = new ControllerAdmin();
        controllerAdmin.start();
    }

    public void goToCashier() {
        ControllerCashier controllerCashier = new ControllerCashier();
        controllerCashier.start();
    }
}

