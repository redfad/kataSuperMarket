package pricing;

import java.math.BigDecimal;

import model.Order;

public class PayNItemsWinXItemsFree extends AbstractOffre{
	
	private BigDecimal thresHoldAsNumberOfItems;
	private BigDecimal numberOFXitemsToWin;
	
	/**
	 * @param thresHoldAsNumberOfItems
	 */
	public PayNItemsWinXItemsFree(BigDecimal thresHoldAsNumberOfItems,BigDecimal numberOFXitemsToWin) {
		super();
		this.thresHoldAsNumberOfItems = thresHoldAsNumberOfItems;
		this.numberOFXitemsToWin = numberOFXitemsToWin;
	}
	
	@Override
	public void calculReducedPrice(Order order) {
		if(order.getQuantity().compareTo(this.thresHoldAsNumberOfItems)==1 &&
				this.thresHoldAsNumberOfItems.compareTo(this.numberOFXitemsToWin)==1) {
			order.setOrderPriceReduced(order.getProduct().getPrice().multiply(order.getQuantity().subtract(numberOFXitemsToWin)));
		}
	}

	/**
	 * @return the thresHoldAsNumberOfItems
	 */
	public BigDecimal getThresHoldAsNumberOfItems() {
		return thresHoldAsNumberOfItems;
	}

	/**
	 * @return the numberOFXitemsToWin
	 */
	public BigDecimal getNumberOFXitemsToWin() {
		return numberOFXitemsToWin;
	}
}
