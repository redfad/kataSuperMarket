package manager;

import java.util.logging.Logger;

import dao.CartDAO;
import dao.OrderDAO;
import exception.SuperMarketException;
import model.Cart;
import model.Order;
import pricing.Offre;

public class CartManager {
	private final Logger LOG = Logger.getLogger("CartManager");
	private final CartDAO cartDAO = new CartDAO();
	private final OrderDAO orderDAO = new OrderDAO();

	/**
	 * Add a Product
	 * 
	 * @param product
	 * @return
	 * @throws BankCartException
	 */
	public Cart add(Cart cart, Order order) throws SuperMarketException {
		return cart;
	}
}
