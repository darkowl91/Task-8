/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.action;

import com.epam.employees.dao.IEmployeeDAO;
import com.epam.employees.form.EmployeesForm;
import com.epam.employees.model.Employee;
import java.util.List;
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

    private IEmployeeDAO employeeDAO;

    public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    /* forward name="success" path="" */
    private final static String EMPLOYEESLIST = "list";

    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward showEmployees(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeesForm employeeForm = (EmployeesForm) form;
        long beginTime = System.currentTimeMillis();
        List<Employee> employeesList = (List<Employee>) employeeDAO.getRecords(1, 100);
        long endTime = System.currentTimeMillis();
        long time = endTime - beginTime;
        employeeForm.setTime(time);
        employeeForm.setEmployees(employeesList);
        return mapping.findForward(EMPLOYEESLIST);
    }
}
