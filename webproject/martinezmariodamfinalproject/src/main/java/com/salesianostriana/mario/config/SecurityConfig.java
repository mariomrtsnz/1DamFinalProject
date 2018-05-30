package com.salesianostriana.mario.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.salesianostriana.mario.model.Admin;
import com.salesianostriana.mario.model.Client;
import com.salesianostriana.mario.model.Employee;

@Configuration
public class SecurityConfig {
	
//	@Bean
//	public FilterRegistrationBean<SecurityFilter> filterSecurityBean() {
//		FilterRegistrationBean<SecurityFilter> registro = new FilterRegistrationBean<>();
//		registro.setFilter(securityFilter());
//		registro.addUrlPatterns("/");
//		registro.setName("securityFilter");
//		return registro;
//	}

//	@Bean("securityFilter")
//	public SecurityFilter securityFilter() {
//		return new SecurityFilter();
//	}
//	
//	class SecurityFilter implements Filter {
//		
//		@Override
//		public void init(FilterConfig filterConfig) throws ServletException {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//				throws IOException, ServletException {
//			HttpServletRequest request = (HttpServletRequest) req;
//			HttpServletResponse response = (HttpServletResponse) resp;
//			HttpSession session = request.getSession();
//			
//			if (session.getAttribute("loggedUser") == null) {
//				response.sendRedirect("/index");
//				return;
//			} else
//				chain.doFilter(req, resp);
//			
//		}
//		
//		@Override
//		public void destroy() {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
	
	@Bean
	public FilterRegistrationBean<SecurityAdminFilter> adminFilterSecurityBean() {
		FilterRegistrationBean<SecurityAdminFilter> registro = new FilterRegistrationBean<>();
		registro.setFilter(securityAdminFilter());
		registro.addUrlPatterns("/");
		registro.setName("securityAdminFilter");
		return registro;
	}
	@Bean("securityAdminFilter")
	public SecurityAdminFilter securityAdminFilter() {
		return new SecurityAdminFilter();
	}

	class SecurityAdminFilter implements Filter {

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			// TODO Auto-generated method stub

		}

		@Override
		public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
				throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			HttpSession session = request.getSession();

			if (session.getAttribute("loggedUser") instanceof Admin) {
				response.sendRedirect("/admin");
				return;
			} else if (session.getAttribute("loggedUser") instanceof Employee) {
				response.sendRedirect("/staff");
				return;
			} else if (session.getAttribute("loggedUser") instanceof Client) {
				response.sendRedirect("/public");
				return;
			} else
				chain.doFilter(req, resp);

		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub

		}
	}
	
	@Bean
	public FilterRegistrationBean<SecurityEmployeeFilter> employeeFilterSecurityBean() {
		FilterRegistrationBean<SecurityEmployeeFilter> registro = new FilterRegistrationBean<>();
		registro.setFilter(securityEmployeeFilter());
		registro.addUrlPatterns("/staff/*");
		registro.addUrlPatterns("/public/*");
		registro.setName("securityEmployeeFilter");
		return registro;
	}
	@Bean("securityEmployeeFilter")
	public SecurityEmployeeFilter securityEmployeeFilter() {
		return new SecurityEmployeeFilter();
	}

	class SecurityEmployeeFilter implements Filter {

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			// TODO Auto-generated method stub

		}

		@Override
		public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
				throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			HttpSession session = request.getSession();

			if (session.getAttribute("loggedUser") instanceof Admin) {
				response.sendRedirect("/admin");
				return;
			} else if (session.getAttribute("loggedUser") instanceof Employee) {
				response.sendRedirect("/staff");
				return;
			} else if (session.getAttribute("loggedUser") instanceof Client) {
				response.sendRedirect("/public");
				return;
			} else
				chain.doFilter(req, resp);

		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub

		}
	}
	@Bean
	public FilterRegistrationBean<SecurityClientFilter> clientFilterSecurityBean() {
		FilterRegistrationBean<SecurityClientFilter> registro = new FilterRegistrationBean<>();
		registro.setFilter(securityClientFilter());
		registro.addUrlPatterns("/");
		registro.setName("securityClientFilter");
		return registro;
	}
	@Bean("securityClientFilter")
	public SecurityClientFilter securityClientFilter() {
		return new SecurityClientFilter();
	}

	class SecurityClientFilter implements Filter {

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			// TODO Auto-generated method stub

		}

		@Override
		public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
				throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			HttpSession session = request.getSession();

			if (session.getAttribute("loggedUser") == null) {
				response.sendRedirect("/");
				return;
			} else if (session.getAttribute("loggedUser") instanceof Admin) {
				response.sendRedirect("/admin");
				return;
			} else if (session.getAttribute("loggedUser") instanceof Employee) {
				response.sendRedirect("/staff");
				return;
			} else if (session.getAttribute("loggedUser") instanceof Client) {
				response.sendRedirect("/public");
				return;
			} else
				chain.doFilter(req, resp);

		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub

		}
	}
}
