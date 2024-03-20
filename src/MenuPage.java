import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Arrays;
import java.util.List;

public class MenuPage {
    private VBox layout;

    public MenuPage() {
        layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label pageTitle = new Label("Menu");
        pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        layout.getChildren().add(pageTitle);
        layout.getChildren().add(createMenuSection("Salads", Arrays.asList("Greek Salad - 100g", "Caesar Salad - 150g")));
        layout.getChildren().add(createMenuSection("Soups", Arrays.asList("Tomato Soup - 250ml", "Chicken Soup - 300ml")));
        layout.getChildren().add(createMenuSection("Desserts", Arrays.asList("Cheesecake - 200g", "Ice Cream - 150g")));
        layout.getChildren().add(createMenuSection("Drinks", Arrays.asList("Coffee - 200ml", "Green Tea - 250ml")));
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
