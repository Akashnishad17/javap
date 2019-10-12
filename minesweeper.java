import java.awt.*;  
import javax.swing.*;  
public class minesweeper
{  
	JFrame f;  
	minesweeper()
	{  
	    f=new JFrame();
	    int i;
	    JButton[] top = new JButton[100];
	    JButton[] down = new JButton[100];
	    for(i=0;i<100;i++)
	    {
	    	top[i] = new JButton("Top");
	    	down[i] = new JButton("Down");
	    }
	    for(i=0;i<100;i++)
	    {
	    	f.add(top[i]);
	    	//f.add(down[i]);
	    }
	    f.setLayout(new GridLayout(10,10));    	     
	    f.setSize(1000,1000);  
	    f.setVisible(true);  
	}  
	public static void main(String[] args)
	{  
	    new minesweeper();  
	}  
}  