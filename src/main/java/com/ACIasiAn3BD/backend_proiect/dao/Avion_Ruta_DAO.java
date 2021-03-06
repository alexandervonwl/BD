package com.ACIasiAn3BD.backend_proiect.dao;


import com.ACIasiAn3BD.backend_proiect.model.Avion_Ruta_FK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class Avion_Ruta_DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Avion_Ruta_FK> getAll() {
        String sql = "SELECT * FROM avion_ruta_fk";

        List<Avion_Ruta_FK> listAR = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Avion_Ruta_FK.class));
        return listAR;
    }

    public void save(Avion_Ruta_FK avion_ruta_fk) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("avion_ruta_fk").usingColumns("avion_avion_id", "ruta_numar_ruta");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(avion_ruta_fk);

        insertActor.execute(param);
    }


    public Avion_Ruta_FK getARA(int id) {
        String sql = "SELECT * FROM avion_ruta_fk WHERE avion_avion_id = ?";
        Object[] args = {id};
        Avion_Ruta_FK avion_ruta_fk = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Avion_Ruta_FK.class));
        return avion_ruta_fk;
    }

    public Avion_Ruta_FK getARR(int id) {
        String sql = "SELECT * FROM avion_ruta_fk WHERE ruta_numar_ruta = ?";
        Object[] args = {id};
        Avion_Ruta_FK avion_ruta_fk = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Avion_Ruta_FK.class));
        return avion_ruta_fk;
    }

    public void updateARA(Avion_Ruta_FK avion_ruta_fk) {
        String sql = "UPDATE Avion_Ruta_FK SET ruta_numar_ruta=:ruta_numar_ruta WHERE avion_avion_id=:avion_avion_id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(avion_ruta_fk);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void updateARR(Avion_Ruta_FK avion_ruta_fk) {
        String sql = "UPDATE Avion_Ruta_FK SET avion_avion_id=:avion_avion_id WHERE ruta_numar_ruta=:ruta_numar_ruta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(avion_ruta_fk);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }


    public void deleteARA(int id) {
        String sql = "DELETE FROM Avion_Ruta_FK WHERE avion_avion_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void deleteARR(int id) {
        String sql = "DELETE FROM Avion_Ruta_FK WHERE ruta_numar_ruta = ?";
        jdbcTemplate.update(sql, id);
    }

}
