import { inferAsyncReturnType } from '@trpc/server';
import Database from "better-sqlite3";

/**
 * Creates context for an incoming request
 * @link https://trpc.io/docs/context
 */
export const createContext = () => {
    const db = new Database('./federated.db')
    const federated_node = db.prepare(
        `CREATE TABLE IF NOT EXISTS federated_node (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        first_name TEXT NOT NULL,
        owner INTEGER NOT NULL,
        security TEXT NOT NULL
    );`)
    const organization = db.prepare(
        `CREATE TABLE IF NOT EXISTS organization (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        organizationType TEXT NOT NULL,
        security TEXT NOT NULL
    );`)
    const user = db.prepare(
        `CREATE TABLE IF NOT EXISTS _user (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        email TEXT NOT NULL UNIQUE,
        first_name TEXT NOT NULL,
        last_name TEXT NOT NULL
    );`)
    const location = db.prepare(
        `CREATE TABLE IF NOT EXISTS location (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        address TEXT NOT NULL,
        latitude TEXT NOT NULL,
        longitute TEXT NOT NULL,
        security TEXT NOT NULL
    );`)
    const order_item = db.prepare(
        `CREATE TABLE IF NOT EXISTS order_item (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        item_type TEXT NOT NULL,
        requested_quantity INTEGER NOT NULL,
        actual_quantity INTEGER NOT NULL,
        security TEXT NOT NULL
    );`)
    const order = db.prepare(
        `CREATE TABLE IF NOT EXISTS _order (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        status TEXT NOT NULL,
        security TEXT NOT NULL
    );`)

    const inventory = db.prepare(
        `CREATE TABLE IF NOT EXISTS inventory (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        item_type TEXT NOT NULL,
        quantity INTEGER,
        security TEXT NOT NULL
    );`)

    federated_node.run()
    organization.run()
    user.run()
    location.run()
    order_item.run()
    order.run()
    inventory.run()

    return {
        db
    }
};

export type Context = inferAsyncReturnType<typeof createContext>;