package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAssetsRepositoryPicturesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryPictureEntity;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryPicture;

public interface SpringJpaGameAssetsRepostoryPicturesRepository
		extends GameAssetsRepositoryPicturesRepository, CrudRepository<GameAssetsRepositoryPictureEntity, Long> {

	void deleteByGameAssetsRepository(GameAssetsRepository gameAssetsRepository);

	List<GameAssetsRepositoryPictureEntity> findAll();
}
