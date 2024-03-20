import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ContactUsPage {

    private VBox layout;

    public ContactUsPage() {
        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label pageTitle = new Label("Contact Us");
        pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        GridPane formGrid = createContactForm();

        layout.getChildren().addAll(pageTitle, formGrid);
    }

    private GridPane createContactForm() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Form fields
        TextField nameField = new TextField();
        nameField.setPromptText("Your Name");
        TextField emailField = new TextField();
        emailField.setPromptText("Your Email");
        TextArea commentField = new TextArea();
        commentField.setPromptText("Your Comment");
        Button submitButton = new Button("Send");

        // Add form fields to the grid
        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Email:"), 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(new Label("Comment:"), 0, 2);
        grid.add(commentField, 1, 2);
        grid.add(submitButton, 1, 3);

        // Placeholder action for submit button
        submitButton.setOnAction(e -> System.out.println("Comment submitted!"));

        return grid;
    }

    public VBox getLayout() {
        return layout;
    }
}
