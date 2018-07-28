package com.org.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyTypeStringHandlerScan implements TypeHandler {
    Logger logger = Logger.getLogger(MyTypeStringHandlerScan.class);
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        logger.info("设置String参数1.1：" + parameter);
        ps.setString(i, (String) parameter);
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        logger.info("设置String参数1.2：" + result);
        return result;
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        logger.info("设置String参数2.2：" + result);
        return result;
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        logger.info("设置String参数3.2：" + result);
        return result;
    }
}
