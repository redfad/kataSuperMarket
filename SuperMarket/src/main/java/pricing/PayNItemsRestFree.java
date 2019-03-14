package pricing;

import java.math.BigDecimal;

import model.Order;

public class PayNItemsRestFree extends AbstractOffre{
	
	private BigDecimal thresHoldAsNumberOfItems; 
	/**
	 * @param thresHoldAsNumberOfItems
	 */
	public PayNItemsRestFree(BigDecimal thresHoldAsNumberOfItems) {
		super();
		this.thresHoldAsNumberOfItems = thresHoldAsNumberOfItems;
	}
	
	@Override
	public void calculReducedPrice(Order order) {
		if(order.getQuantity().compareTo(this.thresHoldAsNumberOfItems)==1) {
			order.setOrderPriceReduced(order.getProduct().getPrice().multiply(thresHoldAsNumberOfItems));
		}
	}

	/**
	 * @return the thresHoldAsNumberOfItems
	 */
	public BigDecimal getThresHoldAsNumberOfItems() {
		return thresHoldAsNumberOfItems;
	}
	
}
