package _host.bouncingballs;

import java.awt.*;
import java.util.Random;

public class BoxBall
{
    private Color color;
    private int diameter;
    private int x;
    private int y;
    private final int boxTop;
    private final int boxLeft;
    private final int width;
    private final int height;      // y position of ground
    private Canvas canvas;
    private int ySpeed;                // initial downward speed
    private int xSpeed;

    public static final double TOLERANCE = 0.001;
    private static final int PASS = 40;
    public static final char HELP = 'h';

    /**
     * Constructor for objects of class BouncingBall
     * Exercise 5.65
     *
     * @param x  the horizontal coordinate of the ball
     * @param y  the vertical coordinate of the ball
     * @param diameter  the diameter (in pixels) of the ball
     * @param color  the color of the ball
     * @param boxHeight  the position of the ground (where the wall will bounce)
     * @param canvas  the canvas to draw this ball on
     */
    public BoxBall(int x, int y, int boxLeft, int boxTop, int boxWidth, int boxHeight, int diameter, Color color, Canvas canvas)
    {
        Random r = new Random();
        this.x = x;
        this.y = y;
        this.boxLeft = boxLeft;
        this.boxTop = boxTop;
        this.color = color;
        this.diameter = diameter;
        this.width = boxWidth;
        this.height = boxHeight;
        this.canvas = canvas;
        this.xSpeed = r.nextInt(15) + 5;
        this.ySpeed = r.nextInt(15) + 5;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(x, y, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase() { canvas.eraseCircle(x, y, diameter); }

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();

        y += ySpeed;
        x += xSpeed;

        // Check collision with top
        if (y <= boxTop && ySpeed < 0)
        {
            y = boxTop;
            ySpeed = -ySpeed;
        }

        // Check collision with left
        if (x <= boxLeft && xSpeed < 0)
        {
            x = boxLeft;
            xSpeed = -xSpeed;
        }

        // Check collision with bottom
        if (y >= height + boxTop - diameter && ySpeed > 0)
        {
            y = height + boxTop - diameter;
            ySpeed = -ySpeed;
        }

        // Check collision with right
        if (x >= width + boxLeft - diameter && xSpeed > 0)
        {
            x = width + boxLeft - diameter;
            xSpeed = -xSpeed;
        }


        // draw again at new position
        draw();
    }    

    public int getXPosition() { return x; }
    public int getYPosition() { return y; }
}
