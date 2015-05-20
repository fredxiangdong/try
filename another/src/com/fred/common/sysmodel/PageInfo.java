package com.fred.common.sysmodel;

import java.io.Serializable;

public class PageInfo  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private int curPageNum = 1;
  private int allPageNum;
  private int rowOfPage;
  private int allRowNum;

  public int getAllPageNum()
  {
    return this.allPageNum;
  }

  public void setAllPageNum(int allPageNum)
  {
    this.allPageNum = allPageNum;
  }

  public int getAllRowNum()
  {
    return this.allRowNum;
  }

  public void setAllRowNum(int allRowNum)
  {
    this.allRowNum = allRowNum;
    if (this.rowOfPage > 0)
      if (allRowNum % this.rowOfPage == 0)
        this.allPageNum = (allRowNum / this.rowOfPage);
      else
        this.allPageNum = (allRowNum / this.rowOfPage + 1);
  }

  public int getCurPageNum()
  {
    return this.curPageNum;
  }

  public void setCurPageNum(int curPageNum)
  {
    this.curPageNum = curPageNum;
  }

  public int getRowOfPage()
  {
    return this.rowOfPage;
  }

  public void setRowOfPage(int rowOfPage)
  {
    this.rowOfPage = rowOfPage;
  }

  public String toString()
  {
    StringBuffer buffer = new StringBuffer();
    buffer.append("curPageNum=" + this.curPageNum).append("\r\n");
    buffer.append("allPageNum=" + this.allPageNum).append("\r\n");
    buffer.append("rowOfPage=" + this.rowOfPage).append("\r\n");
    buffer.append("allRowNum=" + this.allRowNum).append("\r\n");
    return buffer.toString();
  }
}