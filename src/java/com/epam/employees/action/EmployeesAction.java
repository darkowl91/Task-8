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
    private final static String EMPLOYEE = "list";

    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward showEmployees(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeesForm employeeForm = (EmployeesForm) form;

        int pageNumber = employeeForm.getPageNumber();
        int pageSize = employeeForm.getPageSize();

        long beginTime = System.currentTimeMillis();
        Page page = employeeDAO.getPage(pageNumber, pageSize);
        long endTime = System.currentTimeMillis();
        long time = endTime - beginTime;

        employeeForm.setTime(time);
        employeeForm.setTotalPages(page.getTotalPages());
        employeeForm.setEmployees(page.getContent());
        employeeForm.setTotalItems(page.getTotalNumberOfElements());

        return mapping.findForward(EMPLOYEE);
    }
}
