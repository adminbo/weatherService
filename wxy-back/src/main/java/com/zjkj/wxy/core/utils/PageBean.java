package com.zjkj.wxy.core.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 封装分页信息
 * 
 * @author
 */
public class PageBean<E> {
	private int currentPage = 1;//当前页码
	private int pageSize = 10;//每页显示记录数
	private DetachedCriteria detachedCriteria;//分页查询条件

	private int total;//总记录数
	private List<E> rows;//当前页展示的数据集合

	private String formId;
	private String ctxPath;

	public PageBean() {
	}

	public PageBean(HttpServletRequest request) {
		this(null, request);
	}

	public PageBean(String formId, HttpServletRequest request) {
		this.formId = formId;
		this.ctxPath = request.getContextPath();
		//System.out.println(ctxPath);
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		if (currentPage == null || "".equals(currentPage.trim()) || Integer.parseInt(currentPage) <= 0) {
			this.currentPage = 1;
		} else {
			this.currentPage = Integer.parseInt(currentPage);
		}
		if (pageSize == null || "".equals(pageSize)) {
			this.pageSize = 10;
		} else {
			this.pageSize = Integer.parseInt(pageSize);
		}
		@SuppressWarnings("unchecked")
		Map<String, String[]> params = request.getParameterMap();
		for (Map.Entry<String, String[]> env : params.entrySet()) {
			request.setAttribute(env.getKey(), env.getValue() != null && env.getValue().length > 0 ? env.getValue()[0] : "");
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}

	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}

	public List<E> getRows() {
		return rows;
	}

	public void setRows(List<E> rows) {
		this.rows = rows;
	}

	public String getPageHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<div class=\"bar\">");
		sb.append("<div class=\"barcon\">");
		sb.append("<select id=\"pageSize\">");
		sb.append("<option value=\"10\" " + (this.pageSize == 10 ? "selected" : "") + ">显示10条</option>");
		sb.append("<option value=\"20\"" + (this.pageSize == 20 ? "selected" : "") + ">显示20条</option>");
		sb.append("<option value=\"30\"" + (this.pageSize == 30 ? "selected" : "") + ">显示30条</option></select>");
		sb.append("<div class=\"page\">");
		sb.append("<a href=\"javascript:void(0)\" id=\"first\" class=\"first\"><img onclick=\"page(1," + this.pageSize + ")\" src=\"" + this.ctxPath + "/images/first.jpg\" /></a>");
		sb.append("<a href=\"javascript:void(0)\" id=\"up\" class=\"up\"><img onclick=\"page(" + (this.currentPage - 1) + "," + this.pageSize + ")\" src=\"" + this.ctxPath + "/images/up.jpg\" /></a>");
		int totalPage = this.total % this.pageSize == 0 ? this.total / this.pageSize : (this.total / this.pageSize) + 1;
		sb.append("<span>第").append("<input id=\"currentPage\" value=\"" + this.currentPage + "\" />").append("页 共" + totalPage + "页</span>");
		sb.append("<a href=\"javascript:void(0)\" id=\"down\" class=\"down\"><img onclick=\"page(" + (this.currentPage + 1) + "," + this.pageSize + ")\" src=\"" + this.ctxPath + "/images/down.jpg\" /></a>");
		sb.append("<a href=\"javascript:void(0)\" id=\"last\" class=\"last\"><img onclick=\"page(" + totalPage + "," + this.pageSize + ")\" src=\"" + this.ctxPath + "/images/last.jpg\" /></a>");
		sb.append("</div>");
		sb.append("<a href=\"javascript:void(0)\" class=\"reload\">").append("<img onclick=\"page(" + this.currentPage + "," + this.pageSize + ")\" src=\"" + this.ctxPath + "/images/reload.jpg\"></a>");
		sb.append("<p>共" + this.total + "条记录</p>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<script>");
		if (this.formId == null) {
			sb.append("var form=$(\"form\");");
		} else {
			sb.append("var form=$(\"#" + this.formId + "\");");
		}
		sb.append("form.append('<input type=\"hidden\"  id=\"formCurrentPage\" name=\"currentPage\" value=\"" + this.currentPage + "\"/>');form.append('<input type=\"hidden\" id=\"formPageSize\" name=\"pageSize\" value=\"" + this.pageSize + "\"/>');");
		sb.append("function page(currentPage,pageSize){ if(currentPage>0&&currentPage<=" + totalPage + "){cp=form.find(\"#formCurrentPage\");ps=form.find(\"#formPageSize\");cp.val(currentPage);ps.val(pageSize);form.submit()}}");
		sb.append("$(\"#pageSize\").change(function(){ var ps=$(this).val();var cp=$(\"#currentPage\").val();page(cp,ps)});");
		sb.append("$(\"#currentPage\").keydown(function(event){if(event.keyCode==13){var cp=$(this).val();var ps=$(\"#pageSize\").val();if((cp-0)>" + totalPage + "){cp=" + totalPage + "}page(cp,ps)}});");
		sb.append("</script>");
		return sb.toString();
	}
}
