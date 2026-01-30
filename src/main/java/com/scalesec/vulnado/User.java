package com.scalesec.vulnado;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

public class User {
    private String id;
    private String username;

    private String hashedPassword;
  public User(String id, String username, String hashedPassword) {
    public String getId() {
    this.id = id;
        return id;
    this.username = username;
    }
    this.hashedPassword = hashedPassword;
    public String getUsername() {
  }
        return username;

    }
  public String token(String secret) {
    public String getHashedPassword() {
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        return hashedPassword;
        return Jwts.builder().setSubject(this.username).signWith(key).compact();
    }
    return jws;
  }

  public static void assertAuth(String secret, String token) {
    try {
      SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
      Jwts.parser()
        .setSigningKey(key)
        .parseClaimsJws(token);
    } catch(Exception e) {
        // Debugging feature deactivated for production
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
        logger.severe(e.getMessage());
      System.err.println(e.getClass().getName()+": "+e.getMessage());
    } finally {
    }
  }
}
