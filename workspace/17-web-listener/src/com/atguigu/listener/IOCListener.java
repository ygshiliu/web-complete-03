package com.atguigu.listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



/**
 * 描述：
 * 开发者：Miss Wang
 * 2017年4月26日 下午5:31:35
 */
public class IOCListener implements ServletContextListener ,HttpSessionListener{
	
	List<HttpSession> list = Collections.synchronizedList(new LinkedList<HttpSession>());
	
	public IOCListener() {
		System.out.println("IOCListener实例化");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextInitialized初始化");
		
		ServletContext context = sce.getServletContext();
		context.setAttribute("online", 0);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				for (HttpSession session : list) {
					System.out.println("循环中");
					if(System.currentTimeMillis()-session.getLastAccessedTime() > 1000*30){
						System.out.println("=====");
						list.remove(session);
						session.invalidate();
					}
					
				}
				
			}
		}, 0, 1000*10);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed销毁");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session = se.getSession();
		list.add(session);
		System.out.println(list);
		ServletContext context = session.getServletContext();
		int count = (int) context.getAttribute("online");
		context.setAttribute("online", ++count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext context = se.getSession().getServletContext();
		int count = (int) context.getAttribute("online");
		context.setAttribute("online", --count);
		
	}

}
