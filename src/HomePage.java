import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HomePage {

    private VBox layout;
    private Runnable onShowBookingPage;

    public HomePage(Runnable onShowBookingPage) {
        this.onShowBookingPage = onShowBookingPage;
        layout = new VBox(); // Убираем расстояние между элементами, чтобы использовать весь верхний контейнер
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);"); // Черный фон с прозрачностью
        layout.setFillWidth(true); // Растягиваем VBox на всю ширину

        Text welcomeText = new Text("Добро пожаловать в Knowledge Kitchen");
        welcomeText.setStyle("-fx-font-size: 20px; -fx-fill: white;");

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        // Убрали фон для HBox, т.к. фон будет у VBox

        // Стилизуем кнопки
        String buttonStyle = "-fx-background-color: linear-gradient(#ff5400, #be1d00);" +
                "-fx-background-radius: 30;" +
                "-fx-background-insets: 0;" +
                "-fx-text-fill: white;" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );";

        Button menuButton = new Button("Меню");
        Button bookingButton = new Button("Бронирование");
        Button galleryButton = new Button("Галерея");
        Button contactUsButton = new Button("Контакты");

        // Применяем стили к кнопкам
        menuButton.setStyle(buttonStyle);
        bookingButton.setStyle(buttonStyle);
        galleryButton.setStyle(buttonStyle);
        contactUsButton.setStyle(buttonStyle);

        menuButton.setOnAction(e -> showMenuPage());
        bookingButton.setOnAction(e -> showBookingPage());
        galleryButton.setOnAction(e -> showGalleryPage());
        contactUsButton.setOnAction(e -> showContactUsPage());

        buttonBox.getChildren().addAll(menuButton, bookingButton, galleryButton, contactUsButton);
        layout.getChildren().addAll(welcomeText, buttonBox);
    }

    private void showBookingPage() {
        if (onShowBookingPage != null) {
            onShowBookingPage.run();
        }
    }

    // Placeholder method for showing the menu page
    private void showMenuPage() {
        // Implementation will switch to the Menu page view
        System.out.println("Navigating to Menu Page...");
    }

    // Placeholder method for showing the gallery page
    private void showGalleryPage() {
        // Implementation will switch to the Gallery page view
        System.out.println("Navigating to Gallery Page...");
    }

    // Placeholder method for showing the contact us page
    private void showContactUsPage() {
        // Implementation will switch to the Contact Us page view
        System.out.println("Navigating to Contact Us Page...");
    }

    public VBox getLayout() {
        return layout;
    }
}

