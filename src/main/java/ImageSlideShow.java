import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ImageSlideShow extends JFrame {
    private static ImgPanel imgPanel;
    private static Timer timer;
    private static int current;
    private static ArrayList<String> imgURLS;
    public ImageSlideShow (ArrayList<String> urls){
        //super();
        this.imgURLS = urls;
        current = 0;

//        JPanel loading = new JPanel(){
//            @Override
//            protected void paintComponent(Graphics g){
//                super.paintComponent(g);
//                g.setFont(new Font("Arial", Font.BOLD, 24));
//                g.setColor(Color.BLACK);
//                String frase = "Cargando...";
//                FontMetrics metrics = g.getFontMetrics();
//                int x = (getWidth() - metrics.stringWidth(frase)) / 2;
//                int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
//                g.drawString(frase, x, y);
//            }
//        };
//        add(loading);

        imgPanel = new ImgPanel();
        add(imgPanel);
        imgPanel.setVisible(false);
        long time = System.currentTimeMillis();
        timer = new Timer(15000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (time< 15000){

                }
                else if (current < imgURLS.size()){
                    try{
                        URL imgURL = new URL(imgURLS.get(current));
                        BufferedImage brImage = ImageIO.read(imgURL);
                        imgPanel.setImage(brImage);
                        setPreferredSize(new java.awt.Dimension(brImage.getWidth(),brImage.getHeight()));
                        pack();
                        imgPanel.setVisible(true);
                        current++;
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
                }else {
                    //timer.stop();
                    current=0;
                }
            }
        });
        timer.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
