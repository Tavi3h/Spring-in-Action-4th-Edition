package sia.jdbc.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sia.jdbc.QueryUsingJdbcTemplate;
import sia.jdbc.beans.Employee;

public class QueryUsingJdbcTemplateTest {

    private ApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
    }

    @After
    public void after() {
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void query() {
        QueryUsingJdbcTemplate query = (QueryUsingJdbcTemplate) context.getBean("queryUsingJdbcTemplate");
        String sql = "select id, firstname, lastname, salary from employee where id = ?";
        Employee employee = query.getEmployeeById(1, sql);
        System.out.println(employee);
    }
}
