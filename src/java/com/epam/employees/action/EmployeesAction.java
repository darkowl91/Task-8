/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.action;

import com.epam.employees.dao.PersistentEntityDAO;
import com.epam.employees.form.EmployeesForm;
import com.epam.employees.pagination.page.Page;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

/**
 *
 * @author Owl
 */
public final class EmployeesAction extends MappingDispatchAction {

    private PersistentEntityDAO employeeDAO;

    public void setEmployeeDAO(PersistentEntityDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    /* forward name="success" path="" */
    private final static String EMPLOYEESLIST = "employeeList";

    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward showEmployees(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeesForm employeeForm = (EmployeesForm) form;
        Page page = employeeDAO.findByNamedQuery(employeeForm.getPageRequest(), EMPLOYEESLIST);
        employeeForm.setPage(page);


        return mapping.findForward(EMPLOYEESLIST);
    }
}
