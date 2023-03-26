package group.lab1FINAL.Service;

import group.lab1FINAL.Model.EmployeeDTO;
import group.lab1FINAL.Model.Restaurant;
import group.lab1FINAL.Model.RestaurantDTO;
import group.lab1FINAL.Repo.RestaurantRepo;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service

public class RestaurantService implements Service<Restaurant> {
    private RestaurantRepo repo;

    public RestaurantRepo getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepo repo) {
        this.repo = repo;
    }

    public RestaurantService(RestaurantRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Long> getAll() {
        return repo.findAll().stream().map(restaurant->restaurant.getId()).collect(Collectors.toList());
    }

    @Override
    public Restaurant save(Restaurant obj) {
        return repo.save(obj);
    }

    @Override
    public Restaurant getById(Long id) {

        return repo.findById(id).get();
    }

    @Override
    public Restaurant update(Restaurant obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);

    }

    public List<RestaurantDTO> getComparison(){
        return repo.findAll().stream()
                .map(restaurant->{return new RestaurantDTO(restaurant.getName(),restaurant.getRating());}).
                sorted().collect(Collectors.toList());
    }

}
