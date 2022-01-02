package hello;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;


public class EmployeeHibernateApi {

	private static Logger logger = Logger.getLogger(EmployeeHibernateApi.class);
	
	private HibernateUtil hbu;

	public EmployeeHibernateApi() throws Exception {
		hbu=new HibernateUtil();

	}

	public void insert(EmployeePojo p) throws SQLException {
		logger.info("inserting employees");

		hbu.createSession();
		hbu.beginTransaction();
		Session s=hbu.getSession();
		s.save(p);
		hbu.commitTransaction();
		hbu.closeSession();


	}

	public EmployeePojo select(int id) throws SQLException {
		logger.info("selecting an employees");

		hbu.createSession();
		hbu.beginTransaction();
		Session s=hbu.getSession();
		EmployeePojo p=s.find(EmployeePojo.class, id);
		hbu.commitTransaction();
		hbu.closeSession();
		return p;

	}
	
	public List<EmployeePojo> selectAll() throws SQLException {
		logger.info("selecting all employees");

		hbu.createSession();
		hbu.beginTransaction();
		Session s=hbu.getSession();
		Query<EmployeePojo> q=s.createQuery("select o from EmployeePojo o");
		List<EmployeePojo> list=q.getResultList();	
		hbu.commitTransaction();
		hbu.closeSession();
		return list;

	}

	public void delete(int id) throws SQLException {
		
		hbu.createSession();
		hbu.beginTransaction();
		Session s=hbu.getSession();
		EmployeePojo p=s.find(EmployeePojo.class, id);
		s.delete(p);
		hbu.commitTransaction();
		hbu.closeSession();

	}
	
public void deleteAll() throws SQLException {
		
		hbu.createSession();
		hbu.beginTransaction();
		Session s=hbu.getSession();
		Query<EmployeePojo> q=s.createQuery("select o from EmployeePojo o");
		List<EmployeePojo> list=q.getResultList();	
		for(EmployeePojo p:list) {
			s.delete(p);
		}
		hbu.commitTransaction();
		hbu.closeSession();

	}

public void printAll() throws SQLException {
	
	logger.info("Inside printall");
	List<EmployeePojo> list=selectAll();
	for(EmployeePojo p:list) {
		logger.warn("Employee id:"+p.getId()+" name:"+p.getName()+" age:"+p.getAge());
	}
//	deleteAll();
}

}
