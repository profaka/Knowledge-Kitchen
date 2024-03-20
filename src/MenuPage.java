import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuPage {
    private VBox layout;
    private MainController mainController;

    public MenuPage(MainController mainController) {
        this.mainController = mainController;
        layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        // Группировка блюд по категориям
        Map<String, List<FoodItem>> foodItemsByCategory = mainController.getFoodItems().stream()
                .collect(Collectors.groupingBy(FoodItem::getCategory));

        // Создание GUI для каждой категории
        foodItemsByCategory.forEach((category, foodItems) -> {
            Label categoryLabel = new Label(category);
            categoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            VBox categoryBox = new VBox(categoryLabel);
            categoryBox.setSpacing(5);
            categoryBox.setPadding(new Insets(15, 0, 15, 0));

            foodItems.forEach(foodItem -> {
                Label itemLabel = new Label(foodItem.getName() + " - " + foodItem.getDescription() + " - $" + foodItem.getPrice());
                itemLabel.setWrapText(true);
                itemLabel.setMaxWidth(200);

                BorderPane borderPane = new BorderPane();
                borderPane.setCenter(itemLabel);
                BorderPane.setAlignment(itemLabel, Pos.CENTER_LEFT);
                borderPane.setPadding(new Insets(10));

                categoryBox.getChildren().add(borderPane);
            });

            layout.getChildren().add(categoryBox);
        });
    }

    private VBox createMenuSection(String category, List<String> items) {
        VBox section = new VBox(10);
        section.setAlignment(Pos.CENTER_LEFT);

        Label categoryLabel = new Label(category);
        categoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        section.getChildren().add(categoryLabel);

        for (String item : items) {
            Label itemLabel = new Label(item);
            itemLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
            section.getChildren().add(itemLabel);
        }

        return section;
    }

    public VBox getLayout() {
        return layout;
    }
}