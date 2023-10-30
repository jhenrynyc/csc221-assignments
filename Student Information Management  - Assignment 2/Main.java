import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Main {


    public static ArrayList<Student> loadStudentRecord() {
        ArrayList<Student> students = new ArrayList<Student>();
        // try to create a file, if not read the existing file
        try {
            File create = new File("src/StudentRecords.txt");

            if (!create.createNewFile()) {
                System.out.println("Reading file...");
                Scanner inFile = new Scanner(new File("src/StudentRecords.txt"));
                // read the whole line, then split it up by the commas.
                while (inFile.hasNextLine()) {
                    String parse = inFile.nextLine();
                    // split each line of the file into
                    String[] info = parse.split(",");
                    ArrayList<Integer> marks = new ArrayList<Integer>();
                    // first two strings are the name and roll number, so skip those
                    for (int i = 2; i < info.length; i++) {
                        marks.add(Integer.parseInt(info[i]));
                    }
                    students.add(new Student(info[0], Integer.parseInt(info[1]), marks));
                }
            }
            else System.out.println("Creating file...");

            return students;
        }
        // catch error reading file
        catch (Exception e) {
            System.out.println("Cannot read file!");
        }

        return students;

    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        ArrayList<Student> students = loadStudentRecord();
        System.out.print("1 : View All Records\n2 : Search by Roll Number\n3 : Edit by Roll Number\n4 : Delete by Roll Number\n5 : Save Records\n6 : Exit\nYour Choice : ");
        int choice = Integer.parseInt(br.readLine());
        while (choice != 6) {

            switch (choice) {

                case 1:
                    try {
                        BufferedReader view = new BufferedReader(new FileReader("src/StudentRecords.txt"));
                        String line;
                        while ((line = view.readLine()) != null) {
                            System.out.println(line);

                        }
                        view.close();
                        break;

                    } catch (FileNotFoundException e) {
                        System.out.println("\nERROR : File not Found !!!");
                        break;
                    }


                case 2:
                    System.out.print("Enter roll number to search: ");
                    int rollNumber = in.nextInt();
                    in.nextLine(); // Consume the newline character

                    boolean found = false;
                    for (Student student : students) {
                        if (student.getRollNumber() == rollNumber) {
                            System.out.println("Student Record Found:\n" + student.toString());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student record not found for roll number " + rollNumber);
                    }
                    break;
                case 3:
                    System.out.print("Enter roll number to edit: ");
                    rollNumber = in.nextInt();
                    in.nextLine(); // Consume the newline character
                    boolean founder = false;
                    for (int i = 0; i < students.size(); i++) {
                        Student student = students.get(i);
                        if (student.getRollNumber() == rollNumber) {
                            System.out.println("Student Record Found:\n" + student);
                            System.out.print("Enter new marks: ");
                            int neMarks = in.nextInt();
                            ArrayList<Integer> newMarks = new ArrayList<Integer>();
                            newMarks.add(neMarks);
                            in.nextLine(); // Consume the newline character
                            students.set(i, new Student(student.getName(), rollNumber, newMarks));
                            System.out.println("Student record updated successfully.");
                            founder = true;
                            break;
                        }
                    }
                    break;
                case 4:

                    System.out.print("Enter roll number to delete: ");
                    rollNumber = in.nextInt();
                    in.nextLine(); // Consume the newline character

                    int finalRollNumber = rollNumber;
                    boolean removed = students.removeIf(student -> student.getRollNumber() == finalRollNumber);

                    if (removed) {
                        System.out.println("Student record for roll number " + rollNumber + " deleted.");
                    } else {
                        System.out.println("Student record not found for roll number " + rollNumber);
                    }
                    break;
                case 5:

                    try (PrintWriter writer = new PrintWriter("src/StudentRecords.txt")) {
                        for (Student student : students) {
                            writer.println(student.getName() + "," + student.getRollNumber() + "," + student.getMarks());
                        }
                    } catch (FileNotFoundException e) {
                        System.err.println("Error saving student data: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Program Exited");
                    System.exit(1);
                    break;

                default:
                    System.out.println("\nInvalid Choice !");

                    break;


            }
            System.out.print("1 : View All Records\n2 : Search by Roll Number\n3 : Edit by Roll Number\n4 : Delete by Roll Number\n5 : Save Records\n6 : Exit\nYour Choice : ");

            choice = Integer.parseInt(br.readLine());

        }
        }


}














