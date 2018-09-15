package spittr.service.impl;

import java.util.List;

import spittr.domain.Spitter;
import spittr.service.SpitterService;

public class SpitterServiceImpl implements SpitterService {

    @Override
    public List<Spitter> getAllSpitters() {
        String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(clazz + " : " + method);
        return null;
    }

}
