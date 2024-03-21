import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class GalleryPage {
    private MainController mainController;
    private VBox layout;

    public GalleryPage(MainController mainController) {
        this.mainController = mainController;

        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label pageTitle = new Label("Gallery");
        pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        ScrollPane scrollPane = new ScrollPane(); // Создаем ScrollPane
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Полоса прокрутки по горизонтали при необходимости
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Полоса прокрутки по вертикали при необходимости
        scrollPane.setFitToWidth(true); // Подгонять ширину содержимого под ширину ScrollPane
        scrollPane.setPadding(new Insets(10)); // Отступ для ScrollPane

        TilePane imageGallery = createImageGallery();
        scrollPane.setContent(imageGallery); // Устанавливаем TilePane как содержимое ScrollPane

        layout.getChildren().addAll(pageTitle, scrollPane); // Добавляем ScrollPane вместо TilePane напрямую
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
