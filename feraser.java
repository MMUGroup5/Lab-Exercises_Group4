
public class bPanel extends JPanel {
    private BufferedImage canvas;
    private Graphics2D g2;
    private Color penColor;
    private int penSize;
    private double rotationAngle;
    private boolean eraserMode; // Flag for eraser mode

    public feraser() {
        canvas = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
        g2 = canvas.createGraphics();
        //DONT CHANGE THE BACKHROUND COLOUR//
        g2.setColor(Color.YELLOW);
        g2.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g2.setColor(Color.BLACK);
        penColor = Color.BLACK;
        penSize = 1;
        rotationAngle = 0;// Initialize rotation angle to 0
        eraserMode = false; // Initialize eraser mode to false
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
            g2.setColor(Color.YELLOW); // Set color to background color when erasing
        } else {
            g2.setColor(penColor);
        }
        g2.fillOval(x - penSize / 2, y - penSize / 2, penSize, penSize);
        repaint();
    }