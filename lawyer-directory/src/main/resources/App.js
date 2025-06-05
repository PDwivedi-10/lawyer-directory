import React, { useState } from 'react';
import LawyerList from './components/LawyerList';
import QueryForm from './components/QueryForm';

const App = () => {
  const [specialization, setSpecialization] = useState('criminal');
  const [selectedLawyer, setSelectedLawyer] = useState(null);

  return (
    <div>
      <h1>Lawyer Directory</h1>
      <select value={specialization} onChange={(e) => setSpecialization(e.target.value)}>
        <option value="criminal">Criminal</option>
        <option value="civil">Civil</option>
        <option value="corporate">Corporate</option>
      </select>

      <LawyerList specialization={specialization} onSelectLawyer={setSelectedLawyer} />

      {selectedLawyer && <QueryForm lawyerId={selectedLawyer.id} />}
    </div>
  );
};

export default App;