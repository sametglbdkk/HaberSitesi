package model;

public enum Category {
    SPORTS("Sports"),
    MAGAZINE("Magazine"),
    POLITICS("Politics"),
    TECHNOLOGY("Technology"),
    TRAVEL("Travel"),
    FOOD("Food"),
    MUSIC("Music"),
    EDUCATION("Education"),
    BUSINESS("Business"),
    ENTERTAINMENT("Entertainment");

    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
