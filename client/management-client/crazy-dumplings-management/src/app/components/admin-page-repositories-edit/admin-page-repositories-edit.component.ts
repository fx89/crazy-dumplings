import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { RepositoriesService } from '../../services/repositories/repositories.service';

@Component({
  selector: 'app-admin-page-repositories-edit',
  templateUrl: './admin-page-repositories-edit.component.html',
  styleUrls: ['./admin-page-repositories-edit.component.less']
})
export class AdminPageRepositoriesEditComponent implements OnInit {

    public isLoadingFile = false;

    constructor(
        protected variables: StatefulViewVariablesService,
        private repositoriesService: RepositoriesService
    ) { }

    ngOnInit() {

    }

    save() {
        this.repositoriesService.saveRepository(this.variables.currentRepository)
                    .subscribe( repository => {
                            this.variables.currentRepository = repository;
                            this.variables.revertSectionSelection();
                        });
    }

    cancel() {
        this.variables.revertRepositorySelection();
        this.variables.revertSectionSelection();
    }

    onFileChanged(event) {
        this.isLoadingFile = true;

        const file = event.target.files[0];

        const fileReader = new FileReader();
        fileReader.onload = (e) => {
            this.isLoadingFile = false;
            console.log(fileReader.result.toString().length);
        };
        fileReader.readAsDataURL(file);
    }
}
