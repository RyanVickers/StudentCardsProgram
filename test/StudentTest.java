import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

import static org.junit.Assert.*;

public class StudentTest {
    private Student validStudent;
    JFXPanel jfxPanel = new JFXPanel();

    /**
     * Method set up valid student object
     */
    @Before
    public void setUp() {
        validStudent = new Student("Ryan", "Vickers", 100000000, "VideoGames", LocalDate.of(2001, 7, 5), new Image("images/RyanVickers.jpg"));
    }

    /**
     * tests getFirstName Method
     */
    @Test
    public void getFirstName() {
        String expResult = "Ryan";
        String result = validStudent.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * tests setFirstName Method
     */
    @Test
    public void setFirstName() {
        String expResult = "Jim";
        validStudent.setFirstName("Jim");
        String result = validStudent.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * tests Invalid First Name
     */
    @Test
    public void setInvalidFirstName() {
        try {
            validStudent.setFirstName("j");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * tests getLastName Method
     */
    @Test
    public void getLastName() {
        String expResult = "Vickers";
        String result = validStudent.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * tests setLastName Method
     */
    @Test
    public void setLastName() {
        String expResult = "Hope";
        validStudent.setLastName("Hope");
        String result = validStudent.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * tests Invalid First Name
     */
    @Test
    public void setInvalidLastName() {
        try {
            validStudent.setLastName("v");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * tests setStudentNumber Method
     */
    @Test
    public void setStudentNumber() {
        int expResult = 100000000;
        validStudent.setStudentNumber(100000000);
        int result = validStudent.getStudentNumber();
        assertEquals(expResult, result);
    }

    /**
     * tests getStudentNumber Method
     */
    @Test
    public void getStudentNumber() {
        int expResult = 100000000;
        int result = validStudent.getStudentNumber();
        assertEquals(expResult, result);
    }

    /**
     * tests getNewStudentNumber Method
     */
    @Test
    public void getNewStudentNumber() {
        validStudent.setStudentNumber(100000000);
        int expResult = Student.getNewStudentNumber();
        int result = Student.getNewStudentNumber();
        assertEquals(expResult, result);
    }

    /**
     * tests Invalid Student Number
     */
    @Test
    public void setInvalidStudentNumber() {
        try {
            validStudent.setStudentNumber(1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * tests addActivity Method
     */
    @Test
    public void addActivity() {
        String expResult = "VideoGames,\nCoding";
        validStudent.addActivity("Coding");
        String result = validStudent.getActivityList();
        assertEquals(expResult, result);
    }

    /**
     * tests studentString Method
     */
    @Test
    public void studentString() {
        String expResult = String.format("Ryan Vickers, student #: %d\r\n" + "Favourite Activities: \r\nVideoGames\r\n", validStudent.getStudentNumber());
        String result = validStudent.studentString();
        assertEquals(expResult, result);
    }

    /**
     * tests toString Method
     */
    @Test
    public void testToString() {
        String expResult = String.format("Ryan Vickers, student #: %d\r\n", validStudent.getStudentNumber());
        String result = validStudent.toString();
        assertEquals(expResult, result);
    }

    /**
     * tests getActivityList Method
     */
    @Test
    public void getActivityList() {
        String expResult = "VideoGames";
        String result = validStudent.getActivityList();
        assertEquals(expResult, result);
    }

    /**
     * tests Invalid birthday
     */
    @Test
    public void setInvalidActivity() {
        try {
            validStudent.addActivity("");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * tests setBirthday Method
     */
    @Test
    public void setBirthday() {
        LocalDate expResult = LocalDate.of(1998, 6, 21);
        validStudent.setBirthday(LocalDate.of(1998, 6, 21));
        LocalDate result = validStudent.getBirthday();
        assertEquals(expResult, result);

    }

    /**
     * tests Invalid birthday
     */
    @Test
    public void setInvalidBirthday() {
        try {
            validStudent.setBirthday(LocalDate.of(2015, 05, 31));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * tests getBirthday Method
     */
    @Test
    public void getBirthday() {
        LocalDate expResult = LocalDate.of(2001, 7, 5);
        LocalDate result = validStudent.getBirthday();
        assertEquals(expResult, result);
    }

    /**
     * tests getAge Method
     */
    @Test
    public void getAge() {
        LocalDate date = LocalDate.now();
        Period period = Period.between(LocalDate.of(2001, 7, 5), date);
        int expResult = period.getYears();
        int result = validStudent.getAge();
        assertEquals(expResult, result);
    }

    @Test
    public void getImage() {

    }
}