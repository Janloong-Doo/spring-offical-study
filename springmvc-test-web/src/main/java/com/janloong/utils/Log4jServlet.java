package com.janloong.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author sam
 * 
 * @version v0.1
 * 
 * Created on 2013-06-24
 * 
 * Revision History:
 * Date   		Reviser		Description
 * ----   		-------   	----------------------------------------------------
 * 
 * Description:初始化log4j
 */
public class Log4jServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* 
	 * 初始化方法
	 */
	@Override
	public void init() throws ServletException {
		String sWebRootLocalPath = this.getServletContext().getRealPath("/");
		String sLog4jLocalPath = sWebRootLocalPath + this.getInitParameter("log4jPath");
		Logger logger = Logger.getLogger(Log4jServlet.class);
		logger.info(sLog4jLocalPath);
		PropertyConfigurator.configure(sLog4jLocalPath);
		logger.info("log4j初始化成功！");
	}
}
