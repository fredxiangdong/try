package com.fred.common.sysmodel;


public class DealPageInfo {

	/**		public int dealPageInfo(PageInfo pageInfo){
		// �����ҳ
			if (pageInfo != null) {
						if (pageInfo.getStartIndex() != null) {//new Grid����ѯ����
							query.setFirstResult(pageInfo.getStartIndex());
							query.setMaxResults(pageInfo.getEndIndex() - pageInfo.getStartIndex());
						} else {

							// ����������
							// ʹ���α���ʽ������ҳ��,Ч�ʻ�����,�����ݱ��뵥��д��ѯ����ql
							int totalCount = 0;
							if (pageInfo.getPageHql() == null) {//pageInfo�������Զ����ҳ
								String pageJpql = JpqlUtil.deleteOuterOrderBy(jpql);
								Query pageQuery = getSession().createQuery(pageJpql);
								setQueryParamList(pageQuery, allParams);
								ScrollableResults scrollCursor = pageQuery.scroll(ScrollMode.SCROLL_SENSITIVE);
								scrollCursor.last();
								totalCount = Integer.valueOf(scrollCursor.getRowNumber() + 1);
							} else {//PageInfo��hql,ʹ���Զ���hql
								Query innPageQuery = getSession().createQuery(pageInfo.getPageHql());
								innPageQuery.setCacheable(true);//ʹ�û���
								setQueryParamList(innPageQuery, pageInfo.getPageParams());
								totalCount = Integer.valueOf(innPageQuery.uniqueResult() + "");
							}
							pageInfo.setAllRowNum(totalCount);

							// ֻ�д���0�ŷ�ҳ
							if (pageInfo.getRowOfPage() > 0) {
								int startRowNo = 0;
								if (totalCount == 0) {
									pageInfo.setAllPageNum(0);
									pageInfo.setCurPageNum(0);
								} else {
									// ������ҳ��
									int tpPageNum = totalCount % pageInfo.getRowOfPage();
									int allPageNum = (totalCount - tpPageNum) / pageInfo.getRowOfPage();
									if (tpPageNum > 0) {
										allPageNum = allPageNum + 1;
									}
									pageInfo.setAllPageNum(allPageNum);

									if (pageInfo.getCurPageNum() == 0) {
										pageInfo.setCurPageNum(1);
									}
									startRowNo = (pageInfo.getCurPageNum() - 1) * pageInfo.getRowOfPage();
									//���ָ����ҳ��û�����ݣ��������һҳ������ 
									if (totalCount <= startRowNo) {
										pageInfo.setCurPageNum(1);
										startRowNo = 0;
									}
								}

								query.setFirstResult(startRowNo);
								query.setMaxResults(pageInfo.getRowOfPage());

							}
						}
	}
	**/
}
