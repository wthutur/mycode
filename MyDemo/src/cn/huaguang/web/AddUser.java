package cn.huaguang.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huaguang.util.JDBCUtil;


/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理中文乱码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");

				// 1.从客户端(浏览器)接收用户输入的信息
//				String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				String username = request.getParameter("username");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				
				
				System.out.println(username);
				System.out.println(password);
				String sql = "insert into user(username,name,password)values(?,?,?)";
				//re是一个变量,是操作数据库返回的值,本质:是操作成功多少条数据
				int re = JDBCUtil.executeUpdate(sql,username,name,password);
				if(re!=0) {
					System.out.println("添加成功");
				}else {
					System.out.println("管理员添加失败");
				}
				response.addHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().println(re);
				
			


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
