package com.ACIasiAn3BD.backend_proiect.dao;


import com.ACIasiAn3BD.backend_proiect.model.Echipaj;
import com.ACIasiAn3BD.backend_proiect.model.Ruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@Transactional
public class EchipajDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Echipaj> getAll() {
        String sql = "SELECT * FROM Echipaj";

        List<Echipaj> listEchipaj = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Echipaj.class));
        return listEchipaj;
    }

    public void save(Echipaj echipaj) {
        String sql1 = "INSERT INTO Echipaj (pilot_id, copilot_id, steward1_id, steward2_id, steward3_id, " +
                "steward4_id, steward5_id, steward6_id, numar_ruta, numar_zbor, echipaj_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)";
        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setInt(1 , echipaj.getPilot_id());
            ps.setInt(2 , echipaj.getCopilot_id());
            ps.setInt(3 , echipaj.getSteward1_id());
            ps.setInt(4 , echipaj.getSteward2_id());
            ps.setInt(5 , echipaj.getSteward3_id());
            ps.setInt(6 , echipaj.getSteward4_id());
            ps.setObject(7 , echipaj.getSteward5_id());
            ps.setObject(8 , echipaj.getSteward6_id());
            ps.setInt(9 , echipaj.getNumar_ruta());
            ps.setInt(10 , echipaj.getNumar_zbor());

            return  ps;
        });
    }

    public Echipaj get(int id) {
        String sql = "SELECT * FROM Echipaj WHERE echipaj_id = ?";
        Object[] args = {id};
        Echipaj echipaj = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Echipaj.class));
        return echipaj;
    }

    public void update(Echipaj echipaj) {
        String sql = "UPDATE Echipaj SET pilot_id=:pilot_id, copilot_id=:copilot_id, steward1_id=:steward1_id" +
                ", steward2_id=:steward2_id, steward3_id=:steward3_id, steward4_id=:steward4_id, steward5_id=:steward5_id, steward6_id=:steward6_id WHERE echipaj_id=:echipaj_id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(echipaj);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM Echipaj WHERE echipaj_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
