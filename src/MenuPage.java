import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuPage {

    private VBox layout;

    public MenuPage() {
        layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label pageTitle = new Label("Menu");
        pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        GridPane menuItemsGrid = createMenuItemsGrid();

        layout.getChildren().addAll(pageTitle, menuItemsGrid);
    }

    private GridPane createMenuItemsGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Example menu items
        String[][] menuItems = {
                {"Starters", "Salmon Carpaccio", "Fondue", "Veal Carpaccio"},
                {"Salads", "Meat Salad", "Turkey Salad"},
                {"Soups", "Chiopino"}
        };

        for (int i = 0; i < menuItems.length; i++) {
            Label categoryLabel = new Label(menuItems[i][0]);
            categoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            grid.add(categoryLabel, 0, i);

            VBox itemsBox = new VBox(5);
            for (int j = 1; j < menuItems[i].length; j++) {
                Label itemLabel = new Label(menuItems[i][j]);
                itemLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
                itemsBox.getChildren().add(itemLabel);
            }
            grid.add(itemsBox, 1, i);
        }

        return grid;
    }

    public VBox getLayout() {
        return layout;
    }
}
