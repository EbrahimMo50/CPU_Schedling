package GUIPack;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel{
    private int height = 1600;
    private int width = 800;
    private Color BGcolor=new Color(200,200,200);
    private Dimension frameSize = new Dimension(height,width);


    public Panel(){
        setBackground(BGcolor);
        setPreferredSize(frameSize);
        repaint();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawString("15",100,100);
        g.fillRect(20, 0, 50, 50);
    }
}
