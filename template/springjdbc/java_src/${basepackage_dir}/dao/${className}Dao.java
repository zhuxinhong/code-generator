<#assign className = table.className>
package ${basepackage}.dao;

import ${commonpackage}.common.base.BaseDao;
import ${basepackage}.model.${className};

public interface ${className}Dao extends BaseDao<${className}, ${table.idColumn.simpleJavaType}>{

<#list table.columns as column>
    <#if column.unique && !column.pk>
    public ${className} findBy${column.columnName}(${column.simpleJavaType} v);
    </#if>
</#list>

}