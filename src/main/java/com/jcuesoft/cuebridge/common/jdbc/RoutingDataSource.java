package com.jcuesoft.cuebridge.common.jdbc;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return ContextHolder.getDataSourceType();
    }
}