package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
      public List<User> listUsers() {
      Query query = sessionFactory.getCurrentSession().createQuery("from User");
      List<User> list = query.getResultList();
      return list;
   }
public User getFrom(String model, int series){
      Query query = sessionFactory.getCurrentSession().createQuery("from User user where user.car.model =:model and user.car.series =:series");
      query.setParameter("model", model).setParameter("series", series);
      return (User) query.getSingleResult();
}
}
