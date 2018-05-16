package com.salesianostriana.b2b.seguridad;

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

import com.salesianostriana.b2b.model.Administrador;
import com.salesianostriana.b2b.model.Distribuidor;
import com.salesianostriana.b2b.model.Empresa;


@Configuration
public class ConfigSeguridad {

	@Bean
	public FilterRegistrationBean<SecurityFilter> filterSecurityBean() {
		FilterRegistrationBean<SecurityFilter> registro = new FilterRegistrationBean<>();
		registro.setFilter(securityFilter());
		registro.addUrlPatterns("/");
		registro.setName("securityFilter");
		return registro;
	}

	@Bean
	public FilterRegistrationBean<SecurityAdminFilter> adminFilterSecurityBean() {
		FilterRegistrationBean<SecurityAdminFilter> registro = new FilterRegistrationBean<>();
		registro.setFilter(securityAdminFilter());
		registro.addUrlPatterns("/");
		registro.setName("securityAdminFilter");
		return registro;
	}

	@Bean("securityFilter")
	public SecurityFilter securityFilter() {
		return new SecurityFilter();
	}

	class SecurityFilter implements Filter {

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

			if (session.getAttribute("usuarioActual") == null) {
				response.sendRedirect("/login");
				return;
			} else
				chain.doFilter(req, resp);

		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub

		}

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

			if (session.getAttribute("usuarioActual") instanceof Administrador) {
				response.sendRedirect("/pc_admin/");
				return;
			} else if (session.getAttribute("usuarioActual") instanceof Distribuidor) {
				response.sendRedirect("/pc_dis/");
				return;
			} else if (session.getAttribute("usuarioActual") instanceof Empresa) {
				response.sendRedirect("/pc_emp/");
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
