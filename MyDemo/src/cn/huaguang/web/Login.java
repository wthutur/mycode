package cn.huaguang.web;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huaguang.util.JDBCUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = "select * from user where username=?;";
		ResultSet res = JDBCUtil.executeQuery(sql,username);//?
		String info = "0";
		try {
			if(res.next()) {
				if(password.equals(res.getString("password"))) {
					info = "2";
					System.out.println(username+"登录成功");
				}else{
					info="1";
					System.out.println(username+"密码错误");
				}
			}else {
				System.out.println(username+"没有这个用户名");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().println(info);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
