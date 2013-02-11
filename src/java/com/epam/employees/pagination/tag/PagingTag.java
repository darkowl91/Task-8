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
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Nickolay_Petrash
 */
public class PagingTag extends TagSupport {

    private static final long serialVersionUID = 5492589500127835257L;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private String action;

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            printForm(out);
        } catch (IOException ex) {
            Logger.getLogger(PagingTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SKIP_BODY;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    private void printForm(JspWriter out) throws IOException {
        out.write("<form style=\"navbar-form pull-right\" action=\"" + action + "\"onsubmit=\"return validatePagingForm(this);\">");
        out.write("<span class=\"help-inline\">");
        out.write("Size");
        out.write("</span>");
        out.write("<input type=\"text\" style=\" span2\" name=\"employeesOnPage\" size=\"3\" value=\"" + pageSize + "\" />");
        out.write("<span class=\"help-inline\">");
        out.write("Page");
        out.write("</span>");
        out.write("<input type=\"text\" style=\" span2\" name=\"page\" size=\"3\" value=\"" + pageNumber + "\" />");
        out.write("<span class=\"help-inline\">");
        out.write("of " + totalPages);
        out.write("</span>");
        out.write("<input type=\"submit\" class=\"btn\" value=\"GO!\"/>");
        out.write("</form>");
    }
//<html:form action="/EmployeeList" styleClass="navbar-form pull-right">
//<html:hidden property="method" value="EmployeeList.do" />
//<span class="help-inline">
//<bean:message key="header.size"/>
//</span>
//<nested:text name="EmployeesForm" property="pageSize" styleClass="span2"/>
//<span class="help-inline">
//<nested:message key="header.page"/>
//</span>
//<nested:text name="EmployeesForm" property="pageNumber" styleClass="span2"/>
//<span class="help-inline">
//<bean:message key="header.of"/>
//${EmployeesForm.totalPages}
//</span>
//<input type="submit" value="GO!" class="btn" />
//</html:form>
}
