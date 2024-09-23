package cardenas;

public class SalesItem {
	private String name;
	private double cost;
	private int quantity;
	
	//Constructor for the item objects 
	public SalesItem() {
		name = "";
		cost = 0;
		quantity = 0;
	}
	public SalesItem(String name, double cost, int quantity) {
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
	}
	
	
	//Getter and Setter for Name variable
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	//Getter and Setter for Cost variable
	public void setCost(int c) {
		cost = c;
	}
	public double getCost() {
		return cost;
	}
	
	//Getter and Setter for Quantity variable
	public void setQuant(int q) {
		quantity = q;
	}
	public int getQuant() {
		return quantity;
	}
	
	//This method gets the total cost of the amount of items 
	public double totalItemCost() {
		double total = cost * (double)(quantity);
		return total;
	}
	
	
	//toString method which has a formatted output so everything is formatted the same. 
	public String toString() {
		String in1 = String.format("%-25s", name);
		String in2 = String.format("%.2f", cost);
		return in1 + "$" + String.format("%-10s", in2) + " " + quantity;
	}
	
	
}
