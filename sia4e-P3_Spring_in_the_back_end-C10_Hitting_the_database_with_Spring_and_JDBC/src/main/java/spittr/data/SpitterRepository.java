package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {

    void addSpitter(Spitter spitter);

    Spitter findByUsername(String username);

}
