/**
 * 
 */
package pricing;

import model.Order;

/**
 * @author mac
 *
 */
public abstract class AbstractOffre implements Offre {

	protected Integer offreId;
	
	/**
	 * 
	 */
	public AbstractOffre() {
		this.offreId = Integer.valueOf((int) (Math.random() * 1000));
	}

	@Override
	public abstract void calculReducedPrice(Order order);

	@Override
	public Integer getOffreId() {
		return this.offreId;
	}

}
