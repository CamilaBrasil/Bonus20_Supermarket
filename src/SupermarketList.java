import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SupermarketList {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String response = "y";
		String userItem;
		String format = "%15s";

		// ArrayList for the marketProducts
		HashMap<String, Double> marketProducts = new HashMap<>();
		marketProducts.put("apple", 0.99);
		marketProducts.put("banana", 0.59);
		marketProducts.put("cauliflower", 1.59);
		marketProducts.put("dragonfruit", 2.19);
		marketProducts.put("elderberry", 1.79);
		marketProducts.put("figs", 0.99);
		marketProducts.put("grapefruit", 0.99);
		marketProducts.put("honeydew", 0.99);

		// ArrayList for the shoppingCart
		ArrayList<String> shoppingCartProducts = new ArrayList<>();
		ArrayList<Double> shoppingCartPrices = new ArrayList<>();
		
		// Loop to process the choice and give the possibility of keep adding
		while (response.equalsIgnoreCase("y")) {
			
			// Beginning of the supermarket list
			System.out.println("----Welcome to Guenther's Market!----\n");
			System.out.println("\t  Item" + "\t\t  Price");
			System.out.println("=====================================\n");
			
			for (String tempKey : marketProducts.keySet()) {
				String productName = tempKey;
				String productPrice = "$" + marketProducts.get(tempKey).toString();

				System.out.format(format, productName);
				System.out.format(format, productPrice);
				System.out.println();
			}
			
			// Ask for item
			System.out.println("What item would you like to order?");
			userItem = scan.nextLine().toLowerCase();

			if (marketProducts.containsKey(userItem)) {
				System.out.println("Adding " + userItem + " to cart at $" + marketProducts.get(userItem));
				shoppingCartProducts.add(userItem);
				shoppingCartPrices.add(marketProducts.get(userItem));
			} else {
				System.out.println("\nSorry, we don't have those. Please try again.");
			}

			System.out.println("Would you like to order anything else? (y/n)\n");
			response = scan.next();
			scan.nextLine();
		}
		
		System.out.println("Thank you for your order!/n");
		System.out.println("Here's what you got:");
		
		for (int i = 0; i < shoppingCartProducts.size(); i++) {
			System.out.println(shoppingCartProducts.get(i) + "	" + "$" + shoppingCartPrices.get(i));
		}
		
		System.out.println("Average price per item in order was $" + averagePriceOrdered(shoppingCartPrices));
		
		System.out.println("The index of the highest value product in the shopping cart is: " + indexMax(shoppingCartPrices));
		System.out.println("The index of the smalest value product in the shopping cart is: " + indexMin(shoppingCartPrices));
		
		scan.close();
	}
	
	public static BigDecimal averagePriceOrdered (ArrayList<Double> shoppingCartPrices) {
		
		Double averagePriceOrdered = 0.0;
		
		for (int i = 0; i < shoppingCartPrices.size(); i++) {
			Double productPrice = shoppingCartPrices.get(i);
			averagePriceOrdered += productPrice;
		}
		
		
		return BigDecimal.valueOf(averagePriceOrdered / shoppingCartPrices.size());
	}
	
	public static int indexMax (ArrayList <Double> shoppingCartPrices) {
		
		int highestCartIndex = 0;
		Double highestPrice = 0.0;
		
		for (int i = 0; i < shoppingCartPrices.size(); i++) {

				if (shoppingCartPrices.get(i) > highestPrice) {
					highestPrice = shoppingCartPrices.get(i);
					highestCartIndex = i;
				}
			} 
		

		
		return highestCartIndex;
	}
	
	public static int indexMin (ArrayList <Double> shoppingCartPrices) {
		
		int smalestCartIndex = 0;
		Double price = 100.0;
		
		for (int i = 0; i < shoppingCartPrices.size(); i++) {

				if (shoppingCartPrices.get(i) < price) {
					price = shoppingCartPrices.get(i);
					smalestCartIndex = i;
				}
			} 
		

		
		return smalestCartIndex;
	}

}
