package sample.hibernate;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import org.hibernate.*;

public class HibernateTest {
	private SessionFactory factory;
	private Session session;
	private Query query;

	@Before
	public void setUp() {
		factory = createMock(SessionFactory.class);
		session = createMock(Session.class);
		query = createMock(Query.class);
	}

}
