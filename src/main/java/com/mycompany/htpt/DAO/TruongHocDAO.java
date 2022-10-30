/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.htpt.DAO;

import com.mycompany.htpt.model.Khoa;
import com.mycompany.htpt.model.TruongHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MinhDuc
 */
public class TruongHocDAO extends DAO {
     public TruongHocDAO() {
      
    }

    public List<TruongHoc> listAll() throws SQLException {
        List<TruongHoc> listCn = new ArrayList<>();

        String sql = "SELECT * FROM TruongHoc";

        connect();

        try ( Statement statement = jdbcConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String ma = resultSet.getString("MaCN");
                String ten = resultSet.getString("Ten");
                String diaChi = resultSet.getString("DiaChi");

                TruongHoc t = new TruongHoc(ma, ten, diaChi);
                listCn.add(t);
            }

            resultSet.close();
        }

        disconnect();

        return listCn;
    }

}
