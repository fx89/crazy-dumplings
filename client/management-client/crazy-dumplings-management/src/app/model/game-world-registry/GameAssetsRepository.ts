
export class GameAssetsRepository {
    id: number;
    uniqueName: string;
    description: string;
    pictureHash: string;



    constructor( uniqueName: string ) {
        this.uniqueName = uniqueName; /* this is to keep all the properties at the beginning of the class
                                         and not have some of them declared in the constructor
                                        while others still at the top */
    }
}
