package kh.semi.thduo.alarm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.alarm.model.vo.AlarmVo;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

public class AlarmDao {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public int sendAlarm(Connection conn, AlarmVo vo) {
		int result = 0;
		String sql = "INSERT INTO alarm VALUES((SELECT NVL(MAX(alarm_no), 0) + 1 FROM alarm), ?, DEFAULT, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAlarm_content());
			pstmt.setString(2, vo.getAlarm_sendid());
			pstmt.setString(3, vo.getAlarm_receiveid());
			pstmt.setString(4, vo.getM_id());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<AlarmVo> sendListAlarm(Connection conn, String mNickname){
		ArrayList<AlarmVo> voList = null;
		String sql = "select alarm_content,alarm_date,alarm_receiveid from ALARM where alarm_sendid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mNickname);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<AlarmVo>();
				while(rs.next()) {
					AlarmVo vo = new AlarmVo();
					vo.setAlarm_content(rs.getString("alarm_content"));
					vo.setAlarm_date(rs.getTimestamp("alarm_date"));
					vo.setAlarm_receiveid(rs.getString("alarm_receiveid"));
					voList.add(vo);
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return voList;
	}
	public ArrayList<AlarmVo> receiveListAlarm(Connection conn, String mNickname){
		ArrayList<AlarmVo> voList = null;
		String sql = "select alarm_content,alarm_date,alarm_sendid from ALARM where alarm_receiveid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mNickname);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<AlarmVo>();
				while(rs.next()) {
					AlarmVo vo = new AlarmVo();
					vo.setAlarm_content(rs.getString("alarm_content"));
					vo.setAlarm_date(rs.getTimestamp("alarm_date"));
					vo.setAlarm_sendid(rs.getString("alarm_sendid"));
					voList.add(vo);
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return voList;
	}
	
	
}
