package hello;

import java.util.List;

public class App {
	public static void main(String[] args) throws Exception {
		
		HibernateUtil.configure();
		EmployeeHibernateApi api=new EmployeeHibernateApi();
		
		api.deleteAll();
		
		for(int i=0;i<5;i++)
		{
			EmployeePojo p=new EmployeePojo();
			p.setAge(i+20);
			p.setName("name"+i);
			p.setId(i);
			api.insert(p);
		}
		
		api.printAll();
	}

}
