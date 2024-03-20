import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.time.LocalDate;

public class BookingPage {

    private VBox layout;

    public BookingPage() {
        VBox formContainer = new VBox(10);
        formContainer.setAlignment(Pos.CENTER);
        // Устанавливаем отступы так, чтобы верхняя часть страницы оставалась видимой
        formContainer.setPadding(new Insets(40, 20, 5, 20)); // Пример отступа сверху
        formContainer.setStyle("-fx-background-color: white;"); // Белый фон с закругленными углами

        Label pageTitle = new Label("Book Your Table");
        pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        GridPane formGrid = createBookingForm();
        formContainer.getChildren().addAll(pageTitle, formGrid);

        // Добавляем formContainer к основному layout, который теперь станет прозрачным
        layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(formContainer);
        // Применяем прозрачный фон к основному layout
        layout.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");


    }

    private GridPane createBookingForm() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Form fields
        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone");
        DatePicker datePicker = new DatePicker(LocalDate.now());
        TextField timeField = new TextField();
        timeField.setPromptText("Time (HH:MM)");
        TextField sizeField = new TextField();
        sizeField.setPromptText("Party Size");
        TextField specialRequestsField = new TextField();
        specialRequestsField.setPromptText("Special Requests");
        Button submitButton = new Button("Submit Booking");

        // Add form fields to the grid
        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Email:"), 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(new Label("Phone:"), 0, 2);
        grid.add(phoneField, 1, 2);
        grid.add(new Label("Date:"), 0, 3);
        grid.add(datePicker, 1, 3);
        grid.add(new Label("Time:"), 0, 4);
        grid.add(timeField, 1, 4);
        grid.add(new Label("Party Size:"), 0, 5);
        grid.add(sizeField, 1, 5);
        grid.add(new Label("Special Requests:"), 0, 6);
        grid.add(specialRequestsField, 1, 6);
        grid.add(submitButton, 1, 7);

        // Placeholder action for submit button
        submitButton.setOnAction(e -> System.out.println("Booking submitted!"));

        return grid;
    }

    public VBox getLayout() {
        return layout;
    }
}
