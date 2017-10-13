package com.lqyhmb.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lqyhmb.model.User;

public class Test {

	public static void main(String[] args) throws IOException {
		// mybatis配置文件
		String resource = "com/lqyhmb/config/Configuration.xml";
		
		/**
		 * 方式1
		 */
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		//InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
		// 构建sqlSession工厂对象
		//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		/**
		 * 方式2
		 */
		//使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession工厂对象
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		// 创建能执行映射文件中sql的sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/**
		 * 映射sql的标识字符串，
		 * com.lqyhmb.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "com.lqyhmb.mapping.userMapper.getUser";
		// 执行查询返回一个唯一user对象的sql
		User user = sqlSession.selectOne(statement, 2);
		System.out.println(user.toString());
	}

}
