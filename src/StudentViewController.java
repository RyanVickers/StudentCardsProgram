import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.time.Period;
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
    @FXML
    private TextArea activityTextArea;
    @FXML
    private Label birthday;
    private Student selectedStudent;

    /**
     * Method initializes student data
     *
     * @param student
     */
    public void initData(Student student) {
        selectedStudent = student;
        fNameText.setText(selectedStudent.getFirstName());
        lNameText.setText(selectedStudent.getLastName());
        studentNumberText.setText(Integer.toString(selectedStudent.getStudentNumber()));
        activityTextArea.setText(student.getActivityList());
        studentImage.setImage(student.getImage());
        birthday.setText(selectedStudent.getBirthday() +" Age: "+ selectedStudent.getAge());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


