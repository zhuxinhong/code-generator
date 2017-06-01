<#assign className = table.className>
package ${basepackage}.service;

import ${commonpackage}.common.base.BaseService;
import ${basepackage}.model.${className};

public interface ${className}Service extends BaseService<${className}, ${table.idColumn.javaType}>{

}