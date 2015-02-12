/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */

package _host.chapter04.weblog;

public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Exercise 4.74
     * Return the number of accesses recorded in the log
     * file.
     */
    public int numberOfAccesses()
    {
        int total = 0;

        for (int hourCount : hourCounts)
            total += hourCount;

        return total;
    }

    /**
     * Exercise 4.75
     * Defaulting the first hour as the busiest, requires only one variable
     * @return int
     */
    public int busiestHour()
    {
        // With this method this check is required, or no data would return index 0
        if (numberOfAccesses() == 0)
            return -1;

        int hour = 0; // Assume the first hour is the busiest

        // Loop through and find higher value than current maximum
        for (int i = 0; i < hourCounts.length; i++)
            if (hourCounts[i] > hourCounts[hour])
                hour = i;

        return hour;
    }

    /**
     * Exercise 4.75 (alternate implementation)
     * Defaulting nothing as the busiest, requires two variables
     * @return int
     */
    public int busiestHourAlt()
    {
        int hour = -1;          // Assume no hour is busy
        int hourValue = 0;

        for (int i = 0; i < hourCounts.length; i++)
            if (hourCounts[i] > hourValue) {
                hour = i;
                hourValue = hourCounts[i];
            }

        return hour;
    }

    /**
     * Exercise 4.76
     * @return int
     */
    public int quietestHour()
    {
        // Make sure there's data to compare
        if (numberOfAccesses() == 0)
            return -1;

        int hour = 0; // Assume 0th hour is quietest

        for (int i = 0; i < hourCounts.length; i++)
            if (hourCounts[i] < hourCounts[hour])
                hour = i;

        return hour;
    }

    /**
     * Exercise 4.78
     * @return Value of the first of the two busiest hours
     */
    public int busiestHours()
    {
        int hour = -1; // Assume no hour is busy
        int hourValue = 0;

        for (int i = 0; i < hourCounts.length - 1; i++)
        {
            int current = hourCounts[i] + hourCounts[i + 1];

            if (current > hourValue)
            {
                hour = i;
                hourValue = current;
            }
        }

        return hourCounts[hour];
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
