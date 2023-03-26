package group.lab1FINAL.Repo;
import group.lab1FINAL.Model.RestaurantEmployee;
import group.lab1FINAL.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface RestaurantEmployeeRepo extends JpaRepository<RestaurantEmployee,Long>{
}
