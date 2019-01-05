package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.ProvinceDao;
import com.shopping.pojo.Province;
import com.shopping.util.DBUtil;

public class ProvinceDaoImpl implements ProvinceDao {

	@Override
	public List<Province> queryAllProvince() {
		List<Province> pr = new ArrayList<Province>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_province ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Province p = null;
			while(rs.next()){
				p = new Province();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				pr.add(p);
			}
			 rs.close();
	            pstmt.close();
	            conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		return pr;
	}

	@Override
	public Province queryById(int id) {
		Connection conn = DBUtil.getConnection();
		Province p = null;
		String sql = "select * from t_province where id =? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				p = new Province();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				
			}
			 rs.close();
	            pstmt.close();
	            conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		return p;
	}

}
