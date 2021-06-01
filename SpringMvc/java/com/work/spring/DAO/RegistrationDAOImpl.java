package com.work.spring.DAO;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.work.spring.Entity.RegistrationEntity;

@Repository

public class RegistrationDAOImpl implements RegistrationDAO {

	private Logger logger;

	@Autowired
	private SessionFactory factory;

	public RegistrationDAOImpl() {
		// TODO Auto-generated constructor stub
		logger = Logger.getLogger(getClass());
	}

	@Override
	public Integer save(RegistrationEntity entity) {

		Transaction transaction = null;
		Integer affectedRow = 0;
		try (Session session = factory.openSession()) {

			transaction = session.beginTransaction();
			affectedRow = (Integer) session.save(entity);

			logger.error("affectedRow in save session " + affectedRow);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			transaction.rollback();
			logger.error("you have exception in {} " + e.getMessage(), e);
			return 0;
		}
	}

	public RegistrationEntity getByEmailId(String emailId) {

		Transaction transaction = null;
		Session session = null;
		RegistrationEntity entity = null;
		try {
			session = factory.openSession();
			Query query = session.createNamedQuery("getByEmailId");
			query.setParameter("email", emailId);
			entity = (RegistrationEntity) query.uniqueResult();
		} catch (Exception e) {
			logger.error("you have exception in {} " + e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();

			}
			return entity;
		}

		// TODO Auto-generated method stub

	}

	@Override
	public RegistrationEntity checkUserIsExistOrNot(String fullName) {
		Transaction transaction = null;
		Session session = null;
		RegistrationEntity entity = null;
		try {
			session =  factory.openSession();
			Query query =session.createNamedQuery("checkUserIsExistOrNot");
			query.setParameter("Fullname", fullName );
			entity=(RegistrationEntity) query.uniqueResult();
		} catch (Exception e) {
			logger.error("you have exception in {} " + e.getMessage() , e );
			return null;
		}
		finally {
			if (session != null) {
				session.close();
			
			}
		}
		return entity;
	}
}
