import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

// Define the Purchase interface
public interface Purchase {
    double getAmount();
    LocalDate getDate();
    String getItemName();
}

// Example concrete implementations
class OnlinePurchase implements Purchase {
    private String itemName;
    private double amount;
    private LocalDate date;
    private String website;

    public OnlinePurchase(String itemName, double amount, LocalDate date, String website) {
        this.itemName = itemName;
        this.amount = amount;
        this.date = date;
        this.website = website;
    }

    @Override
    public double getAmount() { return amount; }
    @Override
    public LocalDate getDate() { return date; }
    @Override
    public String getItemName() { return itemName; }
    public String getWebsite() { return website; }

    @Override
    public String toString() {
        return "OnlinePurchase{itemName='" + itemName + "', amount=" + amount + ", date=" + date + ", website='" + website + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnlinePurchase that = (OnlinePurchase) o;
        return Double.compare(that.amount, amount) == 0 && itemName.equals(that.itemName) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, amount, date);
    }
}

class InStorePurchase implements Purchase {
    private String itemName;
    private double amount;
    private LocalDate date;
    private String storeName;

    public InStorePurchase(String itemName, double amount, LocalDate date, String storeName) {
        this.itemName = itemName;
        this.amount = amount;
        this.date = date;
        this.storeName = storeName;
    }

    @Override
    public double getAmount() { return amount; }
    @Override
    public LocalDate getDate() { return date; }
    @Override
    public String getItemName() { return itemName; }
    public String getStoreName() { return storeName; }

    @Override
    public String toString() {
        return "InStorePurchase{itemName='" + itemName + "', amount=" + amount + ", date=" + date + ", storeName='" + storeName + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InStorePurchase that = (InStorePurchase) o;
        return Double.compare(that.amount, amount) == 0 && itemName.equals(that.itemName) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, amount, date);
    }
}

public class PurchaseSorter {

    /**
     * Sorts a list of purchases based on amount (descending) and then by date (ascending).
     *
     * @param purchases The list of purchases to sort.
     * @param <T> The type of purchase, must extend Purchase.
     */
    public static <T extends Purchase> void sortPurchases(List<T> purchases) {
        // Your code here
        // Hint: Use Collections.sort with a custom Comparator.
        Collections.sort(purchases , new Comparator<T>() {
            @Override
            public int compare(T p1 , T p2)
            {   
               return Double.compare(p2.getAmount(),p1.getAmount());
            }});

        Collections.sort(purchases, new Comparator<T>() {
            @Override
            public int compare(T p1 , T p2)
            {
                return p1.getDate().compareTo(p2.getDate());
            }
        });
        }
    } 

              