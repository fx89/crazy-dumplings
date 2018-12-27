package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryOwner;

public interface GameAssetsRepositoryOwnersRepository {
    GameAssetsRepositoryOwner findOneByGameAssetsRepositoryIdAndOwnerUserId(Long gameAssetsRepositoryId, Long ownerUserId);

    void deleteByGameAssetsRepository(GameAssetsRepository gameAssetsRepository);
    
    GameAssetsRepositoryOwner save(GameAssetsRepositoryOwner gameClientType);
}
