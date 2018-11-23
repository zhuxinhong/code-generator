<#assign className = table.className>
package ${basepackage}.dao;

import ${commonpackage}.common.base.BaseDao;
import ${basepackage}.model.${className};

public interface ${className}Dao extends BaseDao<${className}, ${table.idColumn.javaType}>{

<#list table.columns as column>
    <#if column.unique && !column.pk>
    public ${className} findBy${column.columnName}(${column.javaType} v);
    </#if>
</#list>

}