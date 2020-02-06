import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    @FXML
    private Label fNameText;
    @FXML
    private Label lNameText;
    @FXML
    private Label studentNumberText;
    @FXML
    private ImageView studentImage;
    private Student game;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = new Student("Ryan", "Vickers", 11111810,"cool");
        studentImage.setImage(game.getImage());
    fNameText.setText(game.getFirstName());
    lNameText.setText(game.getLastName());
studentNumberText.setText(String.valueOf(game.getStudentNumber()));
    }
}
