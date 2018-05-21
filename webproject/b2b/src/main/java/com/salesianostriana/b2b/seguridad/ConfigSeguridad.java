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

	//Bean Filtro normal
	/*@Bean
	public FilterRegistrationBean<SecurityFilter> filterSecurityBean() {
		FilterRegistrationBean<SecurityFilter> registro = new FilterRegistrationBean<>();
		registro.setFilter(securityFilter());
		registro.addUrlPatterns("/");
		registro.setName("securityFilter");
		return registro;
	}*/

	//Bean filtro Admin
	@Bean
	public FilterRegistrationBean<SecurityAdminFilter> adminFilterSecurityBean() {
		FilterRegistrationBean<SecurityAdminFilter> registro = new FilterRegistrationBean<>();
		registro.setFilter(securityAdminFilter());
		registro.addUrlPatterns("/admin/*");
		registro.setName("securityAdminFilter");
		return registro;
	}
	
	//Bean filtro Distribuidor
	@Bean
	public FilterRegistrationBean<SecurityDisFilter> disFilterSecurityBean() {
		FilterRegistrationBean<SecurityDisFilter> registro = new FilterRegistrationBean<>();
		registro.setFilter(securityDisFilter());
		registro.addUrlPatterns("/distribuidor/*");
		registro.setName("securityDisFilter");
		return registro;
	}
	
	//Bean filtro Empresa
	
	@Bean
	public FilterRegistrationBean<SecurityEmpFilter> empFilterSecurityBean() {
		FilterRegistrationBean<SecurityEmpFilter> registro = new FilterRegistrationBean<>();
		registro.setFilter(securityEmpFilter());
		registro.addUrlPatterns("/empresa/*");
		registro.setName("securityEmpFilter");
		return registro;
	}
	
	//FILTRO SEGURIDAD - Normal
/*
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
	*/
	//FILTRO SEGURIDAD - Admin

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

			if (session.getAttribute("usuarioActual") == null) {
				response.sendRedirect("/login");
				return;
			} else if (!(session.getAttribute("usuarioActual") instanceof Administrador)) {
				if (session.getAttribute("usuarioActual") instanceof Distribuidor)
					response.sendRedirect("/distribuidor/");
				else
					response.sendRedirect("/empresa/");
				return;
			
			} else
				chain.doFilter(req, resp);

		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub

		}
	}
	
	//FILTRO SEGURIDAD - Distribuidor
	
	@Bean("securityDisFilter")
	public SecurityDisFilter securityDisFilter() {
		return new SecurityDisFilter();
	}
	
	class SecurityDisFilter implements Filter {

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
			} else if (!(session.getAttribute("usuarioActual") instanceof Distribuidor)) {
				if (session.getAttribute("usuarioActual") instanceof Administrador)
					response.sendRedirect("/admin/");
				else
					response.sendRedirect("/empresa/");
				return;
			
			} else
				chain.doFilter(req, resp);

		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub

		}

	}
	
	//FILTRO SEGURIDAD - Empresa
	
	@Bean("securityEmpFilter")
	public SecurityEmpFilter securityEmpFilter() {
		return new SecurityEmpFilter();
	}
	
	class SecurityEmpFilter implements Filter {

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
			}  else if (!(session.getAttribute("usuarioActual") instanceof Empresa)) {
				if (session.getAttribute("usuarioActual") instanceof Administrador)
					response.sendRedirect("/admin/");
				else
					response.sendRedirect("/distribuidor/");
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
