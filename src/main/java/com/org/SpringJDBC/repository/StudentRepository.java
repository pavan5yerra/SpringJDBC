package com.org.SpringJDBC.repository;

import com.org.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private JdbcTemplate jdbc;

    public void save(Student s) {

        String sql = "insert into student (rollno , name , marks) values (?,?,?)";
        int rows = jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println("Added Student to DB.." +rows);

    }

    public List<Student> findAll() {
        String sql = "select * from student";

        //--Accessing Functional Interface using lambda expression--
         RowMapper<Student> mapper = (rs,rowNum) -> {
             Student s = new Student();
             s.setRollNo(rs.getInt("rollNo"));
             s.setName(rs.getString("name"));
             s.setMarks(rs.getInt("marks"));
             return  s;
         };

        return  jdbc.query(sql,mapper);
//        return new ArrayList<Student>();
    }
}


// Accessing Functional interface using Anonymous Class
    /*    RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setRollNo(rs.getInt("rollNo"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return  s;
            }
        };
*/
