package org.book.recommend.repository;

import java.util.ArrayList;
import java.util.List;

import org.book.recommend.config.DBConfig;
import org.book.recommend.model.PublicationModel;

public class PubRepositoryImpl extends DBConfig implements PubRepository {
	List<PublicationModel> list;

	@Override
	public boolean isAddNewPublication(PublicationModel model) {
		try {
			stmt = conn.prepareStatement("insert into publication values('0',?)");
			stmt.setString(1, model.getName());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
		}
		return false;
	}

	@Override
	public List<PublicationModel> getAllPublication() {
		try {
			list = new ArrayList<PublicationModel>();
			stmt.getConnection().prepareCall("select * from publication");
			rs = stmt.executeQuery();
			while (rs.next()) {
				PublicationModel model = new PublicationModel(rs.getInt(1), rs.getString(2));
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			return null;
		}
	}

}
