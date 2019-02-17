package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.CardDetailDataBeans;


public class CardDetailDAO {
	public List<CardDetailDataBeans> findAllCardInfo()  {
		Connection conn = null;
		List<CardDetailDataBeans> AllCardList = new ArrayList<CardDetailDataBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "select * from card_detail join class on card_detail.class_id=class.id order by class.id ";


			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id=rs.getInt("id");
				String cardName  = rs.getString("card_name");
				String className=rs.getString("class_name");
				CardDetailDataBeans carddata = new CardDetailDataBeans(id,cardName,className);

				AllCardList.add(carddata);
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
		return AllCardList;
	}
	public List<CardDetailDataBeans> findAllCardSearch(String nameSearch,String classSearch) {
		Connection conn = null;
		List<CardDetailDataBeans> AllCardList = new ArrayList<CardDetailDataBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "select * from card_detail join class on card_detail.class_id=class.id   where card_detail.id not in (1)";

			if(!nameSearch.equals("")){
				sql +=" AND card_detail.card_name LIKE '%" + nameSearch + "%'";
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
				int id=rs.getInt("id");
				String cardName  = rs.getString("card_name");
				String className=rs.getString("class_name");
				CardDetailDataBeans carddata = new CardDetailDataBeans(id,cardName,className);

				AllCardList.add(carddata);
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
		return AllCardList;
	}
	public CardDetailDataBeans getCardInfo(String cardId)  {
		Connection conn = null;

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "select * from card_detail join class on card_detail.class_id=class.id where card_detail.id=?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, cardId);
			ResultSet rs = pStmt.executeQuery();


			if (!rs.next()) {
				return null;
			}
			String cardName = rs.getString("card_name");
			int cardCost = rs.getInt("card_cost");
			String cardEffect=rs.getString("card_effect");
			String fileName=rs.getString("file_name");
			String className=rs.getString("class_name");
			return new CardDetailDataBeans(cardName,cardCost,cardEffect,fileName,className);


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
}
