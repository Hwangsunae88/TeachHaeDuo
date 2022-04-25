package kh.semi.thduo.teacher.model.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.review.model.vo.ReviewVo;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

public class TeacherDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 선생님 교습정보 삽입
	public int insertTeacher(Connection conn, TeacherVo vo) {
		int result = 0;
		
		return result;
	}
	
	// 모든 선생님 정보 읽기
	public ArrayList<TeacherVo> readAllTeacher(Connection conn){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	} 
	
	// 검색한 과목에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readTeacher(Connection conn, String object) {
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	} 
	
	// 성별에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readGenderTeacher(Connection conn, String genderFm){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 활동지역에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readAreaTeacher(Connection conn, String area){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 온-오프 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readOnlineTeacher(Connection conn, String onlineYna){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 통화허용 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readCallTeacher(Connection conn, String tPermitYn){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 모집 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readRecruitTeacher(Connection conn, String tRecruitYn){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 찜 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readLikeTeacher(Connection conn, String sNo){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 선생님 상세정보 읽기
	public TeacherVo readTeacherInfo(Connection conn, String tNo){
		TeacherVo retVo = null;
		String sql = "SELECT pro.*, olist.object_list, alist.area_list, rscore.avg_rscore, SUBSTR(m.m_name,1,1) || LPAD('*',LENGTH(m.m_name)-1, '*') m_name, TRUNC(MONTHS_BETWEEN(TRUNC(SYSDATE,'YEAR'), m.m_birth)/12)+2 t_age, m.m_nickname, m.gender_fm, m.m_address "
				+ "FROM t_profile pro JOIN member m ON pro.m_id = m.m_id "
				+ "JOIN view_teacher_rscroe_avg rscore ON rscore.m_nickname = m.m_nickname "
				+ "JOIN view_teacher_object olist ON olist.m_nickname = m.m_nickname "
				+ "JOIN view_teacher_area alist ON alist.m_nickname = m.m_nickname "
				+ "WHERE t_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNo);
			rs = pstmt.executeQuery();
//			private ArrayList<ReviewVo> tReview;
			
			if (rs.next()) {
				retVo = new TeacherVo();
				
				retVo.setT_no(rs.getString("t_no"));
				retVo.setT_major(rs.getString("t_major"));
				retVo.setOnline_yna(rs.getString("online_yna"));
				retVo.setT_tcnt(rs.getString("t_tcnt"));
				retVo.setT_tprice(rs.getString("t_tprice"));
				retVo.setT_wantstud(rs.getString("t_wantstud"));
				retVo.setT_career(rs.getString("t_career"));
				retVo.setT_language(rs.getString("t_language"));
				retVo.setT_special(rs.getString("t_special"));
				retVo.setT_approval(rs.getString("t_approval"));
				retVo.setT_permit_yn(rs.getString("t_permit_yn"));
//				retVo.setT_picture(rs.getString("t_picture"));
				retVo.setT_intro(rs.getString("t_intro"));
				retVo.setT_recruit_yn(rs.getString("t_recruit_yn"));
				retVo.setObject_list(rs.getString("object_list"));
				retVo.setArea_list(rs.getString("area_List"));
				retVo.setAvg_rscore(rs.getDouble("avg_rscore"));
				retVo.setM_id(rs.getString("m_id"));
				retVo.setT_age(rs.getInt("t_age"));
				retVo.setM_name(rs.getString("m_name"));
				retVo.setM_nickname(rs.getString("m_nickname"));
				retVo.setGender_fm(rs.getString("gender_fm"));
				retVo.setM_address(rs.getString("m_address"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return retVo;
	}
	
	// 선생님 교습정보 수정
	public int updateTeacher(Connection conn, TeacherVo vo){
		int retsult = 0;
		
		return retsult;
	}
	
	// 선생님 통화허용 여부 변경
	public int updateTeacherPermit(Connection conn, String tNo){
		int retsult = 0;
		
		return retsult;
	}
}