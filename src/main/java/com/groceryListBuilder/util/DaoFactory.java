package com.groceryListBuilder.util;

import com.groceryListBuilder.persistence.GenericDao;

public class DaoFactory {

    public DaoFactory() {
    }

    public static GenericDao createDao(Class type) {
        return new GenericDao(type);
    }
}
