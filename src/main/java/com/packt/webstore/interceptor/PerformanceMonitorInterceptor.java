package com.packt.webstore.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sun.istack.internal.logging.Logger;

public class PerformanceMonitorInterceptor implements HandlerInterceptor{

	ThreadLocal<StopWatch> stopWatchLocal=new ThreadLocal<StopWatch>();
	
	Logger logger= Logger.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		StopWatch stopWatch=new StopWatch(handler.toString());
		stopWatch.start(handler.toString());
		stopWatchLocal.set(stopWatch);
		logger.info("Przetwarzanie ¿¹dania do œcie¿ki: " +geteURLPath(request));
		logger.info("Przetwarzanie rozpoczêto o: "+getCurrentTime());
		
		return true;
	}



	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Przetwarzanie ¿¹dania zakoñczono o: "+getCurrentTime());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		StopWatch stopWatch=stopWatchLocal.get();
		stopWatch.stop();
		logger.info("£¹czny czas przetwarzania ¿¹dania: " +stopWatch.getTotalTimeMillis()+ " ms");
		stopWatchLocal.set(null);
		logger.info("=============================================================================");
		
	}

	private String getCurrentTime() {
		// TODO Auto-generated method stub
		
		DateFormat formatter=new SimpleDateFormat("dd/MM/yyyy 'o' hh:mm:ss");
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		
		return formatter.format(calendar.getTime());
	}

	private String geteURLPath(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String currentPath=request.getRequestURI();
		String queryString=request.getQueryString();
		queryString=queryString == null ? "" : "?" + queryString;
		
		return currentPath+queryString;
	}
	
	
}// koniec klasy
