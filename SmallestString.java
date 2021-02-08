private static String smallestString(List<String> substrings){
	
	Collections.sort(substrings, new Comparator<String>(){

		public int compare(String a, String b)
		{
			String t1 = a + b;
			String t2 = b + a;

			return t1.compareTo(t2);
		}
	});

	StringBuilder sb = new StringBuilder();

	for(String s : substrings)
		sb.append(s);

	return sb.toString();
}