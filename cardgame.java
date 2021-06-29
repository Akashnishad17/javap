import java.util.Random;
class card
{
	static int[] name = new int[4]; //1 for diamond, 2 for spade, 3 for heart and 4 for star
 	static int[] num = new int[13]; //1 for ace, 11 for joker, 12 for queen and 13 for queen
	static
	{
		int i;
		for(i=0;i<4;i++)
			name[i]=i+1;
		for(i=0;i<13;i++)
			num[i]=i+1;
	}
}
class player1 extends Thread
{
	Random rand = new Random();
	static int cardname;
	static int cardnum;
	static int point;
	static
	{
		point=0;
	}
	public void run()
	{
		while(true)
		{
			if(point==100 || player2.point==100)
				break;
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			finally
			{
				cardnum=card.num[rand.nextInt(card.num.length)];
				cardname=card.name[rand.nextInt(card.name.length)];
				System.out.println("PLayer 1 draws: "+cardname+","+cardnum);
			}
		}
	}	
}
class player2 extends Thread
{
	Random rand = new Random();
	static int cardname;
	static int cardnum;
	static int point;
	static
	{
		point=0;
	}
	public void run()
	{
		while(true)
		{
			if(point==100 || player1.point==100)
				break;
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			finally
			{
				cardnum=card.num[rand.nextInt(card.num.length)];
				cardname=card.name[rand.nextInt(card.name.length)];
				System.out.println("PLayer 2 draws: "+cardname+","+cardnum);
			}
		}
	}	
}
class gamecheck extends Thread
{
	public void run()
	{
		while(true)
		{
			if(player1.point==100 || player2.point==100)
			{
				if(player1.point > player2.point)
					System.out.println("Player 1 wins with score "+player1.point+":"+player2.point);
				if(player2.point > player1.point)
					System.out.println("Player 2 wins with score "+player2.point+":"+player1.point);
				break;
			}
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			finally
			{
				if(player1.cardnum > player2.cardnum)
					player1.point+=25;
				if(player1.cardnum < player2.cardnum)
					player2.point+=25;
				System.out.println("Current score, Player1: "+player1.point+", Player2: "+player2.point);
			}
		}
	}
}
class cardgame
{
	public static void main(String args[])
	{
		player1 p1 = new player1();
		player2 p2 = new player2();
		gamecheck g = new gamecheck();
		new card();
		
		p1.setPriority(10);
		p2.setPriority(5);
		g.setPriority(1);
		
		p1.start();
		p2.start();
		g.start();
	}
}