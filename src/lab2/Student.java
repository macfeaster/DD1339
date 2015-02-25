package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Student
{
    private String name;
	private Stack<String> strings;

    public Student(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return name;
    }

    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mary"));
        students.add(new Student("Kate"));

        for (Object s : students)
            System.out.println(s);


    }
}