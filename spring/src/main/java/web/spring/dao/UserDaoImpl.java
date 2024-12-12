package web.spring.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.spring.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> findAll() {
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    public void update(int id, User user) {
        User tempUser = em.find(User.class, id);
        tempUser.setName(user.getName());
        tempUser.setAge(user.getAge());
        tempUser.setEmail(user.getEmail());
        em.merge(tempUser);
    }

}
