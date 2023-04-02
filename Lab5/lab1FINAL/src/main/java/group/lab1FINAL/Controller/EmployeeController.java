//package group.lab1FINAL.Controller;
//
//import group.lab1FINAL.Model.Employee;
//import group.lab1FINAL.Model.Review;
//import group.lab1FINAL.Service.EmployeeServiceImpl;
//import group.lab1FINAL.Service.Service;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class EmployeeController {
//    private Service<Employee> employeeService;
//    private Service<Review> reviewService;
//
//    public EmployeeController(Service<Employee> employeeService, Service<Review> reviewService) {
//        this.employeeService = employeeService;
//        this.reviewService = reviewService;
//    }
//
//    @PostMapping("/filter")
//    public String setFilter(@ModelAttribute("filter") String filter)
//    {
//        try {
//            System.out.println(filter);
//            Integer filt = Integer.valueOf(filter);
//            ((EmployeeServiceImpl) employeeService).setFilter(filt);
//        } catch (Exception e){
//            System.out.println("cannot convert");
//            ((EmployeeServiceImpl) employeeService).setFilter(0);
//        }finally {
//            return "redirect:/employees";
//        }
//    }
//
//    @GetMapping("/employees")
//    public String listEmployees(Model model){
//        model.addAttribute("filter","0");
//        model.addAttribute("employees", employeeService.getAll());
//        model.addAttribute("reviews",reviewService.getAll());
//        return "employees";
//    }
//
//    @GetMapping("/employees/add_review/{id}")
//    public String addReview(Model model,@PathVariable Long id){
//        Review rev = new Review();
//        Employee employee = employeeService.getById(id);
//        rev.setEmployee(employee);
//        model.addAttribute("review",rev);
//        return "add_review";
//    }
//
//
//
//    @PostMapping("/reviews")
//    public String saveReview(@ModelAttribute("review") Review review)
//    {
//        reviewService.save(review);
//        return "redirect:/employees";
//    }
//
//
//    @GetMapping("/employees/new")
//    public String createEmployee(Model model){
//        Employee employee = new Employee();
//        model.addAttribute("employees",employee);
//        return "create_employee";
//    }
//
//    @PostMapping("/employees")
//    public String saveEmployee(@ModelAttribute("employees") Employee employee){
//        employeeService.save(employee);
//        return "redirect:/employees";
//    }
//
//
//    @GetMapping("/employees/edit/{id}")
//    public String editEmployee(@PathVariable Long id , Model model){
//        model.addAttribute("employees", employeeService.getById(id));
//        return "edit_employees";
//    }
//
//    @GetMapping("/reviews/edit/{id}")
//    public String schimbareReview(@PathVariable Long id ,Model model){
//        model.addAttribute("review",reviewService.getById(id));
//        return "schimbare_review";
//    }
//
//    @PostMapping("/reviews/{id}")
//    public String schimbareReview(@PathVariable Long id,@ModelAttribute("review") Review review,Model model){
//        Review reviewOLD = (Review) reviewService.getById(id);
//        reviewOLD.setDate(review.getDate());
//        reviewOLD.setDescription(review.getDescription());
//        reviewOLD.setRating(review.getRating());
//        reviewOLD.setUsername(review.getUsername());
//        reviewOLD.setCity(review.isRecommend());
//
//        reviewService.update(reviewOLD);
//        return "redirect:/employees";
//    }
//
//    @PostMapping("/employees/{id}")
//    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employees") Employee employee, Model model){
//        Employee oldEmployee = (Employee) employeeService.getById(id);
//        oldEmployee.setName(employee.getName());
//        oldEmployee.setSalary(employee.getSalary());
//        oldEmployee.setAge(employee.getAge());
//        oldEmployee.setRestaurant(employee.getRestaurant());
//        oldEmployee.setIntern(employee.getIntern());
//
//        employeeService.update(oldEmployee);
//        return "redirect:/employees";
//    }
//
//    @GetMapping("/reviews/{id}")
//    public String deleteReview(@PathVariable Long id)
//    {
//        reviewService.delete(id);
//        return "redirect:/employees";
//    }
//
//    @GetMapping("/employees/{id}")
//    public String deleteEmployee(@PathVariable Long id){
//        employeeService.delete(id);
//        return "redirect:/employees";
//    }
//
//
//}
