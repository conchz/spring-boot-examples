package com.github.dolphineor.springboot.model.dialect;

import org.hibernate.dialect.MySQL57InnoDBDialect;

/**
 * Created on 2016-01-06.
 *
 * @author dolphineor
 */
public class CustomMySQLDialect extends MySQL57InnoDBDialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
