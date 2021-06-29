public static List<Long> sumValues(List<Integer> parents, List<Integer> startPoint, List<Integer> jumpLength)
{
	int q = startPoint.size();
	List<Long> res = new ArrayList<>();

	int jump, last;
	long sum;

	for(int i = 0; i < q; i++)
	{
		last = startPoint.get(i);
		sum = 0;

		while(last >= 0)
		{
			jump = jumpLength.get(i);

			while(jump > 0)
			{
				last = parent.get(last);
				jump--;
			}

			if(last >= 0)
				sum += last;
		}

		res.add(sum);
	}

	return res;
}


public static int getMostVisited(int n, List<Integer> sprints)
{
	int[] range = new int[n+1];
	int min, max;

	for(int i = 0; i < sprints.size() - 1; i++)
	{
		min = Math.min(sprints.get(i), sprints.get(i+1));
		max = Math.max(sprints.get(i), sprints.get(i+1));

		range[min]++;

		if(max+1 <= n)
			range[max+1]--;
	}

	for(int i = 1; i <= n; i++)
		range[i] += range[i-1];

	int index = -1
	int max = 0;

	for(int i = 1; i <= n; i++)
	{
		if(range[i] > max)
		{
			max = range[i];
			index = i;
		}
	}

	return index;
}