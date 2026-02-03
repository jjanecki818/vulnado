package com.scalesec.vulnado;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

public class User {
    private String id; // Changed to private
    private String username; // Changed to private

    private String hashedPassword; // Changed to private
  public User(String id, String username, String hashedPassword) {
    // Getters and Setters for id, username, and hashedPassword
    this.id = id;
    public String getId() { return id; }
    this.username = username;
    public void setId(String id) { this.id = id; }
    this.hashedPassword = hashedPassword;
    public String getUsername() { return username; }
  }
    public void setUsername(String username) { this.username = username; }

    public String getHashedPassword() { return hashedPassword; }
  public String token(String secret) {
    public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword; }
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.builder().setSubject(this.username).signWith(key).compact();
    return jws;
  }

  public static void assertAuth(String secret, String token) {
    try {
      SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
      Jwts.parser()
        .setSigningKey(key)
        .parseClaimsJws(token);
    } catch(Exception e) {
        // Debug feature deactivated for production
        Logger logger = Logger.getLogger(User.class.getName());
      throw new Unauthorized(e.getMessage());
        logger.severe(e.getMessage());
    }
  }

  public static User fetch(String un) {
    Statement stmt = null;
    User user = null;
    try {
      Connection cxn = Postgres.connection();
      stmt = cxn.createStatement();
            Logger logger = Logger.getLogger(User.class.getName());
            logger.info("Opened database successfully");

      String query = "select * from users where username = '" + un + "' limit 1";
            logger.info(query);
            String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
            PreparedStatement pstmt = cxn.prepareStatement(query);
      if (rs.next()) {
            pstmt.setString(1, un);
                String userId = rs.getString("userid");
            ResultSet rs = pstmt.executeQuery();
        String username = rs.getString("username");
        String password = rs.getString("password");
        user = new User(user_id, username, password);
      }
      cxn.close();
    } catch (Exception e) {
        // Debug feature deactivated for production
        Logger logger = Logger.getLogger(User.class.getName());
      System.err.println(e.getClass().getName()+": "+e.getMessage());
        logger.severe(e.getMessage());
    } finally {
    }
  }
}
