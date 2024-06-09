public void addAnimalImage(String filePath) {
        ImageIcon icon = new ImageIcon(filePath); // a class used to represent images in java - tutorialspoint
        if (icon.getIconWidth() == -1) { // this to check if the image succesfully loaded by verifying its width
            JOptionPane.showMessageDialog(this, "Image not found or unable to load: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
           return; // if the width is -1, then its invalid and will show the message dialog 
      }

        int xOffset = 5; // horizontal
        int yOffset = currentRow * icon.getIconHeight(); // vertical. 
        //each image is placed below the previous one
     
        images.add(new ImageEntry(icon, xOffset, yOffset));
        
        // Increment row only when both an animal and a flower are added
        if (images.size() % 2 == 0) {
            currentRow++;
        }
        
        repaint(); // the panel is repainted to reflect the newly added image
    }

