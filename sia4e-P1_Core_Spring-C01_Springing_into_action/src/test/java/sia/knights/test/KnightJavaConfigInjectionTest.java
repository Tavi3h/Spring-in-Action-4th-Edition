package sia.knights.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sia.knights.Knight;
import sia.knights.config.KnightConfig;

public class KnightJavaConfigInjectionTest {
    
    private ApplicationContext context;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(KnightConfig.class);
    }

    @After
    public void after() {
        ((AnnotationConfigApplicationContext) context).close();
    }
    
    @Test
    public void annotationConfigInjectionTest() {

        // 获取knight bean
        Knight knight = context.getBean(Knight.class);

        // 使用bean
        knight.embarkOnQuest();
    }
}
