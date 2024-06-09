public void addFlowerImage(String filePath) {
    ImageIcon icon = new ImageIcon(filePath);
    if (icon.getIconWidth() == -1) {
        JOptionPane.showMessageDialog(this, "Image not found or unable to load: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int xOffset = 200; // Offset by 200 pixels to place next to the animal image
    int yOffset = currentRow * icon.getIconHeight();

    images.add(new ImageEntry(icon, xOffset, yOffset));

    // Increment row only when both an animal and a flower are added
    if (images.size() % 2 == 0) {
        currentRow++;
    }

    repaint();
}