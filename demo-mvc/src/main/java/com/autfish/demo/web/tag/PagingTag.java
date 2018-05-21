package com.autfish.demo.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*
 * 自定义分页标签
 */
public class PagingTag extends SimpleTagSupport {

	private int pageIndex = 1;
	private int pageSize = 20;
	private int pageCount = 0;
	private int itemCount = 0;
	private int numCount = 10;
	
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		
		out.write("<script type=\"text/javascript\">function navigatorPage(pageIndex) {document.getElementById('pageIndex').value = pageIndex;document.forms[0].submit();}</script>");
		
		out.write("每页显示");
		out.write("<select id='pageSize' name='pageSize' onchange='navigatorPage(" + pageIndex + ")'>");
		out.write("<option value='5'" + (pageSize == 5 ? " selected='true'" : "") + ">5</option>");
		out.write("<option value='20'" + (pageSize == 20 ? " selected='true'" : "") + ">20</option>");
		out.write("<option value='50'" + (pageSize == 50 ? " selected='true'" : "") + ">50</option>");
		out.write("<option value='100'" + (pageSize == 100 ? " selected='true'" : "") + ">100</option>");
		out.write("<option value='500'" + (pageSize == 500 ? " selected='true'" : "") + ">500</option>");
		out.write("</select>");
		out.write("条&nbsp;&nbsp;&nbsp;&nbsp;");
		
		out.write(pageIndex + "/" + pageCount + "页&nbsp;&nbsp;&nbsp;&nbsp;");
		out.write("共" + itemCount + "条记录&nbsp;&nbsp;&nbsp;&nbsp;");
		
		out.write("<input type='button' value='第一页' onclick='javascript:navigatorPage(1);'" + (pageIndex > 1 ? "" : " disabled='true'") + " />&nbsp;&nbsp;");
		out.write("<input type='button' value='上一页' onclick='javascript:navigatorPage(" + (pageIndex - 1) + ");'" + (pageIndex > 1 ? "" : " disabled='true'") + " />&nbsp;&nbsp;");
		
		//数字导航栏
		int iStartIndex = 1;
		int iEndIndex = pageCount;
		if(pageCount <= numCount) {
		} else if ((pageIndex + (numCount + 1) / 2) > pageCount) {
			iStartIndex = pageCount - (numCount - 1);
			iEndIndex = pageCount;
        } else if (pageIndex <= (numCount + 1) / 2) {
        	iEndIndex = numCount;
        } else {
            if (numCount % 2 == 0) {
            	iStartIndex = pageIndex - numCount / 2;
            	iEndIndex = pageIndex + (numCount - 1) / 2;
            } else {
            	iStartIndex = pageIndex - numCount / 2;
            	iEndIndex = pageIndex + numCount / 2;
            }
        }
		for(int i = iStartIndex; i <= iEndIndex; i++) {
			if(i == pageIndex) {
				out.write(i + "&nbsp;&nbsp;");
			} else {
				out.write("<a href='javascript:navigatorPage(" + i + ");'>" + i + "</a>&nbsp;&nbsp;");
			}
		}
		
		out.write("<input type='button' value='下一页' onclick='javascript:navigatorPage(" + (pageIndex + 1) + ");'" + (pageIndex < pageCount ? "" : " disabled='true'") + " />&nbsp;&nbsp;");
		out.write("<input type='button' value='最后页' onclick='javascript:navigatorPage(" + pageCount + ");'" + (pageIndex < pageCount ? "" : " disabled='true'") + " />");
		out.write("<input type='hidden' id='pageIndex' name='pageIndex' value='" + pageIndex + "'/>");
	}
}
