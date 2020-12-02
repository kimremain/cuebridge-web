package com.jcuesoft.cuebridge.common.pagination.support;

import java.lang.invoke.MethodHandles;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringTypeHandler extends BaseTypeHandler {
    
    /*private static Logger logger = LoggerFactory.getLogger(StringTypeHandler.class);*/
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        
        if(logger.isDebugEnabled()){
          logger.debug("@@ parameter:"+parameter);
        }
        ps.setString(i, ((String) parameter));
    }

    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getString(columnName);
    }

    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getString(columnIndex);
    }

    @Override
    public Object getNullableResult(ResultSet paramResultSet, int paramInt) throws SQLException {
        return paramResultSet.getString(paramInt);
    }

}