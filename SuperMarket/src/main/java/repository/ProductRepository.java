package repository;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductRepository {
	private static ArrayList<Product> products;

	private ProductRepository() {

	}

	public static List<Product> getProducts() {
		if(products == null) {
			products = new ArrayList<Product>();
		}
		return products;
	}
}
