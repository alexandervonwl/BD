package com.ACIasiAn3BD.backend_proiect.dao;


import com.ACIasiAn3BD.backend_proiect.model.Zbor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.*;

@Repository
@Transactional
public class
ZborDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private List<Zbor> listZbor;


    public List<Zbor> getAll() {
        String sql = "SELECT * FROM ZBOR";

        listZbor = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Zbor.class));

        return listZbor;
    }

    public void save(Zbor zbor) {
        String sql1 = "INSERT INTO Zbor (numar_ruta, ziua_ora_decolare, pret_economic_class, " +
                "pret_business_class, numar_echipaj, oras_decolare, oras_aterizare, oras_oprire1, oras_oprire2, " +
                "avion_id, numar_zbor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? , ?, null)";
        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setInt(1 , zbor.getNumar_ruta());
            ps.setString(2 , zbor.getZiua_ora_decolare());
            ps.setDouble(3 , zbor.getPret_economic_class());
            ps.setDouble(4 , zbor.getPret_business_class());
            ps.setDouble(5 , zbor.getNumar_echipaj());
            ps.setString(6 , zbor.getOras_decolare());
            ps.setString(7 , zbor.getOras_aterizare());
            ps.setString(8 , zbor.getOras_oprire1());
            ps.setString(9 , zbor.getOras_oprire2());
            ps.setInt(10 , zbor.getAvion_id());
            return  ps;
        });
    }

    public Zbor get(int id) {
        String sql = "SELECT * FROM Zbor WHERE numar_zbor = ?";
        Object[] args = {id};
        Zbor zbor = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Zbor.class));
        return zbor;
    }

    public void update(Zbor zbor) {
        String sql = "UPDATE Zbor SET numar_ruta=:numar_ruta, ziua_ora_decolare=:ziua_ora_decolare, pret_economic_class=:pret_economic_class" +
                ", pret_business_class=:pret_business_class, numar_echipaj=:numar_echipaj, oras_decolare=:oras_decolare, " +
                "oras_aterizare=:oras_aterizare, oras_oprire1=:oras_oprire1, oras_oprire2=:oras_oprire2, " +
                "avion_id=:avion_id WHERE numar_zbor=:numar_zbor";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zbor);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql1 = "DELETE FROM Echipaj WHERE numar_zbor = ?";
        String sql2 = "DELETE FROM Zbor WHERE numar_zbor = ?";
        jdbcTemplate.update(sql1, id);
        jdbcTemplate.update(sql2, id);
    }
}
