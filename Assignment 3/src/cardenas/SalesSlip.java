package cardenas;

import java.util.LinkedList;

public class SalesSlip {
	
	private LinkedList<SalesItem> elements;
	private double totalPay;
	
	public SalesSlip() {
		elements = new LinkedList<SalesItem>();
	}
	
	public void addSale(SalesItem i) {
		elements.add(i);
	}
	
	public String totalSales() {
		totalPay = 0;
		for(int i = 0; i < elements.size(); i++) {
			totalPay += elements.get(i).totalItemCost();
		}
		return "$" + String.format("%.2f", totalPay);

	}

	public String toString() {
		String output = "";
		for(int i = 0; i < elements.size(); i++) {
			output += elements.get(i).toString() + "\n";
		}
		return output;
	}
}
