<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.controller;

import ${basepackage}.service.${className}Service;
import ${basepackage}.model.${className};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("${classNameLowerCase}")
public class ${className}Controller {

    @Autowired
    private ${className}Service ${classNameLowerCase}Service;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ${className} create(@RequestBody ${className} ${classNameFirstLower}, HttpServletRequest request) {
        return ${classNameLowerCase}Service.save(${classNameFirstLower});
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ${className} ${classNameFirstLower}(@PathVariable Integer id) {
        return ${classNameLowerCase}Service.findOne(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id, HttpServletRequest request) {
        ${classNameLowerCase}Service.delete(id);
    }

}