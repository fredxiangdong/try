package com.fred.common.timer;

import java.sql.Timestamp;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fred.common.HyCommonUtil;


public class WarnTimer implements ServletContextListener {

	/**
	 * 每天的毫秒数
	 */
	public static final long PERIOD_HOUR = 86400000;
	/**
	 * 定时器
	 */
	private Timer timer;

	/**
	 * 在Web应用启动时初始化任务
	 */
	public void contextInitialized(ServletContextEvent event) {
		// 定义定时器
		timer = new Timer(true);
		try{
		// 预警信息，应用启动后每天10点55执行一次
			Timestamp time1 = HyCommonUtil.addMinute(HyCommonUtil.addHour(HyCommonUtil.addDay(
					HyCommonUtil.getDayFirst(HyCommonUtil.getDate()), 0), 10),55);

		timer.schedule(new WarnTask(), time1, PERIOD_HOUR);
		
/*		Timestamp time2 = HyCommonUtil.addMinute(HyCommonUtil.addHour(HyCommonUtil.addDay(
				HyCommonUtil.getDayFirst(HyCommonUtil.getDate()), 0), 10),54);

		timer.schedule(new WarnTask(), time2, PERIOD_HOUR);*/
		//可定义多个定时器

		} catch (Exception e) {
			System.out.println("定时任务主线程异常:" + e.getMessage());
		}

	}

	/**
	 * 在Web应用结束时停止任务
	 */
	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel(); // 定时器销毁
	}

}
