package repository;

import java.util.ArrayList;
import java.util.List;

import model.Cart;

public class CartRepository {
	private static ArrayList<Cart> carts;

	private CartRepository() {

	}

	public static List<Cart> getCarts() {
		if(carts == null) {
			carts = new ArrayList<Cart>();
		}
		return carts;
	}
}
