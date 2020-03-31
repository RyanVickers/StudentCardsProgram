import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Student {
    //Instance variables
    private String firstName, lastName;
    private int studentNumber;
    private ArrayList<String> activityList;
    private LocalDate birthday;
    private Image image;

    /**
     * This constructor accepts a first name,last name and student #
     * to create a student object with valid values
     *
     * @param firstName     must contain more than 1 letter
     * @param lastName      must contain more than 1 letter
     * @param studentNumber must be between 10000000-99999999
     */
    public Student(String firstName, String lastName, int studentNumber, String activity,LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        setBirthday(birthday);
        activityList = new ArrayList<>();
        addActivity(activity);
        String fileName = "defaultImage.jpg";
        image = new Image("/images/" + fileName);

    }

    /**
     * Method returns First name
     *
     * @return firstName
     */
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

    /**
     * Method returns Last name
     *
     * @return Last Name
     */
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

    /**
     * Method returns student number
     *
     * @return studentNumber
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * This method validates the student number is in the proper range
     *
     * @param studentNumber must be between 10000000-99999999
     */
    public void setStudentNumber(int studentNumber) {
        if (studentNumber >= 1000000 && studentNumber <= 9999999)
            this.studentNumber = studentNumber;
        else
            throw new IllegalArgumentException("The student number should be in the range 10000000-9999999");
    }

    /**
     * Adds activity to activity arraylist
     *
     * @param activity must not be empty
     */
    public void addActivity(String activity) {
        if (!activity.isEmpty())
            activityList.add(activity);
        else
            throw new IllegalArgumentException("Activity must not be empty");
    }

    /**
     * This method formats the object into a string that can be output to the console
     *
     * @return
     */
    public String toString() {
        return String.format("%s %s student #: %d%n Favourite Activities: %n%s%n", firstName, lastName, studentNumber, getActivityList());
    }

    /**
     * Method returns activity
     *
     * @return activitylist
     */
    public String getActivityList() {
        return activityList.toString().replace("[", "").replace("]", "");

    }

    /**
     * Method get student image
     *
     * @return
     */
    public Image getImage() {
        return image;
    }

    public void setBirthday(LocalDate birthday){
        LocalDate date =LocalDate.now();
        Period period= Period.between(birthday,date);
        int age = period.getYears();
        if(age>=10&&age<=120)
            this.birthday=birthday;
        else
            throw new IllegalArgumentException("Age must be between 10 and 120 years old.");

    }
    public LocalDate getBirthday(){return birthday;}

    public int getAge() {
        LocalDate date = LocalDate.now();
        Period period = Period.between(birthday, date);
        int age = period.getYears();
        return age;
    }
}
