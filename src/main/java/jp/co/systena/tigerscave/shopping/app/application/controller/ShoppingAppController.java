package jp.co.systena.tigerscave.shopping.app.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.shopping.app.application.model.Cart;
import jp.co.systena.tigerscave.shopping.app.application.model.Item;
import jp.co.systena.tigerscave.shopping.app.application.model.ListForm;
import jp.co.systena.tigerscave.shopping.app.application.model.Order;
import jp.co.systena.tigerscave.shopping.app.appllication.service.ListService;


@Controller
public class ShoppingAppController {

	@Autowired
	HttpSession session;

	// ListServiceクラスのgetItemListメソッド呼び出して、Mapに格納する
	private static final Map<Integer, Item> ITEM = ListService.getItemList();

	@RequestMapping(value = "/ShopTop", method = RequestMethod.GET) // URLとのマッピング
	public ModelAndView index(ModelAndView mav) {


		// 出したいビューをsetする。
		mav.setViewName("GlossaryTop");
		// 使いたいオブジェクトをビューに渡す。
		mav.addObject("ohage", ITEM);
		mav.addObject("watanabe", new ListForm());

		return mav;
	}

	@RequestMapping(value = "/userlist", method = RequestMethod.POST)
	public ModelAndView order(ModelAndView ord,@ModelAttribute ListForm form, Model model, HttpServletRequest request) {
		
		List<Order> carts = (List<Order>)session.getAttribute("orderList");
	    if( carts == null) {
	    	carts = new ArrayList<Order>();
	        session.setAttribute("orderList",carts);
	    }
		session.getAttribute("message");
		Item cartitem = ITEM.get(form.getItemid());
		//model.addAttribute("message", cartitem);
		ord.setViewName("CartView");

		Order order = new Order();
		order.setItemId(form.getItemid());
		Cart cart = new Cart();
		cart.addOrder(order);
		

		session.setAttribute("cartList",cart);
		
		return ord;


	}

}
