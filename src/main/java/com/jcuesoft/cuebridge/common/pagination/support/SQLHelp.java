/*
 * Copyright (c) 2012-2013, Poplar Yfyang 杨友峰 (poplar1123@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jcuesoft.cuebridge.common.pagination.support;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcuesoft.cuebridge.common.jdbc.ContextHolder;
import com.jcuesoft.cuebridge.common.jdbc.DataSourceType;
import com.jcuesoft.cuebridge.common.pagination.DefaultParameterHandler;

/**
 *
 * @author poplar.yfyang
 * @author miemiedev
 */
public class SQLHelp {
    /*private static Logger logger = LoggerFactory.getLogger(SQLHelp.class);*/
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * 查询总纪录数
     *
     * @param mappedStatement mapped
     * @param parameterObject 参数
     * @param boundSql        boundSql
     * @param dialect         database dialect
     * @param cdCompnay 
     * @return 总记录数
     * @throws java.sql.SQLException sql查询错误
     */
    public static int getCount(
                               final MappedStatement mappedStatement, final Object parameterObject,
                               final BoundSql boundSql, Dialect dialect, String cdCompnay) throws SQLException {
        final String count_sql = dialect.getCountSQL();
        logger.debug("Total count SQL [{}] ", count_sql);
        logger.debug("Total count Parameters: {} ", parameterObject);
        
        //ContextHolder.clearDataSourceType();
        if(cdCompnay.equals("Y")){            
            ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_YOUI);            
        }else if(cdCompnay.equals("S")){
            ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_STAR);
        }else if(cdCompnay.equals("M")){
            ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_MILL);
        }

        Connection connection = null;
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
            countStmt = connection.prepareStatement(count_sql);
            DefaultParameterHandler handler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
            handler.setParameters(countStmt);

            rs = countStmt.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            logger.debug("Total count: {}", count);
            return count;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } finally {
                try {
                    if (countStmt != null) {
                        countStmt.close();
                    }
                } finally {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                }
            }
        }
    }

    public static List<?> getList(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) throws SQLException {
        Connection connection = null;
        PreparedStatement listStmt = null;
        ResultSet rs = null;
        
        List<?> list = null;
        try {      
            connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
            String list_sql = mappedStatement.getBoundSql(parameterObject).getSql();
            
            logger.debug("list_sql:"+list_sql);
            
            listStmt = connection.prepareStatement(list_sql);
            DefaultParameterHandler handler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
            handler.setParameters(listStmt);
//
            rs = listStmt.executeQuery();
//            List<?> list = new ArrayList();
            
            if(null != rs){
                
                while(rs.next()){
                    logger.debug((String) rs.getObject(1).toString());
                }
            }
            
            logger.debug("getList: {}", rs);
            return list;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } finally {
                try {
                    if (listStmt != null) {
                        listStmt.close();
                    }
                } finally {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                }
            }
        }
    }

}