package org.book.recommend.service;

import java.util.List;

import org.book.recommend.model.PublicationModel;

public interface PubService {
	public boolean isAddNewPublication(PublicationModel model);

	public List<PublicationModel> getAllPublication();
}
