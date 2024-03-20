public class FoodItem {
    private String name;
    private String category;
    private double price;
    private String description;

    private String imagePath;

    public FoodItem(String name, String category, double price, String description, String imagePath) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return name + " - " + description + " - " + price;
    }
}
