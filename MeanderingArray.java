private static List<Integer> meanderingArray(List<Integer> unsorted){

	Collections.sort(unsorted);

	int l = 0;
	int r = unsorted.size() - 1;

	List<Integer> res = new ArrayList<>();

	while(l < r)
	{
		res.add(unsorted.get(r));
		res.add(unsorted.get(l));
		r--;
		l++;
	}

	if(l == r)
		res.add(unsorted.get(l));

	return res;
}