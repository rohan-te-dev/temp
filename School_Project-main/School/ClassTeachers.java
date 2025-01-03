package School;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassTeachers {
    Scanner sc = new Scanner(System.in);
    private Map<Integer, String> classTeachers = new HashMap<>(10);

    
    public ClassTeachers() {
        classTeachers.put(1, "Sir Mustaq");
        classTeachers.put(2, "Sir Nabeel");
        classTeachers.put(3, "Miss Farah");
        classTeachers.put(4, "Sir Abbas");
        classTeachers.put(5, "Miss Shumaila");
        classTeachers.put(6, "Dr. Khalid Rashid");
        classTeachers.put(7, "Sir Ammar");
        classTeachers.put(8, "Sir Khizer");
        classTeachers.put(9, "Sir Abdul Husain");
        classTeachers.put(10, "Sir Amir Imam");
    }

    public void displayClassTeachersFile() {
        try {
            FileReader reader = new FileReader("classTeachers.txt");
            Scanner data = new Scanner(reader);
            while (data.hasNextLine()) {
                String info = data.nextLine();
                System.out.println(info);
            }
            data.close();
        } catch (Exception e) {
            System.out.println("Error 405: " + e.getMessage());
            e.printStackTrace();
        }

    }

    protected void changeClassTeacher(int Class, String name) {
        for (Map.Entry<Integer, String> entry : classTeachers.entrySet()) {
            if (entry.getKey() == Class) {
                System.out.println("Do You Want to Change Class Teacher ? [Yes/ No]");
                String str = sc.next();
                if (str.equalsIgnoreCase("yes")) {
                    classTeachers.put(Class, name);
                    System.out.println("Class Teacher Changed...!");
                    for (Map.Entry<Integer, String> var : classTeachers.entrySet()) {
                        System.out.println("Class Teacher of " + var.getKey() + " is " + var.getValue());
                    }
                    // CHANGE IN fILE
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("classTeachers.txt", true));
                        writer.newLine();
                        writer.write("Class Teacher of Class " + Class + " is *" + name+"* NEW_! ");
                        writer.close();

                    } catch (Exception e) {
                        System.out.println("Error 406: " + e.getMessage());
                        e.printStackTrace();
                    }

                } else {
                    return;
                }
            }
        }
    }

    public void searchClassTeacher(int key) { // key == class
        for (Map.Entry<Integer, String> entry : classTeachers.entrySet()) {
            if (entry.getKey() == key) {
                System.out.println("Class Teacher of " + key + " is " + entry.getValue());
                return;
            }
        }
        // System.out.println("Not Found ");
    }

}
