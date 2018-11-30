<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
package ${basepackage}.controller;

import ${basepackage}.service.${className}Service;
import ${basepackage}.model.${className};
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("${classNameFirstLower}")
public class ${className}Controller {

    private static final String LIST_ACTION = "redirect:/${classNameFirstLower}/list";

    @Resource
    private ${className}Service ${classNameFirstLower}Service;

    @GetMapping("list")
    public ModelAndView list(@PageableDefault(page = 1) Pageable pageable, ${className} ${classNameFirstLower}){
        Page<${className}> page = ${classNameFirstLower}Service.page(pageable, ${classNameFirstLower});
        return new ModelAndView("${classNameFirstLower}/list", "page", page);
    }

    @GetMapping("add")
    public ModelAndView add(${className} ${classNameFirstLower}) {
        return new ModelAndView("${classNameFirstLower}/add", "${classNameFirstLower}", ${classNameFirstLower});
    }

    @PostMapping("save")
    public ModelAndView save(${className} ${classNameFirstLower}, HttpServletRequest request){
        ${classNameFirstLower}Service.save(${classNameFirstLower});
        return new ModelAndView(LIST_ACTION);
    }

    @GetMapping("edit")
    public ModelAndView edit(HttpServletRequest request){
        <@generateIdParameter/>
        ${className} ${classNameFirstLower} = ${classNameFirstLower}Service.findOne(id);
        ${classNameFirstLower}Service.update(${classNameFirstLower});
        return new ModelAndView("${classNameFirstLower}/edit}", "${classNameFirstLower}", ${classNameFirstLower});
    }

    @PostMapping("update")
    public ModelAndView update(HttpServletRequest request, ${className} ${classNameFirstLower}){
        ${classNameFirstLower}Service.update(${classNameFirstLower});
        return new ModelAndView(LIST_ACTION);
    }

    @GetMapping("delete")
    public ModelAndView delete(HttpServletRequest request) {
        <@generateIdParameter/>
        ${classNameFirstLower}Service.delete(id);
        return new ModelAndView(LIST_ACTION);
    }

}

<#macro generateIdParameter>
<#if table.compositeId>
    ${className}Id id = new ${className}Id();
    bind(request, id);
<#else>
<#list table.compositeIdColumns as column>
        ${column.simpleJavaType} id = new ${column.simpleJavaType}(request.getParameter("${column.columnNameLower}"));
</#list>
</#if>
</#macro>