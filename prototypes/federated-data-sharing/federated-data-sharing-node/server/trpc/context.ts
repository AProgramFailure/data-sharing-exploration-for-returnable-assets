import { inferAsyncReturnType } from '@trpc/server';
import Database from "better-sqlite3";
/**
 * Creates context for an incoming request
 * @link https://trpc.io/docs/context
 */
export const createContext = () : unknown => {
    const db = new Database('./federated.db')
    const createTable = db.prepare(`
        CREATE TABLE IF NOT EXISTS sample (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            message TEXT NOT NULL,
            message2 TEXT NOT NULL
        );
    `);

    createTable.run();

    return {
        db
    }
};

export type Context = inferAsyncReturnType<typeof createContext>;