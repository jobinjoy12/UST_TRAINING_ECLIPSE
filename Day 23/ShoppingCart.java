import java.util.function.BiFunction;

@FunctionalInterface
interface PricingStrategy extends BiFunction<Double, Integer, Double> {
	// The apply method from BiFunction is inherited: Double apply(Double itemPrice, Integer quantity);
}

class ShoppingCart {
	private PricingStrategy currentStrategy;

	public void setPricingStrategy(PricingStrategy strategy) {
		this.currentStrategy = strategy;
	}

	public double calculateTotal(double itemPrice, int quantity) {
		if (currentStrategy == null) {
			throw new IllegalStateException("Pricing strategy not set.");
		}
		// Your code here: Apply the current strategy
        double total = currentStrategy.apply(itemPrice, quantity);
		return total;
	}
}