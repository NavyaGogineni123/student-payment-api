package net.navya.springtest.dao;

import net.navya.springtest.model.Payment;
import net.navya.springtest.mapper.PaymentMapper;
import net.navya.springtest.mapper.StudentRowMapper;
import net.navya.springtest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PaymentDao {


    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    StudentRowMapper studentRowMapper;
    @Autowired
    PaymentMapper paymentMapper;

    public List<Student> getStudentList() {
        return namedParameterJdbcTemplate.query("select * from student", studentRowMapper);
    }

    public void create(Student student) {
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("id", student.getStudentId());
        sqlParameterSource.addValue("fName", student.getFirstName());
        sqlParameterSource.addValue("lastName", student.getLastName());
        sqlParameterSource.addValue("dateOfBirth", student.getDob());

        namedParameterJdbcTemplate.update("INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (:id, :fName, :lastName, :dateOfBirth)", sqlParameterSource);
    }

    public void update(Student student) {

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("id", student.getStudentId());
        sqlParameterSource.addValue("firstName", student.getFirstName());

        namedParameterJdbcTemplate.update("UPDATE student SET first_name=:firstName where student_id=:id", sqlParameterSource);
    }

    public void delete(int id) {
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("id", id);
        namedParameterJdbcTemplate.update("delete from student where student_id = :id", sqlParameterSource);

    }

    public List<Payment> getById(int id) {
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("id", id);
        return namedParameterJdbcTemplate.query("select * from payments where student_id ="  + id , new PaymentMapper());
    }

    public List<Payment> getPaymentsByName(String name) {

        return namedParameterJdbcTemplate.query("select * from payments where student_id in (select student_id from student where first_name ='"+name+ "')"   , new PaymentMapper());
    }

    //after fixing above method
    public List<Payment> getPaymentsByNameFixSqlInjection(String name) {
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("name", name);
        return namedParameterJdbcTemplate.query("select * from payments where student_id in (select student_id from student where first_name =:name)" ,sqlParameterSource  , new PaymentMapper());
    }
}
