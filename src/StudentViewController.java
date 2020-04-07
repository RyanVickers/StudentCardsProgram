import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.Period;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {


    @FXML
    private Label fNameLabel;

    @FXML
    private Label fNameText;

    @FXML
    private Label lNameLabel;

    @FXML
    private Label lNameText;

    @FXML
    private Label studentNumberLabel;

    @FXML
    private Label studentNumberText;

    @FXML
    private Label birthdayLabel;

    @FXML
    private Label birthday;

    @FXML
    private TextArea activityTextArea;
    @FXML
    private ListView<?> studentListView;

    @FXML
    private ImageView studentImage;
    private Student selectedStudent;
    private ArrayList<Student> studentList = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

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
        studentImage.setImage(selectedStudent.getImage());
        birthday.setText(selectedStudent.getBirthday() + " Age: " + selectedStudent.getAge());
        studentList.add(selectedStudent);
    }

    public void createStudentPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("NewView.fxml"));
        Parent ViewParent = loader.load();
        Scene ViewScene = new Scene(ViewParent);

        //Getting the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(ViewScene);
        window.show();
    }
}




