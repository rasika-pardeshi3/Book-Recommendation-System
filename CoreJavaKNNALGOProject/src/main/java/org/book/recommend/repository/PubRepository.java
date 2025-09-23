package org.book.recommend.repository;

import java.util.List;

import org.book.recommend.model.PublicationModel;

public interface PubRepository {
	public boolean isAddNewPublication(PublicationModel model);

	public List<PublicationModel> getAllPublication();
}
