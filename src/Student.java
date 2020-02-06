import javafx.scene.image.Image;

import javax.swing.*;
import java.util.ArrayList;

public class Student {
    //Instance variables
    private String firstName, lastName, activity;
    private int studentNumber;
    private Image image;

    /**
     * This constructor accepts a first name,last name and student #
     * to create a student object with valid values
     *
     * @param firstName     must contain more than 1 letter
     * @param lastName      must contain more than 1 letter
     * @param studentNumber must be between 10000000-99999999
     */
    public Student(String firstName, String lastName, int studentNumber, String activity) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        addActivity(activity);
        String fileName = firstName+lastName+".jpg";
        image = new Image("./images/"+fileName);

    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * This method validates first name contains more than 1 letter
     * and sets the first letter uppercase
     *
     * @param firstName must contain more than 1 letter
     */
    public void setFirstName(String firstName) {
        if (firstName.length() > 1) {
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            this.firstName = firstName;
        } else
            throw new IllegalArgumentException("First name must contain more than 1 letter");
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * This method validates last name contains more than 1 letter
     * and sets the first letter uppercase
     *
     * @param lastName must contain more than 1 letter
     */
    public void setLastName(String lastName) {
        if (lastName.length() > 1) {
            lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
            this.lastName = lastName;
        } else
            throw new IllegalArgumentException("Last name must contain more than 1 letter");

    }

    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * This method validates the student number is in the proper range
     *
     * @param studentNumber must be between 10000000-99999999
     */
    public void setStudentNumber(int studentNumber) {
        if (studentNumber >= 10000000 && studentNumber <= 99999999)
            this.studentNumber = studentNumber;
        else
            throw new IllegalArgumentException("The student number should be in the range 10000000-9999999");
    }
    public void addActivity(String activity){
 if(!activity.isEmpty())
     this.activity=activity;
     else
         throw new IllegalArgumentException("activity must not be empty");
 }

    /**
     * This method formats the object into a string that can be output to the console
     *
     * @return
     */
    public String toString() {
        return String.format("%s %s student #: %d%n", firstName, lastName, studentNumber);
    }

    public String getActivity() {
        return activity;
    }

    public Image getImage() {
        return image;
    }
}
