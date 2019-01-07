package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.UserDao;
import com.shopping.pojo.User;
import com.shopping.util.DBUtil;

public class UserDaoImpl implements UserDao {
	/**
	 * 添加用户
	 */
	@Override
	public int addUser(User user) {
		Connection conn = DBUtil.getConnection();
		int i = 0;
		String sql = "insert into t_user values(null,?,?,?,?,?,?,null)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getActivatecode());
			pstmt.setInt(5, user.getFlag());
			pstmt.setString(6, user.getGender());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 删除用户根据Id
	 */
	public int delUser(int id) {
		int i = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "delete from t_user where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 修改用户
	 */
	public int editUser(User user) {
		System.out.println(user);
		int i = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "update t_user set username=?,password=?,email=?,flag=?,gender=? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, user.getFlag());
			pstmt.setString(5, user.getGender());
			pstmt.setInt(6, user.getId());
			i = pstmt.executeUpdate();
			System.out.println(i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 查询所有用户
	 */
	public List<User> queryAllUser() {
		Connection conn = DBUtil.getConnection();
		List<User> userList = new ArrayList<User>();
		String sql = "select * from t_user ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setActivatecode(rs.getString("activatecode"));
				user.setFlag(rs.getInt("flag"));
				user.setGender(rs.getString("gender"));
				user.setCreatetime(rs.getDate("createtime"));
				userList.add(user);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * 查询用户根据id
	 */
	public User queryUser(int id) {
		Connection conn = DBUtil.getConnection();
		User user = null;
		String sql = "select * from t_user where id = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setActivatecode(rs.getString("activatecode"));
				user.setFlag(rs.getInt("flag"));
				user.setGender(rs.getString("gender"));
				user.setCreatetime(rs.getDate("createtime"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 查询用户根据name
	 */
	public User queryUserByname(String username) {
		Connection conn = DBUtil.getConnection();
		User user = null;
		String sql = "select * from t_user where username = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setActivatecode(rs.getString("activatecode"));
				user.setFlag(rs.getInt("flag"));
				user.setGender(rs.getString("gender"));
				user.setCreatetime(rs.getDate("createtime"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	/**
	 * 查询用户根据用户姓名密码
	 */
	public User queryUser(String username, String password) {
		Connection conn = DBUtil.getConnection();
		User user = null;
		String sql = "select * from t_user where username = ? and password = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setActivatecode(rs.getString("activatecode"));
				user.setFlag(rs.getInt("flag"));
				user.setGender(rs.getString("gender"));
				user.setCreatetime(rs.getDate("createtime"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> queryUserList(String name, String gender) {
		Connection conn = DBUtil.getConnection();
		List<User> userList = new ArrayList<User>();
		String sql = "select * from t_user where username like ? and gender= ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + name + '%');
			pstmt.setString(2, gender);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setActivatecode(rs.getString("activatecode"));
				user.setFlag(rs.getInt("flag"));
				user.setGender(rs.getString("gender"));
				user.setCreatetime(rs.getDate("createtime"));
				userList.add(user);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<User> queryUserListByUserName(String name) {
		Connection conn = DBUtil.getConnection();
		List<User> userList = new ArrayList<User>();
		String sql = "select * from t_user where username like ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + name + '%');
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setActivatecode(rs.getString("activatecode"));
				user.setFlag(rs.getInt("flag"));
				user.setGender(rs.getString("gender"));
				user.setCreatetime(rs.getDate("createtime"));
				userList.add(user);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<User> queryUserListByGender(String gender) {
		Connection conn = DBUtil.getConnection();
		List<User> userList = new ArrayList<User>();
		String sql = "select * from t_user where gender= ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gender);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setActivatecode(rs.getString("activatecode"));
				user.setFlag(rs.getInt("flag"));
				user.setGender(rs.getString("gender"));
				user.setCreatetime(rs.getDate("createtime"));
				userList.add(user);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
