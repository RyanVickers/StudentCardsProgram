import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
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
    @FXML
    private Button viewStudentButton;
    @FXML
    private ImageView chooseImage;

    @FXML
    private Button imageButton;

    private Student student1;
    private ArrayList<String> interestList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chooseImage.setImage(new Image("images/defaultImage.jpg"));

    }
    /**
     * Method adds each selected checkbox activity to an arraylist
     */
    public void activity() {
        interestList.clear();
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

    /**
     * Method gets activity list and returns it as a string
     *
     * @return
     */
    public String getActivity() {
        activity();
        return interestList.toString().replace("[", "").replace("]", "").replace(",", "");
    }

    /**
     * Method checks if fields are entered and prints out stduent object
     * to the console if submit button is pressed
     */
    public void buttonPressed() {
        if (fieldsEntered()) {
            try {
                student1 = new Student(fNameTextField.getText(), lNameTextField.getText(),
                        Integer.parseInt(studentNumberTextField.getText()), getActivity());
                System.out.println(student1);
                viewStudentButton.setVisible(true);
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }

    /**
     * Method displays student object in GUI
     *
     * @param event
     * @throws IOException
     */
    public void viewStudentPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View.fxml"));
        Parent ViewParent = loader.load();
        Scene ViewScene = new Scene(ViewParent);

        //access the controller
        StudentViewController controller = loader.getController();
        controller.initData(student1);

        //Getting the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(ViewScene);
        window.show();
    }

    /**
     * Method checks all fields are entered and has error handling
     *
     * @return
     */
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

    public void chooseImageButtonPushed(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");
        FileChooser.ExtensionFilter imageFilter=new FileChooser.ExtensionFilter("Image Files","*.jpg","*.png");
        fileChooser.getExtensionFilters().add(imageFilter);
        String startDirectoryString=System.getProperty("user.home")+"\\Pictures";
        File startDirectory=new File(startDirectoryString);
        if(!startDirectory.canRead())
            startDirectory = new File(System.getProperty("user.home"));
            fileChooser.setInitialDirectory(startDirectory);

        File studentImageFile = fileChooser.showOpenDialog(stage);
        if (studentImageFile != null && studentImageFile.isFile()) {
            chooseImage.setImage(new Image(studentImageFile.toURI().toString()));
        }
    }


}