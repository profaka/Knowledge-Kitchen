import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainController {

    private ObservableList<FoodItem> foodItems;
    private ObservableList<Booking> bookings;

    public MainController() {
        this.foodItems = FXCollections.observableArrayList();
        this.bookings = FXCollections.observableArrayList();
        // Here you could load initial data or handle other initialization
    }

    // Add a food item to the menu
    public void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
    }

    // Get the list of food items
    public ObservableList<FoodItem> getFoodItems() {
        return foodItems;
    }

    // Add a booking
    public void addBooking(Booking booking) {
        bookings.add(booking);
        System.out.println("Booking added: " + booking); // Для отладки
    }

    // Get the list of bookings
    public ObservableList<Booking> getBookings() {
        return bookings;
    }

    // Here you could add more methods to handle user actions, like navigation, form submissions, etc.
}
