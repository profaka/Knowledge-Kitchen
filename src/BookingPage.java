import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingPage {
    private MainController mainController;

    private VBox layout;

    public BookingPage(MainController mainController) {
        this.mainController = mainController;
        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label pageTitle = new Label("Book Your Table");
        pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        GridPane formGrid = createBookingForm();

        layout.getChildren().addAll(pageTitle, formGrid);
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
        submitButton.setOnAction(e -> {
            String errorMessage = "";

            if (nameField.getText().isEmpty()) {
                errorMessage += "Name cannot be empty.\n";
            }
            if (emailField.getText().isEmpty() || !emailField.getText().contains("@")) {
                errorMessage += "Please enter a valid email.\n";
            }
            if (phoneField.getText().isEmpty()) {
                errorMessage += "Phone cannot be empty.\n";
            }
            if (datePicker.getValue() == null) {
                errorMessage += "Please select a date.\n";
            }
            try {
                LocalTime.parse(timeField.getText());
            } catch (Exception ex) {
                errorMessage += "Please enter a valid time (HH:MM).\n";
            }
            try {
                int partySize = Integer.parseInt(sizeField.getText());
                if (partySize <= 0) {
                    errorMessage += "Party size must be greater than 0.\n";
                }
            } catch (NumberFormatException ex) {
                errorMessage += "Party size must be a number.\n";
            }

            if (!errorMessage.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Please correct the following errors:");
                alert.setContentText(errorMessage);
                alert.showAndWait();
            } else {
                Booking newBooking = new Booking(
                        nameField.getText(),
                        emailField.getText(),
                        phoneField.getText(),
                        datePicker.getValue(),
                        LocalTime.parse(timeField.getText()),
                        Integer.parseInt(sizeField.getText()),
                        specialRequestsField.getText()
                );
                mainController.addBooking(newBooking);

                // Очистка полей формы после отправки
                nameField.clear();
                emailField.clear();
                phoneField.clear();
                datePicker.setValue(LocalDate.now()); // Возвращаем к текущей дате
                timeField.clear();
                sizeField.clear();
                specialRequestsField.clear();

                // Показ уведомления об успешной отправке
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Booking Submitted");
                alert.setHeaderText(null);
                alert.setContentText("Your booking has been successfully submitted!");
                alert.showAndWait();
            }
        });

        return grid;
    }

    public VBox getLayout() {
        return layout;
    }
}
