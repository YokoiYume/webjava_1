package jp.co.systena.tigerscave.shopping.app.application.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Order> ordList = new ArrayList<Order>();

	public void addOrder(int itemId,int num) {
		Order ord=null;
		for(Order order:ordList) {
			if(order.getItemId()==itemId) {
				ord=order;


			}
		}
		if(ord==null) {
			ord=new Order();
			ord.setItemId(itemId);
			ord.setNum(num);
			ordList.add(ord);

		}else {
			int Num=ord.getNum()+num;
			ord.setNum(Num);
		}

	}

	public List<Order> getOrderList() {
		return ordList;

	}


}
