import java.io.*;
import java.util.*;

class PlayFair{
	
	static HashMap<Character,int[]> map;
	static List<Character> chars;
	static char[][] key;
	
	public static void main(String[] args)
	{
		map = new HashMap<>();
		chars = new ArrayList<>();
		
		for(char i = 'a'; i <= 'z'; i++)
		{
			if(i == 'j')
				continue;
			chars.add(i);
		}
		Collections.shuffle(chars);
		int index = 0;		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
				map.put(chars.get(index++), new int[]{i,j});
		}
		key = new char[5][5];
		for(Map.Entry<Character,int[]> e : map.entrySet())
			key[e.getValue()[0]][e.getValue()[1]] = e.getKey();
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		if(s.length() % 2 == 1)
			s += 'z';

		String res = "";
		for(int i = 0; i < s.length(); i += 2)
			res += encrypt(s,i);

		String decrypted = "";
		for(int i = 0; i < res.length(); i += 2)
			decrypted += decrypt(res, i);
		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
				System.out.print(key[i][j]+" ");
			System.out.println();
		}

		System.out.println("Before Encryption: "+s);
		System.out.println("Encrypted String: "+res);
		System.out.print("Decrypted String: "+decrypted);
	}

	public static String encrypt(String s, int index)
	{
		char x = s.charAt(index);
		char y = s.charAt(index+1);
		int[] posX = map.get(x);
		int[] posY = map.get(y);
		String res = "";
		if(posX[0] == posY[0])
		{
			int y1 = posX[1]+1 < 5 ? posX[1] + 1 : 0; 
			int y2 = posY[1]+1 < 5 ? posY[1] + 1 : 0;
			res += key[posX[0]][y1];
			res += key[posY[0]][y2];
		}
		else if(posX[1] == posY[1])
		{
			int x1 = posX[0]+1 < 5 ? posX[0] + 1 : 0; 
			int x2 = posY[0]+1 < 5 ? posY[0] + 1 : 0;
			res += key[x1][posX[1]];
			res += key[x2][posY[1]];
		}
		else
		{
			res += key[posX[0]][posY[1]];
			res += key[posY[0]][posX[1]]; 
		}
		return res;
	} 

	public static String decrypt(String s, int index)
	{
		char x = s.charAt(index);
		char y = s.charAt(index+1);
		int[] posX = map.get(x);
		int[] posY = map.get(y);
		String res = "";
		if(posX[0] == posY[0])
		{
			int y1 = posX[1]-1 >= 0 ? posX[1] - 1 : 4; 
			int y2 = posY[1]-1 >= 0 ? posY[1] - 1 : 4;
			res += key[posX[0]][y1];
			res += key[posY[0]][y2];
		}
		else if(posX[1] == posY[1])
		{
			int x1 = posX[0]-1 >= 0 ? posX[0] - 1 : 4; 
			int x2 = posY[0]-1 >= 0 ? posY[0] - 1 : 4;
			res += key[x1][posX[1]];
			res += key[x2][posY[1]];
		}
		else
		{
			res += key[posX[0]][posY[1]];
			res += key[posY[0]][posX[1]]; 
		}
		return res;
	} 
}