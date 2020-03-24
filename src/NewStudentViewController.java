import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
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

    private Student student1;
    private ArrayList<String> interestList = new ArrayList<>();
    public void activity() {

        if (videoGamesCheckBox.isSelected()) {
            interestList.add("Video Games\n");
        }
        if (readingCheckBox.isSelected()) {
            interestList.add("Reading\n");
        }
        if (cookingCheckBox.isSelected()) {
            interestList.add("Cooking\n");
        }
        if (codingCheckBox.isSelected()) {
            interestList.add("Coding\n");
        }
        if (runningCheckBox.isSelected()) {
            interestList.add("Running\n");
        }
        if (musicCheckBox.isSelected()) {
            interestList.add("Music\n");
        }
        if (hockeyCheckBox.isSelected()) {
            interestList.add("Hockey\n");
        }
        if (moviesCheckBox.isSelected()) {
            interestList.add("Movies\n");
        }
        if (sleepingCheckBox.isSelected()) {
            interestList.add("Sleeping\n");
        }
        if (travelingCheckBox.isSelected()) {
            interestList.add("Traveling\n");
        }
    }

public String getActivity(){
        activity();
    return interestList.toString().replace("[","").replace("]","").replace(",","");
}

    public void buttonPressed() {
        if (fieldsEntered()) {
            try {
                student1 = new Student(fNameTextField.getText(), lNameTextField.getText(),
                        Integer.parseInt(studentNumberTextField.getText()),getActivity());
                System.out.println(student1);
                interestList.clear();
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }

    public boolean fieldsEntered() {
        String error = "";
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
        if (!error.isEmpty()) {
            return false;
        }
        return true;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}