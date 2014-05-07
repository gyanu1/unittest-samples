package sample.hibernate.dao;

import java.util.List;

import sample.hibernate.model.Employee;

/**
 * Interface declaration for Employee Model
 * 
 * @author gyanu
 * **/

public interface EmployeeDao {
    public Employee saveOrUpdate(Employee emp);

    public List<Employee> getAll();

    public Employee getById(long id);

    public void delete(Employee emp);
}
