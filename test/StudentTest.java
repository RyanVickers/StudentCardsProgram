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
    @Before
    public void setUp() {

        validStudent = new Student("Ryan", "Vickers",100000000,"VideoGames", LocalDate.of(2001,7,5), new Image("images/RyanVickers.jpg"));
    }
    @Test
    public void getFirstName() {
        String expResult = "Ryan";
        String result = validStudent.getFirstName();
        assertEquals(expResult, result);
    }

    @Test
    public void setFirstName() {
        String expResult = "Jim";
        validStudent.setFirstName("Jim");
        String result = validStudent.getFirstName();
        assertEquals(expResult, result);
    }

    @Test
    public void getLastName() {
        String expResult = "Vickers";
        String result = validStudent.getLastName();
        assertEquals(expResult, result);
    }

    @Test
    public void setLastName() {
        String expResult = "Hope";
        validStudent.setLastName("Hope");
        String result = validStudent.getLastName();
        assertEquals(expResult, result);
    }

    @Test
    public void getStudentNumber() {
        int expResult = Student.getNewStudentNumber()-1;
        int result = validStudent.getStudentNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void getNewStudentNumber() {
        int expResult = validStudent.getStudentNumber()+1;
        int result = Student.getNewStudentNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void addActivity() {
        String expResult = "VideoGames,\nCoding";
        validStudent.addActivity("Coding");
        String result = validStudent.getActivityList();
        assertEquals(expResult, result);
    }

    @Test
    public void studentString() {
        String expResult = String.format("Ryan Vickers, student #: %d\r\n" + "Favourite Activities: \r\nVideoGames\r\n",validStudent.getStudentNumber());
        String result = validStudent.studentString();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        String expResult = String.format("Ryan Vickers, student #: %d\r\n",validStudent.getStudentNumber());
        String result = validStudent.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void getActivityList() {
        String expResult = "VideoGames";
        String result = validStudent.getActivityList();
        assertEquals(expResult, result);
    }

    @Test
    public void setBirthday() {
        LocalDate expResult = LocalDate.of(1998,6,21);
        validStudent.setBirthday(LocalDate.of(1998,6,21));
        LocalDate result = validStudent.getBirthday();
        assertEquals(expResult, result);

    }

    @Test
    public void getBirthday() {
        LocalDate expResult = LocalDate.of(2001,7,5);
        LocalDate result = validStudent.getBirthday();
        assertEquals(expResult, result);
    }

    @Test
    public void getAge() {
        LocalDate date = LocalDate.now();
        Period period = Period.between(LocalDate.of(2001,7,5), date);
        int expResult = period.getYears();
        int result = validStudent.getAge();
        assertEquals(expResult, result);
    }
}