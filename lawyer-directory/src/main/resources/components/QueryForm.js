const QueryForm = ({ lawyerId }) => {
  const [userName, setUserName] = useState('');
  const [userMessage, setUserMessage] = useState('');
  const [responseMsg, setResponseMsg] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/api/queries/create', {
        lawyerId,
        userMessage,
        userName,
      });
      setResponseMsg(response.data);
    } catch (error) {
      console.error('Error submitting query:', error);
    }
  };

  return (
    <div>
      <h2>Send a Message to the Lawyer</h2>
      <input
        type="text"
        value={userName}
        onChange={(e) => setUserName(e.target.value)}
        placeholder="Your name"
      />
      <br />
      <textarea
        value={userMessage}
        onChange={(e) => setUserMessage(e.target.value)}
        placeholder="Your query..."
      ></textarea>
      <br />
      <button onClick={handleSubmit}>Submit Query</button>
      {responseMsg && <p>{responseMsg}</p>}
    </div>
  );
};
