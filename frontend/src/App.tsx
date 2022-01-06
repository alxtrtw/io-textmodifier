import './App.scss';
import { useState } from 'react';
import { Transformation } from './models';
import { TextTransformService } from './services';
import AllowedRelation = Transformation.AllowedRelation;

const App = () => {
  const [transformParams, setTransformParams] = useState('');

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
          const data = await TextTransformService.transform(transformParams, [
            AllowedRelation.Identity,
          ]);
          console.log({ data });
        }}
      >
        click me
      </button>
    </div>
  );
};

export default App;
