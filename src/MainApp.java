import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private MainController mainController;
    private StackPane overlay;

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
        overlay = new StackPane();
        overlay.setVisible(false); // Изначально делаем слой невидимым

        // Обертываем основной layout и overlay в новый StackPane
        StackPane mainContainer = new StackPane(rootLayout, overlay);

        Scene scene = new Scene(mainContainer, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Shows the Home page inside the root layout.
     */
    public void showHomePage() {
        HomePage homePage = new HomePage(this::showBookingPage);
        // Implement navigation logic here
        // For example, on some button click: homePage.getMenuButton().setOnAction(e -> showMenuPage());
        rootLayout.setCenter(homePage.getLayout());
    }

    public void showBookingPage() {
        BookingPage bookingPage = new BookingPage();
        overlay.getChildren().clear(); // Очищаем предыдущее содержимое, если оно есть
        overlay.getChildren().add(bookingPage.getLayout());
        overlay.setVisible(true); // Делаем слой видимым
    }

    // Additional methods to show other pages like showMenuPage(), showBookingPage(), etc.

    public static void main(String[] args) {
        launch(args);
    }
}
