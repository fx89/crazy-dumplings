import { Component, OnInit } from '@angular/core';
import { RepositoriesService } from '../../services/repositories/repositories.service';
import { GameAssetsRepository } from '../../model/game-world-registry/GameAssetsRepository';

@Component({
  selector: 'app-admin-page-repositories',
  templateUrl: './admin-page-repositories.component.html',
  styleUrls: ['./admin-page-repositories.component.less']
})
export class AdminPageRepositoriesComponent implements OnInit {

    protected repositories: GameAssetsRepository[];

    constructor(private repositoriesService: RepositoriesService) { }

    ngOnInit() {
        this.repositoriesService.getRepositoriesList().subscribe(response => {
            this.repositories = response;
        });
    }

}
