import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Client{
	public static void main(String[] args){		
		
		if (args.length == 0){
			System.out.println("Use command line to enter N. \nLeaving.");
			return;
		}
       	    	  
		int param = 0; 
       	    	  
		try{
			param = (int)Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e){
			System.out.println("Invalid argument: " + args[0]);
			return;
		}
		
		final int n = param;
		
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("RandomGrid");
				frame.setSize(800, 800);
				RandomGridComponent component = new RandomGridComponent(n);
				frame.add(component);
				frame.setVisible(true);
				component.test();

			};
		});
		
		return;
	}	
}