import { router } from '../trpc';
import { itemRouter } from './item/itemRouter';
import { routerRouter } from './route/routeRouter';
import { truckRouter } from './truck/truckRouter';
import { orderRouter } from './order/orderRouter';
import { locationRouter } from './location/locationRouter';
import { institutionRouter } from './institution/institutionRouter';

export const appRouter = router({
    items: itemRouter,
    routes: routerRouter,
    trucks: truckRouter,
    orders: orderRouter,
    locations: locationRouter,
    institutions: institutionRouter
});

// export type definition of API
export type AppRouter = typeof appRouter;