/*
 * NumberDisplay12Hr.java
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
 * Last modified 10/15/14 1:04 PM
 */

package _host.chapter03;

public class NumberDisplay12Hr
{
    private int value = 1;

    public int getValue() { return value; }

    /**
     * Increment the display value by one, rolling over to zero if the limit is reached.
     */
    public void increment()
    {
        value++;
        if (value == 13)
            value = 1;
    }

    public void setValue(int replacementValue)
    {
        if(replacementValue >= 1 && replacementValue < 13) {
            value = replacementValue;
        }
    }
}