/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.htpt.model;

import java.sql.Date;

/**
 *
 * @author MinhDuc
 */
public class SinhVien {
    private String maSV;
    private String ten;
    private Date ngaySinh;
    private String diaChi;
    private String maK;
    private String maCn;
    private String tenK;
    private String tenCn;

    public String getTenK() {
        return tenK;
    }

    public void setTenK(String tenK) {
        this.tenK = tenK;
    }

    public String getTenCn() {
        return tenCn;
    }

    public void setTenCn(String tenCn) {
        this.tenCn = tenCn;
    }

    public SinhVien(String maSV, String ten, Date ngaySinh, String diaChi, String maK, String maCn, String tenK, String tenCn) {
        this.maSV = maSV;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maK = maK;
        this.maCn = maCn;
        this.tenK = tenK;
        this.tenCn = tenCn;
    }

    public SinhVien(String maSV, String ten,  Date ngaySinh, String diaChi, String maK, String maCn) {
        this.maSV = maSV;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maK = maK;
        this.maCn = maCn;

    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaK() {
        return maK;
    }

    public void setMaK(String maK) {
        this.maK = maK;
    }

    public String getMaCn() {
        return maCn;
    }

    public void setMaCn(String maCn) {
        this.maCn = maCn;
    }

    public SinhVien() {
    }
}
