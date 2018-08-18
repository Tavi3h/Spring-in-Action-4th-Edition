package com.springinaction.springidol;

public class CriticismEngineImpl implements CriticismEngine {

    private String[] criticismPool;

    // 注入criticismPool
    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }

    @Override
    public String getCriticism() {
        int criticismIndex = (int) (Math.random() * criticismPool.length);
        return criticismPool[criticismIndex];
    }

}