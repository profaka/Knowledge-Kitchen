import javafx.collections.ObservableList;
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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GalleryPage {
    private MainController mainController;
    private VBox layout;

    public GalleryPage(MainController mainController) { // Измененный конструктор
        this.mainController = mainController; // Инициализируйте MainController

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

        // Получаем список путей изображений из объектов FoodItem
        ObservableList<FoodItem> foodItems = mainController.getFoodItems();
        List<String> imagePaths = foodItems.stream()
                .map(FoodItem::getImagePath)
                .collect(Collectors.toList());

        Collections.shuffle(imagePaths); // Перемешиваем для случайного порядка

        for (String imagePath : imagePaths) {
            Image image = new Image(imagePath);
            ImageView imageView = new ImageView(image);
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