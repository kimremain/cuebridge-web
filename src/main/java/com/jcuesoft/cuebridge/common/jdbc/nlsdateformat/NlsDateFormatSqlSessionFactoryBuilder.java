package com.jcuesoft.cuebridge.common.jdbc.nlsdateformat;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NlsDateFormatSqlSessionFactoryBuilder extends SqlSessionFactoryBuilder{
    @Override
    public SqlSessionFactory build(Configuration config)
    {
        return new NlsDateFormatSqlSessionFactory(config);
    }
}
