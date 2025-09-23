package org.book.recommend.service;

import java.util.List;

import org.book.recommend.model.PublicationModel;
import org.book.recommend.repository.*;

public class PubServiceImpl implements PubService {
	PubRepository pubRepo = new PubRepositoryImpl();

	@Override
	public boolean isAddNewPublication(PublicationModel model) {
		// TODO Auto-generated method stub
		return pubRepo.isAddNewPublication(model);
	}

	@Override
	public List<PublicationModel> getAllPublication() {
		// TODO Auto-generated method stub
		return pubRepo.getAllPublication();
	}

}
