package org.crudDemo.service;

import org.crudDemo.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ManagerDAOImpl implements ManagerDAO {


    @Autowired
    DataSource dataSource;

    public final Connection getFinalConnection() {
        Connection connection;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


    @Override
    public int save(Manager manager) {
        try {
            Connection connection = getFinalConnection();
            String query = "INSERT INTO manager (id,name,email,number,age) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setInt(1, manager.getId());
            pstmt.setString(2, manager.getName());
            pstmt.setString(3, manager.getEmail());
            pstmt.setLong(4, manager.getNumber());
            pstmt.setInt(5, manager.getAge());

            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public int update(Manager manager, int id) {
            try {
                Connection connection = getFinalConnection();
                String sql = "update manager set id=? , name=? , email=? , number=? , age=? where id=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,manager.getId());
                statement.setString(2,manager.getName());
                statement.setString(3,manager.getEmail());
                statement.setLong(4,manager.getNumber());
                statement.setInt(5,manager.getAge());

                statement.setInt(6,id);
                int count = statement.executeUpdate();
                return count;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }




    @Override
    public int delete(int id) {
        int count;
        try {
            Connection connection = getFinalConnection();
            String query = "DELETE FROM manager where id=?";

            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return count;
    }
    @Override
    public Manager getById(int id) {
        try{
        Connection connection=getFinalConnection();
        String query="SELECT * FROM manager where id=?";

            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                Manager manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setName(rs.getString("name"));
                manager.setEmail(rs.getString("email"));
                manager.setNumber(rs.getLong("number"));
                manager.setAge(rs.getInt("age"));
                return manager;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Manager> getAll() {
        try {
            Connection connection = getFinalConnection();
            String query = "SELECT * FROM manager";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
//            SELECT id, student_address, student_email, student_name
//            FROM public.student;
            ArrayList<Manager> employees = new ArrayList<>();

            while (resultSet.next()) {

                Manager mo = new Manager();
                mo.setId(resultSet.getInt("id"));
                mo.setName(resultSet.getString("name"));
                mo.setEmail(resultSet.getString("email"));
                mo.setNumber(resultSet.getLong("number"));
                mo.setAge(resultSet.getInt("age"));
                employees.add(mo);
            }


            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
