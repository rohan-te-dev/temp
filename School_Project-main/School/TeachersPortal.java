package School;

import java.util.Scanner;

public class TeachersPortal {
    public static void main(String[] args) {
        final String pass = "teachers456";

        Scanner sc = new Scanner(System.in);
        AttendenceTracking attendenceTracking = new AttendenceTracking();
        School school = new School();

        System.out.println("Welcome to Teachers Portal");
        System.out.print("Enter password to continue: ");
        String password = sc.next();
        if (!password.equals(password)) {
            System.out.println("Invalid Password !");
            return;
        } else {
            System.out.println("Password Correct\n");
            while (true) {

                System.out.println("1 to Mark Attendence");
                

                System.out.print("Enter Your choice: ");
                int opt = sc.nextInt();

                switch (opt) {
                    case 1: {
                        System.out.println("\nTeachers Attendence\n");
                        sc.nextLine();
                        System.out.print("Enter your Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter ID: ");
                        String id = sc.next();
                        System.out.println("Enter Status [p/a]");
                        String status = sc.next();
                        if (status.equalsIgnoreCase("p") || status.equalsIgnoreCase("a")) {
                            attendenceTracking.attendenceOfTeachers(name, id, status);
                        } else {

                        }
                        break;

                    }

                    default:
                        break;
                }

            }

        }

    }

}
