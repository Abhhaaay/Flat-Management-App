import { useState } from 'react';
import './admin.css'
import { SlArrowDown } from "react-icons/sl";

function Admin() {

    const [isVisible, setIsVisible] = useState(false);

    const toggleVisibility = () => {
        setIsVisible(!isVisible); // Toggle isVisible state
    };

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
                <div className='flat'>
                    <div className='flat-head'>
                        <div className='flat-no'>Flat No: 1</div>
                        <div className='flat-detail-button' onClick={toggleVisibility}><SlArrowDown color="white" size="1.5rem"/></div>
                    </div>
                    <div className={`flat-detail-container ${isVisible ? 'visible' : 'hidden'}`}>
                        <div className="flat-details">
                            <div>
                                <div>Arpan</div>
                                <div>+91 11</div>
                                <div>arpan@gmail.com</div>
                            </div>
                            <div>
                                <div>Maintenance: $100</div>
                                <div>Status: paid</div>
                                <div>
                                    <input type="button" value="Add" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
      </div>
    </>
  )
}

export default Admin