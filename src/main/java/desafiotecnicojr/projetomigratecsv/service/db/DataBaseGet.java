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
public class DataBaseGet {

    private Logger logger = LoggerFactory.getLogger(ProjetoMigrateCsvApplication.class);
    private final JdbcTemplate jdbcTemplate;

    public DataBaseGet(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Produto> getAll() throws Exception {
        String sql = "SELECT * from produto ";
        try{
            RowMapper<Produto> rowMapper = ((rs, rowNum) -> new Produto(
                    rs.getInt("id"),
                    rs.getString("descricao"),
                    rs.getInt("quantidade"),
                    rs.getBigDecimal("preco"),
                    rs.getString("categoria")
            ));

            return jdbcTemplate.query(sql, rowMapper);
        }catch (DataAccessException ex){
           throw new Exception("Q");
        }
    }
}
