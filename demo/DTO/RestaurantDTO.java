package com.example.demo.DTO;

public class RestaurantDTO {
    private String image;
    private String title ;
    private boolean isfreeship;
    private String subtitle;
    private double Rating;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIsfreeship() {
        return isfreeship;
    }

    public void setIsfreeship(boolean isfreeship) {
        this.isfreeship = isfreeship;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }
}
