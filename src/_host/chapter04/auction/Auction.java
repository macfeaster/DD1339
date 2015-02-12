/*
 * Auction.java
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
 * Last modified 10/16/14 3:00 PM
 */

package _host.chapter04.auction;

import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Auction
{
	// The list of Lots in this auction.
	private ArrayList<Lot> lots;
	// The number that will be given to the next lot entered
	// into this auction.
	private int nextLotNumber;

	/**
	 * Create a new auction.
	 */
	public Auction()
	{
		lots = new ArrayList<>();
		nextLotNumber = 1;
	}

	/**
	 * Enter a new lot into the auction.
	 * @param description A description of the lot.
	 */
	public void enterLot(String description)
	{
		lots.add(new Lot(nextLotNumber, description));
		nextLotNumber++;
	}

	/**
	 * Show the full list of lots in this auction.
	 */
	public void showLots()
	{
		for(Lot lot : lots) {
			System.out.println(lot.toString());
		}
	}

	/**
	 * Make a bid for a lot.
	 * A message is printed indicating whether the bid is
	 * successful or not.
	 *
	 * @param lotNumber The lot being bid for.
	 * @param bidder The person bidding for the lot.
	 * @param value  The value of the bid.
	 */
	public void makeABid(int lotNumber, Person bidder, long value)
	{
		Lot selectedLot = getLot(lotNumber);
		if(selectedLot != null) {
			Bid bid = new Bid(bidder, value);
			boolean successful = selectedLot.bidFor(bid);
			if(successful) {
				System.out.println("The bid for lot number " +
								   lotNumber + " was successful.");
			}
			else {
				// Report which bid is higher.
				Bid highestBid = selectedLot.getHighestBid();
				System.out.println("Lot number: " + lotNumber +
								   " already has a bid of: " +
								   highestBid.getValue());
			}
		}
	}

	/**
	 * Exercise 4.51
	 *
	 * Return the lot with the given number. Return null
	 * if a lot with this number does not exist.
	 * @param number The number of the lot to return.
	 */
	public Lot getLot(int number)
	{
		for (Lot lot : lots)
			if (lot.getNumber() == number)
				return lot;

		return null;
	}

	/**
	 * Exercise 4.48
	 */
	public void close()
	{
		for (Lot lot : lots)
		{
			Bid bid = lot.getHighestBid();

			if (bid != null)
				System.out.printf("Auction for lot %s won by %s for $%d! \n",
						lot.getDescription(), bid.getBidder().getName(), bid.getValue());
			else
				System.out.printf("Lot %s have no bids. \n", lot.getDescription());
		}
	}

	/**
	 * Exercise 4.49
	 * @return	Unsold lots
	 */
	public ArrayList<Lot> getUnsold()
	{
		ArrayList<Lot> unsold = new ArrayList<>();

        // Get all the unsold lots
		for (Lot lot : lots)
			if (lot.getHighestBid() == null)
				unsold.add(lot);

        return unsold;
	}

    /**
	 * Exercise 4.52
	 *
     * Remove the lot with the given lot number.
     * @param number The number of the lot to be removed.
     * @return The Lot with the given number, or null if
     * there is no such lot.
     */
    public Lot removeLot(int number)
    {
        for (Lot lot : lots)
            if (lot.getNumber() == number)
            {
                lots.remove(lot);
                return lot;
            }

        return null;
    }
}