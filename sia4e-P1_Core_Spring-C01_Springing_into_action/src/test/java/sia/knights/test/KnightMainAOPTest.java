package sia.knights.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sia.knights.Knight;

public class KnightMainAOPTest {

    private ApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("minstrel.xml");
    }

    @After
    public void after() {
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void aopTest() {

        // 获取knight bean
        Knight knight = context.getBean(Knight.class);

        // 使用bean
        knight.embarkOnQuest();

    }
}
