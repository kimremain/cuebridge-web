package com.jcuesoft.cuebridge.common.jdbc.nlsdateformat;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NlsDateFormatSqlSessionFactory extends DefaultSqlSessionFactory {
    
    /*private Logger logger = LoggerFactory.getLogger(this.getClass());*/
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public NlsDateFormatSqlSessionFactory(Configuration configuration) {
        super(configuration);
    }

    @Override
    public SqlSession openSession() {
        SqlSession session = super.openSession();
        alterSession(session);
        return session;
    }

    protected void alterSession(SqlSession session) {
        try {
            Statement statement = session.getConnection().createStatement();
            statement.addBatch("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS'");
            statement.addBatch("ALTER SESSION SET NLS_TIMESTAMP_FORMAT = 'YYYY-MM-DD HH24:MI:SSXFF'");
            // statement.addBatch("ALTER SESSION SET NLS_COMP = LINGUISTIC");
            statement.addBatch("ALTER SESSION SET NLS_SORT = KOREAN_M");
            statement.executeBatch();
            if(logger.isDebugEnabled()){
                logger.debug("Altered newly created session parameters.");
            }
            statement.close();
        } catch (SQLException e) {
            logger.error("Alter session failed!", e);
        }
    }

    @Override
    public SqlSession openSession(boolean autoCommit) {
        SqlSession session = super.openSession(autoCommit);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(Connection connection) {
        SqlSession session = super.openSession(connection);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(ExecutorType execType) {
        SqlSession session = super.openSession(execType);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
        SqlSession session = super.openSession(execType, autoCommit);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, Connection connection) {
        SqlSession session = super.openSession(execType, connection);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
        SqlSession session = super.openSession(execType, level);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(TransactionIsolationLevel level) {
        SqlSession session = super.openSession(level);
        alterSession(session);
        return session;
    }
}