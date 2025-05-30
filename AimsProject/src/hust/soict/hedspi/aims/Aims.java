package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.exception.*;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.media.*;

import java.util.*;

public class Aims {
    private static Store store;
    private static ArrayList<Media> cart = new ArrayList<>();

    public static void main(String[] args) throws LimitExceedMediaException, PlayerException {
        store = new Store();
        Scanner scanner = new Scanner(System.in);

        store.addMedia(new Book("Harry Potter", "J. K. Rowling", 25.99f));
        store.addMedia(new Book("Effective Java", "Programming", 45.0f));
        store.addMedia(new DigitalVideoDisc("Super Sentai", "JPanimate", 19.99f));
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new CompactDisc("Back in black"));
        store.addMedia(new CompactDisc("Hybrid Theory", "Music", "Linkin Park", 29.99f));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    seeCurrentCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() throws LimitExceedMediaException,PlayerException {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        storeMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                seeMediaDetails(scanner);
                break;
            case 2:
                addMediaToCart(scanner);
                break;
            case 3:
                playMedia(scanner);
                break;
            case 4:
                seeCurrentCart(scanner);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void storeMenu() throws LimitExceedMediaException,PlayerException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() throws LimitExceedMediaException,PlayerException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void seeMediaDetails(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            System.out.println("Details of " + title + ": " + media);
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addMediaToCart(scanner);
                    break;
                case 2:
                    playMedia(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void addMediaToCart(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        System.out.print("Enter media title to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            cart.add(media);
            System.out.println(media.getTitle() + " added to the cart.");
            if (media instanceof DigitalVideoDisc) {
                System.out.println("There are " + countDVDsInCart() + " DVDs in the cart.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
                System.out.println("Playing " + media.getTitle());
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void seeCurrentCart(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Media media : cart) {
                System.out.println(media);
            }
        }
        cartMenu(scanner);
    }

    public static void cartMenu(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                filterMediasInCart(scanner);
                break;
            case 2:
                sortMediasInCart(scanner);
                break;
            case 3:
                removeMediaFromCart(scanner);
                break;
            case 4:
                playMedia(scanner);
                break;
            case 5:
                placeOrder();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void filterMediasInCart(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                // Filter by ID 
                break;
            case 2:
                // Filter by Title
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    public static void updateStore(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                addMediaToStore(scanner);
                break;
            case 2:
                removeMediaFromStore(scanner);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void addMediaToStore(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        System.out.println("Enter media type (1: Book, 2: DVD, 3: CompactDisc): ");
        int mediaType = scanner.nextInt();
        scanner.nextLine();

        Media media = null;

        switch (mediaType) {
            case 1:
                System.out.println("Enter book title: ");
                String bookTitle = scanner.nextLine();
                System.out.println("Enter book category: ");
                String bookCategory = scanner.nextLine();
                System.out.println("Enter book cost: ");
                Float bookCost = scanner.nextFloat();
                scanner.nextLine();

                Book newBook = new Book(bookTitle, bookCategory, bookCost);
                store.addMedia(newBook);
                break;
            case 2:
                System.out.println("Enter DVD title: ");
                String dvdTitle = scanner.nextLine();
                System.out.println("Enter DVD category: ");
                String dvdCategory = scanner.nextLine();
                System.out.println("Enter book cost: ");
                Float dvdCost = scanner.nextFloat();
                scanner.nextLine();
                
                DigitalVideoDisc newDVD = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdCost);
                store.addMedia(newDVD);                
                break;
            case 3:
                System.out.println("Enter CD title: ");
                String cdTitle = scanner.nextLine();
                System.out.println("Enter CD category: ");
                String cdCategory = scanner.nextLine();
                System.out.println("Enter CD artist: ");
                String cdArtist = scanner.nextLine();
                System.out.println("Enter CD cost: ");
                Float cdCost = scanner.nextFloat();
                scanner.nextLine();

                media = new CompactDisc(cdTitle, cdCategory, cdArtist, cdCost);

                break;
            default:
                System.out.println("Invalid media type.");
                return;
        }

        store.addMedia(media);
        System.out.println("Media added successfully!");
    }

    public static void removeMediaFromStore(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        System.out.print("Enter title of media to remove: ");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title);
        
        if (media != null) {
            store.removeMedia(media); 
        } else {
            System.out.println("Media not found in the store.");
        }
    }


    public static void sortMediasInCart(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                // Sorting by title (implementation can be added)
                break;
            case 2:
                // Sorting by cost (implementation can be added)
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void removeMediaFromCart(Scanner scanner) throws LimitExceedMediaException,PlayerException {
        System.out.print("Enter media title to remove from cart: ");
        String title = scanner.nextLine();
        Media media = getCartMediaByTitle(title);
        if (media != null) {
            cart.remove(media);
            System.out.println(media.getTitle() + " removed from the cart.");
        } else {
            System.out.println("Media not found in the cart.");
        }
    }

    public static void placeOrder() throws LimitExceedMediaException,PlayerException {
        System.out.println("Order placed successfully!");
        cart.clear();
    }

    public static Media getCartMediaByTitle(String title) throws LimitExceedMediaException,PlayerExceptionc {
        for (Media media : cart) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public static int countDVDsInCart() throws LimitExceedMediaException,PlayerException {
        int count = 0;
        for (Media media : cart) {
            if (media instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }
}