package com.ACIasiAn3BD.backend_proiect.dao;

import java.sql.PreparedStatement;
import java.util.List;


import com.ACIasiAn3BD.backend_proiect.model.Angajat;
import com.ACIasiAn3BD.backend_proiect.model.Avion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AvionDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Avion> getAll() {
        String sql = "SELECT * FROM AVION";

        List<Avion> listAvion = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Avion.class));
        return listAvion;
    }

    public void save(Avion avion) {
        String sql1 = "INSERT INTO Avion (ultima_revizie, anul_fabricarii, capacitate, incarcatura_maxima, distanta_maxima, tip_avion, avion_id) VALUES (?, ?, ?, ?, ?, ?, null)";
        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setDate(1 , avion.getUltima_revizie());
            ps.setDate(2 , avion.getAnul_fabricarii());
            ps.setInt(3 , avion.getCapacitate());
            ps.setDouble(4 , avion.getIncarcatura_maxima());
            ps.setDouble(5 , avion.getDistanta_maxima());
            ps.setString(6 , avion.getTip_avion());
            return  ps;
        });
    }

    public Avion get(int id) {
        String sql = "SELECT * FROM Avion WHERE avion_id = ?";
        Object[] args = {id};
        Avion avion = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Avion.class));
        return avion;
    }

    public void update(Avion avion) {
        String sql = "UPDATE Avion SET ultima_revizie=:ultima_revizie, anul_fabricarii=:anul_fabricarii, capacitate=:capacitate" +
                ", incarcatura_maxima=:incarcatura_maxima, distanta_maxima=:distanta_maxima, tip_avion=:tip_avion WHERE avion_id=:avion_id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(avion);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }


    public void delete(int id) {
        String sql1 = "DELETE FROM Echipaj WHERE numar_zbor IN (SELECT numar_zbor FROM zbor WHERE avion_id = ? )";
        String sql2 = "DELETE FROM Zbor WHERE avion_id = ? ";
        String sql3 = "DELETE FROM Avion_Ruta_fk WHERE avion_avion_id = ? ";
        String sql4 = "DELETE FROM Avion where avion_id = ? ";
        jdbcTemplate.update(sql1, id);
        jdbcTemplate.update(sql2, id);
        jdbcTemplate.update(sql3, id);
        jdbcTemplate.update(sql4, id);
    }
}
