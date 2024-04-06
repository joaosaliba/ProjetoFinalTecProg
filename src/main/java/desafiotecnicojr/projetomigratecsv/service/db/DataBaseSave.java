package desafiotecnicojr.projetomigratecsv.service.db;

import desafiotecnicojr.projetomigratecsv.ProjetoMigrateCsvApplication;
import desafiotecnicojr.projetomigratecsv.entity.Produto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseSave {

    private Logger logger = LoggerFactory.getLogger(ProjetoMigrateCsvApplication.class);
    private final JdbcTemplate jdbcTemplate;

    public DataBaseSave(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void insert(Produto produto) {
        String sql = "INSERT INTO estoque.produto (id, descricao, quantidade, preco,categoria) VALUES (?, ?, ?, ?, ?)";
        try{
            jdbcTemplate.update(sql, produto.getId(),
                    produto.getDescricao(), produto.getQuantidade(),
                    produto.getPreco(), produto.getCategoria());
//            logger.info("Dado  inserido com sucesso " + produto.getId());

        }catch (DataAccessException ex){
//            logger.info("Dado já inserido para id "+ produto.getId() );
        }
    }

}
