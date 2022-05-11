package kh.semi.thduo.teacher.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

/**
 * Servlet implementation class TeacherSearchController
 */
@WebServlet("/teacherSearch")
public class TeacherSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet - teacherSearch");
		int currentPage = 1;
		String currentPageStr = request.getParameter("page");
		try {
			if(currentPageStr !=null && !currentPageStr.equals(""))
				currentPage = Integer.parseInt(currentPageStr);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		final int pageSize = 5;  // ���������� ������ ��
		final int pageBlock = 3;  // ����¡�� ��Ÿ�� ��������
		int startPage=0;
		int endPage=0;
		int startRnum=0;
		int endRnum=0;
		
		int totalCnt = 0; // �� �� ��
		totalCnt = new TeacherService().countReadAllTeacher();
		
		System.out.println("��"+totalCnt);
		// select count(*) from board
		
		/* Paging ó�� */
//		int totalPageCnt = (int)Math.ceil(totalCnt/pageSize); 
		int totalPageCnt = (totalCnt/pageSize) + (totalCnt%pageSize==0 ? 0 : 1);
		if(currentPage%pageBlock == 0) {
			startPage = ((currentPage/pageBlock)-1)*pageBlock + 1;
		} else {
			startPage = (currentPage/pageBlock)*pageBlock + 1;
		}
		endPage = startPage + pageBlock - 1;
		if(endPage>totalPageCnt) {
			endPage = totalPageCnt;
		}
		System.out.println("page:"+ startPage +"~"+endPage);
		
		/* rownum ó�� */
		startRnum = (currentPage-1)*pageSize + 1;
		endRnum = startRnum + pageSize -1;
		if(endRnum>totalCnt) {
			endRnum = totalCnt;
		}
		System.out.println("rnum:"+ startRnum +"~"+endRnum);
				
		ArrayList<TeacherVo> volist = new TeacherService().readAllTeacher(startRnum, endRnum);
		
		request.setAttribute("teachVolist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPageCnt", totalPageCnt);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("WEB-INF/view/teacherSearchMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost - teacherSearch");
		
		String object = request.getParameter("object");
		System.out.println(object);
		
		int currentPage = 1;
		String currentPageStr = request.getParameter("page");
		try {
			if(currentPageStr !=null && !currentPageStr.equals(""))
				currentPage = Integer.parseInt(currentPageStr);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		final int pageSize = 2;  // ���������� ������ ��
		final int pageBlock = 3;  // ����¡�� ��Ÿ�� ��������
		int startPage=0;
		int endPage=0;
		int startRnum=0;
		int endRnum=0;
		
		int totalCnt = 0; // �� �� ��
		totalCnt = new TeacherService().countReadTeacher(object);
		
		System.out.println("��"+totalCnt);
		// select count(*) from board
		
		/* Paging ó�� */
//		int totalPageCnt = (int)Math.ceil(totalCnt/pageSize); 
		int totalPageCnt = (totalCnt/pageSize) + (totalCnt%pageSize==0 ? 0 : 1);
		if(currentPage%pageBlock == 0) {
			startPage = ((currentPage/pageBlock)-1)*pageBlock + 1;
		} else {
			startPage = (currentPage/pageBlock)*pageBlock + 1;
		}
		endPage = startPage + pageBlock - 1;
		if(endPage>totalPageCnt) {
			endPage = totalPageCnt;
		}
		System.out.println("page:"+ startPage +"~"+endPage);
		
		/* rownum ó�� */
		startRnum = (currentPage-1)*pageSize + 1;
		endRnum = startRnum + pageSize -1;
		if(endRnum>totalCnt) {
			endRnum = totalCnt;
		}
		System.out.println("rnum:"+ startRnum +"~"+endRnum);
				
		ArrayList<TeacherVo> volist = new TeacherService().readTeacher(object, startRnum, endRnum);
		
		request.setAttribute("teachVolist", volist);
		request.setAttribute("object", object);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPageCnt", totalPageCnt);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("WEB-INF/view/teacherSearchMain.jsp").forward(request, response);
	}

}
