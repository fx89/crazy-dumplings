package com.crazydumplings.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crazydumplings.backend.rest.model.BulkAssetRequestItem;
import com.crazydumplings.backend.rest.model.GameObjectTypePropertyRequest;
import com.crazydumplings.backend.security.annotations.AssetType;
import com.crazydumplings.backend.security.annotations.PreAuthorizeOwnAssets;
import com.crazydumplings.gameworldregistry.GameWorldRegistryService;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeProperty;

@RestController()
@RequestMapping("/game-object-type-properties")
@PreAuthorize("hasAuthority('MANAGEMENT_CLIENT')")
public class GameObjectTypePropertiesController {
    @Autowired
    private GameWorldRegistryService registryService;

    @GetMapping("/list")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public List<GameObjectTypeProperty> listGameObjectTypeProperties(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId) {
        return registryService.getGameObjectTypeProperties(repoId, parentId);
    }

    @PostMapping("/add")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public GameObjectTypeProperty createGameObjectTypeProperty(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestBody GameObjectTypePropertyRequest request) {
        return registryService.addGameObjectTypeProperty(repoId, parentId, request.propertyName, request.propertyDefaultValue, request.propertyMinValue, request.propertyMaxValue);
    }

    @PutMapping("/update")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public GameObjectTypeProperty updateGameObjectTypeProperty(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestParam("asset_id") Long assetId, @RequestBody GameObjectTypePropertyRequest request) {
        return registryService.updateGameObjectTypeProperty(repoId, parentId, assetId, request.propertyName, request.propertyDefaultValue, request.propertyMinValue, request.propertyMaxValue);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('REMOVE_ASSETS')")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public void removeGameObjectTypeProperty(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestParam("asset_id") Long assetId) {
        registryService.deleteGameObjectTypeProperty(repoId, parentId, assetId);
    }

    @PostMapping("/bulkSave")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public void bulkUpdateGameObjectTypeProperties(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestBody List<BulkAssetRequestItem<GameObjectTypePropertyRequest>> request) {
        request.forEach(item -> {
            if (item.assetId != null && item.assetId > 0) {
                registryService.updateGameObjectTypeProperty(
                    repoId, parentId, item.assetId,
                    item.assetRequest.propertyName,
                    item.assetRequest.propertyDefaultValue,
                    item.assetRequest.propertyMinValue,
                    item.assetRequest.propertyMaxValue
                );
            } else {
                registryService.addGameObjectTypeProperty(
                    repoId, parentId,
                    item.assetRequest.propertyName,
                    item.assetRequest.propertyDefaultValue,
                    item.assetRequest.propertyMinValue,
                    item.assetRequest.propertyMaxValue
                );
            }
        });
    }

    @DeleteMapping("/bulkDelete")
    @PreAuthorize("hasAuthority('REMOVE_ASSETS')")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public void bulkRemoveGameObjectTypeProperties(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestBody List<Long> assetIds) {
        assetIds.forEach(assetId -> registryService.deleteGameObjectTypeProperty(repoId, parentId, assetId) );
    }
}
