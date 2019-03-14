package pricing;

import model.Order;

public interface Offre {
	public void calculReducedPrice(Order order);
	public Integer getOffreId();
}
