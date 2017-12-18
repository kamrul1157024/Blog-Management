package root_pacakge;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       // Process p = Runtime.getRuntime().exec(new String[]{"bash","b.sh"});

        Root mainroot=new Root();
        if (mainroot.allLoaded) {
            //AquaFx.style();

            Parent root = FXMLLoader.load(Main.class.getResource("Main.fxml"));
            primaryStage.setTitle("Blog Manager");
            Scene scene=new Scene(root);
            scene.getStylesheets().add(getClass().getResource("bootstrap.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
            primaryStage.setResizable(false);
            primaryStage.setOnCloseRequest(windowEvent -> System.exit(1));
            primaryStage.show();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
