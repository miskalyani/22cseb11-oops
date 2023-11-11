import javax.swing.*;
import java.awt.*;

public class CirclePathPlotter extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int CENTER_X = WIDTH / 2;
    private static final int CENTER_Y = HEIGHT / 2;
    private static final int LARGE_CIRCLE_RADIUS = 200;
    private static final int SMALL_CIRCLE_RADIUS = 20;

    private double angle = 0;

    public CirclePathPlotter() {
        setTitle("Circle Path Plotter");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.toRadians(2); // Increment angle for circular motion
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawCircles(g);
    }

    private void drawCircles(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(CENTER_X - LARGE_CIRCLE_RADIUS, CENTER_Y - LARGE_CIRCLE_RADIUS,
                2 * LARGE_CIRCLE_RADIUS, 2 * LARGE_CIRCLE_RADIUS);
        int smallCircleX = CENTER_X + (int) (LARGE_CIRCLE_RADIUS * Math.cos(angle)) - SMALL_CIRCLE_RADIUS;
        int smallCircleY = CENTER_Y + (int) (LARGE_CIRCLE_RADIUS * Math.sin(angle)) - SMALL_CIRCLE_RADIUS;
        g.setColor(Color.RED);
        g.fillOval(smallCircleX, smallCircleY, 2 * SMALL_CIRCLE_RADIUS, 2 * SMALL_CIRCLE_RADIUS);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CirclePathPlotter().setVisible(true);
            }
        });
    }
}
