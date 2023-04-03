package group.lab1FINAL.Controller;

import ch.qos.logback.core.status.ErrorStatus;
import group.lab1FINAL.Model.*;
import group.lab1FINAL.Service.EmployeeServiceImpl;
import group.lab1FINAL.Service.ReviewService;
import group.lab1FINAL.Service.RestaurantService;
import group.lab1FINAL.Service.RestaurantEmployeeService;
import group.lab1FINAL.Service.Service;
import group.lab1FINAL.Service.Validators.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "https://illustrious-cactus-75f2eb.netlify.app/")
@RestController
public class EmployeeControllerJson {
    private EmployeeServiceImpl employeeService;
    private ReviewService reviewService;
    private RestaurantEmployeeService restaurantEmployeeService;
    private RestaurantService restaurantService;
    private EmployeeValidator employeeValidator;


    public EmployeeControllerJson(EmployeeServiceImpl employeeService, ReviewService reviewService, RestaurantEmployeeService restaurantEmployeeService, RestaurantService restaurantService) {
        this.employeeService = employeeService;
        this.reviewService = reviewService;
        this.restaurantEmployeeService = restaurantEmployeeService;
        this.restaurantService = restaurantService;
         employeeValidator = new EmployeeValidator();

    }


    //@CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/employees")
    public List<Long> listEmployees(){ return employeeService.getAll(); }

    @GetMapping("/employees-details")
    public List<Employee> listEmployeesDetails(){ return employeeService.getAllDeatils(); }

    @GetMapping("/employees/{id}")
    public Employee listEmployee(@PathVariable Long id){
        return employeeService.getById(id);
    }

    @PostMapping ("/employees")
    public Object addEmployee(@RequestBody Employee employee){
        Errors errors = new BeanPropertyBindingResult(employee,"employee");
        employeeValidator.validate(employee,errors);
        if(errors.hasErrors())
            return errors.getAllErrors().stream().map(e->e.getCode()).collect(Collectors.toList());

        return employeeService.save(employee);

    }
    @PutMapping("/employees/{id}")
    public Object updateEmployee( @RequestBody Employee employee,@PathVariable Long id){

        Errors errors = new BeanPropertyBindingResult(employee,"employee");
        employeeValidator.validate(employee,errors);
        if(errors.hasErrors())
            return errors.getAllErrors().stream().map(e->e.getCode()).collect(Collectors.toList());

        Employee oldEmployee = (Employee) employeeService.getById(id);
        oldEmployee.setAge(employee.getAge());
        oldEmployee.setSalary(employee.getSalary());
        oldEmployee.setName(employee.getName());
        oldEmployee.setRestaurant(employee.getRestaurant());
        oldEmployee.setIntern(employee.getIntern());
        return employeeService.update(oldEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.delete(id);
    }

    @GetMapping("/review")
    public List<Long> listReviews(){ return reviewService.getAll(); }

    @GetMapping("/review-details")
    public List<Review> listReviewsDetails(){ return reviewService.getAllDeatils(); }

    @GetMapping("/review/{id}")
    public Review listReview(@PathVariable Long id){
        return reviewService.getById(id);
    }

    @PostMapping ("/review")
    public Review addReview(@RequestBody Review review){
        return reviewService.save(review);
    }

    @PostMapping ("/employee/{id}/review")
    public Object addMultipleReview(@PathVariable Long id,@RequestBody List<Review> reviews){
        Employee employee = employeeService.getById(id);
        for(Review r:reviews){
            r.setEmployee(employee);
            reviewService.save(r);
//            Errors errors = new BeanPropertyBindingResult(r,"review");
//            employeeValidator.validate(r,errors);
//            if(errors.hasErrors())
//                return errors.getAllErrors().stream().map(e->e.getCode()).collect(Collectors.toList());
        }
        return reviews;

//        return reviewService.save(review);
    }

    @PutMapping("/review/{id}")
    public Review updateReview( @RequestBody Review review,@PathVariable Long id){
        Review oldReview = (Review) reviewService.getById(id);
        oldReview.setUsername(review.getUsername());
        oldReview.setDescription(review.getDescription());
        oldReview.setRating(review.getRating());
        oldReview.setDate(review.getDate());
        oldReview.setRecommend(review.getRecommend());
        oldReview.setEmployee(review.getEmployee());
        return reviewService.update(oldReview);

    }

    @DeleteMapping("/review/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewService.delete(id);
    }

    @GetMapping("/employees/filter")
    public List<Employee> filter(@RequestBody Integer nr){
        return employeeService.filter(nr);
    }


    @GetMapping("/restaurantemployee")
    public List<Long> listRestaurantEmployees(){ return restaurantEmployeeService.getAll(); }
    @GetMapping("/restaurantemployee-details")
    public List<RestaurantEmployee> listRestaurantEmployeesDetails(){ return restaurantEmployeeService.getAllDeatils(); }

    @GetMapping("/restaurantemployee/{id}")
    public RestaurantEmployee listRestaurantEmployee(@PathVariable Long id){
        return restaurantEmployeeService.getById(id);
    }
    @PostMapping ("/restaurantemployee")
    public RestaurantEmployee addRestaurantEmployee(@RequestBody RestaurantEmployee restaurantEmployee){
        return restaurantEmployeeService.save(restaurantEmployee);
    }

@PutMapping("/restaurantemployee/{id}")
    public RestaurantEmployee updateRestaurantEmployee( @RequestBody RestaurantEmployee restaurantEmployee, @PathVariable Long id){
        RestaurantEmployee oldRestaurantEmployee = (RestaurantEmployee) restaurantEmployeeService.getById(id);
        oldRestaurantEmployee.setBoss(restaurantEmployee.getBoss());
        oldRestaurantEmployee.setHours(restaurantEmployee.getHours());
        oldRestaurantEmployee.setPartTime(restaurantEmployee.getPartTime());
        oldRestaurantEmployee.setRemote(restaurantEmployee.getRemote());
        oldRestaurantEmployee.setNumberOfWriteUps(restaurantEmployee.getNumberOfWriteUps());
        return restaurantEmployeeService.update(oldRestaurantEmployee);
}

@DeleteMapping("/restaurantemployee/{id}")
public void  deleteRestaurantEmployee(@PathVariable Long id){
    restaurantEmployeeService.delete(id);
}





    @GetMapping("/restaurant")
    public List<Long> listRestaurants(){ return restaurantService.getAll(); }
    @GetMapping("/restaurant-details")
    public List<Restaurant> listRestaurantDetails(){ return restaurantService.getAllDeatils(); }

    @GetMapping("/restaurant/{id}")
    public Restaurant listRestaurant(@PathVariable Long id){
        return restaurantService.getById(id);
    }
    @PostMapping ("/restaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.save(restaurant);
    }

    @PutMapping("/restaurant/{id}")
    public Restaurant updateRestaurantEmployee( @RequestBody Restaurant restaurant, @PathVariable Long id){
        Restaurant oldRestaurant = (Restaurant) restaurantService.getById(id);
        oldRestaurant.setName(restaurant.getName());
        oldRestaurant.setDate(restaurant.getDate());
        oldRestaurant.setDescription(restaurant.getDescription());
        oldRestaurant.setRating(restaurant.getRating());
        oldRestaurant.setCity(restaurant.getCity());
        return restaurantService.update(oldRestaurant);
    }

    @DeleteMapping("/restaurant/{id}")
    public void  deleteRestaurant(@PathVariable Long id){
        restaurantService.delete(id);
    }

    @GetMapping("/employee/comparison")
    @ResponseBody
    public List<EmployeeDTO> getComparisonEmployee(){
        return employeeService.getComparison();
    }


    @GetMapping("/restaurant/rating")
    @ResponseBody
    public List<RestaurantDTO> getComparisonRestaurant(){
        return restaurantService.getComparison();
    }


}
