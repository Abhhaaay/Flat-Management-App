import { useState } from 'react'
import './tenant.css'

function Tenant() {

  const [isVisible, setIsVisible] = useState(false);

  return (
    <>
      <div id="header">
        <div>
          <input type="button" value="Log Out" className='header-button'/>
        </div>
      </div>
      <div id="complaint-section">
        <div className='complaint-head'>Complaints</div>
        <div className='complaint-box-container'>
          <div className='complaint-box'>
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
          </div>
        </div>
      </div>
      <div id="add-complaint">
        {isVisible && 
        <div className='complaint-details'>
          <input type="text" placeholder="Type your complaint" className='complaint-text'/>
          <input type="button" value="Submit" className='submit-button'/>
        </div>
        }
        <div>
          <input type="button" onClick={() => setIsVisible(true)} value="Add Complaint" className='complaint-button'/>
        </div>
      </div>
    </>
  )
}

export default Tenant