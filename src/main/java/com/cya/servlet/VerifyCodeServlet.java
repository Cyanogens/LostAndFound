package com.cya.servlet;

import com.cya.utils.VerifyCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description 验证码请求生成处理类
 * @author WANGZIC
 */
@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String verifyCode = VerifyCode.getVerifyCode(90,40,response.getOutputStream());
		request.getSession().setAttribute("sessionVerify",verifyCode);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}

}
