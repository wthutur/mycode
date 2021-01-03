package com.web.oa.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	// 验证码在登录之前拦截
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		// 获取用户输入的字符串
		String validateCode = req.getParameter("validateCode");
		// 获取验证码的字符串
		String randNum = (String) session.getAttribute("randomCode");
		
		// 比较如果验证码和用户输入的不等于就返回错误信息
		if (validateCode != null && randNum != null && !validateCode.equals(randNum)) {
			// 验证码的错误信息存入InValidateCode中
			request.setAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, "InValidateCode");
			return true;
			// 进入"/login"
		}

		return super.onAccessDenied(request, response);
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		WebUtils.getAndClearSavedRequest(request);
		WebUtils.redirectToSavedRequest(request, response, "/main");
		return false;
	}
}
