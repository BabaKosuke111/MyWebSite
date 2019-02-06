package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ClassDataBeans;
import beans.DeckDataBeans;

public class DeckDAO {
    public List<DeckDataBeans> findAllDeckInfo()  {
        Connection conn = null;
        List<DeckDataBeans> AllDeckList = new ArrayList<DeckDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM deck JOIN class ON deck.deck_class_id = class.id where deck.id not in (4) ";


             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String deckName  = rs.getString("deck_name");
                String className = rs.getString("class_name");
                int voteCount=rs.getInt("vote_count");
                DeckDataBeans deckdata = new DeckDataBeans(id,deckName,voteCount,className);

                AllDeckList.add(deckdata);
            }
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
        return AllDeckList;
    }
    public List<DeckDataBeans> findRankingInfo()  {
        Connection conn = null;
        List<DeckDataBeans> deckRankingList = new ArrayList<DeckDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM deck JOIN class ON deck.deck_class_id = class.id where deck.id not in (4) order by vote_count desc ";


             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String deckName  = rs.getString("deck_name");
                String className = rs.getString("class_name");
                int voteCount=rs.getInt("vote_count");
                DeckDataBeans deckrank = new DeckDataBeans(id,deckName,voteCount,className);

                deckRankingList.add(deckrank);
            }
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
        return deckRankingList;
    }
    public List<DeckDataBeans> findAllDeckSearch(String nameSearch,String classSearch) {
        Connection conn = null;
        List<DeckDataBeans>  AllDeckList = new ArrayList<DeckDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM deck JOIN class ON deck.deck_class_id = class.id  where deck.id not in (4)";

            if(!nameSearch.equals("")){
            	sql +=" AND deck.deck_name LIKE '%" + nameSearch + "%'";
            }
            if(!classSearch.equals("")) {
            	sql +=" AND class.class_name = '"+classSearch+"'";
            }

            // SELECTを実行し、結果表を取得
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String deckName  = rs.getString("deck_name");
                String className = rs.getString("class_name");
                int voteCount=rs.getInt("vote_count");
                DeckDataBeans deckdata = new DeckDataBeans(id,deckName,voteCount,className);

                AllDeckList.add(deckdata);
            }
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
        return  AllDeckList;
    }
    public void DeckVote(int voteId)  {
        Connection conn = null;
        try {

            conn = DBManager.getConnection();

            String sql = "update deck set vote_count = vote_count +1 where id=?";


            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1,voteId);
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
    public List<ClassDataBeans> findAllClassInfo()  {
        Connection conn = null;
        List<ClassDataBeans> classList = new ArrayList<ClassDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM class where id not in (1)";


             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String className = rs.getString("class_name");
                ClassDataBeans classdata = new ClassDataBeans(id,className);

                classList.add(classdata);
            }
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
        return classList;
    }
    public List<DeckDataBeans> findUserDeckInfo(int userId)  {
        Connection conn = null;
        List<DeckDataBeans> userdeckList = new ArrayList<DeckDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM deck JOIN class ON deck.deck_class_id = class.id where deck.id not in (4) and deck.user_id=? ";


             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1,userId);
            ResultSet rs = pStmt.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String deckName  = rs.getString("deck_name");
                String className = rs.getString("class_name");
                int voteCount=rs.getInt("vote_count");
                DeckDataBeans userdeckdata = new DeckDataBeans(id,deckName,voteCount,className);

                userdeckList.add(userdeckdata);
            }
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
        return userdeckList;
    }
	public static int insertDeck (DeckDataBeans ddb)  {
        Connection conn = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement(
					"insert into deck(deck_name,deck_class_id,user_id,vote_count)values(?,?,?,0)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, ddb.getDeckName());
			st.setString(2, ddb.getClassId());
			st.setInt(3, ddb.getUserId());
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}

			return autoIncKey;
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
		return autoIncKey;
	}    public void DeleteDeckInfo(String deckId) {
        Connection conn = null;
        try {

            conn = DBManager.getConnection();

            String sql = " DELETE FROM deck WHERE id = ?;" ;




            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,deckId);
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
}
