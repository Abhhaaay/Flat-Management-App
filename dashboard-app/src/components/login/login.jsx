import './login.css';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import registerCheckInstance from '../../instance/registerCheckInstance';
import { useDispatch } from 'react-redux';
import { setUserEmail } from '../../features/auth/authSlice';

const Login = () => {
  
  const dispatch = useDispatch();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [emailError, setEmailError] = useState('');
  const [passwordError, setPasswordError] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (event) => {
    event.preventDefault();

    setEmailError('');
    setPasswordError('');

    if (email === '') {
      setEmailError('Please enter your email');
      return;
    }

    if (password === '') {
      setPasswordError('Please enter a password');
      return;
    }

    try {
      const response = await registerCheckInstance.get(`/auth/login/${email}/${password}`);

      if (response.data === 1) {
        navigate("/admin");
      } else if (response.data === 2) {
        dispatch(setUserEmail(email));
        navigate("/owner");
      } else if (response.data === 3) {
        navigate("/tenant");
      } else {
        setPasswordError('Invalid credentials');
      }

    } catch (error) {
      console.error('Sign in error:', error);
    }
  };

  const handleRegister = async (event) => {
    event.preventDefault();

    setEmailError('');
    setPasswordError('');

    if (email === '') {
      setEmailError('Please enter your email');
      return;
    }

    try {
      const response = await registerCheckInstance.get(`/auth/search/${email}`);
      if (response.data === 2) {
        navigate("/signup");
      }
    } catch (error) {
      console.error('Registration error:', error);
    }
  };

  return (
    <div className='mainContainer'>
      <form onSubmit={handleLogin}>
        <div className='titleContainer'>
          <div>Login</div>
        </div>
        <br />
        <div className='inputContainer'>
          <input
            placeholder="Enter your email here"
            className='inputBox'
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <label className="errorLabel">{emailError}</label>
        </div>
        <br />
        <div className='inputContainer'>
          <input
            placeholder="Enter your password here"
            className='inputBox'
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <label className="errorLabel">{passwordError}</label>
        </div>
        <br />
        <div className='flex'>
          <input
            className='inputButton'
            type="submit"
            value='Log in'
          />
          <input
            className='inputButton'
            type="button"
            onClick={handleRegister}
            value='Register'
          />
        </div>
      </form>
    </div>
  );
};

export default Login;