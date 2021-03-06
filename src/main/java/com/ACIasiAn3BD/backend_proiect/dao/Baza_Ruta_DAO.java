package com.ACIasiAn3BD.backend_proiect.dao;


import com.ACIasiAn3BD.backend_proiect.model.Baza_Ruta_FK;
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
public class Baza_Ruta_DAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Baza_Ruta_FK> getAll() {
        String sql = "SELECT * FROM baza_ruta_fk";

        List<Baza_Ruta_FK> listBR = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Baza_Ruta_FK.class));
        return listBR;
    }

    public void save(Baza_Ruta_FK baza_ruta_fk) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("baza_ruta_fk").usingColumns("baza_nume", "ruta_numar_ruta");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(baza_ruta_fk);

        insertActor.execute(param);
    }

    public Baza_Ruta_FK getBRB(String nume) {
        String sql = "SELECT * FROM baza_ruta_fk WHERE baza_nume = ?";
        Object[] args = {nume};
        Baza_Ruta_FK baza_ruta_fk = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Baza_Ruta_FK.class));
        return baza_ruta_fk;
    }

    public Baza_Ruta_FK getBRR(int id) {
        String sql = "SELECT * FROM baza_ruta_fk WHERE ruta_numar_ruta = ?";
        Object[] args = {id};
        Baza_Ruta_FK baza_ruta_fk = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Baza_Ruta_FK.class));
        return baza_ruta_fk;
    }

    public void updateBRB(Baza_Ruta_FK baza_ruta_fk) {
        String sql = "UPDATE baza_ruta_fk SET ruta_numar_ruta=:ruta_numar_ruta WHERE baza_nume=:baza_nume";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(baza_ruta_fk);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void updateBRR(Baza_Ruta_FK baza_ruta_fk) {
        String sql = "UPDATE baza_ruta_fk SET baza_nume=:baza_nume WHERE ruta_numar_ruta=:ruta_numar_ruta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(baza_ruta_fk);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }


    public void deleteBRB(String nume) {
        String sql = "DELETE FROM baza_ruta_fk WHERE baza_nume = ?";
        jdbcTemplate.update(sql, nume);
    }

    public void deleteBRR(int id) {
        String sql = "DELETE FROM baza_ruta_fk WHERE ruta_numar_ruta = ?";
        jdbcTemplate.update(sql, id);
    }

}
