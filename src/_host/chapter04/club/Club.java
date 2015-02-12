/*
 * Club.java
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
 * Last modified 10/17/14 8:20 AM
 */

package _host.chapter04.club;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
	ArrayList<Membership> memberships;

	/**
	 * Exercise 4.40
	 * Constructor for objects of class Club
	 */
	public Club()
	{
		memberships = new ArrayList<>();
	}

	/**
	 * Add a new member to the club's list of members.
	 * @param member The member object to be added.
	 */
	public void join(Membership member)
	{
		memberships.add(member);
	}

	/**
	 * Exercise 4.42
	 * Determine the number of members who joined in the
	 * given month.
	 * @param month The month we are interested in.
	￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼4.14 Another example: an auction system | 137
	 * @return The number of members who joined in that month.
	 */
	public int joinedInMonth(int month)
	{
		if (month < 1 || month > 12)
		{
			System.out.println("Month not within valid range.");
			return 0;
		}

		int i = 0;

		// Do it the Java 7 way
		for (Membership m : memberships)
            if (m.getMonth() == month)
                i++;

		// ... or the Java 8 way
		i = (int) memberships
				.stream()
				.filter(m -> m.getMonth() == month)
				.count();

		return i;
	}

	/**
	 * Remove from the club's collection all members who
	 * joined in the given month, and return them stored
	 * in a separate collection object.
	 * @param month The month of the membership.
	 * @param year The year of the membership.
	 * @return The members who joined in the given month and year.
	 */
	public ArrayList<Membership> purge(int month, int year)
	{
		ArrayList<Membership> forked = new ArrayList<>();
        Iterator<Membership> it = memberships.iterator();

        // We have to use an Iterator here to avoid ConcurrentModificationException
        while (it.hasNext())
        {
            Membership m = it.next();

            if (m.getYear() == year && m.getMonth() == month)
            {
                forked.add(m);
                it.remove();
            }
        }

		return forked;
	}

	/**
	 * Exercise 4.41
	 *
	 * @return The number of members (com.macfeaster.blok._host.chapter04.club.Membership objects) in
	 *         the club.
	 */
	public int numberOfMembers() { return memberships.size(); }
}
