package sia.knights.test;

import org.junit.Test;

import sia.knights.BraveKnight;
import sia.knights.Quest;

import static org.mockito.Mockito.*;

public class BraveKnightTest {
    
    @Test
    public void knightShouldEmbarkOnQuest() {
        // 创建mock Quest
        Quest mockQuest = mock(Quest.class);
        
        // 注入 mock Quest
        BraveKnight knight = new BraveKnight(mockQuest);
        
        knight.embarkOnQuest();
        
        verify(mockQuest, times(1)).embark();
        
        System.out.println("测试成功");
    }
}
