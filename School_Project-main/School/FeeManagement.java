package School;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FeeManagement extends School {
    private double bal;
    private String studentName;
    private int studentRoll;
    private int studentClass;
    // private double collegeFees = 5000;
    private double studentFee = 3000;
    private String pass = "2380246";

    GregorianCalendar gc = new GregorianCalendar();
    int day, month, year;

    public FeeManagement() {
        this.day = gc.get(Calendar.DAY_OF_MONTH);
        this.month = gc.get(Calendar.MONTH) + 1;
        this.year = gc.get(Calendar.YEAR);
    }

    public void offlineFeePayment(String stdName, int stdClass, int stdRoll, double stdfees) {
        setStudentName(stdName);
        setStudentClass(stdClass);
        setStudentRoll(stdRoll);
        setBal(stdfees);

        try {
            if (this.bal != this.studentFee) {
                return;
            } else {
                FileWriter writer = new FileWriter("FeesRecord.txt", true);
                writer.write("Student: *" + this.studentName + "* Roll_No# *" + this.studentRoll + "* of Class: *"
                        + this.studentClass + "* Fees Status |" + this.bal + "| Submited " + this.day + "/"
                        + this.month + "/" + this.year + "\n");
                writer.close();
                System.out.println("\n" + stdName.toUpperCase() + "'s Fees Submited ");
                System.out.println("╔─────────────────────────────────────────────────╗\r\n" + //
                        "│                                                 │\r\n" + //
                        "│  _____ _  _   _   _  _ _  __ __   _____  _   _  │\r\n" + //
                        "│ |_   _| || | /_\\ | \\| | |/ / \\ \\ / / _ \\| | | | │\r\n" + //
                        "│   | | | __ |/ _ \\| .` | ' <   \\ V / (_) | |_| | │\r\n" + //
                        "│   |_| |_||_/_/ \\_\\_|\\_|_|\\_\\   |_| \\___/ \\___/  │\r\n" + //
                        "│                                                 │\r\n" + //
                        "╚─────────────────────────────────────────────────╝");
            }
        } catch (Exception e) {
            System.out.println("Error 407: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private void setBal(double fees) {
        if (fees != this.studentFee) {
            System.out.println("Invalid Fees Entered !");
            System.out.println("Fees not Submitted");
            return;
        } else {
            this.bal += fees;
        }
    }

    private void setStudentName(String name) {
        this.studentName = name;
    }

    private void setStudentRoll(int roll) {
        this.studentRoll = roll;
    }

    private void setStudentClass(int Class) {
        this.studentClass = Class;
    }


    // ONLY FOR ADMIN
    protected void displayFeesRecord(String password) {
        if (password.equals(this.pass)) {
            System.out.println("\nDisplaying Fees Records...\n");
            try {
                Thread.sleep(3000); // Pause for 3 seconds
                try {
                    FileReader file = new FileReader("FeesRecord.txt");
                    Scanner reader = new Scanner(file);
                    while (reader.hasNextLine()) {
                        String data = reader.nextLine();
                        System.out.println(data);
                    }
                    reader.close();
                } catch (Exception e) {
                    System.out.println("Error 606: " + e.getMessage());
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                System.out.println("Error 302: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid Password !");
            return;
        }

    }

}
