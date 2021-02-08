private static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice){
	
	HashMap<String,Float> map = new HashMap<>();

	for(int i = 0; i < products.size(); i++)
		map.put(products.get(i), productPrices.get(i));

	int errors = 0;

	for(int i = 0; i < productSold.size(); i++)
	{
		if((float)map.get(productSold.get(i)) != (float)soldPrice.get(i))
			errors++;
	}

	return errors;
}