package supermercado.dados;

import java.util.List;

public interface IRepositorio<N> {

    List<N> getAll();

    N getOne();

    List<N> find();

    void add();

    void update();

    void delete();

}
