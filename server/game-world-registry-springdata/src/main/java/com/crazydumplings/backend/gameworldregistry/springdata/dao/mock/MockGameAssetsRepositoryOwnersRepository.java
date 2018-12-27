package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAssetsRepositoryOwnersRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryOwner;

public class MockGameAssetsRepositoryOwnersRepository  implements GameAssetsRepositoryOwnersRepository{

    @Override
    public GameAssetsRepositoryOwner findOneByGameAssetsRepositoryIdAndOwnerUserId(Long gameAssetsRepositoryId, Long ownerUserId) {
        return null;
    }

    @Override
    public void deleteByGameAssetsRepository(GameAssetsRepository gameAssetsRepository) {
        
    }

    @Override
    public GameAssetsRepositoryOwner save(GameAssetsRepositoryOwner gameClientType) {
        return null;
    }
}
