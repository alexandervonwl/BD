package com.ACIasiAn3BD.backend_proiect.dao;

import com.ACIasiAn3BD.backend_proiect.model.Angajat;
import com.ACIasiAn3BD.backend_proiect.model.Echipaj;
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
public class AngajatDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Angajat> getAll() {
        String sql = "SELECT * FROM Angajat";

        List<Angajat> listAngajat= jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Angajat.class));
        return listAngajat;
    }

    public void save(Angajat angajat) {
        String sql1 = "INSERT INTO Angajat (nume, prenume, data_angajare, functie, salariu, numar_zboruri, angajat_id) VALUES (?, ?, ?, ?, ?, ?, null)";
        jdbcTemplate.update( conn -> {
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1 , angajat.getNume());
            ps.setString(2 , angajat.getPrenume());
            ps.setDate(3 , angajat.getData_angajare());
            ps.setString(4 , angajat.getFunctie());
            ps.setInt(5 , angajat.getSalariu());
            ps.setInt(6 , angajat.getNumar_zboruri());
            return  ps;
        });
    }

    public Angajat get(int id) {
        String sql = "SELECT * FROM Angajat WHERE angajat_id = ?";
        Object[] args = {id};
        Angajat angajat = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Angajat.class));
        return angajat;
    }

    public List<Angajat> getP() {
        String sql = "SELECT * FROM Angajat WHERE functie = 'pilot' ";

        List<Angajat> listAngajat= jdbcTemplate.query(sql, new BeanPropertyRowMapper<Angajat>(Angajat.class));

        System.out.println(listAngajat);
        return listAngajat;
    }

    public List<Angajat> getCP() {
        String sql = "SELECT * FROM Angajat WHERE functie = 'co-pilot' ";

        List<Angajat> listAngajat= jdbcTemplate.query(sql, new BeanPropertyRowMapper<Angajat>(Angajat.class));

        System.out.println(listAngajat);
        return listAngajat;
    }

    public List<Angajat> getS() {
        String sql = "SELECT * FROM Angajat WHERE functie = 'steward' ";

        List<Angajat> listAngajat= jdbcTemplate.query(sql, new BeanPropertyRowMapper<Angajat>(Angajat.class));

        System.out.println(listAngajat);
        return listAngajat;
    }

    public void update(Angajat angajat) {
        String sql = "UPDATE Angajat SET nume=:nume, prenume=:prenume, data_angajare=:data_angajare" +
                ", functie=:functie, salariu=:salariu, numar_zboruri=:numar_zboruri WHERE angajat_id=:angajat_id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(angajat);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql1 = "DELETE FROM echipaj WHERE echipaj_id in (select echipaj_id from echipaj where pilot_id = ? )";
        String sql2 = "DELETE FROM echipaj WHERE echipaj_id in (select echipaj_id from echipaj where copilot_id = ? )";
        String sql3 = "DELETE FROM echipaj WHERE echipaj_id in (select echipaj_id from echipaj where steward1_id = ? )";
        String sql4 = "DELETE FROM echipaj WHERE echipaj_id in (select echipaj_id from echipaj where steward2_id = ? )";
        String sql5 = "DELETE FROM echipaj WHERE echipaj_id in (select echipaj_id from echipaj where steward3_id = ? )";
        String sql6 = "DELETE FROM echipaj WHERE echipaj_id in (select echipaj_id from echipaj where steward4_id = ? )";
        String sql7 = "DELETE from ruta_angajat_fk where angajat_angajat_id = ? ";
        String sql8 = "DELETE FROM Angajat WHERE angajat_id = ? ";
        jdbcTemplate.update(sql1, id);
        jdbcTemplate.update(sql2, id);
        jdbcTemplate.update(sql3, id);
        jdbcTemplate.update(sql4, id);
        jdbcTemplate.update(sql5, id);
        jdbcTemplate.update(sql6, id);
        jdbcTemplate.update(sql7, id);
        jdbcTemplate.update(sql8, id);
    }
}
