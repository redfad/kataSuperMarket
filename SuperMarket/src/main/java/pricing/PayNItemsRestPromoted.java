package pricing;

import java.math.BigDecimal;

import model.Order;

public class PayNItemsRestPromoted extends AbstractOffre{
	
	private BigDecimal thresHoldAsNumberOfItems; 
	private BigDecimal reductionRate;
	
	/**
	 * @param thresHoldAsNumberOfItems
	 */
	public PayNItemsRestPromoted(BigDecimal thresHoldAsNumberOfItems,BigDecimal reductionRate) {
		super();
		this.thresHoldAsNumberOfItems = thresHoldAsNumberOfItems;
		this.reductionRate=reductionRate;
	}
	
	@Override
	public void calculReducedPrice(Order order) {
		if(order.getQuantity().compareTo(this.thresHoldAsNumberOfItems)==1) {
			order.setOrderPriceReduced(order.getProduct().getPrice().multiply(thresHoldAsNumberOfItems)
					.add(order.getQuantity().subtract(thresHoldAsNumberOfItems)
							.multiply(new BigDecimal(1).subtract(reductionRate)))
					);
		}
	}

	/**
	 * @return the thresHoldAsNumberOfItems
	 */
	public BigDecimal getThresHoldAsNumberOfItems() {
		return thresHoldAsNumberOfItems;
	}

	/**
	 * @return the reductionRate
	 */
	public BigDecimal getReductionRate() {
		return reductionRate;
	}
	
}
