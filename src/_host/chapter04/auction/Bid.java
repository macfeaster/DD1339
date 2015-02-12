/*
 * Bid.java
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
 * A class that models an auction bid.
 * It contains a reference to the lab3.Person bidding and the amount bid.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Bid
{
    // The person making the bid.
    private final Person bidder;
    // The value of the bid. This could be a large number so
    // the long type has been used.
    private final long value;

    /**
     * Create a bid.
     * @param bidder Who is bidding for the lot.
     * @param value The value of the bid.
     */
    public Bid(Person bidder, long value)
    {
        this.bidder = bidder;
        this.value = value;
    }

    /**
     * @return The bidder.
     */
    public Person getBidder()
    {
        return bidder;
    }

    /**
     * @return The value of the bid.
     */
    public long getValue()
    {
        return value;
    }
}
