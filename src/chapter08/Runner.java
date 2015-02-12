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
 * Copyright (c) Mauritz Zachrisson and the Blok Team 2015.
 * Last modified 1/22/15 3:44 PM
 */

package chapter08;

public class Runner
{
	public static void main(String[] args)
	{
		LabClass l = new LabClass(4);
		l.setInstructor(new Instructor("Mary Seinfeld", "PCX547"));
		l.setRoom("Conference Room C");
		l.setTime("Friday, 2pm");
		l.enrollStudent(new Student("Lisa", "ISH281"));
		l.enrollStudent(new Student("Kate", "KLE495"));
		l.enrollStudent(new Student("Bobby", "APO048"));
		l.enrollStudent(new Student("Robert", "EPG193"));
		l.enrollStudent(new Student("Clara", "OIE285"));

		l.printList();
	}
}
