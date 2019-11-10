package jp.co.systena.tigerscave.shopping.app.application.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Order> ordList = new ArrayList<Order>();

	public void addOrder(Order ord) {
		ordList.add(ord);
	}

	public List<Order> getOrderList() {
		return ordList;

	}


}
