const LawyerList = ({ specialization, onSelectLawyer }) => {
  const [lawyers, setLawyers] = useState([]);

  useEffect(() => {
    const fetchLawyers = async () => {
      try {
        const response = await axios.get(`/api/lawyers/specialization/${specialization}`);
        setLawyers(response.data);
      } catch (error) {
        console.error('Error fetching lawyers:', error);
      }
    };
    fetchLawyers();
  }, [specialization]);

  return (
    <div>
      <h3>Lawyers specializing in {specialization}</h3>
      <ul>
        {lawyers.map((lawyer) => (
          <li key={lawyer.id}>
            <h4>{lawyer.name}</h4>
            <p>Expertise: {lawyer.expertise}</p>
            <p>Email: {lawyer.email}</p>
            <button onClick={() => onSelectLawyer(lawyer)}>Chat / Contact</button>
          </li>
        ))}
      </ul>
    </div>
  );
};
