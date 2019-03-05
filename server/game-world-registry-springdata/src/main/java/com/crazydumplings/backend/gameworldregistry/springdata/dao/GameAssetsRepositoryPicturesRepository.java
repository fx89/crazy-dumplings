package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryPictureEntity;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryPicture;

public interface GameAssetsRepositoryPicturesRepository {
	GameAssetsRepositoryPicture findOneById(Long id);

	GameAssetsRepositoryPicture findOneByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	void delete(GameAssetsRepositoryPicture gameAssetsRepositoryPicture);

	void deleteByGameAssetsRepository(GameAssetsRepository gameAssetsRepository);

	GameAssetsRepositoryPicture save(GameAssetsRepositoryPicture gameAssetsRepositoryPicture);

	List<GameAssetsRepositoryPictureEntity> findAll();
}
