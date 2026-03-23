//package com.codewithankita.portfolioproject.repository;
//import com.codewithankita.portfolioproject.model.Contact;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Repository;
//import java.sql.*;
//
//@Repository
//public class ContactRepository {
//
//    @Value("${db.username}")
//    private String username;
//
//    @Value("${db.password}")
//    private String password;
//
//    @Value("${db.url}")
//    private String url;
//
//    public void addContact(Contact contact){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            Connection con =DriverManager.getConnection(url, username, password);
//
//            String query = "INSERT INTO contact(name, email, message) VALUES(?, ?, ?)";
//            PreparedStatement ps = con.prepareStatement(query);
//
//            ps.setString(1, contact.getName());
//            ps.setString(2, contact.getEmail());
//            ps.setString(3, contact.getMessage());
//
//            ps.executeUpdate();
//            con.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//}
