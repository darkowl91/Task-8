package com.epam.employees.pagination.page;

/**
 *
 * @author Nickolay_Petrash
 */
public interface PageRequest {

    /**
     * Returns the page to be returned.
     *
     * @return the page to be returned.
     */
    int getPageNumber();

    /**
     * Returns the number of items to be returned.
     *
     * @return the number of items of that page.
     */
    int getPageSize();
}
