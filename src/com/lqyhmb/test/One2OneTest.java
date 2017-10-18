package com.lqyhmb.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lqyhmb.model.Classes;
import com.lqyhmb.util.MyBatisUtil;

/**
 * 一对一关联
 */
public class One2OneTest {

	@Test
	public void testGetClass() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession(true);
			/**
			 * 映射sql的标识字符串，com.lqyhmb.mapping.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
			 * getClass是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
			 */
			String statement = "com.lqyhmb.mapping.classMapper.getClass";// 映射sql的标识字符串
			// 执行查询操作，将查询结果自动封装成Classes对象返回
			Classes clazz = sqlSession.selectOne(statement, 1);
			System.out.println(clazz);// 打印结果
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 使用SqlSession执行完SQL之后需要关闭SqlSession
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void testGetClass2() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession(true);
			/**
			 * 映射sql的标识字符串，com.lqyhmb.mapping.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
			 * getClass2是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
			 */
			String statement = "com.lqyhmb.mapping.classMapper.getClass2";// 映射sql的标识字符串
			// 执行查询操作，将查询结果自动封装成Classes对象返回
			Classes clazz = sqlSession.selectOne(statement, 2);
			System.out.println(clazz);// 打印结果
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 使用SqlSession执行完SQL之后需要关闭SqlSession
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
