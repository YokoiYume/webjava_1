package jp.co.systena.tigerscave.shopping.app.appllication.service;

import java.util.HashMap;
import java.util.Map;

import jp.co.systena.tigerscave.shopping.app.application.model.Item;

public  class ListService {

	public static Map<Integer,Item> getItemList() {

		Item p1 = new Item();
		p1.setName("にんじん");
		p1.setPrice(150);
		p1.setItemid(2020);

		Item p2 = new Item();
		p2.setName("じゃがいも");
		p2.setPrice(300);
		p2.setItemid(1112);

		Item p3 = new Item();
		p3.setName("たまねぎ");
		p3.setPrice(300);
		p3.setItemid(1113);

		Item p4= new Item();
		p4.setName("ぶたにく");
		p4.setPrice(400);
		p4.setItemid(1129);

		Item p5 = new Item();
		p5.setName("ルー");
		p5.setPrice(100);
		p5.setItemid(1122);

		Map<Integer, Item> map = new HashMap<Integer, Item>();
	    map.put(2020,p1);
	    map.put(1112,p2);
	    map.put(1113,p3);
	    map.put(1129,p4);
	    map.put(1122,p5);

	    return map;
	}


}
