package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAddonInteractionReceivingPropertyModifierEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAllowedAddonTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameAddonInteractionReceivingPropertyModifier entity")
public interface GameAddonInteractionReceivingPropertyModifiersRepository {
    List<GameAddonInteractionReceivingPropertyModifierEntity> findAll();

    GameAddonInteractionReceivingPropertyModifierEntity findOneById(Long id);

    List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByGameObjectTypeAllowedAddonType(
            GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType);

    List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByAffectedGameObjectTypeProperty(
            GameObjectTypePropertyEntity affectedGameObjectTypeProperty);

    List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByAnyTextFieldContaining(String content);

    List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByExample(
            GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType, GameObjectTypePropertyEntity affectedGameObjectTypeProperty,
            Double appliedPropertyValueMultiplier);

    GameAddonInteractionReceivingPropertyModifierEntity save(
            GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier);

    void delete(GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier);
}