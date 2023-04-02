package group.lab1FINAL.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table(name= "review")

public class Review {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(name="username")
    private String username;
    @Column(name="description")
    private String description;
    @Column(name="rating")
    private float rating;
    @Column(name="date")
    private String date;
    @Column(name="recommend")
    private boolean recommend;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Review( String username, String description, float rating, String date, boolean recommend, Employee employee) {

        this.username = username;
        this.description = description;
        this.rating = rating;
        this.date = date;
        this.recommend = recommend;
        this.employee = employee;
    }

    public Review() {
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
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

    public boolean getRecommend() {
        return recommend;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", date='" + date + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}
