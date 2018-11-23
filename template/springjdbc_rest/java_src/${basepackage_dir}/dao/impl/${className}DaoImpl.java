<#assign className = table.className>
package ${basepackage}.dao.impl;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.model.${className};
import ${basepackage}.repository.BaseSpringJdbcDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ${className}DaoImpl extends BaseSpringJdbcDao<${className}, ${table.idColumn.javaType}> implements ${className}Dao {

    @Override
    public Class getEntityClass() {
        return ${className}.class;
    }

    @Override
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

    @Override
    public String getFindByIdSql() {
        return getSelectPrefix() + " where ${table.idColumn.sqlName} = ?";
    }

    @Override
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

    @Override
    public Page<${className}> page(Pageable pageable, ${className} entity) {
        String sql = getSelectPrefix() + "where 1=1 "
        <#list table.columns as column>
            + " /~ and ${column.sqlName} = '[${column.columnNameLower}]' ~/ "
        </#list>
            + "/~ order by '[sortColumns]' ~/";
        return pageQuery(sql, pageable, new BeanPropertyRowMapper(getEntityClass()),
        entity);
    }

  <#list table.columns as column>
    <#if column.unique && !column.pk>
    @Override
    public ${className} findBy${column.columnName}(${column.javaType} v) {
        String sql =  getSelectPrefix() + " where ${column.columnNameLower} = ?";
        List<${className}> list = getJdbcTemplate().query(sql, new Object[]{v}, new BeanPropertyRowMapper(getEntityClass()));
        return DataAccessUtils.singleResult(list);
    }
    </#if>
  </#list>
}