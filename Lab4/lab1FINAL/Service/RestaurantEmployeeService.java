package group.lab1FINAL.Service;
import group.lab1FINAL.Model.RestaurantEmployee;
import group.lab1FINAL.Repo.RestaurantEmployeeRepo;

import java.util.List;
import java.util.stream.Collectors;
@org.springframework.stereotype.Service
public class RestaurantEmployeeService implements Service<RestaurantEmployee>{

    private RestaurantEmployeeRepo repo;
    public RestaurantEmployeeService(RestaurantEmployeeRepo repo) {
        this.repo = repo;
    }
    @Override
    public List<Long> getAll() {
        return repo.findAll().stream().map(restaurantEmployee->restaurantEmployee.getId()).collect(Collectors.toList());
    }

    @Override
    public RestaurantEmployee save(RestaurantEmployee obj) {
        return repo.save(obj);
    }

    @Override
    public RestaurantEmployee getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public RestaurantEmployee update(RestaurantEmployee obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
