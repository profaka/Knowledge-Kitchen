import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class BookingManagementPage {

    private VBox layout;
    private TableView<Booking> table;
    private MainController controller;

    public BookingManagementPage(MainController controller) {
        this.controller = controller;
        layout = new VBox(10);

        table = new TableView<>();
        initializeTable();

        Button deleteButton = new Button("Delete");
        Button editButton = new Button("Edit");
        editButton.setOnAction(e -> showEditDialog());
        layout.getChildren().add(editButton);

        deleteButton.setOnAction(e -> deleteSelectedBooking());

        layout.getChildren().addAll(table, deleteButton);
    }

    private void initializeTable() {
        TableColumn<Booking, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Booking, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Добавление новых столбцов
        TableColumn<Booking, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Booking, LocalDate> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Booking, LocalTime> timeColumn = new TableColumn<>("Time");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<Booking, Integer> partySizeColumn = new TableColumn<>("Party Size");
        partySizeColumn.setCellValueFactory(new PropertyValueFactory<>("partySize"));

        TableColumn<Booking, String> specialRequestsColumn = new TableColumn<>("Special Requests");
        specialRequestsColumn.setCellValueFactory(new PropertyValueFactory<>("specialRequests"));

        table.getColumns().addAll(nameColumn, emailColumn, phoneColumn, dateColumn, timeColumn, partySizeColumn, specialRequestsColumn);

        ObservableList<Booking> bookings = controller.getBookings();
        table.setItems(bookings);
    }


    private void deleteSelectedBooking() {
        ObservableList<Booking> selectedBookings, allBookings;
        allBookings = table.getItems();
        selectedBookings = table.getSelectionModel().getSelectedItems();

        // Удаление из модели
        selectedBookings.forEach(allBookings::remove);

        // Здесь можно добавить дополнительную логику для обновления данных в controller, если необходимо
    }

    private void showEditDialog() {
        Booking selectedBooking = table.getSelectionModel().getSelectedItem();
        if (selectedBooking == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a booking in the table.");
            alert.showAndWait();
            return;
        }

        Dialog<Booking> dialog = new Dialog<>();
        dialog.setTitle("Edit Booking");
        dialog.setHeaderText("Edit the booking details");

        // Установка типов кнопок
        ButtonType saveButtonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Поля для редактирования
        TextField nameField = new TextField(selectedBooking.getName());
        TextField emailField = new TextField(selectedBooking.getEmail());
        TextField phoneField = new TextField(selectedBooking.getPhone());
        DatePicker datePicker = new DatePicker(selectedBooking.getDate());
        TextField timeField = new TextField(selectedBooking.getTime().toString());
        TextField sizeField = new TextField(String.valueOf(selectedBooking.getPartySize()));
        TextField specialRequestsField = new TextField(selectedBooking.getSpecialRequests());

        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Email:"), 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(new Label("Phone:"), 0, 2);
        grid.add(phoneField, 1, 2);
        grid.add(new Label("Date:"), 0, 3);
        grid.add(datePicker, 1, 3);
        grid.add(new Label("Time (HH:MM):"), 0, 4);
        grid.add(timeField, 1, 4);
        grid.add(new Label("Party Size:"), 0, 5);
        grid.add(sizeField, 1, 5);
        grid.add(new Label("Special Requests:"), 0, 6);
        grid.add(specialRequestsField, 1, 6);

        dialog.getDialogPane().setContent(grid);

        // Конвертация результатов диалога обратно в объект Booking при нажатии кнопки Save
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                Booking editedBooking = new Booking(
                        nameField.getText(),
                        emailField.getText(),
                        phoneField.getText(),
                        datePicker.getValue(),
                        LocalTime.parse(timeField.getText()),
                        Integer.parseInt(sizeField.getText()),
                        specialRequestsField.getText());
                return editedBooking;
            }
            return null;
        });

        Optional<Booking> result = dialog.showAndWait();

        result.ifPresent(booking -> {
            int selectedIndex = table.getSelectionModel().getSelectedIndex();
            controller.getBookings().set(selectedIndex, booking);
            table.getItems().set(selectedIndex, booking);
        });
    }



    public VBox getLayout() {
        return layout;
    }
}
