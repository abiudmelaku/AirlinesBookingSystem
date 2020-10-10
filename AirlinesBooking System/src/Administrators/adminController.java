package Administrators;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class adminController implements Initializable {
    @FXML
    private JFXButton adminSignOut;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
    public void adminSignOut(javafx.event.ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../sample/sample.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }catch (IOException e){

        }

    }

}
