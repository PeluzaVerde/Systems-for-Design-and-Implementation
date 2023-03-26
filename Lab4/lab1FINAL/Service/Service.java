package group.lab1FINAL.Service;

import java.util.List;

public interface Service<T> {
    List<Long> getAll();

    T save(T obj);

    T getById(Long id);

    T update(T obj);

    void delete(Long id);
}
