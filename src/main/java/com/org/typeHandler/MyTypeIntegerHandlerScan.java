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

@MappedTypes(Integer.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class MyTypeIntegerHandlerScan implements TypeHandler {
    Logger logger = Logger.getLogger(MyTypeIntegerHandlerScan.class);
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        logger.info("设置Integer参数1.2：" + parameter);
        ps.setInt(i, (Integer) parameter);
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        Integer result = rs.getInt(columnName);
        logger.info("设置Integer参数1.2：" + result);
        return result;
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer result = rs.getInt(columnIndex);
        logger.info("设置Integer参数2.2：" + result);
        return result;
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer result = cs.getInt(columnIndex);
        logger.info("设置String参数3.2：" + result);
        return result;
    }
}
