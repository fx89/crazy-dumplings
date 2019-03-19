package com.crazydumplings.backend.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/save")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public GameObjectTypeProperty saveGameObjectTypeProperty(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestBody GameObjectTypePropertyRequest request) {
        return registryService.saveGameObjectTypeProperty(repoId, parentId, request);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('REMOVE_ASSETS')")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public void removeGameObjectTypeProperty(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestParam("asset_id") Long assetId) {
        registryService.deleteGameObjectTypeProperty(repoId, parentId, assetId);
    }

    @PostMapping("/bulkSave")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public void bulkUpdateGameObjectTypeProperties(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestBody List<GameObjectTypePropertyRequest> request) {
        registryService.bulkSaveGameObjectTypeProperties(repoId, parentId, new ArrayList<>(request));
    }

    @DeleteMapping("/bulkDelete")
    @PreAuthorize("hasAuthority('REMOVE_ASSETS')")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public void bulkRemoveGameObjectTypeProperties(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestBody List<Long> assetIds) {
        registryService.bulkDeleteGameObjectTypeProperties(repoId, parentId, assetIds);
    }
}
