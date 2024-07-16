package com.tommy_hoang_p0.Members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tommy_hoang_p0.Util.ConnectionFactory;
import com.tommy_hoang_p0.Util.Interfaces.Crudable;



public class MemberRepository implements Crudable<Member>{
     private static final Logger logger = LoggerFactory.getLogger(MemberRepository.class);
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
     public Member findById(int number) {
        return null;
    }

     public Member findByEmailAndPassword(String email, String password) {
          try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {
               String sql = "SELECT * FROM tommy_hoang_p0.p0_members WHERE email = ? AND pwd = ?";
               try (PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setString(1, email);
                    pst.setString(2, password);

                    try (ResultSet rs = pst.executeQuery()) {
                         if (!rs.next()) {
                              throw new RuntimeException("No member found with the given info.");
                         }

                         Member member = new Member();
                         member.setMemberId(rs.getInt("id_member"));
                         member.setType(rs.getString("member_type"));
                         member.setFirstName(rs.getString("first_name"));
                         member.setLastName(rs.getString("last_name"));
                         member.setPhoneNumber(rs.getString("phone_number"));

                         return member;
                    }
               }
          } catch (SQLException e) {
               logger.error("Error finding member by email and password", e);
               return null;
          }
     }
}
