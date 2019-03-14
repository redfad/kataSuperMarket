package dao;

import java.util.List;
import java.util.logging.Logger;

import model.Cart;
import repository.CartRepository;

public class CartDAO {

	private final Logger log = Logger.getLogger("CartDAO");
	private final List<Cart> carts = CartRepository.getCarts();

	/**
	 * Save a cart
	 * 
	 * @param cart
	 * @return
	 */
	public Cart save(Cart cart) {
		log.info("Request to save Cart : " + cart);
		carts.add(cart);
		return cart;
	}

	/**
	 * Delete a cart
	 * 
	 * @param cart
	 */
	public void delete(Cart cart) {
		log.info("Request to delete Cart : " + cart);
		carts.removeIf(val -> val.getCartId().equals(cart.getCartId()));
	}

	/**
	 * Search for a cart by its id
	 * 
	 * @param id
	 */
	public Cart findOne(Integer id) {
		log.info("Request to finde Cart : " + id);
		return carts.stream().filter(cart -> cart.getCartId().equals(id)).findFirst().get();
	}

	/**
	 * find all carts
	 */
	public List<Cart> findAll() {
		log.info("Request to find all carts : ");
		return carts;
	}
}
