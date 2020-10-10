package sample;

import Administrators.Admin;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Pane pane1,pane2,pane3,pane4;
    @FXML
    private JFXPasswordField passWord = null;
    @FXML
    private JFXTextField userName ;

    @FXML
    private Pane cantSignIn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane1.setStyle("-fx-background-image: url(\"/Pictures/seats2.jpg\")");
        pane2.setStyle("-fx-background-image: url(\"/Pictures/ethiopianAirlines.png\")");
        pane3.setStyle("-fx-background-image: url(\"/Pictures/plane3.png\")");
        pane4.setStyle("-fx-background-image: url(\"/Pictures/EthiopianHostesses.jpg\")");
     myAnimation();

    }
    public void signin(javafx.event.ActionEvent actionEvent){
        cantSignIn.setVisible(false);
        try{
            Admin admin = new Admin();
            if(admin.admin(userName.getText(),passWord.getText())){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../Administrators/adminPage.fxml"));
                AnchorPane pane = loader.load();
                Scene scene = new Scene(pane);
                Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();

            }else {
                cantSignIn.setVisible(true);


            }
        }catch (IOException e){

        }

    }

    public void myAnimation(){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(4), pane4);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        fadeTransition.setOnFinished(event -> {
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(4), pane3);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();
            fadeTransition1.setOnFinished(event1 -> {
                FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(4), pane2);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();
                fadeTransition2.setOnFinished(event2 -> {
                    FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(4), pane2);
                    fadeTransition.setFromValue(0);
                    fadeTransition3.setToValue(1);
                    fadeTransition3.play();
                    fadeTransition3.setOnFinished(event3 -> {
                        FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(4), pane3);
                        fadeTransition4.setFromValue(0);
                        fadeTransition4.setToValue(1);
                        fadeTransition4.play();
                        fadeTransition4.setOnFinished(event4 -> {
                            FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(4), pane4);
                            fadeTransition5.setFromValue(0);
                            fadeTransition5.setToValue(1);
                            fadeTransition5.play();
                            fadeTransition5.setOnFinished(event5 -> myAnimation());

                        });
                    });


                });

            });

        });

    }

}
