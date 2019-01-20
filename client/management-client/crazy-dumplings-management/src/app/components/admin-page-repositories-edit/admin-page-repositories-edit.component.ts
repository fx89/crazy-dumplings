import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { RepositoriesService } from '../../services/repositories/repositories.service';

@Component({
  selector: 'app-admin-page-repositories-edit',
  templateUrl: './admin-page-repositories-edit.component.html',
  styleUrls: ['./admin-page-repositories-edit.component.less']
})
export class AdminPageRepositoriesEditComponent implements OnInit {

    constructor(
        protected variables: StatefulViewVariablesService,
        private repositoriesService: RepositoriesService
    ) { }

    ngOnInit() {

    }

    save() {
        this.repositoriesService.saveRepository(this.variables.currentRepository)
                    .subscribe( repository => {
                            if (this.variables.currentRepository) {
                                this.variables.currentRepository.id = repository.id;
                            } else {
                                this.variables.currentRepository = repository;
                            }

                            this.variables.revertSectionSelection();
                        });
    }

    cancel() {
        this.variables.revertRepositorySelection();
        this.variables.revertSectionSelection();
    }
}
