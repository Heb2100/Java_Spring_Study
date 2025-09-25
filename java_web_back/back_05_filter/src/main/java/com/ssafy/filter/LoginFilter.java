package com.ssafy.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet Filter implementation class MyFilter
 */

@WebFilter("/board")
public class LoginFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 우리의 게시판 로그인 한 사람만 볼수 있어야겠어
		// 세션에 loginUser 속성 있는지 체크
		
		// 명시적 형변환이 필요한 순간. (instance of 를 통해 바꾸는게 안전할지도?)
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect("/login.jsp");
		}
		
		chain.doFilter(request, response);
	}

}
