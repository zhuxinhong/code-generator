package base;

import java.io.Serializable;

/**
 * Created by zhuxh on 17/5/31.
 */
public interface BaseDao<T, ID extends Serializable> {

    T save(T t);

    int update(T t);

    T findOne(ID id);

    void delete(ID id);

}
