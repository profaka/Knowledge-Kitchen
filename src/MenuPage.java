import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuPage {
    private ScrollPane scrollPane;
    private MainController mainController;

    public MenuPage(MainController mainController) {
        this.mainController = mainController;
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20));

        // Группировка блюд по категориям
        mainController.getFoodItems().stream()
                .collect(Collectors.groupingBy(FoodItem::getCategory))
                .forEach((category, foodItems) -> {
                    Label categoryLabel = new Label(category);
                    categoryLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 24));
                    categoryLabel.setPadding(new Insets(10, 0, 10, 0));
                    categoryLabel.setTextAlignment(TextAlignment.CENTER);
                    categoryLabel.setTextFill(Color.WHITE); // Цвет текста
                    categoryLabel.setStyle("-fx-background-color: #494949; -fx-padding: 10px;"); // Фон
                    categoryLabel.setMaxWidth(Double.MAX_VALUE);
                    categoryLabel.setAlignment(Pos.CENTER);

                    VBox categoryBox = new VBox(categoryLabel);
                    categoryBox.setSpacing(50);
                    categoryBox.setAlignment(Pos.TOP_CENTER);
                    categoryBox.setPadding(new Insets(15, 50, 15, 50)); // Добавил отступы слева и справа

                    foodItems.forEach(foodItem -> {
                        HBox itemBox = new HBox();
                        itemBox.setSpacing(10);
                        itemBox.setAlignment(Pos.CENTER_LEFT);

                        Text nameAndDescription = new Text(foodItem.getName() + " - " + foodItem.getDescription());
                        nameAndDescription.setFont(Font.font("Georgia", FontWeight.NORMAL, 18));

                        Text priceText = new Text("$" + foodItem.getPrice());
                        priceText.setFont(Font.font("Georgia", FontWeight.BOLD, 18));
                        priceText.setFill(Color.RED); // Цвет цены

                        // Добавляем текстовые элементы в HBox
                        itemBox.getChildren().addAll(nameAndDescription, priceText);
                        HBox.setHgrow(nameAndDescription, Priority.ALWAYS); // Обеспечиваем, что название и описание займут всё доступное пространство
                        nameAndDescription.wrappingWidthProperty().bind(itemBox.widthProperty().subtract(priceText.getLayoutBounds().getWidth() + 30)); // Обеспечиваем перенос текста

                        categoryBox.getChildren().add(itemBox);
                    });

                    layout.getChildren().add(categoryBox);
                });

        scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);
        scrollPane.setPadding(new Insets(10));
    }

    public ScrollPane getLayout() {
        return scrollPane;
    }
}
