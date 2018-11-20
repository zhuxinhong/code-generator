<#assign className = table.className>
package ${basepackage}.repository;

import ${basepackage}.model.${className};
import org.springframework.data.jpa.repository.JpaRepository;

public interface ${className}Repository extends JpaRepository<${className}, ${table.idColumn.javaType}>{

}