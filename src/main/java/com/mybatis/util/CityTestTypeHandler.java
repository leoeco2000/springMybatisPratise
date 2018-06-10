package com.mybatis.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.mybatis.common.user.enumObject.CityTest;

public class CityTestTypeHandler extends BaseTypeHandler<CityTest> {
    @Override
    public CityTest getNullableResult(ResultSet rSet, String columnName)
            throws SQLException {
        return CityTest.Value2CityTest(rSet.getString(columnName));
    }

    @Override
    public CityTest getNullableResult(ResultSet rSet, int columnIndex)
            throws SQLException {
        return CityTest.Value2CityTest(rSet.getString(columnIndex));
    }

    @Override
    public CityTest getNullableResult(CallableStatement cStatement, int columnIndex)
            throws SQLException {
        return CityTest.Value2CityTest(cStatement.getString(columnIndex));
    }

    @Override
    public void setNonNullParameter(PreparedStatement pStatement, int index,
            CityTest citytest, JdbcType jdbcType) throws SQLException {
        pStatement.setString(index, citytest.getName());
    }
}