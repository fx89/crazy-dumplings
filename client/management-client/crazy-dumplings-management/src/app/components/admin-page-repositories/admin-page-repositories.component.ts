import { Component, OnInit } from '@angular/core';
import { RepositoriesService } from '../../services/repositories/repositories.service';
import { GameAssetsRepository } from '../../model/game-world-registry/GameAssetsRepository';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';

@Component({
  selector: 'app-admin-page-repositories',
  templateUrl: './admin-page-repositories.component.html',
  styleUrls: ['./admin-page-repositories.component.less', '../bottom-bar/css/bottom-bar-button.css']
})
export class AdminPageRepositoriesComponent implements OnInit {

    protected repositories: GameAssetsRepository[];

    constructor(
        private repositoriesService: RepositoriesService,
        protected variables: StatefulViewVariablesService
    ) { }

    ngOnInit() {
        this.repositoriesService.getRepositoriesList().subscribe(response => {
            this.repositories = response;
        });
    }

    newRepository() {
        this.variables.selectRepository(new GameAssetsRepository('New repository'));
        this.variables.selectSection(AppSection.REPOSITORIES_EDIT);
    }
}
