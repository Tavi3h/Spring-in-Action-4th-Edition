package spittr.service.impl;

import java.util.List;

import spittr.domain.Spitter;
import spittr.service.SpitterService;

public class SpitterServiceImpl implements SpitterService {

    @Override
    public List<Spitter> getAllSpitters() {
        System.out.println("RMI DONE!");
        return null;
    }

}
