package com.lqyhmb.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	/**
	 * 获取执行映射文件中sql的sqlSession对象
	 * 
	 * @return
	 * @throws IOException
	 */
	/*public static SqlSession getSqlSession() throws IOException {
		// mybatis配置文件
		String mybatis = "com/lqyhmb/config/Configuration.xml";
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(mybatis);
		// 构建sqlSession工厂对象
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 得到执行映射文件中sql的sqlSession
		return sqlSessionFactory.openSession();
	}*/

	/**
	 * 获取SqlSessionFactory
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static SqlSessionFactory getSqlSessionFactory() throws IOException {
		// mybatis配置文件
		String mybatisConf = "com/lqyhmb/config/Configuration.xml";
		
		/**
		 * 方式1
		 */
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		//InputStream inputStream = MyBatisUtil.class.getClassLoader().getResourceAsStream(mybatisConf);
		// 构建sqlSession工厂对象
		//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		/**
		 * 方式2
		 */
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(mybatisConf);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		return sqlSessionFactory;
	}
	
	/**
	 * 获取SqlSession
	 * @return
	 * @throws IOException 
	 */
	public static SqlSession getSqlSession() throws IOException {
		return getSqlSessionFactory().openSession();
	}
	
	/**
	 * 
	 * @param isAutoCommit
	 * 			true:表示创建的SqlSession对象在执行完sql之后会自动提交事务
	 * 			false:表示创建的SqlSession对象在执行完sql之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
	 * @return
	 * @throws IOException
	 */
	public static SqlSession getSqlSession(boolean isAutoCommit) throws IOException {
		return getSqlSessionFactory().openSession(isAutoCommit);
	}
}
