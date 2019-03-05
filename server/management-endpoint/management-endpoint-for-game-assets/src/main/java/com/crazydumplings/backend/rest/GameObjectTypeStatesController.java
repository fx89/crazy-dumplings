package com.crazydumplings.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crazydumplings.backend.security.annotations.AssetType;
import com.crazydumplings.backend.security.annotations.PreAuthorizeOwnAssets;
import com.crazydumplings.gameworldregistry.GameWorldRegistryService;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeState;

@RestController()
@RequestMapping("/game-object-type-states")
@PreAuthorize("hasAuthority('MANAGEMENT_CLIENT')")
public class GameObjectTypeStatesController {
	@Autowired
    private GameWorldRegistryService registryService;

	@GetMapping("/list")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public List<GameObjectTypeState> listGameObjectTypeStates(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId) {
        return registryService.getGameObjectTypeStates(repoId, parentId);
    }

	@PostMapping("/save")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public GameObjectTypeState saveGameObjectTypeState(
            @RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestParam("name") String name
    ) {
        return registryService.saveGameObjectTypeState(repoId, parentId, name);
    }

	@DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('REMOVE_ASSETS')")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public void removeGameObjectTypeState(@RequestParam("repo_id") Long repoId, @RequestParam("parent_id") Long parentId, @RequestParam("asset_id") Long assetId) {
        registryService.deleteGameObjectTypeState(repoId, parentId, assetId);
    }
}
