package sample.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sample.hibernate.model.Employee;

/**
 * Implementation for EmployeeDao
 * 
 * @author gyanu
 * **/

public class EmployeeDaoImpl implements EmployeeDao {
    Logger logger = Logger.getLogger(EmployeeDaoImpl.class);
    private SessionFactory sessionFactory;

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
	this.sessionFactory.openSession();
    }

    @Override
    public Employee saveOrUpdate(Employee emp) {
	logger.info("inside saveOrUpdate before save id : " + emp.getId());
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(emp);
	logger.info("inside saveOrUpdate after save id : " + emp.getId());
	return emp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAll() {
	Session session = sessionFactory.openSession();
	return session.createCriteria(Employee.class).list();
    }

    @Override
    public Employee getById(long id) {
	Session session = sessionFactory.openSession();
	return (Employee) session.load(Employee.class, id);
    }

    @Override
    public void delete(Employee emp) {
	Session session = sessionFactory.getCurrentSession();
	session.delete(emp);
    }

    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

}
