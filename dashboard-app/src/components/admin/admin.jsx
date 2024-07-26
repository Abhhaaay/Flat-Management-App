import Flat from '../flat/flat'
import './admin.css'


function Admin() {

  return (
    <>
      <div id="header">
        <div>
            <input type="button" value="Log Out" className='header-button'/>
        </div>
      </div>
      <div id="flat-section">
            <div className='complaint-head'>Flats</div>
            <div className='flats-container'>
                <Flat />
                <Flat />
            </div>
      </div>
      <div id="admin-complaint-section">
        <div className='complaint-head'>Complaints</div>
        <div className='complaint-box-container'>
        <div className='tenant-name'>Tenant1</div>
          <div className='complaint-box'>
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
            <div className='complaint'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, voluptate.</div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Admin