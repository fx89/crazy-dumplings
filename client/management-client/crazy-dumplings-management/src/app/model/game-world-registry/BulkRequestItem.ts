export class BulkRequestItem {
    constructor(
        public assetId: number,
        public assetRequest: any
    ) {
        if (this.assetId === undefined) {
            this.assetId = null;
        }
    }
}