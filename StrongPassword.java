import java.util.*;
class StrongPassword{
	static int generateRangeCount(int n)
	{
		double range = 1 + Math.random()*n;
		return (int)range;
	}
	static int generateIndex(int n)
	{
		double range = Math.random()*(n-1);
		return (int)range;
	}
	public static void main(String[] args)
	{
		String sc = "!@#$%&*?";
		String lc = "abcdefghijlkmnopqrstuvwxyz";
		String uc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String nc = "0123456789";
		int sh = generateRangeCount(sc.length());
		int lh = generateRangeCount(lc.length());
		int uh = generateRangeCount(uc.length());
		int nh = generateRangeCount(nc.length());
		List<Character> chars = new ArrayList<>();
		for(int i = 0; i < sh; i++)
			chars.add(sc.charAt(generateIndex(sc.length())));
		for(int i = 0; i < lh; i++)
			chars.add(lc.charAt(generateIndex(lc.length())));
		for(int i = 0; i < uh; i++)
			chars.add(uc.charAt(generateIndex(uc.length())));
		for(int i = 0; i < nh; i++)
			chars.add(nc.charAt(generateIndex(nc.length())));
		Collections.shuffle(chars);
		String pass = "";
		for(char c : chars)
			pass += c;
		System.out.print(pass);
	}
}