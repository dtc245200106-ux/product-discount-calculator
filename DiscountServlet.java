package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DiscountServlet", urlPatterns = {"/display-discount"})
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        // Nhận dữ liệu từ form
        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");
        String discountStr = request.getParameter("discount");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Kết quả chiết khấu</title></head>");
            out.println("<body style='font-family: Arial, sans-serif; display:flex; justify-content:center; margin-top:80px; background:#f8fafc;'>");
            out.println("<div style='background:white; padding:40px; border-radius:8px; box-shadow:0 4px 10px rgba(0,0,0,0.1); width:450px;'>");
            
            try {
                double price = Double.parseDouble(priceStr);
                double discountPercent = Double.parseDouble(discountStr);
                
                // Tính toán theo công thức
                double discountAmount = price * discountPercent * 0.01;
                double discountPrice = price - discountAmount;
                
                out.println("<h2 style='color:#1b2a7a; text-align:center;'>KẾT QUẢ CHIẾT KHẤU</h2>");
                out.println("<hr>");
                out.println("<p><b>Product Description:</b> " + description + "</p>");
                out.println("<p><b>List Price:</b> " + String.format("%,.2f", price) + " USD</p>");
                out.println("<p><b>Discount Percent:</b> " + discountPercent + " %</p>");
                out.println("<hr>");
                out.println("<p style='color:#e67e22; font-size:18px;'><b>Discount Amount:</b> " 
                        + String.format("%,.2f", discountAmount) + " USD</p>");
                out.println("<p style='color:#27ae60; font-size:20px;'><b>Discount Price:</b> " 
                        + String.format("%,.2f", discountPrice) + " USD</p>");
                
            } catch (NumberFormatException | NullPointerException e) {
                out.println("<h2 style='color:red; text-align:center;'>Lỗi: Vui lòng nhập số hợp lệ!</h2>");
            }
            
            out.println("<div style='text-align:center; margin-top:20px;'>");
            out.println("<a href='index.jsp' style='text-decoration:none; padding:10px 20px; background:#1b2a7a; color:white; border-radius:4px;'>Quay lại</a>");
            out.println("</div>");
            out.println("</div></body></html>");
        }
    }
}