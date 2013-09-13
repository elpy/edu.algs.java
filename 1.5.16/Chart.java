import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Chart extends JComponent{
    float x0 = 25, y0 = 540, dx = 0, dy = 0;
    int maxX = 0, maxY = 0;

    private ArrayList<Integer> Points = new ArrayList<Integer>();

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Scale();
        DrawAxes(g2);

        for (int i = 0; i < Points.size(); i++){
            g2.draw(new Ellipse2D.Float(x0 + (i + 1) * dx, y0 - Points.get(i) * dy, 2, 2));
        }
    }

    private void DrawAxes(Graphics2D g){
        g.drawString("0", x0 - 10, y0 + 5);
        g.drawString(String.valueOf(maxX), x0 + 510, y0 + 10);
        g.drawString(String.valueOf(maxY), x0 - 10, y0 - 510);

        Line2D x = new Line2D.Float(new Point2D.Double(x0, y0), new Point2D.Double(x0 + 505, y0));
        Line2D y = new Line2D.Float(new Point2D.Double(x0, y0), new Point2D.Double(x0, y0 - 505));
        g.draw(x);
        g.draw(y);
    }

    public void AddPoint(int y){
        Points.add(y);

        if (y > maxY)
            maxY = y;
    }

    private void Scale(){
        maxX = Points.size();
        dx = 500f / maxX;
        dy = 500f / maxY;
    }
}
