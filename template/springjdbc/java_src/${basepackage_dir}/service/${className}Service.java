<#assign className = table.className>
package ${basepackage}.service;

import ${commonpackage}.common.base.BaseService;
import ${basepackage}.model.${className};

public interface ${className}Service extends BaseService<${className}, ${table.idColumn.simpleJavaType}>{

<#list table.columns as column>
  <#if column.unique && !column.pk>
  public ${className} findBy${column.columnName}(${column.simpleJavaType} v);
  </#if>
</#list>
}