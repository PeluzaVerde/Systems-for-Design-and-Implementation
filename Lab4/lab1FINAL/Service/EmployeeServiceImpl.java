package group.lab1FINAL.Service;

import group.lab1FINAL.Model.Employee;
import group.lab1FINAL.Model.EmployeeDTO;
import group.lab1FINAL.Repo.EmployeeRepo;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class EmployeeServiceImpl implements Service<Employee> {
    private EmployeeRepo repo;
    private Integer filtervalue=0;

    public void setFiltervalue(Integer filtervalue) {
        this.filtervalue = filtervalue;
    }

    public EmployeeServiceImpl(EmployeeRepo repo) {
        this.repo = repo;
    }


    @Override
    public List<Long> getAll() {

        return repo.findAll().stream().map(employee->employee.getId()).collect(Collectors.toList());

    }

    @Override
    public Employee save(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Employee update(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

//    public List<Review> getAllReviews(Long id){
//        return repo.findById(id).get().getReviews();
//    }

    public List<Employee> filter(Integer nr){
        return repo.findAll().stream().filter(employee->employee.getSalary()>nr).collect(Collectors.toList());
    }
//    public void setFilter(Integer filter){
//        filtervalue=filter;
//    }

    public List<EmployeeDTO> getComparison(){
        return repo.findAll().stream()
                .map(employee->{return new EmployeeDTO(employee.getAge(), employee.getSalary(),employee.getName(),employee.getRestaurant(),employee.getIntern());}).
                sorted().collect(Collectors.toList());
    }
}
