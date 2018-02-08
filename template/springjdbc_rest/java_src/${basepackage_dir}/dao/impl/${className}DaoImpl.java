<#assign className = table.className>
package ${basepackage}.dao.impl;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.model.${className};
import ${basepackage}.repository.BaseSpringJdbcDao;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ${className}DaoImpl extends BaseSpringJdbcDao<${className},${table.idColumn.javaType}> implements ${className}Dao {

    public Class getEntityClass() {
        return ${className}.class;
    }

    public String getIdentifierPropertyName() {
    <#if table.singleId>
        return "${table.idColumn.columnNameLower}";
    <#else>
        return null;
    </#if>
    }

    public String getSelectPrefix() {
        return "select  "
                <#list table.columns as column>
                + " ${column.sqlName} as ${column.columnNameFirstLower}<#if column_has_next>,</#if>"
                </#list>
                + " from ${table.sqlName} ";
    }

    public String getFindByIdSql() {
        return getSelectPrefix() + " where ${table.idColumn.sqlName} = ?";
    }

    public String getDeleteByIdSql() {
        return "delete from ${table.sqlName} where ${table.idColumn.sqlName} = ?";
    }

    @Override
    public ${className} save(${className} entity) {
        String sql = "insert into ${table.sqlName} "
        + " (<#list table.columns as column>${column.sqlName}<#if column_has_next>,</#if></#list>) "
        + " values "
        + " (<#list table.columns as column>:${column.columnNameLower}<#if column_has_next>,</#if></#list>)";
        insertWithIdentity(entity, sql);
        return entity;
    }

    @Override
    public int update(${className} entity) {
        String sql = "update ${table.sqlName} set "
        + " <#list table.columns as column>${column.sqlName}=:${column.columnNameLower}<#if column_has_next>,</#if></#list> "
        + " where ${table.idColumn.sqlName}=:${table.idColumn.columnNameLower}";
        return getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
    }

    @Override
    public ${className} findOne(${table.idColumn.javaType} ${table.idColumn.columnNameLower}) {
        List<${className}> result = getJdbcTemplate().query(getFindByIdSql(), new Object[]{${table.idColumn.columnNameLower}}, new BeanPropertyRowMapper(getEntityClass()));
        return DataAccessUtils.singleResult(result);
    }

    @Override
    public void delete(${table.idColumn.javaType} ${table.idColumn.columnNameLower}) {
        getJdbcTemplate().update(getDeleteByIdSql(), ${table.idColumn.columnNameLower});
    }
}