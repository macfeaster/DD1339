/*
 * AuctionDemo.java
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
 * Last modified 10/16/14 3:43 PM
 */

package _host.chapter04.auction;

import java.util.stream.IntStream;

public class AuctionDemo
{
	static Person bidder;
	static Person paris = new Person("Paris HilTon");
	static Person lindsay = new Person("Lindsay LoHan");
	static Auction auction = new Auction();

	public static void main(String[] args)
	{
		bidder = paris;

		auction.enterLot("Paris Hilton CaZa"); // Will be assigned #1
		auction.showLots();

		IntStream
				.of(2, 20, 200, 2000, 20000, 200000, 2000000, 20000000)
				.forEach(AuctionDemo::placeBid);

		System.out.println();

		auction.showLots();

		System.out.println();

		auction.close();
		System.out.println(
				auction.getUnsold().toString());

		auction.removeLot(1);

		System.out.println("Lots after removal:");

		auction.showLots();

		IntStream
				.of(2, 4, 5, 7, 81)
				.forEach(i -> System.out.println(i + " - " + isPrime(i)));

		double[] x = new double[60];
	}

	public static void placeBid(int bid)
	{
		bidder = (bidder.equals(paris)) ? lindsay : paris;
		auction.makeABid(1, bidder, bid);
	}

	/**
	 * Exercise 4.33
	 * @param n		Number to evaluate
	 * @return		True if prime
	 */
	public static boolean isPrime(int n)
	{
		// If less than 2 => not prime
		if (n < 2)
			return false;

		// If evenly divisible with any of 2...n-1 => not prime
		for (int i = 2; i < n - 1; i++)
			if (n % i == 0)
				return false;

		// If none of above are true => prime
		return true;
	}
}
