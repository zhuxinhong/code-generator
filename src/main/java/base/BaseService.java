package base;

import java.io.Serializable;

/**
 * Created by zhuxh on 16/11/30.
 */
public interface BaseService<T, ID extends Serializable>{

    T save(T t);

    int update(T t);

    T findOne(ID id);

    void delete(ID id);

}
