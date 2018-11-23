<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.model;

@Entity
@Table(name = "")
public class ${className} implements java.io.Serializable{

	<@generateFields/>
	<@generateSetterGetter/>

}

<#macro generateFields>
	<#list table.columns as column>
	private ${column.javaType} ${column.columnNameLower};

	</#list>
</#macro>


<#macro generateSetterGetter>
	<#list table.columns as column>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}

	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}

	</#list>
</#macro>