package group.lab1FINAL.Service;

import group.lab1FINAL.Model.Employee;
import group.lab1FINAL.Model.Employee;
import group.lab1FINAL.Model.EmployeeDTO;
import group.lab1FINAL.Repo.EmployeeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {

    @Test
    void filter() {
        EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
        List<Employee> employees = new ArrayList<>();
        List<Employee> employees2 = new ArrayList<>();
        Employee Dani =   new Employee("20",6400,"Dani","Denmark legoland",false);
        employees.add(Dani);
        Employee Dani2 =new Employee("20",4400,"Dani2","Denmark legoland",false);
        employees.add(Dani2);
        Employee Dani3 =new Employee("20",3400,"Dani3","Denmark legoland",false);
        employees.add(Dani3);
        employees2.add(Dani);
        employees2.add(Dani2);
        when(employeeRepo.findAll()).thenReturn(employees);



        EmployeeServiceImpl employeeService2 = new EmployeeServiceImpl(employeeRepo);
//        System.out.println(employeeService2.filter(0));
        assertEquals(employees2,employeeService2.filter(4300));




    }

    @Test
    void getComparison() {
//        EmployeeServiceImpl employeeService = mock(EmployeeServiceImpl.class);

        EmployeeRepo employeeRepo = mock(EmployeeRepo.class);

        List<Employee> list = new ArrayList<>();

        Employee Dani =   new Employee("20",6400,"Dani","Denmark legoland",false);

        Employee Dani2 =new Employee("20",4400,"Dani2","Denmark legoland",false);
        Employee Dani3 =new Employee("20",3400,"Dani3","Denmark legoland",false);
        list.add(Dani);
        list.add(Dani2);
        list.add(Dani3);

        when(employeeRepo.findAll()).thenReturn(list);

        EmployeeServiceImpl employeeService2 = new EmployeeServiceImpl(employeeRepo);

        List<EmployeeDTO> listdto = new ArrayList<>();

        EmployeeDTO Danid =   new EmployeeDTO("20",6400,"Dani","Denmark legoland",false);

        EmployeeDTO Dani2d =new EmployeeDTO("20",4400,"Dani2","Denmark legoland",false);
        EmployeeDTO Dani3d =new EmployeeDTO("20",3400,"Dani3","Denmark legoland",false);
        listdto.add(Dani3d);
        listdto.add(Dani2d);
        listdto.add(Danid);



        Assertions.assertEquals(Arrays.toString(new List[]{employeeService2.getComparison()}),Arrays.toString(new List[]{listdto}));
        //assertEquals(list,employeeService2.getComparison());
    }
}