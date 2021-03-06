package com.ACIasiAn3BD.backend_proiect.dao;


import com.ACIasiAn3BD.backend_proiect.model.Avion;
import com.ACIasiAn3BD.backend_proiect.model.Baza;
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
public class BazaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Baza> getAll() {
        String sql = "SELECT * FROM Baza";

        List<Baza> listBaza = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Baza.class));
        return listBaza;
    }

    public void save(Baza baza) {
        String sql1 = "INSERT INTO Baza (Nume, cafenea, service_mentenanta, hotel_partener) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1 , baza.getNume());
            ps.setBoolean(2 , baza.isCafenea());
            ps.setBoolean(3 , baza.isService_mentenanta());
            ps.setBoolean(4 , baza.isHotel_partener());
            return  ps;
        });
    }


    public Baza get(String nume) {
        String sql = "SELECT * FROM Baza WHERE nume = ?";
        Object[] args = {nume};
        Baza baza = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Baza.class));
        return baza;
    }

    public void update(Baza baza) {
        String sql = "UPDATE Baza SET cafenea=:cafenea, service_mentenanta=:service_mentenanta, hotel_partener=:hotel_partener " +
                "WHERE nume=:nume";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(baza);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(String nume) {
        String sql1 = "DELETE FROM Echipaj WHERE numar_ruta IN (SELECT ruta_numar_ruta FROM baza_ruta_fk WHERE baza_nume = ? )";
        String sql2 = "DELETE FROM Zbor WHERE numar_ruta IN (SELECT ruta_numar_ruta FROM baza_ruta_fk WHERE baza_nume = ? )";
        String sql3 = "DELETE FROM Ruta_Angajat_fk WHERE ruta_numar_ruta IN (SELECT ruta_numar_ruta FROM baza_ruta_fk WHERE baza_nume = ? )";
        String sql4 = "DELETE FROM Avion_Ruta_fk WHERE ruta_numar_ruta IN (SELECT ruta_numar_ruta FROM baza_ruta_fk WHERE baza_nume = ? )";
        String sql5 = "DELETE FROM BAZA_RUTA_fk WHERE ruta_numar_ruta IN (SELECT ruta_numar_ruta FROM baza_ruta_fk WHERE baza_nume = ? )";
        String sql6 = "DELETE FROM Ruta WHERE numar_ruta IN (SELECT numar_ruta FROM ruta WHERE numar_ruta NOT IN (SELECT ruta_numar_ruta FROM baza_ruta_fk WHERE baza_nume != ? ))";
        String sql7 = "DELETE FROM Baza WHERE nume = ? ";
        jdbcTemplate.update(sql1, nume);
        jdbcTemplate.update(sql2, nume);
        jdbcTemplate.update(sql3, nume);
        jdbcTemplate.update(sql4, nume);
        jdbcTemplate.update(sql5, nume);
        jdbcTemplate.update(sql6, nume);
        jdbcTemplate.update(sql7, nume);
    }
}
