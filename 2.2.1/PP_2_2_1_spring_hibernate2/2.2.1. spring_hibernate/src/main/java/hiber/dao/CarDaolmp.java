package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;


@Repository
public class CarDaolmp implements CarDao {
    @Autowired
    public CarDaolmp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> listCars() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Car");
        List<Car> list = query.getResultList();
        return list;
    }
}
