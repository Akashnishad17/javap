import java.util.Random;
class card
{
	static Object[][] cardset = new Object[52][2];
	static
	{
		int i,j=1;
		for(i=0;i<52;i++)
		{
			if(i<13)
				cardset[i][0] = new String("Heart");
			if(i>=13 && i<26)
				cardset[i][0] = new String("Spade");
			if(i>=26 && i<39)
				cardset[i][0] = new String("Club");
			if(i>=39 && i<52)
				cardset[i][0] = new String("Diamond");
			
			if(j<=13)
			{
				cardset[i][1] = new Integer(j);
				j++;
				if(j==14)
					j=1;
			}
		}
	}
}
class cardpick extends card
{
	static boolean picking;
	static Random r = new Random();
	static int[] picked = new int[52];
	static int cardnum, num;
	static
	{
		int i;
		for(i=0;i<52;i++)
			picked[i]=0;
	}
	static int cardpicked()
	{
		picking=false;
		while(!picking)
		{
			cardnum=r.nextInt(cardset.length);
			if(picked[cardnum]==0)
				picking=true;
		}
		picked[cardnum]=1;
		/*if(cardset[cardnum][0]=="Heart")
			num=0;
		if(cardset[cardnum][0]=="Spade")
			num=1;
		if(cardset[cardnum][0]=="Club")
			num=2;
		if(cardset[cardnum][0]=="Diamond")
			num=3;*/
		if(cardnum<13)
				num=0;
		if(cardnum>=13 && cardnum<26)
				num=1;
		if(cardnum>=26 && cardnum<39)
				num=2;
		if(cardnum>=39 && cardnum<52)
				num=3;
		System.out.println(cardnum+","+num);
		return num;
	}
}
class player1 extends Thread
{ 
	static boolean exit=false,run=true;
	static int suitcount[] = {0,0,0,0};
	static int index;
	public void run()
	{
		while(!exit)
		{
			if(run)
			{
				if(gamecheck.gameend()!=0)
				{
					exit=true;
					player2.exit=true;
					run=false;
					player1.run=false;
					break;
				}
				try
				{
					index=cardpick.cardpicked();
					suitcount[index]+=1;
					System.out.println("Player 1, Heart: "+suitcount[0]+" Spade: "+suitcount[1]+" Club: "+suitcount[2]+" Diamond: "+suitcount[3]);
					Thread.sleep(500);
				}
				catch(InterruptedException e)
				{
					System.out.println(e);
				}	
			}		
		}
	}
}
class player2 extends Thread
{ 
	static boolean exit=false,run=true;
	static int suitcount[] = {0,0,0,0};
	static int index;
	public void run()
	{
		while(!exit)
		{
			if(run)
			{
				if(gamecheck.gameend()!=0)
				{
					player1.exit=true;
					exit=true;
					run=false;
					player1.run=false;
					break;
				}
				try
				{
					index=cardpick.cardpicked();
					suitcount[index]+=1;
					System.out.println("Player 2, Heart: "+suitcount[0]+" Spade: "+suitcount[1]+" Club: "+suitcount[2]+" Diamond: "+suitcount[3]);
					Thread.sleep(500);
				}
				catch(InterruptedException e)
				{
					System.out.println(e);
				}
			}
		}
	} 
}
class gamecheck
{
	static int gameend()
	{
		int i,win=0;
		for(i=0;i<4;i++)
		{
			if(player1.suitcount[i]==4)
			{
				win=1;
				System.out.println("Player 1 wins");
				break;
			}		
			if(player2.suitcount[i]==4)
			{
				win=2;
				System.out.println("Player 2 wins");
				break;
			}
		}
		return win;
	}
}
class start
{
	start()
	{
		player1 p1 = new player1();
		player2 p2 = new player2();
		p1.setPriority(10);
		p2.setPriority(5);
		p1.start();
		p2.start();
	}
}
class game
{
	public static void main(String[] args)
	{
		new start();
	}
}