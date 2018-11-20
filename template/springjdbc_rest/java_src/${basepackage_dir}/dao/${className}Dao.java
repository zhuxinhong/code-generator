<#assign className = table.className>
    package ${basepackage}.dao;

    import ${commonpackage}.common.base.BaseDao;
    import org.springframework.stereotype.Repository;
    import ${basepackage}.model.${className};

@Repository
public interface ${className}Dao extends BaseDao<${className}, ${table.idColumn.javaType}>{

}