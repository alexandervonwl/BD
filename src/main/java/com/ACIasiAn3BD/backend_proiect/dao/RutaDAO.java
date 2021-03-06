package com.ACIasiAn3BD.backend_proiect.dao;


import com.ACIasiAn3BD.backend_proiect.model.Ruta;
import com.ACIasiAn3BD.backend_proiect.model.Ruta_Frontend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
@Transactional
public class RutaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Ruta> getAll() {
        String sql = "SELECT * FROM Ruta";

        List<Ruta> listRuta = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Ruta.class));

        return listRuta;
    }

    public void save(Ruta_Frontend ruta) {
        String sql1 = "INSERT INTO Ruta (ruta, durata, distanta, numar_ruta) VALUES (?, ?, ?, null)";
        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1 , ruta.getRuta());
            ps.setInt(2 , ruta.getDurata());
            ps.setInt(3 , ruta.getDistanta());
            return  ps;
        });

        String sql = "SELECT * FROM ruta WHERE numar_ruta = (SELECT max(numar_ruta) FROM ruta)";

        Ruta ultima_ruta = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Ruta.class));


        String sql2 = "INSERT INTO AVION_RUTA_FK (ruta_numar_ruta, avion_avion_id) VALUES (?, ?)";

        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setInt(1 , ultima_ruta.getNumar_ruta());
            ps.setInt(2 , ruta.getAvion_avion_id());
            return  ps;
        });

        String sql3 = "INSERT INTO BAZA_RUTA_FK (ruta_numar_ruta, baza_nume) VALUES (?, ?)";

        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql3);
            ps.setInt(1 , ultima_ruta.getNumar_ruta());
            ps.setString(2 , ruta.getBaza_nume1());
            return  ps;
        });

        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql3);
            ps.setInt(1 , ultima_ruta.getNumar_ruta());
            ps.setString(2 , ruta.getBaza_nume2());
            return  ps;
        });

        String sql4 = "INSERT INTO RUTA_ANGAJAT_FK (ruta_numar_ruta, angajat_angajat_id) VALUES (?, ?)";

        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql4);
            ps.setInt(1 , ultima_ruta.getNumar_ruta());
            ps.setInt(2 , ruta.getAngajat_angajat_id());
            return  ps;
        });
    }

    public Ruta get(int id) {
        String sql = "SELECT * FROM Ruta WHERE numar_ruta = ?";
        Object[] args = {id};
        Ruta ruta = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Ruta.class));
        return ruta;
    }

    public void update(Ruta ruta) {
        String sql = "UPDATE Ruta SET ruta=:ruta, durata=:durata, distanta=:distanta WHERE numar_ruta=:numar_ruta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ruta);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql1 = "DELETE FROM Echipaj where numar_ruta = ?";
        String sql2 = "DELETE FROM Zbor Where numar_ruta = ?";
        String sql3 = "DELETE FROM Ruta_Angajat_fk where ruta_numar_ruta = ?";
        String sql4 = "DELETE FROM Avion_Ruta_fk where ruta_numar_ruta = ?";
        String sql5 = "DELETE FROM BAZA_RUTA_fk where ruta_numar_ruta = ?";
        String sql6 = "DELETE FROM Ruta WHERE numar_ruta = ?";
        jdbcTemplate.update(sql1, id);
        jdbcTemplate.update(sql2, id);
        jdbcTemplate.update(sql3, id);
        jdbcTemplate.update(sql4, id);
        jdbcTemplate.update(sql5, id);
        jdbcTemplate.update(sql6, id);

    }
}
