/*
 * Runner.java
 * Part of the Blok Content Management Engine
 *  __       ___           __
 * /\ \     /\_ \         /\ \
 * \ \ \____\//\ \     ___\ \ \/'\
 *  \ \ '__`\ \ \ \   / __`\ \ , <
 *   \ \ \_\ \ \_\ \_/\ \_\ \ \ \\`\
 *    \ \_,__/ /\____\ \____/\ \_\ \_\
 *     \/___/  \/____/\/___/  \/_/\/_/
 *
 * Copyright (c) Mauritz Zachrisson and the Blok Team 2014.
 * Last modified 11/6/14 7:21 PM
 */

package _host.chapter04.weblog;

public class Runner
{
    public static void main(String[] args)
    {
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.analyzeHourlyData();
        // analyzer.printData();
        analyzer.printHourlyCounts();

        System.out.println("Total number of accesses: " + analyzer.numberOfAccesses());
        System.out.println("Busiest hour: " + analyzer.busiestHour());
        System.out.println("Busiest hour: " + analyzer.busiestHourAlt());
        System.out.println("Busiest hours: " + analyzer.busiestHours());
        System.out.println("Quietest hour: " + analyzer.quietestHour());
    }
}
