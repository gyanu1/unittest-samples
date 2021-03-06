package sample.hibernate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sample.hibernate.dao.EmployeeDao;
import sample.hibernate.dao.EmployeeDaoImpl;
import sample.hibernate.model.Employee;

/**
 * sample test case for basic database operation of hibernate model
 * 
 * @author gyanu
 * 
 * **/

public class EmployeeTest {
    static EmployeeDao empDao;
    static SessionFactory sessionFactory;
    static Transaction transaction;

    @BeforeClass
    public static void setup() {
	sessionFactory = HibernateUtility.getSessionFactory();
	empDao = new EmployeeDaoImpl(sessionFactory);
	transaction = sessionFactory.getCurrentSession().beginTransaction();
    }

    @Test
    public void verifyCrudOperation() {
	Employee emp1 = new Employee("gyanu", "maharjan", (java.util.Date) new Date(), "9841497163");

	emp1 = empDao.saveOrUpdate(emp1);
	assertThat(emp1.getId(), is(1L));
	assertEquals("gyanu", emp1.getFirstname());
	emp1.setFirstname("Ramesh");

	emp1 = empDao.saveOrUpdate(emp1);
	assertThat(emp1.getId(), is(1L));
	assertEquals("Ramesh", emp1.getFirstname());
	Employee emp2 = new Employee("ranjan", "baral", (java.util.Date) new Date(), "9841497163");

	emp2 = empDao.saveOrUpdate(emp2);
	assertThat(emp2.getId(), is(2L));
	assertEquals("ranjan", emp2.getFirstname());

    }

    @Test
    public void verifyEmptyData() {
	List<Employee> empList = empDao.getAll();
	assertThat(empList.size(), is(2));
    }

    @AfterClass
    public static void tearDown() {
	transaction.rollback();
    }

}
