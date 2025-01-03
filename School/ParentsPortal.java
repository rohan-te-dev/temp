package School;

import java.util.Scanner;
import java.awt.Toolkit;

public class ParentsPortal {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FeeManagement feeManagement = new FeeManagement();
        ClassTeachers classTeachers = new ClassTeachers();
        School school = new School();
        int pin = 0344;

        System.out.println("WELCOME TO PARENTS PORTAL");
        System.out.print("\nEnter Name of Student: ");
        String std = sc.nextLine();
        System.out.print("Enter Roll-Number: ");
        int rollNo = sc.nextInt();
        System.out.print("Enter PIN: ");
        int pss = sc.nextInt();

        if (pss == pin) {
            System.out.println("Invalid Pin Entered !");
            Toolkit.getDefaultToolkit().beep(); // to alert user
            return;
        } else {

            while (true) {
                System.out.println("\n1 to pay student Fees ");
                System.out.println("2 to Display Class Teacher of "+ std);
                //System.out.println("3 to Send Query ");
                //System.out.println("4 to Check Result ");

                System.out.println("Enter option: ");
                int opt = sc.nextInt();

                switch (opt) {
                    case 1: {
                        System.out.println("Fees Submission");
                        sc.nextLine();
                        System.out.print("Enter Name of Child: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Class of " + name + ": ");
                        int cls = sc.nextInt();
                        System.out.print("Enter Roll_Number of Student: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Fees of " + name + ": ");
                        double fees = sc.nextDouble();
                        feeManagement.offlineFeePayment(name, cls, id, fees);
                        return;
                    }

                    case 2: {
                        System.out.println("Class Teacher of " + std);
                        System.out.print("Enter CLass of "+std+": ");
                        int cls = sc.nextInt();
                        classTeachers.searchClassTeacher(cls);

                        break;
                    }

                    case 3: {
                        /*System.out.println("Feel Free to ask any Question ");
                        System.out.println("Enter your message below");
                        sc.nextLine();
                        String msg = sc.nextLine();
                        school.setSentMsg(msg,std,rollNo);*/
                        System.out.println("Comming Soon !");
                        break;
                    }

                    default:
                        System.out.println("Invalid Key Pressed !");
                        Toolkit.getDefaultToolkit().beep(); // to alert user
                        break;
                }

            }

        }

    }

}
