package concert;

import com.springinaction.springidol.CriticismEngine;

public aspect CriticAspect {

    public CriticAspect() {
    }

    // 定义切点
    pointcut performance() : execution(* perform(..));

    // 定义返回通知
    after() returning : performance()  {
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    // 注入CriticismEngine
    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}