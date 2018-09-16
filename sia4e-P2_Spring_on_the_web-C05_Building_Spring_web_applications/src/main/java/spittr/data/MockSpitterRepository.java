package spittr.data;

import org.springframework.stereotype.Repository;

import spittr.Spitter;

@Repository
public class MockSpitterRepository implements SpitterRepository {

    @Override
    public Spitter save(Spitter spitter) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

}
