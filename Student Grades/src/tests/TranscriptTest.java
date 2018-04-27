package tests;


import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

//import static org.junit.Assert.assertEquals;


public class TranscriptTest {

    private Transcript testTranscript;
    private String testStudentName = "James M";
    private int testStudentID = 1111;

    @Before
    public void setUp(){
        testTranscript = new Transcript(testStudentName, testStudentID);
        //TODO: write new values in testTranscript constructor
    }

    @Test
    public void testStudentNameSet(){
        assertEquals(testTranscript.getStudentName(), testStudentName);
        }

    @Test
    public void TestStudentIDSet(){
        assertEquals(testTranscript.getStudentID(), testStudentID);
    }

    @Test
    public void TestChangeStudentName(){
        String newStudentName = "Elena";
        assertEquals(testTranscript.getStudentName(), testStudentName);
        testTranscript.setStudentName(newStudentName);
        assertEquals(testTranscript.getStudentName(), newStudentName);
    }

    @Test
    public void TestChangeStudentID(){
        int newStudentID = 2222;
        assertEquals(testTranscript.getStudentID(), testStudentID);
        testTranscript.setStudentID(newStudentID);
        assertEquals(testTranscript.getStudentID(), newStudentID);

    }

    @Test
    public void TestGradeNotInSet(){
        String course = "HIST-111";
        double grade = 2.5;
        assertEquals(testTranscript.getCourseAndGrade(course), null);
        testTranscript.addGrade(course, grade);
        assertEquals(testTranscript.getCourseAndGrade(course), course + ":" + Double.toString(grade));
    }

    @Test
    public void TestGradeInSet(){
        String course = "GEOG-151";
        double grade = 1.5;
        double newGrade = 3.5;
        assertEquals(testTranscript.getCourseAndGrade(course), null);
        testTranscript.addGrade(course, grade);
        assertEquals(testTranscript.getCourseAndGrade(course), course + ":" + Double.toString(grade));
        testTranscript.addGrade(course, newGrade);
        assertEquals(testTranscript.getCourseAndGrade(course), course + ":" + Double.toString(newGrade));

    }
    @Test
    public void TestGPA() {
        testTranscript.addGrade("CPSC-210", 3.5);
        testTranscript.addGrade("ENGL-201", 4.0);
        testTranscript.addGrade("CPSC-110", 3.1);
        double gpa = (3.5 + 4.0 + 3.1) / 3;
        assertEquals(testTranscript.getGPA(), gpa);
    }


    @Test
     public void TestCalculateAverage(){
        List<Double>grades = new ArrayList<>();
        grades.add(2.5);
        grades.add(1.5);
        grades.add(3.1);
        assertEquals(testTranscript.calculateAverage(grades),(2.5 + 1.5 + 3.1)/3);
    }
    @Test
    public void TestGetGradeByCourse(){
        testTranscript.addGrade("CPSC-210", 3.5);
        assertEquals(testTranscript.getCourseAndGrade("CPSC-210"), "CPSC-210:3.5");
        assertEquals(testTranscript.getGradeByCourse("CPSC-210"), 3.5 );
    }
    @Test
    public void TestgetAverageOverSelectedCourses(){
        List<String>courses = new ArrayList<>();
        courses.add("CPSC-201");
        courses.add("ENGL-201");
        testTranscript.addGrade(courses.get(0), 2.5);
        testTranscript.addGrade(courses.get(1), 1.5);
        assertEquals(testTranscript.getAverageOverSelectedCourses(courses),(2.5 + 1.5)/ 2);
    }
}





