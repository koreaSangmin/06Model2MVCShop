package com.model2.mvc.service.user.product;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {

	
	public static SqlSession getSqlSession() throws IOException{
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config.xml");
		
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		
		return sqlSession;
		
	}
	

}
