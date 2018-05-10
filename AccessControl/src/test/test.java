package test;


import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.ManagerAssign;
import entity.ManagerRevoke;
import entity.Managers;
import entity.Users;

public class test {
	
public static void main(String[] args) {
		SqlSession session = null;
		SqlSessionFactory sessionFactory = null;
		InputStream is = test.class.getClassLoader().getResourceAsStream(
				"data/conf.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(is);	
		session = sessionFactory.openSession();
		String statement = "data.Mapper.selectrevoke";
		/*Users users=new Users();
		users.setUsername("李四");
		users.setUserpsd("123");
		users.setRole("员工 1产品员工");
		session.update(statement, users);*/
		ManagerRevoke maAssign=new ManagerRevoke();
		maAssign.setManagerrole("公司主管");
		ManagerRevoke managers=session.selectOne(statement,maAssign);
		
		System.out.println(managers);
		session.commit();
		session.close();
}

}
