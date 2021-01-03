package cn.huaguang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huaguang.util.JDBCUtil;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理中文乱码
		response.getWriter().println(false);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		// 1.从客户端(浏览器)接收用户输入的信息
		String number1 = request.getParameter("number1");
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String chinese = request.getParameter("chinese");
		String math = request.getParameter("math");
		String english = request.getParameter("english");
		
		String sql ="UPDATE `homework`.`student` SET `number`=?,`name`=?,`sex`=?,`phone`=?,`birthday`=?,`address`=?," + 
				" `chinese`=?,`math`=?,`english`=? WHERE `number`=?;";
		
		int res = JDBCUtil.executeUpdate(sql,number,name, sex, phone, birthday, address, chinese, math, english,number1);// ?
	
		if (res != 0) {
			System.out.println("修改成功");
			response.getWriter().println(true);
		} else {
			System.out.println("学生修改失败");
			response.getWriter().println(false);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
