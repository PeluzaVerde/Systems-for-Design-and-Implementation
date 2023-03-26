package group.lab1FINAL.Repo;

import group.lab1FINAL.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long>{
}
