/**
 * Copy/paste from https://basarat.gitbooks.io/algorithms/content/docs/datastructures/stack.html
 */
export class Stack<T> {
    _store: T[] = [];
    push(val: T) {
        this._store.push(val);
    }
    pop(): T | undefined {
        return this._store.pop();
    }
}
