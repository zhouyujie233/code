import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(new Pane(), 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}