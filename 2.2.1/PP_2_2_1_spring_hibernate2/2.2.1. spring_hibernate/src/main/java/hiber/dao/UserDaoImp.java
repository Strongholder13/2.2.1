package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
      public List<User> listUsers() {
      List<User> list = sessionFactory.getCurrentSession().createQuery("FROM User, User.class").getResultList();
      return list;
   }
public User getFrom(String model, int series){
      Query<User> query = sessionFactory.getCurrentSession().createQuery("from User user where user.car.model =:model and user.car.series =:series");
      query.setParameter("model", model).setParameter("series", series);
      return query.setMaxResults(1).getSingleResult();
}
}
