package com.epam.employees.constants;

/**
 *
 * @author Nickolay_Petrash
 */
public final class DBQuery {

    private  DBQuery() {
    }
    
      public static final String EMPLOYEE_LIST = "SELECT e FROM Employee e ORDER BY e.id";
      public static final String EMPLOYEE_LIST_COUNT = "SELECT COUNT (e) FROM Employee e";
      public static final String FORMYLA = "(SELECT COUNT(*) FROM EMPLOYEES.WORK WHERE WORK.OFFICE_ID=ID)";
}
