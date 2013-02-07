/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.pagination.tag;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Nickolay_Petrash
 */
public class PagingTag extends TagSupport {

    private static final long serialVersionUID = 1L;
    PageContext context;

    @Override
    public void setPageContext(PageContext context) {
        this.context = context;
    }

    @Override
    public void setParent(Tag parent) {
    }

    @Override
    public Tag getParent() {
        return null;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        writePagingForm(out);
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    }
    
    private void writePagingForm(JspWriter out) {
        
        
    }
}
