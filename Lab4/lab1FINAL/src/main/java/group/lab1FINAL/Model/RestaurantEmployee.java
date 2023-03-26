package group.lab1FINAL.Model;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name= "restaurantemployee")
public class RestaurantEmployee {
    public RestaurantEmployee(Long id) {
        this.id = id;
    }

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(name="numberofwriteups")
    private Integer numberOfWriteUps;
    @Column(name="boss")
    private String boss;
    @Column(name="hours")
    private Integer hours;
    @Column(name="partTime")
    private Boolean partTime;
    @Column(name="remote")
    private Boolean remote;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    public RestaurantEmployee(Integer numberOfWriteUps, String boss, Integer hours, Boolean partTime, Boolean remote, Employee employee, Restaurant restaurant) {

        this.numberOfWriteUps = numberOfWriteUps;
        this.boss = boss;
        this.hours = hours;
        this.partTime = partTime;
        this.remote = remote;
        this.employee = employee;
        this.restaurant = restaurant;

    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Boolean getPartTime() {
        return partTime;
    }

    public void setPartTime(Boolean partTime) {
        this.partTime = partTime;
    }

    public Boolean getRemote() {
        return remote;
    }

    public void setRemote(Boolean remote) {
        this.remote = remote;
    }

    public Integer getNumberOfWriteUps() {
        return numberOfWriteUps;
    }

    public void setNumberOfWriteUps(Integer numberOfWriteUps) {
        this.numberOfWriteUps = numberOfWriteUps;
    }

    public RestaurantEmployee() {
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "RestaurantEmployee{" +
                "id=" + id +
                ", numberOfWriteUps=" + numberOfWriteUps +
                ", boss='" + boss + '\'' +
                ", hours=" + hours +
                ", partTime=" + partTime +
                ", remote=" + remote +
                ", employee=" + employee +
                ", restaurant=" + restaurant +
                '}';
    }
}
