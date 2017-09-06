package cn.gss.lk.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "UserFilter",urlPatterns = "/pages/front/user/*")
public class UserFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		if (request.getSession().getAttribute("user") == null) {
			request.setAttribute("msg", "您还未登录，请先登录！");
			request.setAttribute("url", "/pages/front/login.jsp");
			request.getRequestDispatcher("/pages/forward.jsp").forward(req, resp);
		} else
			chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
