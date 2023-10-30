

import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.io.BufferedReader;
import java.util.*;

public class Student  {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String name;
    private int rollNumber;
    public ArrayList<Integer> marks = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public Student(String name, int rollNumber, ArrayList<Integer> marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;

    }

    public float marksAverage(ArrayList<Integer> marks) {
        int marksSize = marks.size();
        float count = 0;
        for (int i = 0; i < marks.size(); i++) {
            count += marks.get(i);
        }
        return count / marks.size();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Marks: " + marks;
    }



}






