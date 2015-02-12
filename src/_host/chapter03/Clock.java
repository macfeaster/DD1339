
/*
 * Clock.java
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

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Clock
{
	private JFrame frame;
	private JLabel label;
	private ClockDisplay clock;
	private boolean clockRunning = false;
	private TimerThread timerThread;

	public static void main(String[] args)
	{
		new Clock();
	}

	/**
	 * Constructor for objects of class Clock
	 */
	public Clock()
	{
		makeFrame();
		clock = new ClockDisplay();
	}

	/**
	 *
	 */
	private void start()
	{
		clockRunning = true;
		timerThread = new TimerThread();
		timerThread.start();
	}

	/**
	 *
	 */
	private void stop()
	{
		clockRunning = false;
	}

	/**
	 *
	 */
	private void step()
	{
		clock.timeTick();
		label.setText(clock.getTime());
	}


	/**
	 * Create the Swing frame and its content.
	 */
	private void makeFrame()
	{
		frame = new JFrame("Clock");
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

		// Specify the layout manager with nice spacing
		contentPane.setLayout(new BorderLayout(12, 12));

		// Create the image pane in the center
		label = new JLabel("00:00", SwingConstants.CENTER);
		Font displayFont = label.getFont().deriveFont(96.0f);
		label.setFont(displayFont);
		//imagePanel.setBorder(new EtchedBorder());
		contentPane.add(label, BorderLayout.CENTER);

		// Create the toolbar with the buttons
		JPanel toolbar = new JPanel();
		toolbar.setLayout(new GridLayout(1, 0));

		JButton startButton = new JButton("Start");
		startButton.addActionListener(e -> start());
		toolbar.add(startButton);

		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(e -> stop());
		toolbar.add(stopButton);

		JButton stepButton = new JButton("Step");
		stepButton.addActionListener(e -> step());
		toolbar.add(stepButton);

		// Add toolbar into panel with flow layout for spacing
		JPanel flow = new JPanel();
		flow.add(toolbar);

		contentPane.add(flow, BorderLayout.SOUTH);

		// building is done - arrange the components
		frame.pack();

		// place the frame at the center of the screen and show
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
		frame.setVisible(true);
	}

	class TimerThread extends Thread
	{
		public void run()
		{
			while (clockRunning) {
				step();
				pause();
			}
		}

		private void pause()
		{
			try {
				Thread.sleep(20);   // pause for 300 milliseconds
			}
			catch (InterruptedException exc) {
			}
		}
	}
}