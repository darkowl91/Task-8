/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.form;

import com.epam.employees.pagination.page.Page;
import com.epam.employees.pagination.page.PageRequest;
import com.epam.employees.pagination.page.PageRequestImpl;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Owl
 */
public final class EmployeesForm extends ActionForm {
    private static final long serialVersionUID = 1L;
    private PageRequest pageRequest = new PageRequestImpl();
    private Page page;

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}