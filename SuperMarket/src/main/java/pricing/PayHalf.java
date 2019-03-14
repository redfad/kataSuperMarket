package pricing;

import java.math.BigDecimal;

import model.Order;

public class PayHalf extends AbstractOffre{
	
	private BigDecimal thresHoldAsNumberOfItems; 
	/**
	 * @param thresHoldAsNumberOfItems
	 */
	public PayHalf(BigDecimal thresHoldAsNumberOfItems) {
		super();
		this.thresHoldAsNumberOfItems = thresHoldAsNumberOfItems;
	}
	
	@Override
	public void calculReducedPrice(Order order) {
		if(order.getQuantity().compareTo(this.thresHoldAsNumberOfItems)==1) {
			order.setOrderPriceReduced(order.getProduct().getPrice().multiply(order.getQuantity().divide(new BigDecimal(2))));
		}
	}

	/**
	 * @return the thresHoldAsNumberOfItems
	 */
	public BigDecimal getThresHoldAsNumberOfItems() {
		return thresHoldAsNumberOfItems;
	}
	
}
