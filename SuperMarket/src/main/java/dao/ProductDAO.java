package dao;

import java.util.List;
import java.util.logging.Logger;

import model.Product;
import repository.ProductRepository;

public class ProductDAO {

	private final Logger log = Logger.getLogger("ProductDAO");
	private final List<Product> products = ProductRepository.getProducts();

	/**
	 * Save a product
	 * 
	 * @param product
	 * @return
	 */
	public Product save(Product product) {
		log.info("Request to save Product : " + product);
		products.add(product);
		return product;
	}

	/**
	 * Delete a product
	 * 
	 * @param product
	 */
	public void delete(Product product) {
		log.info("Request to delete Product : " + product);
		products.removeIf(val -> val.getProductId().equals(product.getProductId()));
	}

	/**
	 * Search for a product by its id
	 * 
	 * @param id
	 */
	public Product findOne(Integer id) {
		log.info("Request to finde Product : " + id);
		return products.stream().filter(product -> product.getProductId().equals(id)).findFirst().get();
	}

	/**
	 * find all products
	 */
	public List<Product> findAll() {
		log.info("Request to find all products : ");
		return products;
	}
}
