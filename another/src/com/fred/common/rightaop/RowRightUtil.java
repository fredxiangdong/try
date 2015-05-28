package com.fred.common.rightaop;

import java.util.List;

import com.fred.common.entity.EntityBean;
import com.fred.common.sysmodel.QueryParamList;
import com.fred.system.HibernateSessionFactory;

public class RowRightUtil {

	private RowRightUtil() {

	}

	/**
	 * ����ҵ���м�
	 *
	 * @param extJpql the ext jpql
	 * @param extParams the ext params
	 * @return the busi right
	 */
	private static String getBusiRight(String field, String extJpql, QueryParamList extParams) {
		if (SzglCommonUtil.getUserView() != null) {
			extJpql = SzglCommonUtil.getWhereAnd(extJpql);
			extJpql += field + " in(select nextBusiPartyId from ComBusiNext a ,RightLoginBusiDetail b "
					+ "where a.busiPartyId = b.busiCode and b.loginId = :loginId)";
			extParams.addParam("loginId", SzglCommonUtil.getUserView().getLoginId());
		}
		return extJpql;
	}

	/**
	 * ����Ĭ���м�
	 *
	 * @param extJpql the ext jpql
	 * @param extParams the ext params
	 * @return the busi right
	 */
	private static String getDefaultRight(String field, String extJpql, QueryParamList extParams) {
		return getBusiRight(field, extJpql, extParams, SzglCommonUtil.getUserView().getBusiCode());
	}

	/**
	 * �õ�������м������ݡ�
	 *
	 * @param extJpql the ext jpql
	 * @param extParams the ext params
	 * @return the busi right
	 */
	public static String getBusiRight(String field, String extJpql, QueryParamList extParams, Long busiCode) {
		if (SzglCommonUtil.getUserView() != null) {
			extJpql = SzglCommonUtil.getWhereAnd(extJpql);
			extJpql += field + " in(select nextBusiPartyId from ComBusiNext where busiPartyId = :busiPartyId)";
			extParams.addParam("busiPartyId", busiCode);
		}
		return extJpql;
	}

	/**
	 * ����ʵ���м�
	 *
	 * @param extJpql the ext jpql
	 * @param extParams the ext params
	 * @return the busi right
	 */
	private static String getEntityRight(String field, Class<? extends SzglEntityBean> clazz, String extJpql,
			QueryParamList extParams) {
		if (SzglCommonUtil.getUserView() != null) {
			extJpql = SzglCommonUtil.getWhereAnd(extJpql);
			extJpql += field + " in(select nextBusiPartyId from ComBusiNext a ,RightLoginEntityDetail b "
					+ " where a.busiPartyId = b.busiCode and b.entityCode = :entityCode and b.loginId = :loginId)";
			extParams.addParam("entityCode", clazz.toString());
			extParams.addParam("loginId", SzglCommonUtil.getUserView().getLoginId());
		}
		return extJpql;
	}

	/**
	 * ����˵��м�
	 *
	 * @param extJpql the ext jpql
	 * @param extParams the ext params
	 * @return the busi right
	 */
	private static String getItemRight(String field, String appCode, String extJpql, QueryParamList extParams) {
		extJpql = SzglCommonUtil.getWhereAnd(extJpql);
		extJpql += field + " in(select nextBusiPartyId from ComBusiNext a ,RightItemBusiDetail b "
				+ " where a.busiPartyId = b.busiCode and b.rightItemCode = :rightItemCode and b.loginId = :loginId)";
		extParams.addParam("rightItemCode", appCode);
		extParams.addParam("loginId", SzglCommonUtil.getUserView().getLoginId());
		return extJpql;
	}

	/**
	 * 
	 * ��ǰ����Ա���м�����
	 * @param appCode     �˵����롣���appcodeΪ�գ���ʾû�в˵��м�����
	 * @param clazz       ʵ���ࡣ���ʵ��Ϊ�գ���ʾû��ʵ���м���
	 * @param extJpql     ��չsql��
	 * @param extParams   ��չ���ԡ�
	 * @return
	 */
	public static String getRight(String appCode, Class<? extends EntityBean> clazz, String extJpql,
			QueryParamList extParams) {
		return getRight(" busiCode", appCode, clazz, extJpql, extParams);
	}

	/**
	 * 
	 * ��ǰ����Ա���м�����
	 * @param field       ��Ҫ�м����˵��ֶ�����
	 * @param appCode     �˵����롣���appcodeΪ�գ���ʾû�в˵��м�����
	 * @param clazz       ʵ���ࡣ���ʵ��Ϊ�գ���ʾû��ʵ���м���
	 * @param extJpql     ��չsql��
	 * @param extParams   ��չ���ԡ�
	 * @return
	 */
	public static String getRight(String field, String appCode, Class<? extends SzglEntityBean> clazz, String extJpql,
			QueryParamList extParams) {
		if (extParams == null)
			return " extParams must not null";
		// ���ȴ���ʵ���м���
		String entityRight = SzglCommonUtil.getUserView().getEntityRight();
		if (!SzglCommonUtil.strIsNull(entityRight) && clazz != null) {
			String clazzStr = clazz.toString();
			if (entityRight.indexOf("|" + clazzStr + "|") >= 0) {
				return getEntityRight(field, clazz, extJpql, extParams);
			}
		}
		String itemRight = SzglCommonUtil.getUserView().getItemRight();
		if (!SzglCommonUtil.strIsNull(itemRight) && !SzglCommonUtil.strIsNull(appCode)) {
			if (itemRight.indexOf("|" + appCode + "|") >= 0) {
				return getItemRight(field, appCode, extJpql, extParams);
			}
		}
		if (SzglCommonUtil.getUserView().getHasBusiRight()) {
			return getBusiRight(field, extJpql, extParams);
		} else {
			return getDefaultRight(field, extJpql, extParams);
		}
	}

	/**
	 * �жϵ�ǰ����Ա�Ƿ���Ȩ�޲���
	 * @param clazz
	 * @param busiCode
	 * @return
	 */
	public static boolean hasRowRight(Class<? extends SzglEntityBean> clazz, Long busiCode) {
		SzglOrganizationService szglOrganizationService = (SzglOrganizationService) ApplicationUtil
				.getBean("szglOrganizationService");
		QueryParamList extParams = new QueryParamList();
		String extJpql = getRight("partyId", null, clazz, "", extParams);
		QueryParamList params = new QueryParamList();
		params.addParam("partyId", busiCode);
		List<SzglOrganization> list = szglOrganizationService.retrieve(params, extJpql, extParams, null, null);
		if (list.size() <= 0)
			return true;
		return true;
	}
}
