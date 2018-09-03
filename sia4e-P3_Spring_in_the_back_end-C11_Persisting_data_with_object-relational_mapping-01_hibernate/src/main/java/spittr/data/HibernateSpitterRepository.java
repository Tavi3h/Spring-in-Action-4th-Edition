package spittr.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spittr.domain.Spitter;

@Repository
public class HibernateSpitterRepository implements SpitterRepository {
    
    @Autowired
    private SessionFactory sessionfactory;

    private Session currentSession() {
        return sessionfactory.getCurrentSession();
    }
    
    @Override
    @Transactional
    public void addSpitter(Spitter spitter) {
        
        currentSession().save(new Spitter(
                spitter.getUsername(), 
                new Pbkdf2PasswordEncoder("53cr3t").encode(spitter.getPassword()), 
                spitter.getFirstName(), 
                spitter.getLastName())
            );
    }

    @Override
    @Transactional
    public Spitter findByUsername(String username) {
        return (Spitter) currentSession().createCriteria(Spitter.class)
            .add(Restrictions.eq("username", username)).list().get(0);
    }

    @Override
    @Transactional
    public long count() {
        return findAll().size();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Spitter> findAll() {
        return (List<Spitter>) currentSession().createCriteria(Spitter.class).list();
    }

    @Override
    @Transactional
    public Spitter findOne(long id) {
        return currentSession().get(Spitter.class, id);
    }

}
