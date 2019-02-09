package com.crazydumplings.backend.rest;

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

import com.crazydumplings.backend.rest.model.GameObjectTypeRequest;
import com.crazydumplings.backend.security.annotations.AssetType;
import com.crazydumplings.backend.security.annotations.PreAuthorizeOwnAssets;
import com.crazydumplings.gameworldregistry.GameWorldRegistryService;
import com.crazydumplings.gameworldregistry.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeClass;



@RestController()
@RequestMapping("/game-object-types")
@PreAuthorize("hasAuthority('MANAGEMENT_CLIENT')")
public class GameObjectTypesController {
    @Autowired
    private GameWorldRegistryService registryService;

    @GetMapping("/listClasses")
    public List<GameObjectTypeClass> listGameObjectTypeClasses() {
        return registryService.getGameObjectTypeClasses();
    }

    @PostMapping("/addClass")
    public GameObjectTypeClass createGameObjectTypeClass(@RequestParam("class_name") String className) {
        return registryService.addGameObjectTypeClass(className);
    }

    @GetMapping("/list")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public List<GameObjectType> listGameObjectTypes(@RequestParam("repo_id") Long repoId) {
        return registryService.getGameObjectTypes(repoId);
    }

    @PostMapping("/save")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public GameObjectType saveGameObjectType(@RequestParam("repo_id") Long repoId, @RequestParam("asset_id") Long assetId, @RequestBody GameObjectTypeRequest request) {
        return registryService.saveGameObjectType(repoId, assetId, request.gameObjectTypeClassId, request.uniqueName, request.description, request.experimental);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('REMOVE_ASSETS')")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public void removeGameObjectType(@RequestParam("repo_id") Long repoId, @RequestParam("asset_id") Long assetId) {
        registryService.deleteGameObjectType(repoId, assetId);
    }
}
