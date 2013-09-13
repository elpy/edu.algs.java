import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Chart extends JComponent{
    private ArrayList<Integer> Points = new ArrayList<Integer>();

    public void paintComponent(Graphics g){
	Graphics2D g2 = (Graphics2D)g;
	int dx = 15, dy = 550;

	Line2D x = new Line2D.Float(new Point2D.Double(dx + 0, dy + 0), new Point2D.Double(dx + 0, dy - 530));
	Line2D y = new Line2D.Float(new Point2D.Double(dx + 0, dy + 0), new Point2D.Double(dx + 765, dy + 0));	
	g2.draw(x);
	g2.draw(y);					

	for (int i = 0; i < Points.size(); i++){
	    g2.draw(new Ellipse2D.Float(i * 10, Points.get(i) * 10, 2, 2));	
	}
    } 

    public void AddPoint(int y){
	Points.add(y);
    }
}
