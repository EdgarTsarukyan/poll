package manager;

import java.util.List;

public interface Manager<T, E> {

    List<T> findAll();

    T findById(E id);

}
