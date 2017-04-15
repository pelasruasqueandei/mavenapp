package br.com.douglasfernandes.console.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.douglasfernandes.console.logger.Logs;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter
{
	@Override
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object controller) throws Exception
	 {
		  String uri = request.getRequestURI();
	      
	      if(uri.endsWith("esqueciSenha")||uri.contains("getPontos")||uri.endsWith("login")||uri.endsWith("entrar")||uri.contains("resources")||uri.contains("tags/")||uri.contains("erro")) {
	    	  Logs.info("[AutorizadorInterceptor INFO]: Área externa.");
	    	  return true;
	      }
	      Logs.warn("[AutorizadorInterceptor WARN]: Login necessário.");
	      response.sendRedirect("login");
	      return false;
	 }
}