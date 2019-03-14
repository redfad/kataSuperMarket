package manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.SuperMarketException;
import model.Cart;
import model.Order;
import model.Product;
import pricing.Offre;
import pricing.PayHalf;
import pricing.PayNItemsRestFree;
import pricing.PayNItemsRestPromoted;
import pricing.PayNItemsWinXItemsFree;

class CartManagerTest {

	static CartManager cartManager;
	static ProductManager productManager;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		cartManager = null;
		productManager = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		cartManager = new CartManager();
		productManager = new ProductManager();

		Product pomme = new Product("Pomme", new BigDecimal(0.2));
		Offre offrePomme = new PayHalf(new BigDecimal(4));
		pomme.setOffre(offrePomme);
		
		Product orange = new Product("Orange", new BigDecimal(0.5));
		Offre offreOrange = new PayNItemsRestFree(new BigDecimal(3));
		orange.setOffre(offreOrange);
		
		Product pasteque = new Product("Pastéque", new BigDecimal(0.5));
		Offre offrePasteque = new PayNItemsRestPromoted(new BigDecimal(3),new BigDecimal(0.2));
		pasteque.setOffre(offrePasteque);
		
		Product peche = new Product("Péche", new BigDecimal(0.5));
		Offre offrePeche = new PayNItemsWinXItemsFree(new BigDecimal(3),new BigDecimal(2));
		peche.setOffre(offrePeche);

		productManager.addProduct(pomme);
		productManager.addProduct(orange);
		productManager.addProduct(pasteque);
	}

	@AfterEach
	void tearDown() throws Exception {
		cartManager = null;
		productManager = null;
	}

	@Test
	void shouldFailWhenOrderIsNotProvided() throws SuperMarketException {
		assertThrows(SuperMarketException.class, () -> {
			Cart cart = new Cart();
			cartManager.add(cart, null);
		});
	}

	@Test
	void shouldFailWhenCartIsNotProvided() throws SuperMarketException {
		assertThrows(SuperMarketException.class, () -> {
			Product pomme = productManager.getProductByName("Pomme");
			Order pommeOrder = new Order(pomme, new BigDecimal(1));
			cartManager.add(null, pommeOrder);
		});
	}

	@Test
	void shouldReturnTotalCostWithoutReduction() throws SuperMarketException {
		Cart cart = new Cart();
		Product pomme = productManager.getProductByName("Pomme");

		Order pommeOrder = new Order(pomme, new BigDecimal(1));

		cartManager.add(cart, pommeOrder);// *0.2

		BigDecimal totalCost = pomme.getPrice().multiply(pommeOrder.getQuantity());

		assertEquals(cart.getTotalCost(), totalCost);
	}
	
	@Test
	void shouldReducePriceByHalf() throws SuperMarketException {
		Cart cart = new Cart();
		Product pomme = productManager.getProductByName("Pomme");
		Order pommeOrder = new Order(pomme, new BigDecimal(8));
		cartManager.add(cart, pommeOrder);

		assertEquals(cart.getTotalReduced().setScale(2,BigDecimal.ROUND_HALF_UP), new BigDecimal(0.8).setScale(2,BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	void shouldNotReducePriceByHalf() throws SuperMarketException {
		Cart cart = new Cart();
		Product pomme = productManager.getProductByName("Pomme");
		Order pommeOrder = new Order(pomme, new BigDecimal(2));
		cartManager.add(cart, pommeOrder);

		assertEquals(cart.getTotalReduced().setScale(2,BigDecimal.ROUND_HALF_UP), pomme.getPrice().multiply(pommeOrder.getQuantity()).setScale(2,BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	void should_Pay_N_Items_And_Rest_Free() throws SuperMarketException {
		Cart cart = new Cart();
		Product orange = productManager.getProductByName("Orange");
		Order orangeOrder = new Order(orange, new BigDecimal(8));
		cartManager.add(cart, orangeOrder);

		assertEquals(cart.getTotalReduced(), orange.getPrice().multiply(new BigDecimal(3)));
	}
	
	@Test
	void should_Pay_N_Items_And_Rest_Not_Free() throws SuperMarketException {
		Cart cart = new Cart();
		Product orange = productManager.getProductByName("Orange");
		Order orangeOrder = new Order(orange, new BigDecimal(2));
		cartManager.add(cart, orangeOrder);

		assertEquals(cart.getTotalReduced(), orange.getPrice().multiply(orangeOrder.getQuantity()));
	}
	
	@Test
	void should_Pay_N_Items_And_Rest_Promoted() throws SuperMarketException {
		Cart cart = new Cart();
		Product orange = productManager.getProductByName("Orange");
		Order orangeOrder = new Order(orange, new BigDecimal(8));
		cartManager.add(cart, orangeOrder);

		assertEquals(cart.getTotalReduced(), orange.getPrice().multiply(new BigDecimal(3)));
	}
	
	@Test
	void should_Pay_N_Items_And_Rest_Not_Promoted() throws SuperMarketException {
		Cart cart = new Cart();
		Product orange = productManager.getProductByName("Orange");
		Order orangeOrder = new Order(orange, new BigDecimal(2));
		cartManager.add(cart, orangeOrder);

		assertEquals(cart.getTotalReduced(), orange.getPrice().multiply(orangeOrder.getQuantity()));
	}
	
	@Test
	void shouldPrintTheCart() throws SuperMarketException {
		Cart cart = new Cart();
		Product pomme = productManager.getProductByName("Pomme");
		Product orange = productManager.getProductByName("Orange");
		Product pasteque = productManager.getProductByName("Pastéque");

		Order pommeOrder = new Order(pomme, new BigDecimal(1));
		Order orangeOrder = new Order(orange, new BigDecimal(2));
		Order pastequeOrder = new Order(pasteque, new BigDecimal(3));

		cartManager.add(cart, pommeOrder);// *0.2
		cartManager.add(cart, orangeOrder);// *0.5
		cartManager.add(cart, pastequeOrder);// *0.8

		assertEquals(cart.getOrders().stream().count(),3);
	}

}
