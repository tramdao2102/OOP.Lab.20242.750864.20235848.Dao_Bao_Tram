package hust.soict.hedspi.test.screen.customer.store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	private static Store store;
	private static Cart cart;
	
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		System.out.println(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStore = new ViewStoreController(store, cart);
		fxmlloader.setController(viewStore);
		Parent root = fxmlloader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		cart = new Cart();
		store.addMedia(new DigitalVideoDisc("Edge of Tomorrow", "Sci-Fi/Action", "Doug Liman", 4.2f));
		store.addMedia(new DigitalVideoDisc("Everything Everywhere All At Once", "Multiverse/Drama", "Daniel Kwan & Daniel Scheinert", 4.8f));
		store.addMedia(new DigitalVideoDisc("Spider-Man: Into the Spider-Verse", "Animation/Superhero", "Bob Persichetti", 117, 21.99f));
		store.addMedia(new DigitalVideoDisc("Blade Runner 2049", "Sci-Fi/Thriller", "Denis Villeneuve", 5.0f));
		store.addMedia(new DigitalVideoDisc("The Grand Budapest Hotel", "Comedy/Drama", "Wes Anderson", 4.5f));
		store.addMedia(new DigitalVideoDisc("Parasite", "Thriller/Drama", "Bong Joon-ho", 6.5f));

		store.addMedia(new Book("Project Hail Mary", "Sci-Fi/Adventure", 8.7f));
		store.addMedia(new Book("The Midnight Library", "Fantasy/Philosophy", 7.4f));
		store.addMedia(new Book("Educated", "Memoir/Inspirational", 9.0f));
		store.addMedia(new Book("Tuổi Trẻ Đáng Giá Bao Nhiêu", "Self-help/Motivational", 6.2f));
		store.addMedia(new Book("Tôi Thấy Hoa Vàng Trên Cỏ Xanh", "Fiction/Coming-of-age", 7.0f));
		store.addMedia(new Book("Đi Tìm Lẽ Sống", "Philosophy/Psychology", 8.0f));
		store.addMedia(new Book("Chiếc Lược Ngà", "War/Short Story", 5.8f));
		store.addMedia(new Book("Đất Rừng Phương Nam", "Adventure/Historical", 7.5f));
		
		launch(args);
		
	}
}