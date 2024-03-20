import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HomePage {

    private VBox layout;

    public HomePage() {
        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Text welcomeText = new Text("Welcome to Knowledge Kitchen");
        welcomeText.setStyle("-fx-font-size: 20px;");

        layout.getChildren().add(welcomeText);
    }

    public VBox getLayout() {
        return layout;
    }
}

