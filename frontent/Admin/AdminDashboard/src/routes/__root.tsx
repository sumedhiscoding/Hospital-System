import { createRootRoute, Link } from '@tanstack/react-router';
import NavbarNested from '../components/Dashboard/DashboardContainer';
// import NavbarNested from '../components/Dashboard/DashboardContainer';
export const Route = createRootRoute({
  component: () => <NavbarNested />,
  notFoundComponent: () => {
    return (
      <div>
        <p>This is the notFoundComponent configured on root route</p>
        <Link to="/">Start Over</Link>
      </div>
    );
  },
});
