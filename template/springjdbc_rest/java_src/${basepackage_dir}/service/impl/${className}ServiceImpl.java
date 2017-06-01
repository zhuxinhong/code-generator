<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.service.${className}Service;
import ${basepackage}.model.${className};

@Service
public class ${className}ServiceImpl implements ${className}Service {

    @Autowired
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
    public ${className} findOne(${table.idColumn.javaType} ${table.idColumn.columnNameLower}) {
        return ${classNameFirstLower}Dao.findOne(id);
    }

    @Override
    public void delete(${table.idColumn.javaType} ${table.idColumn.columnNameLower}) {
        ${classNameFirstLower}Dao.delete(${table.idColumn.columnNameLower});
    }

}