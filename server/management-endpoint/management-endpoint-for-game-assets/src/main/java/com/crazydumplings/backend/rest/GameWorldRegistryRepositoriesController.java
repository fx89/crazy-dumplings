package com.crazydumplings.backend.rest;

import static com.crazydumplings.backend.utils.SecurityUtils.getCurrentUserId;

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

import com.crazydumplings.backend.rest.model.GameAssetsRepositoryRequest;
import com.crazydumplings.backend.security.annotations.AssetType;
import com.crazydumplings.backend.security.annotations.PreAuthorizeOwnAssets;
import com.crazydumplings.gameworldregistry.GameWorldRegistryService;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;

@RestController()
@RequestMapping("/repositories")
//@PreAuthorize("hasAuthority('ACCESS_EVERYTHING')")
@PreAuthorize("hasAuthority('MANAGEMENT_CLIENT')")
public class GameWorldRegistryRepositoriesController {
    @Autowired
    private GameWorldRegistryService registryService;

    @GetMapping("/list")
    public List<GameAssetsRepository> listRepositories() {
        return registryService.getAllRepositories();
    }

    @PostMapping("/add")
    public GameAssetsRepository createRepository(@RequestBody GameAssetsRepositoryRequest request) {
        return registryService.addRepository(request.uniqueName, request.description, getCurrentUserId());
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('REMOVE_ASSETS')")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public void removeRepository(@RequestParam("repo_id") Long repoId) {
        registryService.deleteGameAssetsRepository(repoId);
    }

    @PutMapping("/update")
    @PreAuthorizeOwnAssets(assetType = AssetType.REPO_ID)
    public void updateRepository(@RequestParam("repo_id") Long repoId, @RequestBody GameAssetsRepositoryRequest request) {
        // TODO: reconsider the usefulness of the GameAssetsRepositoryRequest type
        registryService.updateGameAssetsRepository(repoId, request.uniqueName, request.description, request.pictureHash);
    }
}
