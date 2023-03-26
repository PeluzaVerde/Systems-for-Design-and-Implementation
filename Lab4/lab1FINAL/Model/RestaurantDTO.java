package group.lab1FINAL.Model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

public class RestaurantDTO implements Comparable<RestaurantDTO>{

    private String name;

    private float rating;



    public RestaurantDTO(String name, float rating) {
        this.name = name;
        this.rating = rating;

    }

    public RestaurantDTO() {
    }





    public void setName(String name) {
        this.name = name;
    }


    public void setRating(float rating) {
        this.rating = rating;
    }


    public String getName() {
        return name;
    }


    public float getRating() {
        return rating;
    }

    @Override
    public int compareTo(RestaurantDTO otherRestaurant) {
        return Float.compare(this.getRating(),otherRestaurant.getRating());
    }
}
