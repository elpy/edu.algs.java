import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.swing.JComponent;

public class RandomGridComponent extends JComponent {
	
	protected int N;
	protected int x0, y0;
	protected float dx, dy;
	private final int LENGTH = 800;
	private final int BORDER = 100;
	private ArrayList<Connection> Connections;
	private Object LockMe;
	
	public RandomGridComponent(int n){
		N = n;
		LockMe = new Object();
		Connections = new ArrayList<Connection>();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Scale();
		DrawGrid((Graphics2D)g);
		
		synchronized (LockMe) {
			for(Connection connection : Connections)
				DrawConnection(connection, (Graphics2D)g);
		}
		
		super.paintComponent(g);
	}
	
	public void test(){
		new Thread(){
			@Override
			public void run() {
				RandomBag<Connection> connections = RandomGrid.Generate(N);
				
				for(Connection connection : connections){
					synchronized (LockMe) {
						Connections.add(connection);
					}		
					
					repaint();
					
					try{
						Thread.sleep(70);
					} catch (InterruptedException e){
						//do nothing
					}
				}
			};
		}.start();
	}
	
	protected void DrawConnection(Connection connection, Graphics2D g){
		Line2D edge = new Line2D.Float(GetPoint(connection.GetQ()), GetPoint(connection.GetP()));
		g.draw(edge);
	}
	
	protected Point2D GetPoint(int position){
		int x = position % N;
		int y = position / N;
					
		return new Point2D.Float(x0 + dx * x, y0 - dy * y);		
	}
	
	protected void DrawGrid(Graphics2D g){
		for (int i = 0; i != N; i++){
			for (int j = 0; j != N; j++){
				g.draw(new Ellipse2D.Float(x0 + i * dx - 2, y0 - j * dy - 2, 4f, 4f));
			}
		}
	}
	
	protected void Scale(){
		x0 = BORDER;
		y0 = LENGTH - BORDER;
		dx = dy = (LENGTH - 2f * BORDER) / N;	
	}
}