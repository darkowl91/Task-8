/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.form;

import com.epam.employees.model.Employee;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Owl
 */
public final class EmployeesForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private int pageNumber = 1;
    private int pageSize = 10;
    private int totalPages;
    private long totalItems;
    private List<Employee> employees;
    private long time;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        if (pageNumber > totalPages) {
            this.pageNumber = totalPages;
        } else {
            this.pageNumber = pageNumber;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > totalItems) {
            this.pageSize = (int)totalItems;
        } else {
            this.pageSize = pageSize;
        }
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
    
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.pageNumber = 1;
        this.pageSize = 10;
        super.reset(mapping, request);
    }
}