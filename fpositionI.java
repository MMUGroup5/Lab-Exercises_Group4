
// @Override
// protected void paintComponent(Graphics g) {
//     super.paintComponent(g);
//     Graphics2D g2d = (Graphics2D) g;

//     for (ImageEntry entry : images) {
//         drawRotatedImage(g2d, entry);
//     }
// }
// // this the input parameters - graphichg2d -ImageEntry entry 
// // calculation the center point of image center x / half of the image width for split
// // this i use w3school to learn . 

// private void drawRotatedImage(Graphics2D g2d, ImageEntry entry) {
//     int imageWidth = entry.image.getIconWidth();
//     int imageHeight = entry.image.getIconHeight();
//     int centerX = entry.x + imageWidth / 2;
//     int centerY = entry.y + imageHeight / 2;

//     AffineTransform oldTransform = g2d.getTransform();
//     AffineTransform transform = new AffineTransform();
//     transform.rotate(entry.angle, centerX, centerY);
//     transform.translate(entry.x, entry.y);

//     g2d.setTransform(transform);
//     g2d.drawImage(entry.image.getImage(), 0, 0, this);
//     g2d.setTransform(oldTransform); // Reset the transform
// }
// }
