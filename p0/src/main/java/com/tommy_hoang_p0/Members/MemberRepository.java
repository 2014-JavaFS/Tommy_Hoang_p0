package com.tommy_hoang_p0.Members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.tommy_hoang_p0.Util.ConnectionFactory;
import com.tommy_hoang_p0.Util.Interfaces.Crudable;



public class MemberRepository implements Crudable<Member>{

     @Override
     public boolean update(Member member){
          return false; // Placeholder for actual database update.
     }

     @Override
     public boolean delete(Member member){
          return false; // Placeholder for actual database deletion.
     }

     @Override
     public List<Member> findAll(){
          return List.of();
     }

     @Override
     public Member create(Member member){
          return null;
     }
     @Override
     public Member findById(int id){
          // Placeholder for actual database query.
          return null;
     }

     public Member findByEmailAndPassword(String email, String password) {
          try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
               String sql = "SELECT * FROM members WHERE email = ? AND password = ?";
               try (PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setString(1, email);
                    pst.setString(2, password);

                    try (ResultSet rs = pst.executeQuery()) {
                         if (!rs.next()) {
                              throw new RuntimeException("No member found with the given info.");
                         }

                         Member member = new Member();
                         member.setMemberId(rs.getInt("member_id"));
                         member.setType(rs.getString("member_type"));
                         member.setFirstName(rs.getString("first_name"));
                         member.setLastName(rs.getString("last_name"));
                         member.setEmail(rs.getString("email"));
                         member.setPhoneNumber(rs.getString("phone_number"));
                         member.setPassword(rs.getString("password"));
                         member.setStreet_address(rs.getString("street_address"));

                         return member;
                    }
               }
          } catch (SQLException e) {
               e.printStackTrace();
               return null;
          }
     }

}
