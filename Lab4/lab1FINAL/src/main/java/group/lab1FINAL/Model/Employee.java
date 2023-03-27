package group.lab1FINAL.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;


    @Column(name = "age")
    private String age;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "name")
    private String name;
    @Column(name = "restaurant")
    private String restaurant;

    @Column(name = "intern")
    private Boolean intern;
//    @OneToMany(mappedBy = "employee",targetEntity = Review.class,cascade = CascadeType.ALL)
//    private List<Review> reviews;


    @JsonIgnoreProperties("reviews")
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Review> reviews;



    @OneToMany
    @JoinColumn(name="restaurant_id")
    @JsonIgnoreProperties("employee")
    private List<RestaurantEmployee> restaurantEmployees;


    public Employee(String age, Integer salary, String name, String restaurant, Boolean intern) {
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.restaurant = restaurant;
        this.intern = intern;
    }

    public Employee() {}

    public Long getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public Boolean getIntern() {
        return intern;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setIntern(Boolean intern) {
        this.intern = intern;
    }

    public List<RestaurantEmployee> getRestaurantEmployees() {
        return restaurantEmployees;
    }

    public void setRestaurantEmployees(List<RestaurantEmployee> restaurantEmployees) {
        this.restaurantEmployees = restaurantEmployees;
    }

    @Override
    public boolean equals(Object obj) {
        if( this == obj)
            return true;
        if( !(obj instanceof Employee))
            return false;
        Employee employee = (Employee) obj;
        return Objects.equals(this.id,employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "Employee{" +"\n"+
                "id=" + id +"\n"+
                ", age='" + age + '\'' +"\n"+
                ", salary=" + salary +"\n"+
                ", name='" + name + '\'' +"\n"+
                ", restaurant='" + restaurant + '\'' +"\n"+
                ", intern=" + intern +"\n"+
                '}';
    }
}
