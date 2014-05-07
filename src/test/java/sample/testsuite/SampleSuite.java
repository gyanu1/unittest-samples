package sample.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import sample.hibernate.EmployeeTest;
import sample.parameterized.ParameterizedTest;

/**
 * sample on writing jUnit Suite
 * 
 * @author gyanu
 * **/

@RunWith(Suite.class)
@Suite.SuiteClasses({ EmployeeTest.class, ParameterizedTest.class })
public class SampleSuite {

}
