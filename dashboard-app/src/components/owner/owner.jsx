import './owner.css'

function Owner() {
  return (
    <>
      <div id="header">
        <div>
          <input type="button" value="Log Out" className='header-button'/>
        </div>
      </div>
      <div id="maintenance-section">
        <div className='maintenance-head'>Maintenance</div>
        <div className='maintenance-display'>
          <div className='maintenance-value'>Maintenance Cost: $100</div>
          <div>
            <input type='button' value='Pay' className='maintenance-button'/>
            <input type='button' value='Generate Receipt' className='maintenance-button'/>
          </div>
        </div>
      </div>
      <div id="owner-complaint-section">
        <div className='maintenance-head'>Complaint</div>
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
          <div>
            <input type="button" value="Add Complaint" className='owner-complaint-button'/>
          </div>
        </div>
      </div>
      <div id="tenants-section">
        <div className='maintenance-head'>Tenants</div>
        <div className='complaint-box-container'>
          <div className='complaint-box'>
            <div className='tenant-details'>
              <div>
                <div className='tenant-name'>Jack</div>
                <div>jack@gmail.com</div>
                <div>+91 11</div>
              </div>
              <div>
                <input type='button' value='Remove' className='tenant-remove-button'/>
              </div>
            </div>
            <div className='tenant-details'>
              <div>
                <div className='tenant-name'>Jack</div>
                <div>jack@gmail.com</div>
                <div>+91 11</div>
              </div>
              <div>
                <input type='button' value='Remove' className='tenant-remove-button'/>
              </div>
            </div>
          </div>
          <div>
            <input type="button" value="Add Tenant" className='owner-complaint-button'/>
          </div>
        </div>
      </div>
    </>
  )
}

export default Owner