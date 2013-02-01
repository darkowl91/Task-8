/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.form;

import com.epam.employees.model.Employee;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.pagination.page.PageRequest;
import com.epam.employees.pagination.page.PageRequestImpl;
import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Owl
 */
public final class EmployeesForm extends ActionForm {
    private static final long serialVersionUID = 1L;
    private List<Employee> employees;
    private PageRequest pageRequest = new PageRequestImpl(1,10);
    private Page page;

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
