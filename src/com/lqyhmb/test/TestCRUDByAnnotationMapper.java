package com.lqyhmb.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.lqyhmb.mapping.UserMapperI;
import com.lqyhmb.model.User;
import com.lqyhmb.util.MyBatisUtil;

/**
 * 使用MyBatis对表执行CRUD操作——基于注解的实现
 */
public class TestCRUDByAnnotationMapper {
	private SqlSession sqlSession = null;

	@Test
	public void testAdd() {
		try {
			sqlSession = MyBatisUtil.getSqlSession(true);
			// 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
			UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
			User user = new User();
			user.setName("Mbappe");
			user.setAge(18);
			// 执行添加方法
			int add = mapper.add(user);
			System.out.println(add);
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
		try {
			sqlSession = MyBatisUtil.getSqlSession(true);
			// 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
			UserMapperI mapper = sqlSession.getMapper(UserMapperI.class); 
			int delete = mapper.deleteById(5);
			System.out.println(delete);
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
		try {
			sqlSession = MyBatisUtil.getSqlSession(true);
			// 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
			UserMapperI mapper = sqlSession.getMapper(UserMapperI.class); 
			User user = new User();
			user.setId(6);
			user.setName("姆巴佩(Mbappe)");;
			user.setAge(18);
			int update = mapper.update(user);
			System.out.println(update);
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
	public void testGetUser() {
		try {
			sqlSession = MyBatisUtil.getSqlSession(true);
			// 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
			UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
			User user = mapper.getById(6);
			System.out.println(user.toString());
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
		List<User> list = new ArrayList<User>();
		try {
			sqlSession = MyBatisUtil.getSqlSession(true);
			// 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
			UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
			list = mapper.getAll();
			System.out.println(list);
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
