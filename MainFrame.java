import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JSplitPane splitPane;
    private aPanel leftCanvas;
    private bPanel rightCanvas;
    private JToolBar toolBar;

    public MainFrame() {
        setTitle("Drawing Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        leftCanvas = new aPanel();
        rightCanvas = new bPanel();

        splitPane.setLeftComponent(new JScrollPane(leftCanvas));
        splitPane.setRightComponent(new JScrollPane(rightCanvas));

        toolBar = new JToolBar();
        addToolBarButtons(toolBar);

        add(toolBar, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);
    }

    private void addToolBarButtons(JToolBar toolBar) {
        JButton addAnimalButton = new JButton("Add Animal");
        addAnimalButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();
                leftCanvas.addAnimalImage(filePath);
            }
        });
        toolBar.add(addAnimalButton);

        JButton addFlowerButton = new JButton("Add Flower");
        addFlowerButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();
                leftCanvas.addFlowerImage(filePath);
            }
        });
        toolBar.add(addFlowerButton);

        JButton penColorButton = new JButton("Pen Colour");
        penColorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(this, "Choose Pen Colour", Color.BLACK);
            if (newColor != null) {
                rightCanvas.setPenColor(newColor);
            }
        });
        toolBar.add(penColorButton);

        JButton penSizeButton = new JButton("Pen Size");
        penSizeButton.addActionListener(e -> {
            String size = JOptionPane.showInputDialog(this, "Enter Pen Size:", "1");
            if (size != null) {
                try {
                    int newSize = Integer.parseInt(size);
                    rightCanvas.setPenSize(newSize);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid size!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        toolBar.add(penSizeButton);

        JButton eraserButton = new JButton("Eraser");
        eraserButton.addActionListener(e -> rightCanvas.setEraserMode(true));
        toolBar.add(eraserButton);

        JButton penButton = new JButton("Pen");
        penButton.addActionListener(e -> rightCanvas.setEraserMode(false));
        toolBar.add(penButton);

        JButton saveButton = new JButton("Save Drawing");
        saveButton.addActionListener(e -> rightCanvas.saveDrawing());
        toolBar.add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
