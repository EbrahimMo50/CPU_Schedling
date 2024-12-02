package GUIPack;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Panel extends JPanel{
    private int width = 1400;
    private int height = 600;
    private Color BGcolor=new Color(200,200,200);
    private Dimension frameSize = new Dimension(width,height+100);

    private List<ArrayList<Integer>> matrix;
    private int rawHeight;
    private int unitHeight;
    private int heightOffSet;
    private int unitWidth;

    public Panel(List<ArrayList<Integer>> matrix){
        System.out.println(matrix.get(0).size());
        System.out.println(matrix.size());
        unitWidth = (int)((width/matrix.get(0).size())*0.9);
        rawHeight = height/matrix.size();    //left 10 precent for the id of the process
        
        unitHeight = (int)(rawHeight*0.9);
        heightOffSet = (int)(rawHeight*0.1);

        this.matrix = matrix;
        setBackground(BGcolor);
        setPreferredSize(frameSize);
        repaint();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.PLAIN, (int)(12));
        g.setFont(font);
        g.drawString("---process graphical view---", (int)(width*0.01), (int)(height*0.08));
        for(int i = 0; matrix.size() > i; ++i){
            g.drawLine((int)(unitWidth*0.1) + 10, (i+1)*rawHeight - 5, (int)(unitWidth*0.1) + width - 200, (i+1)*rawHeight - 5); //left 200 for menu
            g.drawString(matrix.get(i).get(0).toString(),(int)(unitWidth*0.1), (i+1)*rawHeight);
            
        }
        g.setColor(Color.RED);
        for(int i = 0; matrix.size() > i ;++i){
            for(int j = 1; matrix.get(0).size() > j ;++j){
                if(matrix.get(i).get(j) == 1){
                    g.fillRect((int)((unitWidth * 0.2) + unitWidth*(j-1)), rawHeight*(i+1) - unitHeight/2 , unitWidth, unitHeight);
                }
            }
        }
    }
}
