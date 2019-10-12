class NavigationShip
{
	int[] ParsecKey = new int[5];
	int[][] QuadrantKey = new int[5][5];
	void plotCourse(int[] k1, int[][] k2)
	{
		int i,j;
		System.out.println("Stroring the code in ParsecKey...");
		for(i=0;i<5;i++)
			ParsecKey[i]=k1[i];
		System.out.println("Stroring the code in QuadrantKey...");
		for(i=0;i<5;i++)
		{
			for(j=0;j<5;j++)
				QuadrantKey[i][j]=k2[i][j];
		}
	}
	void virusChecker() // considering 0 as virus element
	{
		int i,j,virus=0;
		System.out.println("\nChecking for virus...");
		for(i=0;i<5;i++)
		{
			if(ParsecKey[i]==0)
			{
				virus=1;
				break;
			}
		}
		if(virus==0)
			System.out.println("No virus in the code in 1D array");
		else
			System.out.println("Virus found in the code");

		for(i=0;i<5;i++)
		{
			for(j=0;j<5;j++)
			{
				if(QuadrantKey[i][j]==0)
				{
					virus=1;
					break;
				}
			}
		}
		if(virus==0)
			System.out.println("No virus in the code in 2D array");
		else
			System.out.println("Virus found in the code");
	}
	void navSim()
	{
		int i,j;
		System.out.print("\nNavSim Output: ");
		for(i=0;i<5;i++)
			System.out.print(ParsecKey[i]+" ");
		for(i=0;i<5;i++)
		{
			for(j=0;j<5;j++)
				System.out.print(QuadrantKey[i][j]+" ");
		}
	}
}

//This linearKey and Quadkey code is fixed can not be altered byt aliens
//But the code stored on NavigationShip can be altered by aliens' virus
class LinearKey
{
	int[] q = new int[5];
	void setKey()
	{
		int i;
		for(i=0;i<5;i++)
			q[i]=i+1;
	}
}
class QuadKey
{
	int[][] q = new int[5][5];
	void setKey()
	{
		int i,j;
		for(i=0;i<5;i++)
		{
			for(j=0;j<5;j++)
				q[i][j]=(i+1)*(j+1);
		}
	}
}
class ship
{
	public static void main(String[] args)
	{
		NavigationShip ns = new NavigationShip();
		//creating two object reference variable to remove the problem of Ensign, what Captain wants to tell
		LinearKey q1 = new LinearKey();	//Refrencing to linear key
		QuadKey q2 = new QuadKey();		//Referencing to quadratic key
		q1.setKey();
		q2.setKey();
		ns.plotCourse(q1.q,q2.q);
		ns.virusChecker();
		ns.navSim();
		ns.virusChecker();
	}
}