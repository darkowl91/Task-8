package com.epam.employees.pagination.page;

/**
 *
 * @author Nickolay_Petrash A page request is quite basic and allows client to
 * Abstract interface for pagination information.
 *
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
    int getpageSize();
}
