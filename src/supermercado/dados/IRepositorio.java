package supermercado.dados;

import java.util.List;

public interface IRepositorio<N> {

    N[] getAll();

    N getOne(int codigo);

    void add(N instancia);

    void update(int codigo);

    void delete(int codigo);

}
