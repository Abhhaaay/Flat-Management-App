import { useState } from 'react'
import './signup.css'
import { useNavigate } from 'react-router-dom'
import registerCheckInstance from '../../instance/registerCheckInstance'

const Login = () => {

  const [email, setEmail] = useState('');
  const [pass, setPass] = useState('');
  const [finalPass, setFinalPass] = useState('');
  const [emailError, setEmailError] = useState('');
  const [passError, setPassError] = useState('');
  const [finalPassError, setFinalPassError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async(event) => {
    event.preventDefault();
    setEmailError('');
    setPassError('');
    setFinalPassError('');

    if (email === '') {
      setEmailError('Please enter your email');
      return;
    }

    else if (pass === '') {
      setPassError('Please enter a password');
      return;
    }
    
    else if (finalPass !== pass) {
      setFinalPassError('Passwords do not match');
      return;
    }
      try {
        const response = await registerCheckInstance.get(`/auth/signup/${email}/${finalPass}`);
        console.log(response.data);
        if (response.data === true) {
          navigate("/");
        }
  
      } catch (error) {
        console.error('Sign in error:', error);
      }
    
  };

  return (
    <div className='mainContainer'>
      <form onSubmit={handleSubmit}>
        <div className='titleContainer'>
          <div>Sign up</div>
        </div>
        <br />
        <div className='inputContainer'>
          <input
            placeholder="Enter your email"
            className='inputBox'
            onChange={(e) => setEmail(e.target.value)}
          />
          <label className="errorLabel">{emailError}</label>
        </div>
        <br />
        <div className='inputContainer'>
          <input
            placeholder="Enter your password"
            className='inputBox'
            onChange={(e) => setPass(e.target.value)}
          />
          <label className="errorLabel">{passError}</label>
        </div>
        <br />
        <div className='inputContainer'>
          <input
            placeholder="Confirm your password"
            className='inputBox'
            onChange={(e) => setFinalPass(e.target.value)}
          />
          <label className="errorLabel">{finalPassError}</label>
        </div>
        <br />
        <div>
          <input className='createButton' type="submit" value='Create' />
        </div>
      </form>
    </div>
  )
}

export default Login