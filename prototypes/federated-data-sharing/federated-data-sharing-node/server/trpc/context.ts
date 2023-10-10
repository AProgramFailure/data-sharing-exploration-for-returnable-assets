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
        security TEXT NOT NULL,
        location_id INTEGER,
        order_id INTEGER,
        user_id INTEGER,
        CONSTRAINT organization_location
            FOREIGN KEY (location_id)
            REFERENCES location(location_id),
        CONSTRAINT organization_order
            FOREIGN KEY (order_id)
            REFERENCES _order(order_id),
        CONSTRAINT organization_user
            FOREIGN KEY (user_id)
            REFERENCES _user(user_id)

    );`)
    const user = db.prepare(
        `CREATE TABLE IF NOT EXISTS _user (
        user_id INTEGER PRIMARY KEY AUTOINCREMENT,
        email TEXT NOT NULL UNIQUE,
        first_name TEXT NOT NULL,
        last_name TEXT NOT NULL
    );`)
    const location = db.prepare(
        `CREATE TABLE IF NOT EXISTS location (
        location_id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        address TEXT NOT NULL,
        latitude TEXT NOT NULL,
        longitute TEXT NOT NULL,
        security TEXT NOT NULL
    );`)
    const order_item = db.prepare(
        `CREATE TABLE IF NOT EXISTS order_item (
        order_id INTEGER PRIMARY KEY AUTOINCREMENT,
        item_type TEXT NOT NULL,
        requested_quantity INTEGER NOT NULL,
        actual_quantity INTEGER NOT NULL,
        security TEXT NOT NULL
    );`)
    const order = db.prepare(
        `CREATE TABLE IF NOT EXISTS _order (
        order_id INTEGER PRIMARY KEY AUTOINCREMENT,
        status TEXT NOT NULL,
        security TEXT NOT NULL,
        order_item_id INTEGER,
        CONSTRAINT order_order_item
            FOREIGN KEY (order_item_id)
            REFERENCES order_item(order_item_id)

    );`)

    const inventory = db.prepare(
        `CREATE TABLE IF NOT EXISTS inventory (
        inventory_id INTEGER PRIMARY KEY AUTOINCREMENT,
        item_type TEXT NOT NULL,
        quantity INTEGER,
        security TEXT NOT NULL
    );`)

    federated_node.run()
    user.run()
    location.run()
    order_item.run()
    order.run()
    inventory.run()
    organization.run()

    return {
        db
    }
};

export type Context = inferAsyncReturnType<typeof createContext>;