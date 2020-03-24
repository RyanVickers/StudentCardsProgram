import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    /**
     * This method creates a scene and sets the title to student card
     */
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("NewView.fxml"));
        primaryStage.setTitle("Student Card");
        primaryStage.setScene(new Scene(root, 375, 500));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
