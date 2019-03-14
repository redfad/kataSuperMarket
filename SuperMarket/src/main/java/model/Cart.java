package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Cart {
	private Integer cartId;
	private BigDecimal totalCost;
	private BigDecimal totalReduced;
	private LocalDate dateOfPurchase;
	private HashSet<Order> orders;
	
	
	/**
	 * @param cartId
	 */
	public Cart() {
		super();
		this.cartId = Integer.valueOf((int) (Math.random() * 1000));
		this.orders = new HashSet<Order>();
		this.totalCost= new BigDecimal(0.0);
		this.totalReduced = new BigDecimal(0.0);
		this.dateOfPurchase = LocalDate.now();
	}
	/**
	 * @return the cartId
	 */
	public Integer getCartId() {
		return cartId;
	}
	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	/**
	 * @return the totalCost
	 */
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	/**
	 * @return the totalReduced
	 */
	public BigDecimal getTotalReduced() {
		return totalReduced;
	}
	/**
	 * @param totalReduced the totalReduced to set
	 */
	public void setTotalReduced(BigDecimal totalReduced) {
		this.totalReduced = totalReduced;
	}
	/**
	 * @return the dateOfPurchase
	 */
	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}
	/**
	 * @param dateOfPurchase the dateOfPurchase to set
	 */
	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	/**
	 * @return the orders
	 */
	public HashSet<Order> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(HashSet<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}

	@Override
	public int hashCode() {
		return cartId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Cart other = (Cart) obj;
		if (other.getCartId() == null || cartId == null) {
            return false;
        }
		return Objects.equals(cartId, other.getCartId());
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalCost=" + totalCost + ", totalReduced=" + totalReduced
				+ ", dateOfPurchase=" + dateOfPurchase + ", orders=" + orders + "]";
	}
}
