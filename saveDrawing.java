    // to save the drawing in visual code directly.
    public void saveDrawing() {
        try {
            ImageIO.write(canvas, "PNG", new File("drawing.png"));
            JOptionPane.showMessageDialog(this, "Drawing saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving drawing!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}