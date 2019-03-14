/**
 * 
 */
package model;

import java.math.BigDecimal;
import java.util.Objects;

import pricing.Offre;

/**
 * @author ELMEKKAOUI Redouane
 *
 */
public class Product {
	private Integer productId;
	private String name;
	private Integer stock;
	private Offre offre;
	private BigDecimal price;
	
	
	/**
	 * @param name
	 * @param price
	 */
	public Product(String name, BigDecimal price) {
		super();
		this.productId = Integer.valueOf((int) (Math.random() * 1000));
		this.name = name;
		this.price = price;
	}

	/**
	 * @param productId
	 * @param name
	 * @param stock
	 * @param offre
	 */
	public Product(String name, Integer stock, Offre offre) {
		super();
		this.productId = Integer.valueOf((int) (Math.random() * 1000));
		this.name = name;
		this.stock = stock;
		this.offre = offre;
	}
	
	/**
	 * @param name
	 * @param stock
	 */
	public Product(String name, Integer stock) {
		super();
		this.productId = Integer.valueOf((int) (Math.random() * 1000));;;
		this.name = name;
		this.stock = stock;
	}
	
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * @return the offre
	 */
	public Offre getOffre() {
		return offre;
	}

	/**
	 * @param offre the offre to set
	 */
	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	
	@Override
	public int hashCode() {
		return  productId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Product other = (Product) obj;
		if (other.getProductId() == null || productId == null) {
            return false;
        }
		return Objects.equals(productId, other.getProductId());
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", stock=" + stock + ", offre=" + offre
				+ "]";
	}

}
