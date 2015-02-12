/*
 * lab3.Person.java
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
 * Last modified 10/16/14 10:37 AM
 */

package _host.chapter04.auction;

/**
 * Maintain details of someone who participates in an auction.
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Person
{
    // The name of this person.
    private final String name;

    /**
     * Create a new person with the given name.
     * @param name The person's name.
     */
    public Person(String name)
    {
        this.name = name;
    }

    /**
     * @return The person's name.
     */
    public String getName()
    {
        return name;
    }
}
