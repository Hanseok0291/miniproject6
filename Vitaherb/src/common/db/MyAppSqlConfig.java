package common.db;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {
	private static final SqlSession sqlMapper;
	static {
		try {
			String resource = "config/mybatis/sqlMapConfig.xml";
			//환경설정파일 결로를 받아서 
			Reader reader = Resources.getResourceAsReader(resource);
			//그걸 읽어들이고(로딩하고)
			SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
			//sqlSession객체를 얻어온다.
			//sqlSessionFactory : sqlSession을 만들어내는 클래스
			sqlMapper = sqlFactory.openSession(true);
		} catch (Exception e) {
			
			
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}
	public static SqlSession getSqlSession() {
		return sqlMapper;
	}
}