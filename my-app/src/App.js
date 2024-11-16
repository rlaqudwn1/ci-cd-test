import React, { useState } from 'react';
import './App.css';

function App() {
  const [facilityName, setFacilityName] = useState('');
  const [facilityData, setFacilityData] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleFetchData = async () => {
    setLoading(true);
    try {
        const response = await fetch(`http://backend-test-env.eba-r2dhmebz.ap-northeast-2.elasticbeanstalk.com/api/sport-facility?facilityName=${facilityName}`);
      const data = await response.json();
      setFacilityData(data);
    } catch (error) {
      console.error('Error fetching data:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
      <div className="App">
        <h1>스포츠 시설 정보</h1>
        <input
            type="text"
            value={facilityName}
            onChange={(e) => setFacilityName(e.target.value)}
            placeholder="시설 이름 입력"
        />
        <button onClick={handleFetchData} disabled={loading}>
          {loading ? '로딩 중...' : '정보 가져오기'}
        </button>

        {facilityData && (
            <div>
              <h2>결과</h2>
              <pre>{JSON.stringify(facilityData, null, 2)}</pre>
            </div>
        )}
      </div>
  );
}

export default App;