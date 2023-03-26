package group.lab1FINAL.Service.Validators;

import group.lab1FINAL.Model.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmployeeValidator implements Validator {

    public EmployeeValidator() {

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if (employee.getSalary() < 0) {
            errors.rejectValue("salary", "negativeValue", new Object[]{"'salary'"}, "salary can't be negative");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name cannot be empty");

        if ( employee.getName().length() > 50) {
            errors.rejectValue("name", "Name cannot exceed 50 characters");
        }


    }
}
