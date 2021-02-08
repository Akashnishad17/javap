private static int countPairs(List<Integer> numbers, int k){

	HashSet<Integer> set = new HashSet<>();
	HashSet<Integer> valid = new HashSet<>();

	for(int num : numbers)
	{
		if(set.contains(num+k) && !valid.contains(num))
			valid.add(num);

		if(set.contains(num-k) && !valid.contains(num-k))
			valid.add(num-k);

		set.add(num);
	}

	return valid.size();
}