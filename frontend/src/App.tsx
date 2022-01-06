import axios from 'axios';
import './App.css';
import { useCallback, useState } from 'react';

interface TransformationModel {
  transformations: string[];
  source: string;
  result: string;
}

const App = () => {
  const [transformParams, setTransformParams] = useState('');

  const handleClick = useCallback(async () => {
    axios
      .get<TransformationModel>(`http://localhost:8080/api/${transformParams}`)
      .then(({}) => {});
  }, [transformParams]);

  return (
    <div className="App">
      <div>
        <label>
          Transformation:
          <input
            onChange={({ target: { value } }) => setTransformParams(value)}
          />
        </label>
      </div>
      <button
        onClick={async () => {
          console.log(`clicked with ${transformParams}`);
          const data = await handleClick();
          console.log({ data });
        }}
      >
        click me
      </button>
    </div>
  );
};

export default App;
