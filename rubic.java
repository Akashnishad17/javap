import java.io.*;
import java.util.*;

class Cube{
	private int[][] front, back, top, down, left, right;
	public Cube()
	{
		front = new int[3][3];		// 0 blue
		back = new int[3][3];		// 1 green
		top = new int[3][3];		// 2 white
		down = new int[3][3];		// 3 yellow
		left = new int[3][3];		// 4 red
		right = new int[3][3];		// 5 orange
		
		for(int i = 0; i < 3; i++)
		{
			Arrays.fill(back[i], 1);
			Arrays.fill(top[i], 2);
			Arrays.fill(down[i], 3);
			Arrays.fill(left[i], 4);
			Arrays.fill(right[i], 5);
		}
	}
	public Cube(int x)
	{
		front = new int[][] {{5,5,4},{5,0,4},{5,4,4}};
		back = new int[][] {{5,5,4},{5,1,4},{5,4,4}};
		top = new int[][] {{2,2,2},{1,2,0},{2,2,2}};
		down = new int[][] {{3,3,3},{0,3,1},{3,3,3}};
		left = new int[][] {{1,3,0},{1,4,0},{1,2,0}};
		right = new int[][] {{0,3,1},{0,5,1},{0,2,1}};
	}

	public void displayCube()
	{
		for(int i = 0; i < 3; i++)
		{
			System.out.print("       ");
			for(int j = 0; j < 3; j++)
				System.out.print(back[i][j]+" ");
			System.out.println("");
		}
		System.out.println("");
		for(int i = 0; i < 3; i++)
		{
			System.out.print("       ");
			for(int j = 0; j < 3; j++)
				System.out.print(top[i][j]+" ");
			System.out.println("");
		}
		System.out.println("");
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
				System.out.print(left[i][j]+" ");
			System.out.print(" ");
			for(int j = 0; j < 3; j++)
				System.out.print(front[i][j]+" ");
			System.out.print(" ");
			for(int j = 0; j < 3; j++)
				System.out.print(right[i][j]+" ");
			System.out.println("");
		}
		System.out.println("");
		for(int i = 0; i < 3; i++)
		{
			System.out.print("       ");
			for(int j = 0; j < 3; j++)
				System.out.print(down[i][j]+" ");
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
	}

	public void antiClockFront()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = front[i][j];
				front[i][j] = front[j][i];
				front[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = front[0][i];
			front[0][i] = front[2][i];
			front[2][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[3-i-1][2];
			left[3-i-1][2] = top[2][i];
			top[2][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = top[2][i];
			top[2][i] = right[i][0];
			right[i][0] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = right[i][0];
			right[i][0] = down[0][3-i-1];
			down[0][3-i-1] = temp;
		}
	}
	public void clockFront()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = front[i][j];
				front[i][j] = front[j][i];
				front[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = front[i][0];
			front[i][0] = front[i][2];
			front[i][2] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = right[i][0];
			right[i][0] = down[0][3-i-1];
			down[0][3-i-1] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = top[2][i];
			top[2][i] = right[i][0];
			right[i][0] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[3-i-1][2];
			left[3-i-1][2] = top[2][i];
			top[2][i] = temp;
		}
	}

	public void clockBack()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = back[i][j];
				back[i][j] = back[j][i];
				back[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = back[i][0];
			back[i][0] = back[i][2];
			back[i][2] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[3-i-1][0];
			left[3-i-1][0] = top[0][i];
			top[0][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = top[0][i];
			top[0][i] = right[i][2];
			right[i][2] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = right[i][2];
			right[i][2] = down[2][3-i-1];
			down[2][3-i-1] = temp;
		}
	}

	public void antiClockBack()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = back[i][j];
				back[i][j] = back[j][i];
				back[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = back[0][i];
			back[0][i] = back[2][i];
			back[2][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = right[i][2];
			right[i][2] = down[2][3-i-1];
			down[2][3-i-1] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = top[0][i];
			top[0][i] = right[i][2];
			right[i][2] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[3-i-1][0];
			left[3-i-1][0] = top[0][i];
			top[0][i] = temp;
		}
	}

	public void antiClockTop()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = top[i][j];
				top[i][j] = top[j][i];
				top[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = top[0][i];
			top[0][i] = top[2][i];
			top[2][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = right[0][i];
			right[0][i] = front[0][i];
			front[0][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[0][i];
			left[0][i] = front[0][i];
			front[0][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[0][i];
			left[0][i] = back[2][3-i-1];
			back[2][3-i-1] = temp;
		}
	}

	public void clockTop()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = top[i][j];
				top[i][j] = top[j][i];
				top[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = top[i][0];
			top[i][0] = top[i][2];
			top[i][2] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[0][i];
			left[0][i] = back[2][3-i-1];
			back[2][3-i-1] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[0][i];
			left[0][i] = front[0][i];
			front[0][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = right[0][i];
			right[0][i] = front[0][i];
			front[0][i] = temp;
		}
	}

	public void clockDown()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = down[i][j];
				down[i][j] = down[j][i];
				down[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = down[i][0];
			down[i][0] = down[i][2];
			down[i][2] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = right[2][i];
			right[2][i] = front[2][i];
			front[2][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[2][i];
			left[2][i] = front[2][i];
			front[2][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[2][i];
			left[2][i] = back[0][3-i-1];
			back[0][3-i-1] = temp;
		}
	}

	public void antiClockDown()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = down[i][j];
				down[i][j] = down[j][i];
				down[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = down[0][i];
			down[0][i] = down[2][i];
			down[2][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[2][i];
			left[2][i] = back[0][3-i-1];
			back[0][3-i-1] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = left[2][i];
			left[2][i] = front[2][i];
			front[2][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = right[2][i];
			right[2][i] = front[2][i];
			front[2][i] = temp;
		}
	}

	public void antiClockLeft()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = left[i][j];
				left[i][j] = left[j][i];
				left[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = left[0][i];
			left[0][i] = left[2][i];
			left[2][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = back[i][0];
			back[i][0] = top[i][0];
			top[i][0] = front[i][0];
			front[i][0] = down[i][0];
			down[i][0] = temp;
		}
	}

	public void clockLeft()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = left[i][j];
				left[i][j] = left[j][i];
				left[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = left[i][0];
			left[i][0] = left[i][2];
			left[i][2] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = down[i][0];
			down[i][0] = front[i][0];
			front[i][0] = top[i][0];
			top[i][0] = back[i][0];
			back[i][0] = temp;
		}
	}

	public void antiClockRight()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = right[i][j];
				right[i][j] = right[j][i];
				right[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = right[0][i];
			right[0][i] = right[2][i];
			right[2][i] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = down[i][2];
			down[i][2] = front[i][2];
			front[i][2] = top[i][2];
			top[i][2] = back[i][2];
			back[i][2] = temp;
		}
	}

	public void clockRight()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				int temp = right[i][j];
				right[i][j] = right[j][i];
				right[j][i] = temp;
			}
		}	
		for(int i = 0; i < 3; i++)
		{
			int temp = right[i][0];
			right[i][0] = right[i][2];
			right[i][2] = temp;
		}

		for(int i = 0; i < 3; i++)
		{
			int temp = back[i][2];
			back[i][2] = top[i][2];
			top[i][2] = front[i][2];
			front[i][2] = down[i][2];
			down[i][2] = temp;
		}
	}

	public boolean solved()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(front[i][j] != 0 || back[i][j] != 1 || top[i][j] != 2 || down[i][j] != 3 || left[i][j] != 4 || right[i][j] != 5)
					return false;
			}
		}
		return true;
	}
}
public class rubic{
	public static void main(String[] args)
	{
		Cube cube = new Cube(0);

		/*
		cube.antiClockFront();
		cube.clockFront();
		
		cube.antiClockBack();
		cube.clockBack();

		cube.antiClockTop();
		cube.clockTop();
		
		cube.antiClockDown();
		cube.clockDown();

		cube.antiClockLeft();
		cube.clockLeft();
		
		cube.antiClockRight();
		cube.clockRight();
		*/

		cube.antiClockRight();
		cube.antiClockLeft();
		cube.antiClockDown();
		cube.antiClockTop();
		cube.clockBack();
		cube.clockFront();

		cube.displayCube();
	}
}