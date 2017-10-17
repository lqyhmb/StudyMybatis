package com.lqyhmb.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lqyhmb.model.User;
import com.lqyhmb.util.MyBatisUtil;

/**
 * 使用MyBatis对表执行CRUD操作——基于XML的实现
 * 原文地址: http://www.cnblogs.com/xdp-gacl/p/4262895.html
 */
public class TestCRUDByXmlMapper {

	@Test
	public void testAdd() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			/**
			 * 映射sql的标识字符串，com.lqyhmb.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
			 * addUser是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的SQL
			 */
			// 映射sql的表示字符串
			String statement = "com.lqyhmb.mapping.userMapper.addUser";
			User user = new User();
			user.setName("J罗");
			user.setAge(26);
			// 执行插入操作
			int ret = sqlSession.insert(statement, user);
			// 手动提交事务
			sqlSession.commit();
			System.out.println(ret);
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
	public void testUpdate() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			/**
			 * 映射sql的标识字符串，com.lqyhmb.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
			 * updateUser是update标签的id属性值，通过update标签的id属性值就可以找到要执行的SQL
			 */
			// 映射sql的表示字符串
			String statement = "com.lqyhmb.mapping.userMapper.updateUser";
			User user = new User();
			user.setId(4);
			user.setName("哈梅斯罗德里格斯");
			user.setAge(26);
			// 执行更新操作
			int ret = sqlSession.update(statement, user);
			// 手动执行事务
			sqlSession.commit();
			System.out.println(ret);
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
	public void testDelete() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			/**
			 * 映射sql的标识字符串，com.lqyhmb.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
			 * deleteUser是delete标签的id属性值，通过delete标签的id属性值就可以找到要执行的SQL
			 */
			// 映射sql的表示字符串
			String statement = "com.lqyhmb.mapping.userMapper.deleteUser";
			int id = 5;
			// 执行删除操作
			int ret = sqlSession.delete(statement, id);
			// 手动执行事务
			sqlSession.commit();
			System.out.println(ret);
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
	public void testGetAll() {
		SqlSession sqlSession = null;
		List<User> lstUsers = new ArrayList<User>();
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			/**
			 * 映射sql的标识字符串，com.lqyhmb.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
			 * getAllUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
			 */
			// 映射sql的表示字符串
			String statement = "com.lqyhmb.mapping.userMapper.getAllUser";
			// 执行查询操作
			lstUsers = sqlSession.selectList(statement);
			System.out.println(lstUsers);
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
