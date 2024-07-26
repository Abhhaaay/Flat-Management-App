import './owner.css';
import registerCheckInstance from '../../instance/registerCheckInstance';
import { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';

function Owner() {
  const [release, setRelease] = useState({});
  const [hidden, setHidden] = useState(false);
  const email = useSelector((state) => state.auth.email);
  const [isVisible, setIsVisible] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await registerCheckInstance.get(`/owner/${email}`);
        setRelease(response.data);
      } catch (error) {
        console.error('Registration error:', error);
      }
    };

    fetchData();
  }, [email]);

  const deleteTenant = async(email) => {
    try {
      const response = await registerCheckInstance.delete(`/owner/remove-tenant/${email}`);
      setRelease(response.data);
    } catch (error) {
      console.error('Registration error:', error);
    }
  };

  return (
    <>
      <div id="header">
        <div>
          <Link to="/"><input type="button" value="Log Out" className='header-button' /></Link>
        </div>
      </div>
      <div id="maintenance-section">
        <div className='maintenance-head'>Maintenance</div>
        <div className='maintenance-display'>
          <div className='maintenance-value'>
            Maintenance Cost: ${release.maintenance}
          </div>
          <div className='maintenance-value'>
            Status: {release.status}
          </div>
          <div>
            <input type='button' value='Pay' className='maintenance-button'/>
            <input type='button' value='Generate Receipt' className='maintenance-button'/>
          </div>
        </div>
        <div className='receipt'>
          <div className='confirm'>Are you sure?</div>
          <div className='options'>
            <div>Yes</div>
            <div>No</div>
          </div>
        </div>
      </div>
      <div id="owner-complaint-section">
        <div className='maintenance-head'>Complaint</div>
        <div className='complaint-box-container'>
          <div className='complaint-box'>
            
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
            
          </div>
          <div>
            <input type="button" value="Add Complaint" className='owner-complaint-button'  onClick={() => {setHidden(!hidden)}}/>
          </div>
          {hidden && 
        <div className='complaint-details'>
          <input type="text" placeholder="Enter your complaint" className='complaint-text'/>
          <input type="button" value="Submit" className='submit-button'/>
        </div>
        }
        </div>
      </div>
      <div id="tenants-section">
        <div className='maintenance-head'>Tenants</div>
        <div className='complaint-box-container'>
          <div className='complaint-box'>
            {release.tenants && release.tenants.length > 0 ? (
              release.tenants.map((tenant, index) => (
                <div key={index} className='tenant-details'>
                  <div>
                    <div className='tenant-name'>{tenant.name}</div>
                    <div>{tenant.email}</div>
                    <div>{tenant.phone}</div>
                  </div>
                  <div>
                    <input type='button' value='Remove' className='tenant-remove-button' />
                  </div>
                </div>
              ))
            ) : (
              <div>No tenants available</div>
            )}
          </div>
          <div>
            <input type="button" value="Add Tenant" className='owner-complaint-button' onClick={() => {setIsVisible(!isVisible)}}/>
          </div>
          {isVisible && 
        <div className='complaint-details'>
          <input type="text" placeholder="Enter tenant details" className='complaint-text'/>
          <input type="button" value="Submit" className='submit-button'/>
        </div>
        }
        </div>
      </div>
    </>
  );
}

export default Owner;