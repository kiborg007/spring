package com.roman.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.roman.model.Coordinates;
import com.roman.model.Person;

@Repository
public class CoordinatesDAOImpl implements CoordinatesDAO {

	private static final Logger logger = Logger.getLogger(CoordinatesDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addCoordinate(Coordinates c) {

		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Coordinate saved successfully, Coordinate Details=" + c);
	}

	@Override
	public Coordinates getCoordinateById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		/*
		 * Coordinates coord = new Coordinates(); coord.setCoordID(id);
		 */
		Coordinates c = (Coordinates) session.load(Coordinates.class, new Integer(id));
		Person pers = c.getPerson();
		/*
		 * if (c == null) { c = new Coordinates(); }
		 */
		logger.info("Coordinate loaded successfully, Coordinates details=");
		return c;
	}

	@Override
	public Coordinates getCoordinateByPersonId(int id) {
		Coordinates coord = null;
		Person pers = new Person();
		pers.setPersonID(id);
		Session session = this.sessionFactory.getCurrentSession();
		/*
		 * Query query = session.createSQLQuery(
		 * "select * from coordinates where PERSON_ID = "
		 * +id).addEntity(Coordinates.class) ;
		 * 
		 * @SuppressWarnings("unchecked") List<Coordinates> list =
		 * (List<Coordinates>) query.list();
		 */

		Criteria crit = session.createCriteria(Coordinates.class);
		List list = crit.add(Restrictions.eq("person", pers)).list();

		if (list.isEmpty() || list == null) {
			coord = new Coordinates();
		} else {
			coord = (Coordinates) list.get(0);
		}

		System.out.println(" ===== getCoordinateByPersonId ======");
		return coord;
	}

}
