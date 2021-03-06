package com.ACIasiAn3BD.backend_proiect.dao;


import com.ACIasiAn3BD.backend_proiect.model.Ruta_Angajat_FK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.List;

public class Ruta_Angajat_DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Ruta_Angajat_FK> getAll() {
        String sql = "SELECT * FROM ruta_angajat_fk";

        List<Ruta_Angajat_FK> listRA = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Ruta_Angajat_FK.class));
        return listRA;
    }

    public void save(Ruta_Angajat_FK ruta_angajat_fk) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ruta_angajat_fk").usingColumns("ruta_numar_ruta", "angajat_angajat_id");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ruta_angajat_fk);

        insertActor.execute(param);
    }

    public Ruta_Angajat_FK getRAA(int id) {
        String sql = "SELECT * FROM ruta_angajat_fk WHERE angajat_angajat_id = ?";
        Object[] args = {id};
        Ruta_Angajat_FK ruta_angajat_fk = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Ruta_Angajat_FK.class));
        return ruta_angajat_fk;
    }

    public Ruta_Angajat_FK getRAR(int id) {
        String sql = "SELECT * FROM ruta_angajat_fk WHERE angajat_angajat_id = ?";
        Object[] args = {id};
        Ruta_Angajat_FK ruta_angajat_fk = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Ruta_Angajat_FK.class));
        return ruta_angajat_fk;
    }

    public void updateRAA(Ruta_Angajat_FK ruta_angajat_fk) {
        String sql = "UPDATE ruta_angajat_fk SET ruta_numar_ruta=:ruta_numar_ruta WHERE angajat_angajat_id=:angajat_angajat_id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ruta_angajat_fk);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void updateRAR(Ruta_Angajat_FK ruta_angajat_fk) {
        String sql = "UPDATE Ruta_Angajat_FK SET angajat_angajat_id=:angajat_angajat_id WHERE ruta_numar_ruta=:ruta_numar_ruta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ruta_angajat_fk);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }


    public void deleteRAA(int id) {
        String sql = "DELETE FROM ruta_angajat_fk WHERE angajat_angajat_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void deleteRAR(int id) {
        String sql = "DELETE FROM ruta_angajat_fk WHERE ruta_numar_ruta = ?";
        jdbcTemplate.update(sql, id);
    }

}
