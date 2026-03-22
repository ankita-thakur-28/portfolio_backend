package com.codewithankita.portfolioproject.repository;
import com.codewithankita.portfolioproject.model.Contact;
import org.springframework.stereotype.Repository;
import java.sql.*;

@Repository
public class ContactRepository {
    public void addContact(Contact contact){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/portfolio","root","Ankita@1928");

            String query = "INSERT INTO contact(name, email, message) VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, contact.getName());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getMessage());

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
