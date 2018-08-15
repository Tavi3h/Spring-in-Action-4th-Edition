package sia.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
    public static void main(String[] args) {

        // 加载Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");

        // 获取knight bean
        Knight knight = context.getBean(Knight.class);

        // 使用bean
        knight.embarkOnQuest();

        ((ClassPathXmlApplicationContext) context).close();

    }
}
