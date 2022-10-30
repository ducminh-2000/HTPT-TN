/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.htpt.DAO;

import com.mycompany.htpt.Book;
import com.mycompany.htpt.model.SinhVien;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MinhDuc
 */
public class SinhVienDAO extends DAO {

    public SinhVienDAO() {
//        this.jdbcURL = jdbcURL;
//        this.jdbcUsername = jdbcUsername;
//        this.jdbcPassword = jdbcPassword;
    }

    public boolean insert(SinhVien sinhVien) throws SQLException {
        String sql = "INSERT INTO SinhVien (MaSV,Ten,NgaySinh,DiaChi,MaCN,MaK) VALUES (?, ?, ?, ?,?,?)";
        connect();

        boolean rowInserted;
        try ( PreparedStatement statement = jdbcConnection.prepareStatement(sql)) {
            statement.setString(1, sinhVien.getMaSV());
            statement.setString(2, sinhVien.getTen());
            statement.setDate(3, sinhVien.getNgaySinh());
            statement.setString(4, sinhVien.getDiaChi());
            statement.setString(5, sinhVien.getMaCn());
            statement.setString(6, sinhVien.getMaK());

            rowInserted = statement.executeUpdate() > 0;
        }
        disconnect();
        return rowInserted;
    }

    public List<SinhVien> listAll() throws SQLException {
        List<SinhVien> listSinhVien = new ArrayList<>();

        String sql = "SELECT SinhVien.*, TruongHoc.Ten as TenCN, Khoa.TenKhoa as TenKhoa "
                + "FROM ((SinhVien "
                + "INNER JOIN TruongHoc ON SinhVien.MaCN = TruongHoc.MaCN) "
                + "INNER JOIN Khoa ON SinhVien.MaK = Khoa.MaKhoa);";

        connect();

        try ( Statement statement = jdbcConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String maSv = resultSet.getString("MaSV");
                String ten = resultSet.getString("Ten");
                Date ngaySinh = resultSet.getDate("NgaySinh");
                String diaChi = resultSet.getString("DiaChi");
                String maCn = resultSet.getString("MaCN");
                String maK = resultSet.getString("MaK");
                String tenKhoa = resultSet.getString("TenKhoa");
                String tenCn = resultSet.getString("TenCN");

                SinhVien s = new SinhVien(maSv, ten, ngaySinh, diaChi, maCn, maK, tenKhoa, tenCn);
                listSinhVien.add(s);
            }

            resultSet.close();
        }

        disconnect();

        return listSinhVien;
    }

    public boolean delete(String ma) throws SQLException {
        String sql = "DELETE FROM SinhVien where MaSV = ?";

        connect();

        boolean rowDeleted;
        try ( PreparedStatement statement = jdbcConnection.prepareStatement(sql)) {
            statement.setString(1, ma);
            rowDeleted = statement.executeUpdate() > 0;
        }
        disconnect();
        return rowDeleted;
    }

    public boolean update(SinhVien sinhVien) throws SQLException {
        String sql = "UPDATE SinhVien SET Ten = ?, NgaySinh=?,DiaChi=?,MaK =?,MaCN=?";
        sql += " WHERE MaSV = ?";
        connect();

        boolean rowUpdated;
        try ( PreparedStatement statement = jdbcConnection.prepareStatement(sql)) {
            statement.setString(1, sinhVien.getTen());
            statement.setDate(2, sinhVien.getNgaySinh());
            statement.setString(3, sinhVien.getDiaChi());

            statement.setString(4, sinhVien.getMaK());
            statement.setString(5, sinhVien.getMaCn());
            statement.setString(6, sinhVien.getMaSV());
            rowUpdated = statement.executeUpdate() > 0;
        }
        disconnect();
        return rowUpdated;
    }

    public SinhVien getSinhVien(String ma) throws SQLException {
        SinhVien s = null;
        String sql = "SELECT SinhVien.*, TruongHoc.Ten as TenCN, Khoa.TenKhoa as TenKhoa "
                + "FROM ((SinhVien "
                + "INNER JOIN TruongHoc ON SinhVien.MaCN = TruongHoc.MaCN) "
                + "INNER JOIN Khoa ON SinhVien.MaK = Khoa.MaKhoa) WHERE MaSV = ?";

        connect();

        try ( PreparedStatement statement = jdbcConnection.prepareStatement(sql)) {
            statement.setString(1, ma);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String maSv = resultSet.getString("MaSV");
                String ten = resultSet.getString("Ten");
                Date ngaySinh = resultSet.getDate("NgaySinh");
                String diaChi = resultSet.getString("DiaChi");
                String maK = resultSet.getString("Mak");
                String maCn = resultSet.getString("MaCN");
                String tenKhoa = resultSet.getString("TenKhoa");
                String tenCn = resultSet.getString("TenCN");

                s = new SinhVien(maSv, ten, ngaySinh, diaChi, maK, maCn, tenKhoa, tenCn);
            }

            resultSet.close();
        }

        return s;
    }
}
