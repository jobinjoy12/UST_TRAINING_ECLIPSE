import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collector;

class Transaction {
    private String productId;
    private double amount;
    private String currency;

    public Transaction(String productId, double amount, String currency) {
        this.productId = productId;
        this.amount = amount;
        this.currency = currency;
    }

    public String getProductId() { return productId; }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }

    @Override
    public String toString() {
        return "Transaction{productId='" + productId + "', amount=" + amount + ", currency='" + currency + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
               productId.equals(that.productId) &&
               currency.equals(that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, amount, currency);
    }
}

public class TransactionAggregator {

    /**
     * Groups transactions by product ID and then aggregates total amounts by currency for each product.
     *
     * @param transactions A list of Transaction objects.
     * @return A map where the outer key is product ID, and the inner map contains currency to total amount.
     */
    public static Map<String, Map<String, Double>> aggregateByProductAndCurrency(List<Transaction> transactions) {
        
       //Map<String,Map<String , Double>> result = transactions.stream().collect(Collectors.groupingBy(Transaction::getProductId,Collectors.groupingBy(Transaction::getCurrency,Collectors.summingDouble(Transaction::getAmount))));
        Map<String,Map<String , Double>> result = transactions.stream().collect(Collectors.groupingBy(Transaction::getProductId,Collectors.groupingBy(Transaction::getCurrency,Collectors.averagingDouble(Transaction::getAmount))));

        return result; // Placeholder
    }
}