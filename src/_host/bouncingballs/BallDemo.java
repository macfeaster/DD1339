package _host.bouncingballs;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BallDemo   
{
    private Canvas myCanvas;
    private int boxLeft = 50;
    private int boxTop = 50;
    private int boxWidth = 550;
    private int boxHeight = 450;

    private Random r = new Random();
    private Set<BouncingBall> balls = new HashSet<>();
    private Set<BoxBall> boxBalls = new HashSet<>();

    public static void main(String[] args) { new BallDemo(); }

    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", boxWidth + boxLeft * 2, boxHeight + boxTop * 2);
        bounceBox(50);
    }

    /**
     * Exercise 5.65
     */
    public void bounceBox(int amount)
    {
        myCanvas.setVisible(true);
        myCanvas.draw(new Rectangle(boxLeft, boxTop, boxWidth, boxHeight));

        for (int i = 0; i < amount; i++)
        {
            int xPos = boxLeft + r.nextInt(boxWidth);
            int yPos = boxTop + r.nextInt(boxHeight);
            int diameter = 10 + r.nextInt(20);

            boxBalls.add(new BoxBall(xPos, yPos,
                    boxLeft, boxTop, boxWidth, boxHeight, diameter,
                    new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()), myCanvas));
        }

        while(true) // make them bounce forever!
        {
            myCanvas.wait(25); // small delay
            for (BoxBall ball : boxBalls)
                ball.move();
        }
    }

    /**
     * Exercise 5.62
     * @param amount    Amount of balls
     */
    public void bounce(int amount)
    {
        int ground = 400;   // position of the ground line
        myCanvas.setVisible(true);
        myCanvas.drawLine(50, ground, 550, ground);
        Random r = new Random();

        for (int i = 0; i < amount; i++)
        {
            int xPos = r.nextInt((int) myCanvas.getSize().getWidth());
            int yPos = r.nextInt((int) myCanvas.getSize().getHeight() / 2);
            int diameter = 10 + r.nextInt(20);

            balls.add(new BouncingBall(xPos, yPos, diameter,
                    new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()), ground, myCanvas));
        }

        // make them bounce
        boolean finished =  false;
        while(!finished)
        {
            myCanvas.wait(25);

            for (BouncingBall b : balls)
            {
                b.move();
                if(b.getXPosition() >= 550)
                    finished = true;
            }
        }
    }
}
