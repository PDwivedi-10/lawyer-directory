import React, { useState } from 'react';
import LawyerList from './components/LawyerList';
import Login from './components/Login';
import QueryForm from './components/QueryForm';

const App = () => {
  const [specialization, setSpecialization] = useState('criminal');
  const [selectedLawyer, setSelectedLawyer] = useState(null);

  return (
    <div>
      <h1>Lawyer Directory</h1>
      <Login />
      <LawyerList specialization={specialization} />
      {selectedLawyer && <QueryForm lawyerId={selectedLawyer.id} />}
    </div>
  );
};

export default App;
