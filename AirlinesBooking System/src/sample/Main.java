package sample;

import com.AirlinesLauncher.SystemLaunch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main extends Application{
    public static Socket client;
    Stage window;
    public String host = "127.0.0.1";
    public void MainWindow(){
        try {
            client = new Socket(host , 400);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(getClass().getResource("/CSS/starterPage.css").toExternalForm());
//            Controller controller = loader.getController();
            window.setTitle("Animation login");
            window.setScene(scene);
            window.show();
            SystemLaunch launch = new SystemLaunch();
            launch.starter();

        }catch (Exception e){
            System.out.println("Err: " + e);
        }


}
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.window = primaryStage;
        MainWindow();

    }
}
