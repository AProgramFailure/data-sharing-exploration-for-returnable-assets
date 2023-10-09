import { router } from '../trpc';
import { organizationRouter } from './Organization/organization';

export const appRouter = router({
    organizations : organizationRouter
});

// export type definition of API
export type AppRouter = typeof appRouter;