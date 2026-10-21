import { Link } from 'react-router-dom';
import { Empty } from '../components/ui';

export default function NotFound() {
  return (
    <div className="container page">
      <Empty title="That page does not exist">
        The link may be out of date. Everything in this app is one hop away — try the drug library, the tools index, or the home
        page.
      </Empty>
      <div className="row center mt-4" style={{ justifyContent: 'center' }}>
        <Link to="/" className="btn btn-primary">
          Home
        </Link>
        <Link to="/tools" className="btn btn-secondary">
          Tools
        </Link>
        <Link to="/drugs" className="btn btn-secondary">
          Drug library
        </Link>
      </div>
    </div>
  );
}
