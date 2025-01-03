package School;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.GregorianCalendar;
// Attendence of Students and teachers
import java.util.Scanner;

public class AttendenceTracking extends School{
    
    // Only for Students
    GregorianCalendar gc = new GregorianCalendar();
    int day = gc.get(GregorianCalendar.DAY_OF_MONTH); // Assigning the current date
    int month = gc.get(GregorianCalendar.MONTH) + 1; // Adding 1 as months are 0-indexed
    int year = gc.get(GregorianCalendar.YEAR); // Getting the current year
    

    // Create a Data base which is basically a file and format it to store
    public void attendenceOfStudents(String name, String ID, String status) {  // pending 
        try {
            FileWriter writer = new FileWriter("StudentsAttendence.txt", true);
            writer.write("Name: " + name + " Roll_Number: " + ID + " is " + status + " at " + day + "/" + month + "/"
                    + year + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error 302: " + e.getMessage());
            e.printStackTrace();
        }

    }

    protected void displayStudentsAttendence() {
        try {
            FileReader file = new FileReader("StudentsAttendence.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error 905: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void attendenceOfTeachers(String name, String ID, String status) {
        try {
            if (status.equalsIgnoreCase("p")) {
                status = "*Present*";
                FileWriter writer = new FileWriter("TeachersAttendence.txt", true);
                writer.write("Name: " + name + " Roll_Number: " + ID + " is " + status + " at " + day + "/" + month + "/"
                        + year + "\n");
                writer.close();
            } else {
                status = "*Absent*";
                FileWriter writer = new FileWriter("TeachersAttendence.txt", true);
                writer.write("Name: " + name + " Roll_Number: " + ID + " is " + status + " at " + day + "/" + month + "/"
                        + year + "\n");
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Error 303: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected void displayTeachersAttendence() {
        try {
            FileReader file = new FileReader("TeachersAttendence.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error 906: "+e.getMessage());
            e.printStackTrace();
        }
    }

}
