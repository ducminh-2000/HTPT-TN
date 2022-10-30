/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.htpt.DAO;

import com.mycompany.htpt.model.Khoa;
import com.mycompany.htpt.model.SinhVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MinhDuc
 */
public class KhoaDAO extends DAO {
     public KhoaDAO() {
       
    }
     public List<Khoa> listAll() throws SQLException {
        List<Khoa> listKhoa = new ArrayList<>();

        String sql = "SELECT * FROM Khoa";

        connect();

        try ( Statement statement = jdbcConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String maK = resultSet.getString("MaKhoa");
                String ten = resultSet.getString("TenKhoa");
                Khoa k = new Khoa(maK,ten);
                listKhoa.add(k);
            }

            resultSet.close();
        }

        disconnect();

        return listKhoa;
    }

}
