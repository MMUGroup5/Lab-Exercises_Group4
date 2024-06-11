import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DrawCanvasPanel extends JPanel {
    private BufferedImage canvas;
    private Graphics2D g2;
    private Color penColor;
    private int penSize;
    private double rotationAngle;
    private boolean eraserMode;

    public DrawCanvasPanel() {
        canvas = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
        g2 = canvas.createGraphics();
        g2.setColor(Color.YELLOW);
        g2.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g2.setColor(Color.BLACK);
        penColor = Color.BLACK;
        penSize = 1;
        rotationAngle = 0;
        eraserMode = false;
        setPreferredSize(new Dimension(600, 600));
        setDoubleBuffered(false);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                draw(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                draw(e.getX(), e.getY());
            }
        });
    }

    private void draw(int x, int y) {
        if (eraserMode) {
            g2.setColor(Color.YELLOW);
        } else {
            g2.setColor(penColor);
        }
        g2.fillOval(x - penSize / 2, y - penSize / 2, penSize, penSize);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.rotate(rotationAngle, getWidth() / 2.0, getHeight() / 2.0);
        g2d.drawImage(canvas, 0, 0, null);
        g2d.dispose();
    }
}
