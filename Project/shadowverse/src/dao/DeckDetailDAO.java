package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.DeckDataBeans;
import beans.DeckDetailDataBeans;

public class DeckDetailDAO {
	public List<DeckDetailDataBeans> findById(String deckId)  {
		Connection conn = null;
		List<DeckDetailDataBeans> deckDetailList = new ArrayList<DeckDetailDataBeans>();
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM deck_detail join deck on deck_detail.deck_id=deck.id join card_detail on deck_detail.card_id=card_detail.id join class on deck.deck_class_id=class.id where deck_detail.deck_id=? ";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, deckId);
			ResultSet rs = pStmt.executeQuery();


			while (rs.next()) {
				int cardId = rs.getInt("card_id");
				String cardName = rs.getString("card_name");
				int cardCost = rs.getInt("card_cost");
				int cardCount = rs.getInt("card_count");
				DeckDetailDataBeans deckDetail = new DeckDetailDataBeans(cardId,cardName,cardCost,cardCount);

				deckDetailList.add(deckDetail);
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
		return deckDetailList;
	}
	public DeckDataBeans findDeck(String deckId)  {
		Connection conn = null;

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM deck JOIN class ON deck.deck_class_id = class.id where deck.id not in (4) and deck.id=?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, deckId);
			ResultSet rs = pStmt.executeQuery();


			if (!rs.next()) {
				return null;
			}
			String deckName = rs.getString("deck_name");
			String className = rs.getString("class_name");
			return new DeckDataBeans(deckName,className);


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
	public List<DeckDetailDataBeans> ClassSelectList(String classId)  {
		Connection conn = null;
		List<DeckDetailDataBeans> cardselectList = new ArrayList<DeckDetailDataBeans>();
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "select * from card_detail join class on card_detail.class_id=class.id  where card_detail.class_id=1 or card_detail.class_id=? ";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, classId);
			ResultSet rs = pStmt.executeQuery();


			while (rs.next()) {
				int id = rs.getInt("id");
				String cardName = rs.getString("card_name");
				int cardCost = rs.getInt("card_cost");
				DeckDetailDataBeans cardselect = new DeckDetailDataBeans(id,cardName,cardCost);

				cardselectList.add(cardselect);
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
		return cardselectList;
	}
	public DeckDetailDataBeans cardSelectList(String cardId)  {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "select * from card_detail join class on card_detail.class_id=class.id  where card_detail.id=? ";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, cardId);
			ResultSet rs = pStmt.executeQuery();


			if (!rs.next()) {
				return null;
			}
				int id = rs.getInt("id");
				String cardName = rs.getString("card_name");
				int cardCost = rs.getInt("card_cost");
				return  new DeckDetailDataBeans(id,cardName,cardCost);

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
	public static void insertDeckDetail(DeckDetailDataBeans dddb){
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement(
					"insert into deck_detail(deck_id,card_id,card_count)values(?,?,?)");
			st.setInt(1, dddb.getDeckId());
			st.setInt(2, dddb.getCardId());
			st.setInt(3, dddb.getCardCount());
			st.executeUpdate();


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
