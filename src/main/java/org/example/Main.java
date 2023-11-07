package org.example;


import org.example.util.ConnectDB;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Statement
        Connection conn = ConnectDB.getConnection();
//        try {
//            Statement state = conn.createStatement();
//            ResultSet rs = state.executeQuery("select * from product");
//            while (rs.next()){
//                System.out.println("ID : "+ rs.getInt("id")
//                        +" | Name : "+rs.getString("name")
//                        +" | description: " +rs.getString("description")
//                        +" | price : "+rs.getDouble("price")
//                        +" | stock : "+rs.getInt("stock"));
//            }
//            state.executeUpdate("Insert Into product(name,description,price, stock) " +
//                    "values('sản phẩm 5','mô tả vv ',200,50)");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            ConnectDB.closeConnection(conn);
//        }
        // Prepare Statement
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập tên sản phẩm");
//        String name = sc.nextLine();
//        System.out.println("Nhập mô tả");
//        String des = sc.nextLine();
//        System.out.println("Nhập giá");
//        double price = sc.nextDouble();
//        System.out.println("Nhập số lượng");
//        int stock = sc.nextInt();
//        System.out.println("Nhập id cần xóa");
//        int idDel = sc.nextInt();
//        try {
//            PreparedStatement prepare = conn.prepareStatement("Insert Into product(name,description,price, stock) " +
//                     "values(?,?,?,?)");
//            prepare.setString(1,name);
//            prepare.setString(2,des);
//            prepare.setDouble(3,price);
//            prepare.setInt(4,stock);
//            PreparedStatement prepare = conn.prepareStatement("Delete from product where id =?");
//           prepare.setInt(1,idDel);
//            prepare.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            ConnectDB.closeConnection(conn);
//        }


        // CallableStatement
        System.out.println("Nhập vào id caanf tìm");
        int idFind = sc.nextInt();
        try {
            CallableStatement callSt = conn.prepareCall("{call findByID(?)}");
            callSt.setInt(1,idFind);
            ResultSet rs = callSt.executeQuery();
            if(rs.next()){
                System.out.println("ID : "+ rs.getInt("id")
                        +" | Name : "+rs.getString("name")
                        +" | description: " +rs.getString("description")
                        +" | price : "+rs.getDouble("price")
                        +" | stock : "+rs.getInt("stock"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}