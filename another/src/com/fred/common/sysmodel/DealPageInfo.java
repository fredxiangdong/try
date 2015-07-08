package com.fred.common.sysmodel;


public class DealPageInfo {

	/**		public int dealPageInfo(PageInfo pageInfo){
		// 处理分页
			if (pageInfo != null) {
						if (pageInfo.getStartIndex() != null) {//new Grid不查询总数
							query.setFirstResult(pageInfo.getStartIndex());
							query.setMaxResults(pageInfo.getEndIndex() - pageInfo.getStartIndex());
						} else {

							// 设置总行数
							// 使用游标形式计算总页数,效率会稍慢,大数据必须单独写查询总数ql
							int totalCount = 0;
							if (pageInfo.getPageHql() == null) {//pageInfo增加了自定义分页
								String pageJpql = JpqlUtil.deleteOuterOrderBy(jpql);
								Query pageQuery = getSession().createQuery(pageJpql);
								setQueryParamList(pageQuery, allParams);
								ScrollableResults scrollCursor = pageQuery.scroll(ScrollMode.SCROLL_SENSITIVE);
								scrollCursor.last();
								totalCount = Integer.valueOf(scrollCursor.getRowNumber() + 1);
							} else {//PageInfo有hql,使用自定义hql
								Query innPageQuery = getSession().createQuery(pageInfo.getPageHql());
								innPageQuery.setCacheable(true);//使用缓存
								setQueryParamList(innPageQuery, pageInfo.getPageParams());
								totalCount = Integer.valueOf(innPageQuery.uniqueResult() + "");
							}
							pageInfo.setAllRowNum(totalCount);

							// 只有大于0才分页
							if (pageInfo.getRowOfPage() > 0) {
								int startRowNo = 0;
								if (totalCount == 0) {
									pageInfo.setAllPageNum(0);
									pageInfo.setCurPageNum(0);
								} else {
									// 设置总页数
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
									//如果指定的页面没有数据，则检索第一页的数据 
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
