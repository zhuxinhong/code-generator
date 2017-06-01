//package base;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.Serializable;
//
//
///**
// * Created by zhuxh on 16/7/26.
// */
//@Repository
//public abstract class BaseSpringJdbcDao<T, ID extends Serializable> {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    public abstract String getIdentifierPropertyName();
//
//    protected void insertWithIdentity(T t, String insertSql) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        getNamedParameterJdbcTemplate().update(insertSql,
//                new BeanPropertySqlParameterSource(t), keyHolder);
//        setIdentifierProperty(t, keyHolder.getKey().longValue());
//    }
//
//    public void setIdentifierProperty(Object entity, Object id) {
//        try {
//            BeanUtils.setProperty(entity, getIdentifierPropertyName(), id);
//        } catch (Exception e) {
//            throw new IllegalStateException("cannot set property value:" + id
//                    + " on entityClass:" + entity.getClass()
//                    + " by propertyName:" + getIdentifierPropertyName(), e);
//        }
//    }
//
//    protected JdbcTemplate getJdbcTemplate() {
//        return this.jdbcTemplate;
//    }
//
//    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
//        return namedParameterJdbcTemplate;
//    }
//}
