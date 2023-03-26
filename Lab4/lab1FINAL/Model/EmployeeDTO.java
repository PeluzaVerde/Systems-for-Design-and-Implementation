package group.lab1FINAL.Model;

public class EmployeeDTO implements Comparable<EmployeeDTO>{
    private String name;
    private String age;
    private Integer salary;
    private String restaurant;
    private Boolean intern;


    public EmployeeDTO(String age, Integer salary, String name, String restaurant, Boolean intern) {
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.restaurant = restaurant;
        this.intern = intern;
    }

    public EmployeeDTO() {
    }

    public String getAge() {
        return age;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public Boolean getIntern() {
        return intern;
    }


    public void setAge(String age) {
        this.age = age;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setIntern(Boolean intern) {
        this.intern = intern;
    }

    @Override
    public int compareTo(EmployeeDTO otherEmployee) {
        return Integer.compare(this.getSalary(),otherEmployee.getSalary());
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary=" + salary +
                ", restaurant='" + restaurant + '\'' +
                ", intern=" + intern +
                '}';
    }
}

