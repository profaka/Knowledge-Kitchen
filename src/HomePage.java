import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        // Загрузка изображения из папки resources
        Image image = new Image("resources\\hello.jpeg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);

        layout.getChildren().addAll(welcomeText, imageView);
    }

    public VBox getLayout() {
        return layout;
    }
}