package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.*;

public class ViewStoreController {
	private Store store;
	private Cart cart;
 	
	public ViewStoreController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
	
	@FXML
	public void initialize() {
		final String ITEM_XML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";
		System.out.println(getClass().getResource(ITEM_XML_FILE_PATH));
		int column = 0;
		int row = 1;
		for(int i = 0; i < store.getItemsInStore().size(); i++) {
			try {
				FXMLLoader fxmlloader = new FXMLLoader();
				fxmlloader.setLocation(getClass().getResource(ITEM_XML_FILE_PATH));
				ItemController itemController = new ItemController(cart);
				fxmlloader.setController(itemController);
				AnchorPane anchorPane = new AnchorPane();
				anchorPane = fxmlloader.load();
				itemController.setData(store.getItemsInStore().get(i));
				if(column == 3) {
					column = 0;
					row++;
				}
				gridPane.add(anchorPane, column++, row);
				GridPane.setMargin(anchorPane,new Insets( 20, 10, 10, 10));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@FXML
    private GridPane gridPane;
    
 	@FXML
    void btnViewCartPressed(ActionEvent event) {
 		try{
            final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlloader.setController(new CartController(cart, store));
            Parent root = fxmlloader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}