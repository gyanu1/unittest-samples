package sample.testrunner;


import org.apache.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import sample.testsuite.SampleSuite;

/***
 * sample on writing TestRunner
 * 
 * @author gyanu
 * */

public class SampleRunner {
    private static final Logger LOGGER = Logger.getLogger(SampleRunner.class);
    public static void main(String[] args) {
	Result result = JUnitCore.runClasses(SampleSuite.class);
	for (Failure failure : result.getFailures()) {
	    LOGGER.info(failure.toString());
	}
    }

}
