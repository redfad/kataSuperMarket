package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {
	private Integer orderId;
	private Product product;
	private BigDecimal quantity;
	private BigDecimal orderPrice;
	private BigDecimal orderPriceReduced;
	
	/**
	 * @param product
	 * @param quantity
	 */
	public Order(Product product, BigDecimal quantity) {
		super();
		this.orderId = Integer.valueOf((int) (Math.random() * 1000));
		this.product = product;
		this.quantity = quantity;
		this.quantity.setScale(3,BigDecimal.ROUND_HALF_UP);
	}
	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the orderPrice
	 */
	public BigDecimal getOrderPrice() {
		return orderPrice;
	}
	/**
	 * @param orderPrice the orderPrice to set
	 */
	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
		this.orderPrice.setScale(3,BigDecimal.ROUND_HALF_UP);
		
	}
	
	/**
	 * @return the orderPriceReduced
	 */
	public BigDecimal getOrderPriceReduced() {
		return orderPriceReduced;
	}
	/**
	 * @param orderPriceReduced the orderPriceReduced to set
	 */
	public void setOrderPriceReduced(BigDecimal orderPriceReduced) {
		this.orderPriceReduced = orderPriceReduced;
		this.orderPriceReduced.setScale(3,BigDecimal.ROUND_HALF_UP);
	}
	@Override
	public int hashCode() {
		return  orderId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Order other = (Order) obj;
		if (other.getOrderId() == null || orderId == null) {
            return false;
        }
		return Objects.equals(orderId, other.getOrderId());
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", product=" + product + ", quantity=" + quantity + ", orderPrice="
				+ orderPrice + "]";
	}
	
	
}
