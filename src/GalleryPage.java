import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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

        // Placeholder for images
        for (int i = 1; i <= 5; i++) {
            ImageView imageView = new ImageView(new Image("file:resources/images/food" + i + ".png"));
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
