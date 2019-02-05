package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.DatatypeConverter;

import base.DBManager;
import beans.UserDataBeans;

public class UserDAO {
    public void insertUserdata(String name,String address,String password)  {
        Connection conn = null;
        try {

            conn = DBManager.getConnection();

            String sql = "INSERT INTO user(user_name,email_address,password) VALUES(?,?,?)";

            String codepassword=CodeInfo(password);

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,name);
            pStmt.setString(2,address);
            pStmt.setString(3,codepassword);
            int result =pStmt.executeUpdate();

            pStmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
    public UserDataBeans findByNewLoginInfo(String user,String address) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE user_name=?  or email_address = ? ";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, user);
            pStmt.setString(2, address);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String addressData = rs.getString("email_address");
            String nameData = rs.getString("user_name");
            return new UserDataBeans(addressData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
    public UserDataBeans findByLoginInfo(String address, String password)  {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE email_address = ? and password = ?";

            String codepassword=CodeInfo(password);

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, address);
            pStmt.setString(2, codepassword);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }
            int userId=rs.getInt("id");
            String addressData = rs.getString("email_address");
            String passwordData = rs.getString("password");
            String nameData=rs.getString("user_name");
            return new UserDataBeans(userId,nameData,addressData, passwordData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
    public void UserUpdate(int userId,String name,String address,String password)  {
        Connection conn = null;
        try {

            conn = DBManager.getConnection();

            String sql = "UPDATE user SET user_name =? ,email_address=?,password=? WHERE id=? ";

            String codepassword=CodeInfo(password);

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,name);
            pStmt.setString(2,address);
            pStmt.setString(3,codepassword);
            pStmt.setInt(4,userId);
            int result =pStmt.executeUpdate();

            pStmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String CodeInfo(String password) {
        String source = password;
        //ハッシュ生成前にバイト配列に置き換える際のCharset
        Charset charset = StandardCharsets.UTF_8;
        //ハッシュアルゴリズム
        String algorithm = "MD5";

        //ハッシュ生成処理
        byte[] bytes = null;
    	try {
    		bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
    	} catch (NoSuchAlgorithmException e) {
    		// TODO 自動生成された catch ブロック
    		e.printStackTrace();
    	}
        String result = DatatypeConverter.printHexBinary(bytes);

        return result;
        }
}
