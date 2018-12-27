package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAssetsRepositoryOwnersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryOwnerEntity;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;

public interface SpringJpaGameAssetsRepositoryOwnersRepository
        extends GameAssetsRepositoryOwnersRepository, CrudRepository<GameAssetsRepositoryOwnerEntity, Long> {

    @Query("select distinct gameAssetsRepositoryOwnerEntity from GameAssetsRepositoryOwnerEntity gameAssetsRepositoryOwnerEntity left join fetch gameAssetsRepositoryOwnerEntity.gameAssetsRepository where gameAssetsRepositoryOwnerEntity.gameAssetsRepository.id = ?1 and gameAssetsRepositoryOwnerEntity.ownerUserId = ?2")
    public GameAssetsRepositoryOwnerEntity findOneByGameAssetsRepositorAndOwnerUserId(GameAssetsRepositoryEntity gameAssetsRepository,
            Long ownerUserId);

    public void deleteByGameAssetsRepository(GameAssetsRepository gameAssetsRepository);
}
