package kh.semi.thduo.pencil.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;
import kh.semi.thduo.pencil.model.dao.PencilDao;
import kh.semi.thduo.pencil.model.vo.PencilVo;

public class PencilService {
	private PencilDao dao = new PencilDao();
	
	public int plusPencil(PencilVo vo) {
		int result = 0;
		
		Connection conn = getConnection();
		result = dao.plusPencil(conn, vo);
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	public int minusPencil(PencilVo vo) {
		int result = 0;
		
		return result;
		
	}
	public ArrayList<PencilVo> listPencil(String mId) {
		ArrayList<PencilVo> result = null;
		
		return result;
		
	}
}
