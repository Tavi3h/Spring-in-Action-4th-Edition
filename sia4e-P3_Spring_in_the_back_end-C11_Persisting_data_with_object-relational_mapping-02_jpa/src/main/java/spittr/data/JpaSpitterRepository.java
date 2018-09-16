package spittr.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spittr.domain.Spitter;

@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceContext
    private EntityManager manager;
    
    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public void addSpitter(Spitter spitter) {
        
        spitter.setPassword(new Pbkdf2PasswordEncoder("53cr3t").encode(spitter.getPassword()));
        
        manager.persist(spitter);
    }

    @Override
    public Spitter findByUsername(String username) {
        
        return (Spitter) manager
                .createQuery("select s from Spitter s where s.username=:username")
                .setParameter("username", username)
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) manager.createQuery("SELECT s FROM spitter").getResultList();
    }
    
    @Override
    public Spitter findOne(long id) {
        return manager.find(Spitter.class, id);
    }
}
