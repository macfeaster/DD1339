/*
 * ClubDemo.java
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
 * Last modified 10/16/14 10:34 AM
 */

package _host.chapter04.club;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Provide a demonstration of the Club and com.macfeaster.blok._host.chapter04.club.Membership
 * classes.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClubDemo
{
	// instance variables - replace the example below with your own
	private Club club;

	public static void main(String[] args)
	{
		new ClubDemo();
	}

	/**
	 * Constructor for objects of class com.macfeaster.blok._host.chapter04.club.ClubDemo
	 */
	public ClubDemo()
	{
		club = new Club();
		demo();
	}

	/**
	 * Add some members to the club, and then
	 * show how many there are.
	 * Further example calls could be added if more functionality
	 * is added to the Club class.
	 */
	public void demo()
	{
		club.join(new Membership("David", 2, 2004));
		club.join(new Membership("Michael", 1, 2004));
		System.out.println("The club has " +
						   club.numberOfMembers() +
						   " members.");

		List<String> months = Arrays.asList(
				"January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December");

		IntStream
				.range(1, months.size())
				.forEach(i -> System.out.printf("%d members joined in %s \n",
                        club.joinedInMonth(i), months.get(i)));

		System.out.println(
				club.purge(1, 2004).toString()
		);


	}
}
