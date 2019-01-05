package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.UserAddressDao;
import com.shopping.pojo.UserAddress;
import com.shopping.util.DBUtil;

public class UserAddressDaoImpl implements UserAddressDao {

	/**
	 * 添加用户
	 */
	public int addUserAddress(UserAddress userAddress) {
		Connection conn = DBUtil.getConnection();
		int i = 0;
		String sql = "insert into t_useraddress values(null,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userAddress.getName());
			pstmt.setString(2, userAddress.getPhone());
			pstmt.setInt(3, userAddress.getPid());
			pstmt.setInt(4, userAddress.getCityid());
			pstmt.setInt(5, userAddress.getCountyid());
			pstmt.setInt(6, userAddress.getUid());
			pstmt.setString(7, userAddress.getDetail());
			pstmt.setInt(8, userAddress.getFlag());
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
	 * 删除用户根据Id
	 */
	public int delUserAddress(int id) {
		int i = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "delete from t_useraddress where id = ?";
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

	/**
	 * 根据id修改用户
	 */
	public int editUserAddress(UserAddress userAddress) {
		int i = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "update t_useraddress set name=?,phone=?,pid=?,cityid=?,countyid=?,uid=?,detail=?,"
				+ " flag=? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userAddress.getName());
			pstmt.setString(2, userAddress.getPhone());
			pstmt.setInt(3, userAddress.getPid());
			pstmt.setInt(4, userAddress.getCityid());
			pstmt.setInt(5, userAddress.getCountyid());
			pstmt.setInt(6, userAddress.getUid());
			pstmt.setString(7, userAddress.getDetail());
			pstmt.setInt(8, userAddress.getFlag());
			pstmt.setInt(9, userAddress.getId());
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
	 * 查询所有用户
	 */
	public List<UserAddress> queryAllUserAddress() {
		Connection conn = DBUtil.getConnection();
		List<UserAddress> userList = new ArrayList<UserAddress>();
		String sql = "select * from t_useraddress ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserAddress userAdList = new UserAddress();
				userAdList.setId(rs.getInt("id"));
				userAdList.setName(rs.getString("name"));
				userAdList.setPhone(rs.getString("phone"));
				userAdList.setPid(rs.getInt("pid"));
				userAdList.setCityid(rs.getInt("cityid"));
				userAdList.setCountyid(rs.getInt("countyid"));
				userAdList.setUid(rs.getInt("uid"));
				userAdList.setDetail(rs.getString("detail"));
				userAdList.setFlag(rs.getInt("flag"));
				userList.add(userAdList);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * 查询用户根据id
	 */
	public UserAddress queryUserAddressById(int id) {
		Connection conn = DBUtil.getConnection();
		UserAddress userAd = null;
		String sql = "select * from t_useraddress where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				userAd = new UserAddress();
				userAd.setName(rs.getString("name"));
				userAd.setPhone(rs.getString("phone"));
				userAd.setPid(rs.getInt("pid"));
				userAd.setCityid(rs.getInt("cityid"));
				userAd.setCountyid(rs.getInt("countyid"));
				userAd.setUid(rs.getInt("uid"));
				userAd.setDetail(rs.getString("detail"));
				userAd.setFlag(rs.getInt("flag"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userAd;
	}

	@Override
	public List<UserAddress> queryAllUserAddressByUid(int uid) {
		Connection conn = DBUtil.getConnection();
		List<UserAddress> userList = new ArrayList<UserAddress>();
		String sql = "select * from t_useraddress where uid=? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserAddress userAdList = new UserAddress();
				userAdList.setId(rs.getInt("id"));
				userAdList.setName(rs.getString("name"));
				userAdList.setPhone(rs.getString("phone"));
				userAdList.setPid(rs.getInt("pid"));
				userAdList.setCityid(rs.getInt("cityid"));
				userAdList.setCountyid(rs.getInt("countyid"));
				userAdList.setUid(rs.getInt("uid"));
				userAdList.setDetail(rs.getString("detail"));
				userAdList.setFlag(rs.getInt("flag"));
				userList.add(userAdList);
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
