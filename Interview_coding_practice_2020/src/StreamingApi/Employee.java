package StreamingApi;


import java.util.List;

public  class Employee {
    private String fName;
    private String lName;
    private Double salary;
    private List<String> projects;
    private Address addresses;

    public Employee(String fName, String lName, Double salary, List<String> projects, Address addresses) {
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.projects = projects;
        this.addresses = addresses;
    }

    public Employee() {
    }

    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                ", addresses=" + addresses +
                '}';
    }

}