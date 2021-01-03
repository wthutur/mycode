package cn.huaguang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huaguang.util.JDBCUtil;

/**
 * 添加公的服务器端
 */
@WebServlet("/AddNotice")
public class AddNotice extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//处理跨域访问问题
		response.addHeader("Access-Control-Allow-Origin", "*");
		String notice_title = request.getParameter("notice_title");
		String notice_msg = request.getParameter("notice_msg");
		String notice_content = request.getParameter("notice_content");
		String remark = request.getParameter("remark");
		String sql = "INSERT INTO `homework`.`notice`( `notice_title`, `notice_msg`, `notice_content`, `remark`) VALUES (?,?,?,?)"; 
		//保存到数据库
		int re = JDBCUtil.executeUpdate(sql,notice_title,notice_msg,notice_content,remark);
		if(re!=0) {
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
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
