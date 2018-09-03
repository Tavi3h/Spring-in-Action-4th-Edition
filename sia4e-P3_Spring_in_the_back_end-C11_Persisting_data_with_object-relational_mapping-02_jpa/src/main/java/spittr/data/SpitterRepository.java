package spittr.data;

import java.util.List;

import spittr.domain.Spitter;

public interface SpitterRepository {
    
    long count();

    void addSpitter(Spitter spitter);

    Spitter findByUsername(String username);
    
    List<Spitter> findAll();
    
    Spitter findOne(long id);

}
