import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javafx.scene.shape.Rectangle;

public class aPanel extends JPanel {
    private List<ImageEntry> images;// List to store the ImageEntry object 
    private int currentRow = 0;//set currentRow to 0

    private class ImageEntry {// For initial images, only accessible within aPanel class 
        ImageIcon image;
        int x, y;
        double angle;
        // JTable for Image Entry //https://www.geeksforgeeks.org/java-swing-jtable/ 


        ImageEntry(ImageIcon image, int x, int y) {
            this.image = image;
            this.x = x;
            this.y = y;
            this.angle = 0;
        }

        Rectangle getBounds() {
            return new Rectangle(x, y, image.getIconWidth(), image.getIconHeight());//provide a public methods to get the bounds of the image
        }
    }

     public aPanel() {
        images = new ArrayList<>();
        setPreferredSize(new Dimension(800, 800));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (ImageEntry entry : images) {
                    if (entry.getBounds().contains(e.getPoint())) {
                        entry.angle += Math.toRadians(45); // Rotate 45 degrees on each click
                        repaint();
                        return;
                    }
                }
            }
        });
    }
}
