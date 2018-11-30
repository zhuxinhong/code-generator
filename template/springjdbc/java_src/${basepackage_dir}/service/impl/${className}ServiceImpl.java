<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.service.impl;

import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.service.${className}Service;
import ${basepackage}.model.${className};

@Service
public class ${className}ServiceImpl implements ${className}Service {

    @Resource
    private ${className}Dao ${classNameFirstLower}Dao;

    @Override
    public ${className} save(${className} ${classNameFirstLower}) {
        return ${classNameFirstLower}Dao.save(${classNameFirstLower});
    }

    @Override
    public int update(${className} ${classNameFirstLower}) {
        return ${classNameFirstLower}Dao.update(${classNameFirstLower});
    }

    @Override
    public ${className} findOne(${table.idColumn.simpleJavaType} ${table.idColumn.columnNameLower}) {
        return ${classNameFirstLower}Dao.findOne(id);
    }

    @Override
    public void delete(${table.idColumn.simpleJavaType} ${table.idColumn.columnNameLower}) {
        ${classNameFirstLower}Dao.delete(${table.idColumn.columnNameLower});
    }

    @Override
    public Page page(Pageable pageable, ${className} ${classNameFirstLower}){
        return ${classNameFirstLower}Dao.page(pageable, ${classNameFirstLower});
    }
<#list table.columns as column>
    <#if column.unique && !column.pk>
    @Override
    public ${className} findBy${column.columnName}(${column.simpleJavaType} v){
        return ${classNameFirstLower}Dao.findBy${column.columnName}(v);
    }
    </#if>
</#list>

}