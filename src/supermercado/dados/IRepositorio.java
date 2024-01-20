package supermercado.dados;

import java.util.List;

public interface IRepositorio<N> {

    N[] getAll();

    N[] getOne();

    N[] find();

    void add();

    void update();

    void delete();

}
