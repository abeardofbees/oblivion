package oblivion;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	String name;
	ArrayList<String> inventory = new ArrayList<String>();
	double cash;
	int hp = 200;
	
	public Player() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter your name: ");
		this.name = in.nextLine();
		
		addItem("Wallet");
		addItem("Car keys");
		
		getPaid(100);
		
	}
	
	public String getName() {
		return this.name;
	}

	public void addItem(String b) {
		
		this.inventory.add(b);
		
		
	}
	
	public void removeItem(int b) {
		
		this.inventory.remove(b);
		
	}
	
	public void checkWallet() {
		
		System.out.println("You have $" + this.cash + " and an empty condom wrapper in your wallet.\n");
		
	}
	
	public void getPaid(double c) {
		
		this.cash = this.cash + c;
		
	}
	
	public void payOut(double c, boolean d) {
		
		if (d == true) {
			this.cash = this.cash - c;
		}
		else
			System.out.println("You don't got enough scratch on you.");
		
	}
	
	public boolean canIAfford(double c) {
		
		if (this.cash >= c) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	public void checkInventory() {
		
		for (String e : inventory) {
			System.out.println(e);
		}
		System.out.println();
	}
		
	public boolean onHand(String d) {
		
		return inventory.contains(d);
		
	}

}
