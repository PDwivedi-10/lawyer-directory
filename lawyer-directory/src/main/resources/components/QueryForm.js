import React, { useState } from 'react';
import axios from 'axios';

const QueryForm = ({ lawyerId }) => {
  const [userMessage, setUserMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/api/queries/create', {
        lawyerId,
        userMessage,
        status: 'PENDING',
      });
      console.log('Query submitted:', response.data);
    } catch (error) {
      console.error('Error submitting query:', error);
    }
  };

  return (
    <div>
      <h2>Send a Message to Lawyer</h2>
      <textarea
        value={userMessage}
        onChange={(e) => setUserMessage(e.target.value)}
        placeholder="Your query..."
      ></textarea>
      <button onClick={handleSubmit}>Submit Query</button>
    </div>
  );
};

export default QueryForm;
