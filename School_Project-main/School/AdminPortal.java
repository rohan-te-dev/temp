package School;

import java.io.FileReader;
import java.util.*;
import java.awt.Toolkit;

public class AdminPortal {

    final static String password = "admin334";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        School school = new School();
        ClassTeachers classTeachers = new ClassTeachers();
        AttendenceTracking at = new AttendenceTracking();
        FeeManagement feeManagement = new FeeManagement();

        System.out.println("WELCOME TO ADMIN PORTAL...");

        System.out.print("Enter password: ");
        String pass = sc.next();
        if (pass.equals(password)) {

            while (true) {
                System.out.println();
                System.out.println("\t\t1 to display Teachers ");
                System.out.println("\t\t2 to Add Teachers ");
                System.out.println("\t\t3 to Add Class Teachers ");
                System.out.println("\t\t4 to Search Class Teachers ");
                System.out.println("\t\t5 for Displaying Class-Teachers Data Base ");
                System.out.println("\t\t6 to Display Fees Record ");
                // System.out.println("\t\t7 to Display Parents Query ");
                System.out.println("\t\t8 to Add Students in Data Base ");
                System.out.println("\t\t9 to See Students in Data Base ");
                System.out.println("\t\t10 to Display Students Attendence ");
                System.out.println("\t\t11 to Display Teachers Attendence ");

                // System.out.println("\t\t12 to Display FULL QUERY"); //IC

                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("\nDisplaying Teachers...");
                        try {
                            FileReader reader = new FileReader("TeachersData.txt");
                            Scanner scanner = new Scanner(reader);
                            while (scanner.hasNextLine()) {
                                String data = scanner.nextLine();
                                System.out.println(data);
                            }
                            scanner.close();

                        } catch (Exception e) {
                            System.out.println("Error 501: " + e.getMessage());
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 2: {
                        System.out.println("\nAdd Teachers");
                        System.out.println("Enter number of teachers you want to Enter: ");
                        int size = sc.nextInt();
                        String[] teacher = new String[size];
                        String[] subject = new String[size];
                        int[] Class = new int[size];
                        for (int i = 0; i < size; i++) {
                            sc.nextLine();
                            System.out.println("Enter name of the Teacher: " + (i + 1));
                            teacher[i] = sc.nextLine();
                            System.out.println("Enter Subject for Teaching: ");
                            subject[i] = sc.next();
                            System.out.println("Enter class of Teaching: ");
                            Class[i] = sc.nextInt();
                        }
                        school.addTeachers(teacher, subject, Class);
                        System.out.println();
                        school.displayTeachers(subject, Class);
                        break;
                    }

                    case 3: {
                        System.out.println("\nAdd Class Teachers___");
                        System.out.print("Enter Name of Class Teacher: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Enter Class: ");
                        int Class = sc.nextInt();
                        classTeachers.changeClassTeacher(Class, name);
                        System.out.println("\n***To display class teachers press 1 ");
                        int a = sc.nextInt();
                        if (a == 1) {
                            System.out.println("\nDisplaying Class Teachers...");
                            classTeachers.displayClassTeachersFile();
                            break;
                        } else {
                            continue;
                        }
                    }

                    case 4: {
                        System.out.print("\nEnter Class to Find Class-Teacher: ");
                        int key = sc.nextInt();
                        System.out.println("\nSearching Class Teacher...");
                        classTeachers.searchClassTeacher(key);
                        break;
                    }

                    case 5: {
                        System.out.println("\nDisplaying Class Teacher's Data-Base...");
                        classTeachers.displayClassTeachersFile();
                        break;
                    }

                    case 6: {
                        System.out.print("\nEnter password to Continue: ");
                        String pass2 = sc.next();
                        feeManagement.displayFeesRecord(pass2);
                        break;
                    }

                    case 7: {
                        // school.getMsg();
                        break;
                    }

                    case 8: {
                        System.out.println("\nEnter number of Students you want to Enter: ");
                        int size = sc.nextInt();
                        String[] students = new String[size];
                        String[] roll = new String[size];
                        String[] Class = new String[size];
                        for (int i = 0; i < size; i++) {
                            sc.nextLine();
                            System.out.println("Enter name of the Student: " + (i + 1));
                            students[i] = sc.nextLine();
                            System.out.println("Enter Class of " + students[i]);
                            Class[i] = sc.next();
                            System.out.println("Enter Roll Number of " + students[i]);
                            roll[i] = sc.next();
                        }
                        school.addStudents(students, roll, Class);
                        break;
                    }

                    case 9: {
                        System.out.println("\nDisplaying Students Data Base...\n");
                        school.displayStudentsDataBase();
                        break;
                    }

                    case 10: {
                        System.out.println("\nAttendence Of Students...\n");
                        at.displayStudentsAttendence();
                        break;
                    }

                    case 11: {
                        System.out.println("\nAttendence Of Teachers...\n");
                        at.displayTeachersAttendence();
                        break;
                    }

                    default: {
                        System.out.println("Invalid Key pressed !");
                        Toolkit.getDefaultToolkit().beep(); // to alert user

                    }

                }

            }
        } else {
            System.out.println("Invalid Password Entered !");
            Toolkit.getDefaultToolkit().beep();
        }

    }

}