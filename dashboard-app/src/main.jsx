import ReactDOM from 'react-dom/client'
import './index.css'
import store from './redux/store.js'
import { Provider } from 'react-redux'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'

import Login from './components/login/login.jsx'
import Signup from './components/signup/signup.jsx'
import Tenant from './components/tenant/tenant.jsx'
import Owner from './components/owner/owner.jsx'
import Admin from './components/admin/admin.jsx'

const router = createBrowserRouter([
  {
    path: "/",
    element: <Login />,
  },
  {
    path: "/admin",
    element: <Admin />
  },
  {
    path: "/signup",
    element: <Signup />
  },
  {
    path: "/tenant",
    element: <Tenant />
  },
  {
    path: "/owner",
    element: <Owner />
  }
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <Provider store={store}>
    <RouterProvider router={router}/>
  </Provider>
)
