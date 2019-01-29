import { Component, OnInit, Input } from '@angular/core';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { GameAssetsRepository } from '../../model/game-world-registry/GameAssetsRepository';
import { RepositoriesService } from '../../services/repositories/repositories.service';
import { ConfirmationService } from 'primeng/api';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-repository-card',
  templateUrl: './repository-card.component.html',
  styleUrls: ['./repository-card.component.less']
})
export class RepositoryCardComponent implements OnInit {

    @Input() repository: GameAssetsRepository;

    constructor(
            protected variables: StatefulViewVariablesService,
            private repositoriesService: RepositoriesService,
            private confirmationService: ConfirmationService,
            protected messageService: MessageService
        ) { }

    ngOnInit() { }

    selectRepository() {
        this.variables.selectRepository(this.repository);
    }

    isCurrent(): boolean {
        return this.repository.id === this.variables.currentRepository.id;
    }

    edit() {
        this.variables.selectRepository(this.repository);
        this.variables.selectSection(AppSection.REPOSITORIES_EDIT);
    }

    deleteConfirm() {
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete ' + this.repository.uniqueName + '?',
            accept: () => { this.delete(); }
        });
    }

    private delete() {
        this.repositoriesService.deleteRepository(this.repository).subscribe(response => {
            if (response.status === 'OK') {
                if (this.variables.currentRepository.id === this.repository.id) {
                    this.variables.revertRepositorySelection();
                }
                this.variables.importantMessage.text = 'Repository ' + this.repository.uniqueName + ' was successfully deleted';
                this.variables.selectSection(AppSection.IMPORTANT_MESSAGE);
            } else {
                // TODO: use the messages element from PrimeNG to display messages from the back-end
                // and do it in a generic way to avoid copy/paste
                this.messageService.add({severity: 'error', summary: 'Cannot delete repository', detail: response.payload});
            }
        });
    }
}
