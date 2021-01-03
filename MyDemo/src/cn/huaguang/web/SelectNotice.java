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

import cn.huaguang.pojo.Notice;
import cn.huaguang.util.JDBCUtil;

/**
 * Servlet implementation class SelectNotice
 */
@WebServlet("/SelectNotice")
public class SelectNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		// 查询出总数据
		String sql = "select count(*) counts from notice";
		ResultSet rs = JDBCUtil.executeQuery(sql);// 发送sql语句
		int count = 0;// 默认有0条数据
		// 得到数据
		try {
			if (rs.next()) {
				count = rs.getInt("counts");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭资源
		JDBCUtil.close(JDBCUtil.getCt(), JDBCUtil.getPs(), rs);
		System.out.println("总记录数:" + count);

		// 查询数据
		// layui:有一个分页插件的,只需要得到两个参数:当前页:page,条数:limit:

		int page = Integer.parseInt(request.getParameter("page"));// 1
		//int page =Integer.parseInt(request.getAttribute("page").toString());
		int limit = Integer.parseInt(request.getParameter("limit"));// 10
		//int limit = Integer.parseInt(request.getAttribute("limit").toString());
		sql = "select * from notice limit " + (page - 1) * limit + "," + limit + ";";
		//sql = "select * from notice limit 0,10;";

		ResultSet re2 = JDBCUtil.executeQuery(sql);// n多条数据

		// 1.将得到的数据先封装到一个Notice对象中
		List<Notice> list = new ArrayList<Notice>();

		try {
			while (re2.next()) {

				// 创建一个对象Notice
				Notice notice = new Notice();
				notice.setId(re2.getString("id"));
				notice.setNotice_title(re2.getString("notice_title"));
				notice.setNotice_msg(re2.getString("notice_msg"));
				notice.setNotice_content(re2.getString("notice_content"));
				notice.setRemark(re2.getString("remark"));
				notice.setUpload_time(re2.getString("upload_time"));

				// 2.将这个对象放到list集合中
				list.add(notice);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JDBCUtil.close(JDBCUtil.getCt(), JDBCUtil.getPs(), re2);
		// 3.将list解析成json格式的数据:次处用json解析工具,fastjson(特点:简单,好用,0依赖)
		String listjson = JSON.toJSONString(list);

		String json = "{\"code\":0,\"msg\":\"\",\"count\":" + count + ",\"data\":" + listjson + "}";

		// 4.返回给客户
		response.getWriter().println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
