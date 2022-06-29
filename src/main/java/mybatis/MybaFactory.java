package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MybaFactory {
private static SqlSessionFactory factory;
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}

	static {
		try {
			Reader r = Resources.getResourceAsReader("mybatis/configure.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
			
			if(factory == null ) System.out.println("fail......");

			System.out.println("MybaFactory  Ok...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		 MybaFactory.getFactory();

	}
}
