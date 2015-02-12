package chapter08;

/**
 * The Student class is an extension of the lab3.Person class,
 * modifying nothing but toString and adding a credits field
 */
public class Student extends Person
{
    // the amount of credits for study taken so far
    private int credits;

    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String name, String id)
    {
        super(name, id);
        credits = 0;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return credits;
    }

    @Override
    public String toString()
    {
        return super.toString() + "   Credits: " + credits;
    }
}
