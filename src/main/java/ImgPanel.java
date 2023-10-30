import javax.swing.*;
import java.awt.image.BufferedImage;

public class ImgPanel extends JPanel {
    private static BufferedImage img;

    public void setImage(BufferedImage img) {
        this.img = img;
        repaint();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
        if (img != null){
            g.drawImage(img,0,0,this);
        }
    }
}
