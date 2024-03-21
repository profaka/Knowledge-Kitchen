import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private MainController mainController;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.mainController = new MainController();
        FoodItem saladG = new FoodItem("Греческий салат", "Салаты", 5.99, "Свежие овощи с фетой и оливковым маслом", "resources\\greekSalad.jpeg");
        FoodItem saladC = new FoodItem("Салат цезарь", "Салаты", 6.99, "Овощной салат, популярное блюдо американской кухни.", "resources\\cesar.jpeg");
        FoodItem saladO = new FoodItem("Оливье", "Салаты", 2.99, "Салат Оливье классический советский", "resources\\olive.jpeg");
        FoodItem soupT = new FoodItem("Томатный суп", "Супы", 4.99, "Кремовый томатный суп с базиликом", "resources\\tomate.jpeg");
        FoodItem soupK = new FoodItem("Куриный суп", "Супы", 4.99, "Классический куриный суп", "resources\\kuriny.jpeg");
        FoodItem dessertH = new FoodItem("Чизкейк", "Десерты", 6.50, "Нежный чизкейк с ягодным соусом", "resources\\cheescake.jpeg");
        FoodItem dessertT = new FoodItem("Творожный десерт", "Десерты", 6.50, "Прекрасное домашнее лакомство, которое подойдёт как к завтраку, так и на десерт.", "resources\\tvorog.jpeg");
        FoodItem dessertE = new FoodItem("Эстонская выпечка", "Десерты", 6.50, "Невероятно вкусная выпечка, попробуй и ты", "resources\\estonskiy.jpg");
        mainController.addFoodItem(saladG);
        mainController.addFoodItem(saladC);
        mainController.addFoodItem(saladO);
        mainController.addFoodItem(soupT);
        mainController.addFoodItem(soupK);
        mainController.addFoodItem(dessertH);
        mainController.addFoodItem(dessertT);
        mainController.addFoodItem(dessertE);
        primaryStage.setTitle("Knowledge Kitchen - Food Ordering System");
        initRootLayout();
        showHomePage();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        rootLayout = new BorderPane();

        // Создание панели с кнопками для шапки
        HBox topMenu = new HBox();
        topMenu.setSpacing(10); // Установите промежуток между кнопками
        topMenu.setAlignment(Pos.CENTER); // Выравнивание кнопок по центру
        topMenu.setPadding(new Insets(15, 12, 15, 12)); // Установите отступы

        // Создание кнопок
        Button homePageButton = createStyledButton("HomePage");
        Button menuButton = createStyledButton("Menu");
        Button bookingButton = createStyledButton("Booking");
        Button galleryButton = createStyledButton("Gallery");
        Button contactButton = createStyledButton("Contact");
        Button bookingManagementButton = createStyledButton("Booking Management");

        // Установите обработчики событий для кнопок
        homePageButton.setOnAction(e -> showHomePage());
        menuButton.setOnAction(e -> showMenuPage());
        bookingButton.setOnAction(e -> showBookingPage());
        galleryButton.setOnAction(e -> showGalleryPage());
        contactButton.setOnAction(e -> showContactUsPage());
        bookingManagementButton.setOnAction(e -> showBookingManagementPage());
        topMenu.setStyle("-fx-background-color: #212121;");
// Примените аналогичный стиль для остальных кнопок

        // Добавьте метод showBookingManagementPage() аналогично вышеуказанным, для страницы управления бронированиями

        // Добавление кнопок на панель
        topMenu.getChildren().addAll(homePageButton, menuButton, bookingButton, galleryButton, contactButton, bookingManagementButton);
        topMenu.setStyle("-fx-background-color: #000000;");
        rootLayout.setTop(topMenu); // Добавить шапку в верхнюю часть rootLayout

        Scene scene = new Scene(rootLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-font-size: 14px; -fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-border-color: #2c2c2c; -fx-border-width: 2;");
        button.setPrefSize(140, 30);
        button.setPadding(new Insets(5, 12, 5, 12));
        return button;
    }

    public void showMenuPage() {
        MenuPage menuPage = new MenuPage(mainController);
        rootLayout.setCenter(menuPage.getLayout());
    }

    public void showBookingPage() {
        BookingPage bookingPage = new BookingPage(mainController);
        rootLayout.setCenter(bookingPage.getLayout());
    }

    public void showGalleryPage() {
        GalleryPage galleryPage = new GalleryPage(mainController);
        rootLayout.setCenter(galleryPage.getLayout());
    }

    public void showContactUsPage() {
        ContactUsPage contactUsPage = new ContactUsPage();
        rootLayout.setCenter(contactUsPage.getLayout());
    }

    public void showBookingManagementPage() {
        BookingManagementPage bookingManagementPage = new BookingManagementPage(mainController);
        rootLayout.setCenter(bookingManagementPage.getLayout());
    }


    /**
     * Shows the Home page inside the root layout.
     */
    public void showHomePage() {
        HomePage homePage = new HomePage();
        // Implement navigation logic here
        // For example, on some button click: homePage.getMenuButton().setOnAction(e -> showMenuPage());
        rootLayout.setCenter(homePage.getLayout());
    }

    // Additional methods to show other pages like showMenuPage(), showBookingPage(), etc.

    public static void main(String[] args) {
        launch(args);
    }
}
