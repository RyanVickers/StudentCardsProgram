import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.DatePicker;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

public class NewStudentViewController implements Initializable {

    @FXML
    private Label fNameLabel;

    @FXML
    private TextField fNameTextField;

    @FXML
    private Label lNameLabel;

    @FXML
    private TextField lNameTextField;

    @FXML
    private Label studentNumberLabel;

    @FXML
    private TextField studentNumberTextField;

    @FXML
    private Label interestLabel;

    @FXML
    private CheckBox videoGamesCheckBox;

    @FXML
    private CheckBox readingCheckBox;

    @FXML
    private CheckBox cookingCheckBox;

    @FXML
    private CheckBox codingCheckBox;

    @FXML
    private CheckBox runningCheckBox;

    @FXML
    private CheckBox musicCheckBox;

    @FXML
    private CheckBox hockeyCheckBox;

    @FXML
    private CheckBox moviesCheckBox;

    @FXML
    private CheckBox sleepingCheckBox;

    @FXML
    private CheckBox travelingCheckBox;

    @FXML
    private Label errorLabel;

    @FXML
    private Button submitButton;
    @FXML
    private Button viewStudentButton;
    @FXML
    private ImageView chooseImage;

    @FXML
    private Button imageButton;

    @FXML
    private Label birthday;

    @FXML
    private DatePicker datePicker;

    @FXML
    void getAge() {

    }

    private ArrayList<String> interestList = new ArrayList<>();
    private ArrayList<Student> StudentList = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chooseImage.setImage(new Image("images/defaultImage.jpg"));
        studentNumberTextField.setText(String.valueOf(Student.getNewStudentNumber()));


    }

    /**
     * Method adds each selected checkbox activity to an arraylist
     */
    public void activity() {
        interestList.clear();
        if (videoGamesCheckBox.isSelected()) {
            interestList.add("Video Games");
        }
        if (readingCheckBox.isSelected()) {
            interestList.add("Reading");
        }
        if (cookingCheckBox.isSelected()) {
            interestList.add("Cooking");
        }
        if (codingCheckBox.isSelected()) {
            interestList.add("Coding");
        }
        if (runningCheckBox.isSelected()) {
            interestList.add("Running");
        }
        if (musicCheckBox.isSelected()) {
            interestList.add("Music");
        }
        if (hockeyCheckBox.isSelected()) {
            interestList.add("Hockey");
        }
        if (moviesCheckBox.isSelected()) {
            interestList.add("Movies");
        }
        if (sleepingCheckBox.isSelected()) {
            interestList.add("Sleeping");
        }
        if (travelingCheckBox.isSelected()) {
            interestList.add("Traveling");
        }
    }

    /**
     * Method gets activity list and returns it as a string
     *
     * @return
     */
    public String getActivity() {
        activity();
        return interestList.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "\n");
    }

    /**
     * Method displays student object in GUI
     *
     * @param event
     * @throws IOException
     */
    public void viewStudentPushed(ActionEvent event) throws IOException {
        if (fieldsEntered()) {
            try {
                Student student1 = new Student(fNameTextField.getText(), lNameTextField.getText(), Integer.parseInt(studentNumberTextField.getText()), getActivity(), datePicker.getValue(), chooseImage.getImage());
                StudentList.add(student1);
                System.out.print(student1.studentString());

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("View.fxml"));
                Parent ViewParent = loader.load();
                Scene ViewScene = new Scene(ViewParent);

                //access the controller
                StudentViewController controller = loader.getController();
                controller.getNewArray(StudentList);
                controller.initData(student1);


                //Getting the Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(ViewScene);
                window.show();
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }

    /**
     * Method checks all fields are entered and has error handling
     *
     * @return
     */
    public boolean fieldsEntered() {
        String error = "";
        if (datePicker.getValue() == null) {
            error = "Birthday Field is Empty";
        }
        if (fNameTextField.getText().isEmpty()) {
            error = "First Name Field is Empty";
        }
        if (lNameTextField.getText().isEmpty()) {
            if (error.isEmpty())
                error = "Last Name Field is Empty";
            else error = "First and Last Name Fields are Empty";
        }
        if (studentNumberTextField.getText().isEmpty()) {
            if (error.isEmpty())
                error = "Student Number Field is Empty";
            else if (fNameTextField.getText().isEmpty() && !lNameTextField.getText().isEmpty())
                error = "First Name and Student Number Fields are Empty";
            else if (!fNameTextField.getText().isEmpty() && lNameTextField.getText().isEmpty())
                error = "Last Name and Student Number Fields are Empty";
            else error = "All Fields are Empty";
        }
        errorLabel.setText(error);
        return error.isEmpty();
    }

    /**
     * Method Allows user to set student image when button pushed
     *
     * @param event
     */
    public void chooseImageButtonPushed(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");

        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(imageFilter);

        String startDirectoryString = System.getProperty("user.home") + "\\Pictures";
        File startDirectory = new File(startDirectoryString);
        if (!startDirectory.canRead())
            startDirectory = new File(System.getProperty("user.home"));
        fileChooser.setInitialDirectory(startDirectory);

        File studentImageFile = fileChooser.showOpenDialog(stage);
        if (studentImageFile != null && studentImageFile.isFile()) {
            chooseImage.setImage(new Image(studentImageFile.toURI().toString()));
        }
    }

    public void getAge(ActionEvent event) {
        LocalDate date = LocalDate.now();
        Period period = Period.between(datePicker.getValue(), date);
        int age = period.getYears();
        birthday.setText("Age: " + age);
    }

    public void getArray(ArrayList<Student> newStudentList) {
        StudentList = newStudentList;
    }
}

