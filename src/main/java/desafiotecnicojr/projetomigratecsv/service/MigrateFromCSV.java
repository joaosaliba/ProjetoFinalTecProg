package desafiotecnicojr.projetomigratecsv.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import desafiotecnicojr.projetomigratecsv.ProjetoMigrateCsvApplication;
import desafiotecnicojr.projetomigratecsv.entity.Produto;
import desafiotecnicojr.projetomigratecsv.service.db.DataBaseSave;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
public class MigrateFromCSV {

    private   Logger logger = LoggerFactory.getLogger(ProjetoMigrateCsvApplication.class);
    DataBaseSave db ;
    Actions actions;

    public MigrateFromCSV(DataBaseSave db, Actions actions) {
        this.db = db;
        this.actions = actions;
    }

    @PostConstruct
    private  void init() throws Exception {
        Resource resource = new ClassPathResource("csv/prdotuos.csv");
        try (InputStream inputStream = resource.getInputStream();
             Reader reader = new InputStreamReader(inputStream)) {
            CsvToBean<Produto> csvToBean = new CsvToBeanBuilder<Produto>(reader)
                    .withType(Produto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Produto> produtos = csvToBean.parse();
            produtos.forEach(produto -> db.insert(produto));
            this.actions.runAll();

        } catch (IOException e) {
            throw new IOException("Error reading CSV file", e);
        }
    }

}
