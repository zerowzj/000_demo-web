package com.company.project.common.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 基础标签
 *
 * @author wangzhj
 */
public abstract class BaseTag extends TagSupport {

    private PageContext pageContext;

    public void write(String msg) {
        try {
            pageContext.getOut().write(msg);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public HttpServletRequest getHttpServletRequest(){
        return (HttpServletRequest)pageContext.getRequest();
    }

    public HttpServletResponse getHttpServletResponse(){
        return (HttpServletResponse)pageContext.getResponse();
    }

    public HttpSession getHttpSession(){
        return pageContext.getSession();
    }

    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }
}
