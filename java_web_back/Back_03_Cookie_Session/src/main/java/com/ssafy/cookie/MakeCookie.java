package com.ssafy.cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/make")
public class MakeCookie extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String keyString = req.getParameter("key");
		String valueString = req.getParameter("value");
		
		
		Cookie cookie = new Cookie(keyString, valueString);
		
		cookie.setMaxAge(60);// 1분
		
//		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		
		resp.sendRedirect("02_CookieResult.jsp");
		
		req.getSession();
		
		
	}
}
