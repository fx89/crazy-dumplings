
export enum ImportantMessageIconType {
    SUCCESS,
    ERROR,
    WARNING
}

export class ImportantMessage {
    iconType: ImportantMessageIconType;
    text: string;
}
