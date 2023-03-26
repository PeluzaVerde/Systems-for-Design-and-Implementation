package group.lab1FINAL.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name= "restaurant")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Restaurant {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="rating")
    private float rating;
    @Column(name="date")
    private String date;
    @Column(name="city")
    private String city;




    @OneToMany
    @JoinColumn(name="employee_id")
    private List<RestaurantEmployee> restaurantEmployees;
//    @ManyToOne
//    @JoinColumn(name="employee_id")
//    private Employee employee;

    public Restaurant(String name, String description, float rating, String date, String city) {

        this.name = name;
        this.description = description;
        this.rating = rating;
        this.date = date;
        this.city = city;
    }

    public Restaurant() {
    }




    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", date='" + date + '\'' +
                ", city=" + city +
                '}';
    }
}
