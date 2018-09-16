package concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import concert.ConcertConfig;
import concert.Encoreable;
import concert.Performance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class IntroducerTest {

    @Autowired
    private Performance performance;

    @Test
    public void testEncore() {

        performance.perform();

        Encoreable encoreable = (Encoreable) performance;

        encoreable.performEncore();
    }
}
