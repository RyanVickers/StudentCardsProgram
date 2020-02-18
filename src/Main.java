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
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("Student Card");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        Student ryan = new Student("Ryan","vickers",1111810,"Video Games");
        System.out.println(ryan.toString());
    }
}
