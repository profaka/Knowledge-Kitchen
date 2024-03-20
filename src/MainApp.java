import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private MainController mainController;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.mainController = new MainController();

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
        Button menuButton = new Button("Menu");
        Button bookingButton = new Button("Booking");
        Button galleryButton = new Button("Gallery");
        Button contactButton = new Button("Contact");
        Button bookingManagementButton = new Button("Booking Management");

        // Установите обработчики событий для кнопок
        menuButton.setOnAction(e -> showMenuPage());
        bookingButton.setOnAction(e -> showBookingPage());
        galleryButton.setOnAction(e -> showGalleryPage());
        contactButton.setOnAction(e -> showContactUsPage());
        bookingManagementButton.setOnAction(e -> showBookingManagementPage());
        topMenu.setStyle("-fx-background-color: #336699;");
        menuButton.setStyle("-fx-font-size: 14px; -fx-background-color: #ffffff;");
// Примените аналогичный стиль для остальных кнопок

        // Добавьте метод showBookingManagementPage() аналогично вышеуказанным, для страницы управления бронированиями

        // Добавление кнопок на панель
        topMenu.getChildren().addAll(menuButton, bookingButton, galleryButton, contactButton, bookingManagementButton);

        rootLayout.setTop(topMenu); // Добавить шапку в верхнюю часть rootLayout

        Scene scene = new Scene(rootLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showMenuPage() {
        MenuPage menuPage = new MenuPage();
        rootLayout.setCenter(menuPage.getLayout());
    }

    public void showBookingPage() {
        BookingPage bookingPage = new BookingPage(mainController);
        rootLayout.setCenter(bookingPage.getLayout());
    }

    public void showGalleryPage() {
        GalleryPage galleryPage = new GalleryPage();
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
