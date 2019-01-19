import { Component, OnInit, Input } from '@angular/core';
import { StatefulViewVariablesService } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { GameAssetsRepository } from '../../model/game-world-registry/GameAssetsRepository';

@Component({
  selector: 'app-repository-card',
  templateUrl: './repository-card.component.html',
  styleUrls: ['./repository-card.component.less']
})
export class RepositoryCardComponent implements OnInit {

    @Input() repository: GameAssetsRepository;

    constructor( protected variables: StatefulViewVariablesService ) { }

    ngOnInit() { }

    selectRepository() {
        this.variables.selectRepository(this.repository);
    }

    isCurrent(): boolean {
        return this.repository.id === this.variables.currentRepository.id;
    }
}
