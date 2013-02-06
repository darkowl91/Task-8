package com.epam.employees.constants;

/**
 *
 * @author Nickolay_Petrash
 */
public final class DBQuery {

    private DBQuery() {
    }
    public static final String EMPLOYEE_LIST = "SELECT e FROM Employee e ORDER BY e.id";
    public static final String EMPLOYEE_LIST_COUNT = "SELECT COUNT (e) FROM Employee e";
    public static final String EMPLOYEE_COUNT = "SELECT COUNT(*) FROM EMPLOYEES.EMPLOYEE";
    public static final String FORMYLA = "(SELECT COUNT(*) FROM EMPLOYEES.WORK WHERE WORK.OFFICE_ID=ID)";
    public static final String SELECT_EMPLOYEES = "select "
            + "work.ID as IDWORK, office.ID as IDOFFICE,"
            + "office_address.ID as OFF_IDADDRESS, office_address.STREET as OFF_STREET,"
            + "office_address.BUILDING as OFF_BUILDING, office_address.ROOM as OFF_ROOM,"
            + "office_city.ID as OFF_IDCITY, office_city.TITLE as OFF_CITY_TITLE,"
            + "office_country.ID as OFF_IDCOUNTRY, office_country.TITLE as OFF_COUNTRY_TITLE,"
            + "(select count(*) from EMPLOYEES.WORK w where w.OFFICE_ID=office.ID) as COUNT,"
            + "address.ID as EMPL_IDADDRESS, address.STREET as EMPL_STREET,"
            + "address.BUILDING as EMPL_BUILDING, address.ROOM as EMPL_ROOM,"
            + "city.ID as EMPL_IDCITY, city.TITLE as EMPL_CITY_TITLE,"
            + "country.ID as EMPL_IDCOUNTRY, country.TITLE as EMPL_COUNTRY_TITLE,"
            + "company.ID as IDCOMPANY, company.TITLE as COMPANY_TITLE,"
            + "position.ID as IDPOSITION, position.TITLE as POSITION_TITLE,"
            + "employee.ID as IDEMPLOYEE, employee.FIRSTNAME as FIRSTNAME, employee.LASTNAME as LASTNAME "
            + "from EMPLOYEES.EMPLOYEE employee "
            + "left outer join EMPLOYEES.ADDRESS address on employee.ID=address.ID "
            + "left outer join EMPLOYEES.CITY city on address.CITY_ID=city.ID "
            + "left outer join EMPLOYEES.COUNTRY country on city.COUNTRY_ID=country.ID "
            + "left outer join EMPLOYEES.WORK work on employee.ID=work.EMPLOYEE_ID "
            + "left outer join EMPLOYEES.OFFICE office on work.OFFICE_ID=office.ID "
            + "left outer join EMPLOYEES.ADDRESS office_address on office.ADDRESS_ID=office_address.ID "
            + "left outer join EMPLOYEES.CITY office_city on office_address.CITY_ID=office_city.ID "
            + "left outer join EMPLOYEES.COUNTRY office_country on office_city.COUNTRY_ID=office_country.ID "
            + "left outer join EMPLOYEES.COMPANY company on office.COMPANY_ID=company.ID "
            + "left outer join EMPLOYEES.POSITION position on work.POSITION_ID=position.ID "
            + "where employee.ID in (select id_e from ( select row_.e_id id_e, rownum rownum_ "
            + "from ( select e.ID e_id, ROW_NUMBER() OVER(order by e.ID) rn from EMPLOYEES.EMPLOYEE e)"
            + "row_ where rn <= (?)) where rownum_ >= (?)) order by employee.ID asc";
}
