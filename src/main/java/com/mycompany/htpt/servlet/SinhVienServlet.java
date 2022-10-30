/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.htpt.servlet;

import com.mycompany.htpt.DAO.KhoaDAO;
import com.mycompany.htpt.DAO.SinhVienDAO;
import com.mycompany.htpt.DAO.TruongHocDAO;
import com.mycompany.htpt.model.Khoa;
import com.mycompany.htpt.model.SinhVien;
import com.mycompany.htpt.model.TruongHoc;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MinhDuc
 */
@WebServlet(name = "SinhVienServlet", urlPatterns = {"/SinhVienServlet"})
public class SinhVienServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SinhVienDAO sinhVienDAO;
    private KhoaDAO khoaDAO;
    private TruongHocDAO truongHocDAO;

    @Override
    public void init() {

        sinhVienDAO = new SinhVienDAO();
        khoaDAO = new KhoaDAO();
        truongHocDAO = new TruongHocDAO();

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getServletPath();

            switch (action) {
                case "/SinhVienServlet/new":
                    showNewForm(request, response);
                    break;
                case "/SinhVienServlet/insert":
                    insert(request, response);
                    break;
                case "/SinhVienServlet/delete":
                    delete(request, response);
                    break;
                case "/SinhVienServlet/edit":
                    showEditForm(request, response);
                    break;
                case "/SinhVienServlet/update":
                    update(request, response);
                    break;
                case "/SinhVienServlet/list":
                    list(request, response);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Khoa> khoa = khoaDAO.listAll();
        List<TruongHoc> cn = truongHocDAO.listAll();
        request.setAttribute("listKhoa", khoa);
        request.setAttribute("listCn", cn);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SinhVienForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String ma = request.getParameter("maSV");
        String ten = request.getParameter("ten");
        Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
        String diaChi = request.getParameter("diaChi");
        String maK = request.getParameter("khoa");
        String maCn = request.getParameter("cn");

        SinhVien s = new SinhVien(ma, ten, ngaySinh, diaChi, maK, maCn);
        sinhVienDAO.insert(s);
        response.sendRedirect("list");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String ma = request.getParameter("maSV");
        sinhVienDAO.delete(ma);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String ma = (request.getParameter("maSV"));
        SinhVien existingBook = sinhVienDAO.getSinhVien(ma);
        List<Khoa> khoa = khoaDAO.listAll();
        List<TruongHoc> cn = truongHocDAO.listAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("SinhVienForm.jsp");
        request.setAttribute("sinhVien", existingBook);
        request.setAttribute("listKhoa", khoa);
        request.setAttribute("listCn", cn);
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String ma = request.getParameter("maSV");
        String ten = request.getParameter("ten");
        Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
        String diaChi = request.getParameter("diaChi");
        String maK = request.getParameter("khoa");
        String maCn = request.getParameter("cn");

        SinhVien s = new SinhVien(ma, ten, ngaySinh, diaChi, maK, maCn);
        sinhVienDAO.update(s);
        response.sendRedirect("list");
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<SinhVien> listSinhVien = sinhVienDAO.listAll();
        request.setAttribute("listSinhVien", listSinhVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SinhVienList.jsp");
        dispatcher.forward(request, response);
    }

}
