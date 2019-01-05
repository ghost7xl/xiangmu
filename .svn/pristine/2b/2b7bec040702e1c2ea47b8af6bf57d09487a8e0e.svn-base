package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.SysUserDao;
import com.shopping.pojo.SysUser;
import com.shopping.util.DBUtil;

public class SysUserDaoImpl implements SysUserDao {

	/**
	 * 根据ID修改
	 */
	public int editSysUser(SysUser sysUser) {
		Connection conn = DBUtil.getConnection();
		int i = 0;
		String sql = "update from t_sysuser set username = ?,password = ? and flag = ?"
				+ " where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sysUser.getUsername());
			pstmt.setString(2, sysUser.getPassword());
			pstmt.setInt(3, sysUser.getFlag());
			pstmt.setInt(4, sysUser.getId());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 根据用户名密码查询用户
	 */
	public SysUser querySysUser(String adminname, String password) {
		Connection conn = DBUtil.getConnection();
		SysUser sur = null ;
		String sql = "select * from t_sysuser where username=? and password = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminname);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				sur = new SysUser();
				sur.setId(rs.getInt("id"));
				sur.setUsername(rs.getString("username"));
				sur.setPassword(rs.getString("password"));
				sur.setFlag(rs.getInt("flag"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sur;
	}

	@Override
	public List<SysUser> queryAllSysUsers() {
		List<SysUser> ls = new ArrayList<SysUser>();
		SysUser s = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_sysuser";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				s = new SysUser();
				s.setId(rs.getInt(1));
				s.setUsername(rs.getString(2));
				s.setPassword(rs.getString(3));
				s.setFlag(rs.getInt(4));
				ls.add(s);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ls;
	}

	@Override
	public int delSysUser(int id) {
		 int i = 0;
		 Connection conn = DBUtil.getConnection();
			String sql = "delete * from t_sysuser where id = ?";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				i = pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return i;
	}

}
