package U.I;

import model.Transcript;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        //TODO: create another Transcript object

        t1.addGrade("CPSC-210", 3.5);
        t1.addGrade("ENGL-201", 4.0);
        t1.addGrade("CPSC-110", 3.1);
        t2.addGrade("CPSC-110", 2.5);
        t2.addGrade("ENGL-201", 3.2);
        //TODO: add grades to the other Transcript objects

        System.out.print(t1.getStudentName() + ": ");
        t1.printTranscript();
        System.out.println(t1.getCourseAndGrade("CPSC-210"));
        System.out.println(t1.getGPA());

        System.out.println(t2.getStudentName() + ": ");
        t2.printTranscript();
        System.out.println(t2.getCourseAndGrade("CPSC-110"));
        System.out.println(t2.getGPA());

        List<Double>grades = new ArrayList<>();
        grades.add(1.5);
        grades.add(2.5);
        grades.add(3.5);
        System.out.println("Average Grades :");
        System.out.println(t1.calculateAverage(grades));

        System.out.println("Grade for ENGL-201 :");
        System.out.println(t1.getGradeByCourse("ENGL-201"));

        List<String>courses = new ArrayList<>();
        courses.add("CPSC-210");
        courses.add("ENGL-201");
        System.out.println("Average Grades for CPSC-210 And ENGL-201");
        System.out.println(t1.getAverageOverSelectedCourses(courses));

        //TODO: add more use cases here

    }





}
