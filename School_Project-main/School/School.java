package School;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class School {
    
    private ArrayList<String> students;
    private ArrayList<String> teachers;
    //private String sentMsg,response,stdName;
    Scanner sc = new Scanner(System.in);

    //constructor
    public School() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public ArrayList<String> getStudents() {
        return new ArrayList<>(students);
    }

    public void setStudents(ArrayList<String> students) {
        this.students = new ArrayList<>(students);
    }

    public ArrayList<String> getTeachers() {
        return new ArrayList<>(teachers); // Return a copy of the teachers list
    }

    public void setTeachers(ArrayList<String> teachers) {
        this.teachers = new ArrayList<>(teachers);
    }


    public void addStudents(String studentName[], String studentID[], String studentClass[]) {
        try {
            FileWriter writer = new FileWriter("StudentsDataBase.txt", true);
            for (int i = 0; i < studentName.length; i++) {
                this.students.add(studentName[i]);
                setStudents(students);
                writer.write("Student: " + students.get(i) + " Roll.No: " + studentID[i] + " Class: " + studentClass[i]
                        + "\n");
            }
            writer.close();
            displayStudents(studentID, studentClass);
            System.out.println("HAS BEEN ADDED IN DATA BASE !");
        } catch (Exception e) {
            System.out.println("Error 409: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void displayStudents(String ID[], String Class[]) {
        System.out.println();
        for (int i = 0; i < students.size(); i++) {
            System.out.println("Students: " + students.get(i));
            System.out.println("ROll Number: " + ID[i]);
            System.out.println("Class: " + Class[i]);
        }
    }

    protected void displayStudentsDataBase() {
        try{
           FileReader file = new FileReader("StudentsDataBase.txt");
           Scanner reader = new Scanner(file);
           while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
           }
           reader.close();
        } catch (Exception e) {
            System.out.println("Error 302: "+e.getMessage());
            e.printStackTrace();
        }
    }

    // ADDING TEACHER
    public void addTeachers(String teacherName[], String subject[], int Class[]) {
        try {
            FileWriter writer = new FileWriter("TeachersData.txt",true);
            for (int i = 0; i < teacherName.length; i++) {
                teachers.add(teacherName[i]);
                setTeachers(teachers);
                writer.write("Teacher: *" + teacherName[i] + "* Subject: *" + subject[i] + "* Class: *" + Class[i]+"*\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error 408: "+e.getMessage());
            e.printStackTrace();
        }

    }

    public void displayTeachers(String subject[], int Class[]) {
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println("Teachers: " + teachers.get(i));
            System.out.println("Subject: " + subject[i]);
            System.out.println("Class: " + Class[i]);
        }
        System.out.println("*HAS BEEN ENTERED IN DATA BASE* ");
    }


/*
    // query will be send by parents and teachers will response it
    public void setSentMsg(String question, String childName, int rollNo) {
        this.stdName = childName;
        this.sentMsg = question;
        System.out.println("Query has been Sent ");
    }

    protected String getMsg() {
        System.out.println("Question from a Parent of child "+this.stdName);
        return this.sentMsg;
    }



    //Response portion
    protected void setResponse(String teachersResponse) {
        this.response = teachersResponse;
        System.out.println("Response has been sent...");
    }

    protected String getResponse() {
        return this.response;
    }

*/

    // RESULT portion

    /*protected void result(String stdName, int stdID, int stdClass) {

    }*/



}
