import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.DoubleSummaryStatistics;
import java.util.Objects;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collector;

class SaleTransaction {
	String productId;
	int quantity;
	double pricePerUnit;

	public SaleTransaction(String productId, int quantity, double pricePerUnit) {
		this.productId = productId;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}

	public String getProductId() { return productId; }
	public int getQuantity() { return quantity; }
	public double getPricePerUnit() { return pricePerUnit; }
}

class SaleSummary {
	double totalRevenue;
	double averageQuantity;

	public SaleSummary(double totalRevenue, double averageQuantity) {
		this.totalRevenue = totalRevenue;
		this.averageQuantity = averageQuantity;
	}

	public double getTotalRevenue() { return totalRevenue; }
	public double getAverageQuantity() { return averageQuantity; }

	@Override
	public String toString() {
		return "SaleSummary{totalRevenue=" + totalRevenue + ", averageQuantity=" + averageQuantity + "}";
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SaleSummary that = (SaleSummary) o;
		return Double.compare(that.totalRevenue, totalRevenue) == 0 &&
				 Double.compare(that.averageQuantity, averageQuantity) == 0;
	}
	@Override
	public int hashCode() {
		return Objects.hash(totalRevenue, averageQuantity);
	}
}

public class SaleAnalyzer {
	public static Map<String, SaleSummary> analyzeSales(Stream<SaleTransaction> transactions) {
		// Your code here
		Map<String,SaleSummary> map = transactions.collect(Collectors.groupingBy(SaleTransaction::getProductId,
			
			Collector.of(
			()->new double[3],

			(data,trans)->{data[0] += trans.getQuantity() * trans.getPricePerUnit();
							data[1] += trans.getQuantity();
							data[2]++;},
			
			(data1,data2)-> {data1[0] += data2[0];
							data1[1] += data2[1];
							data1[2] += data2[2];
							return data1;},
			
			(data)-> {double totalRevenue = data[0];
					 double averageQuantity = (data[2]==0)? 0 : data[1]/data[2];
					 return new SaleSummary(totalRevenue, averageQuantity);})));
					 return map;
	}
}