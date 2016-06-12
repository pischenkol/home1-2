package DAO;

import java.util.Objects;

/**
 * Created by appleface on 12.06.16.
 */
public interface Dao<T> {
    public boolean save(T objects);
    public boolean update(T objects);
    public boolean delete(T id);
    public T getById(int id);

}
