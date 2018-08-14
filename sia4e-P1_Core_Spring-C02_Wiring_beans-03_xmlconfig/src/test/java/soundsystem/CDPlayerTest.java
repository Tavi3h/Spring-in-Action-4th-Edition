package soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CDPlayerTest {

    private final String LINE_SEPARATOR = System.getProperty("line.separator");

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void playerShouldNotBeNull() {
        assertNotNull(player);
    }

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles" + LINE_SEPARATOR
                + "-Track: Sgt. Pepper's Lonely Hearts Club Band" + LINE_SEPARATOR
                + "-Track: With a Little Help from My Friends" + LINE_SEPARATOR + "-Track: Lucy in the Sky with Diamonds"
                + LINE_SEPARATOR + "-Track: Getting Better" + LINE_SEPARATOR + "-Track: Fixing a Hole" + LINE_SEPARATOR,
                log.getLog());
    }
}