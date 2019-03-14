package manager;

import java.util.logging.Logger;

import dao.ProductDAO;
import exception.SuperMarketException;
import model.Product;

public class ProductManager {
	private final Logger LOG = Logger.getLogger("ProductManager");
	private final ProductDAO productDAO = new ProductDAO();

	/**
	 * find a Product by name
	 * 
	 * @param product
	 * @return
	 * @throws BankProductException
	 */
	public Product getProductByName(String productName) throws SuperMarketException {
		LOG.info("Request to get a product by name: " + productName);
		Product product = null;
		if (productName != null && !productName.trim().equals("")) {
			product = productDAO.findAll().stream()
					.filter(productItem -> productItem.getName().toLowerCase().equals(productName.toLowerCase()))
					.findFirst()
					.get();
		} else {
			throw new SuperMarketException("Please provide a valid product name!");
		}
		return product;
	}
	
	/**
	 * Add a Product
	 * 
	 * @param product
	 * @return
	 * @throws BankProductException
	 */
	public Product addProduct(Product product) throws SuperMarketException {
		LOG.info("Request to add a product: " + product);
		if (product != null) {
			product = productDAO.save(product);
		} else {
			throw new SuperMarketException("Please provide a valid product name!");
		}
		return product;
	}
}
