package cn.huaguang.web;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.huaguang.pojo.Student;
import cn.huaguang.util.JDBCUtil;
/**
 * 按学号查询学生
 */
/**
 * Servlet implementation class SelectStudentOne
 */
@WebServlet("/SelectStudentOne")
public class SelectStudentOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		// 得到客户端发送过来的
		String number1 = request.getParameter("number1");
		String sql = "select * from student where number=?;";
		ResultSet re2 = JDBCUtil.executeQuery(sql, number1);
		// 1.将得到的数据先封装到一个Student对象中
		List<Student> list = new ArrayList<Student>();
		try {
			if (re2.next()) {
				// 创建一个对象Student
				Student studunt = new Student();
				studunt.setNumber(re2.getString("number"));// 学号
				studunt.setName(re2.getString("name"));// 姓名
				studunt.setSex(re2.getString("sex"));// 性别
				studunt.setPhone(re2.getString("phone"));// 手机
				studunt.setBirthday(re2.getString("birthday"));// 出生日期
				studunt.setAddress(re2.getString("address"));// 地址
				studunt.setChinese(re2.getString("chinese"));// 语文成绩
				studunt.setMath(re2.getString("math"));// 数学成绩
				studunt.setEnglish(re2.getString("english"));// 英语成绩
				System.out.println("---------->" + studunt);
				// 2.将这个对象放到list集合中
				list.add(studunt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JDBCUtil.close(JDBCUtil.getCt(), JDBCUtil.getPs(), re2);
		// 3.将list解析成json格式的数据:次处用json解析工具,fastjson(特点:简单,好用,0依赖)
		String listjson = JSON.toJSONString(list);
		// 4.返回给客户
		response.getWriter().println(listjson);
		System.out.println(request.getRemoteAddr() + "单条查询:" + listjson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
