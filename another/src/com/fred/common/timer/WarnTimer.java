package com.fred.common.timer;

import java.sql.Timestamp;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fred.common.HyCommonUtil;


public class WarnTimer implements ServletContextListener {

	/**
	 * ÿ��ĺ�����
	 */
	public static final long PERIOD_HOUR = 86400000;
	/**
	 * ��ʱ��
	 */
	private Timer timer;

	/**
	 * ��WebӦ������ʱ��ʼ������
	 */
	public void contextInitialized(ServletContextEvent event) {
		// ���嶨ʱ��
		timer = new Timer(true);
		try{
		// Ԥ����Ϣ��Ӧ��������ÿ��10��55ִ��һ��
			Timestamp time1 = HyCommonUtil.addMinute(HyCommonUtil.addHour(HyCommonUtil.addDay(
					HyCommonUtil.getDayFirst(HyCommonUtil.getDate()), 0), 10),55);

		timer.schedule(new WarnTask(), time1, PERIOD_HOUR);
		
/*		Timestamp time2 = HyCommonUtil.addMinute(HyCommonUtil.addHour(HyCommonUtil.addDay(
				HyCommonUtil.getDayFirst(HyCommonUtil.getDate()), 0), 10),54);

		timer.schedule(new WarnTask(), time2, PERIOD_HOUR);*/
		//�ɶ�������ʱ��

		} catch (Exception e) {
			System.out.println("��ʱ�������߳��쳣:" + e.getMessage());
		}

	}

	/**
	 * ��WebӦ�ý���ʱֹͣ����
	 */
	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel(); // ��ʱ������
	}

}
