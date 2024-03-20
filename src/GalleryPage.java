import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Arrays;
import java.util.List;

public class GalleryPage {
    private VBox layout;

    public GalleryPage() {
        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label pageTitle = new Label("Gallery");
        pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        TilePane imageGallery = createImageGallery();

        layout.getChildren().addAll(pageTitle, imageGallery);
    }

    private TilePane createImageGallery() {
        TilePane tilePane = new TilePane();
        tilePane.setAlignment(Pos.CENTER);
        tilePane.setPadding(new Insets(15, 15, 15, 15));
        tilePane.setHgap(15);
        tilePane.setVgap(15);

        List<String> imagePaths = Arrays.asList(
                "/resourses/cat.jpg"
                // Добавьте пути к вашим изображениям
        );

        for (String imagePath : imagePaths) {
            ImageView imageView = new ImageView(new Image(imagePath));
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            imageView.setPreserveRatio(true);
            tilePane.getChildren().add(imageView);
        }

        return tilePane;
    }

    public VBox getLayout() {
        return layout;
    }
}
