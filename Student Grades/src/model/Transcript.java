package model;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private String studentName;
    private int studentID;
    private List<String> courses;
    private  List<Double> grades;

    public Transcript(String studentName, int studentID){
        this.studentName = studentName;
        this.studentID = studentID;
        courses = new ArrayList<>();
        grades = new ArrayList<>();
    }

    //Requires: the grade should be between 0.0 and 4.0, and/or the course should not be null correct
    //MODIFIES: Transcript
    //EFFECTS: adds a grade to a course
    public void addGrade(String course, double grade){
        if (courses.contains(course)){
            int courseIndex = courses.indexOf(course);
            grades.set(courseIndex , grade);
        }else{
            this.courses.add(course);
            this.grades.add(grade);

        }

    }

    //TODO: Design specification for this method
    // EFFECTS: returns course name and grade in format CourseName: Grade
    public String getCourseAndGrade(String course){
        if (courses.contains(course)){
            int courseIndex = courses.indexOf(course);
            return courses.get(courseIndex) + ":" + grades.get(courseIndex);
        }else{
            return null;
        }
    }

    //TODO: Design specification for this method
    //EFFECTS: prints course names with grades earned
    public void printTranscript(){
        StringBuilder Transcript = new StringBuilder(studentName + "," + studentID + ":");
        int courseSize = courses.size();
        for (int i = 0; i < courseSize; i++){
        Transcript
                .append(courses.get(i))
                .append(":")
                .append(grades.get(i));

        if (i != courseSize -1){
            Transcript.append(",");

        }
        }
        System.out.println(Transcript);
    }

    //TODO: Design specification for this method
    //
    public double getGPA(){ return calculateAverage(grades); }

    //TODO: specification
//
    public double calculateAverage(List<Double> selectedGrades){
        double sum = 0.0;
        for(double grade : selectedGrades){
            sum += grade;
            }
            return sum / selectedGrades.size();
            //once you complete this method, figure out how to add it as a helper to getGPA()
    }

    public double getGradeByCourse(String course){
        int index = courses.indexOf(course);
        return grades.get(index);
        //this method should return the grade for the given course parameter
    }

    //TODO: specification
//
    public double getAverageOverSelectedCourses(List<String> selectedCourses){
        List<Double>selectedCourseGrades = new ArrayList<>();
        for (String course : selectedCourses){
            selectedCourseGrades.add(getGradeByCourse(course));

        }
        return calculateAverage(selectedCourseGrades);
        //think about which method you can call as a helper!
    }

   // public int size(){return size();}
    // GETTERS
   public String getStudentName(){return this.studentName;}
   public int getStudentID(){return this.studentID;}

    // SETTERS
    public String setStudentName(String studentName){
        this.studentName = studentName;
        return  studentName;
    }
    public int setStudentID(int studentID){
        this.studentID = studentID;
        return studentID;}




}
