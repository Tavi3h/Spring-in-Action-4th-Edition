package sia.knights;

import java.io.PrintStream;

public class Minstrel {
    
    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }
    
    // 骑士探险之前调用
    public void singBeforeQuest() {
        stream.println("Fa la la, the knight is so brave!");
    }
    
    // 骑士探险之后调用
    public void singAfterQuest() {
        stream.println("Tee hee hee, the brave knight did embark on a quest");
    }
}
