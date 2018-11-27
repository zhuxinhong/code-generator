<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.model;

import java.sql.Timestamp;

public class ${className} implements java.io.Serializable{

	public static final String TABLE_ALIAS = "${table.tableAlias}";

	<#list table.columns as column>
	public static final String ALIAS_${column.constantName} = "${column.columnAlias}";
	</#list>

	<@generateFields/>
	<@generateSetterGetter/>

}

<#macro generateFields>
	<#list table.columns as column>
	private ${column.simpleJavaType} ${column.columnNameLower};

	</#list>
</#macro>


<#macro generateSetterGetter>
	<#list table.columns as column>
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}

	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}

	</#list>
</#macro>