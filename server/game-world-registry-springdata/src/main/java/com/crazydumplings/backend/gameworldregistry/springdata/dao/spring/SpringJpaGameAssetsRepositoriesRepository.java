package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAssetsRepositoriesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameAssetsRepository entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameAssetsRepositoriesRepository
        extends GameAssetsRepositoriesRepository, CrudRepository<GameAssetsRepositoryEntity, Long> {
    @Query("select distinct gameAssetsRepository from GameAssetsRepositoryEntity gameAssetsRepository")
    List<GameAssetsRepositoryEntity> findAll();

    @Query("select distinct gameAssetsRepository from GameAssetsRepositoryEntity gameAssetsRepository where gameAssetsRepository.id = ?1")
    GameAssetsRepositoryEntity findOneById(Long id);

    @Query("select distinct gameAssetsRepository from GameAssetsRepositoryEntity gameAssetsRepository where gameAssetsRepository.uniqueName = ?1")
    GameAssetsRepositoryEntity findOneByUniqueName(String uniqueName);

    @Query("select distinct gameAssetsRepository from GameAssetsRepositoryEntity gameAssetsRepository " + "where "
            + "gameAssetsRepository.uniqueName like '%' + ?1 + '%' or " + "gameAssetsRepository.description like '%' + ?1 + '%' ")
    List<GameAssetsRepositoryEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameAssetsRepository from GameAssetsRepositoryEntity gameAssetsRepository " + "where "
            + "(:uniqueName is null or gameAssetsRepository.uniqueName = :uniqueName) and"
            + "(:description is null or gameAssetsRepository.description = :description)")
    List<GameAssetsRepositoryEntity> findAllByExample(String uniqueName, String description);
}