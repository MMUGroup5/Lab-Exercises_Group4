import javafx.scene.paint.Color;

public class penColor {
    
    public bPanel() {
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
    }
    
    public void setPenColor(Color newColor) {
        penColor = newColor;
    }

    public void setPenSize(int newSize) {
        penSize = newSize;
    }

}
