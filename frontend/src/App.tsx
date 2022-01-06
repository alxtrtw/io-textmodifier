import './App.scss';
import { useState } from 'react';
import { Transformation } from './models';
import { TextTransformService } from './services';
import { Button, Grid, TextField } from '@mui/material';
import { Option } from './components/TransformationSelect/utils';
import { TransformationSelect } from './components/TransformationSelect';

export const App = () => {
  const [selectedTransformationOptions, setSelectedTransformationOptions] =
    useState<Option<Transformation.AllowedRelation>[]>([]);
  const [transformed, setTransformed] = useState('');
  const [transformee, setTransformee] = useState('');

  const handleClick = () =>
    TextTransformService.transform(
      transformee,
      selectedTransformationOptions.map(({ value }) => value),
    ).then((response) => setTransformed(response.result));

  return (
    <div className="App">
      <Grid container spacing={2}>
        <Grid item xs={6}>
          <TransformationSelect
            chips={selectedTransformationOptions}
            setChips={setSelectedTransformationOptions}
          />
        </Grid>
        <Grid item xs={6}>
          <TextField
            fullWidth
            variant="outlined"
            placeholder="Transformee"
            onChange={({ target: { value } }) => setTransformee(value)}
          />
        </Grid>
        <Grid item xs={6}>
          <TextField
            disabled
            value={transformed}
            variant="outlined"
            placeholder="Here will be your transformed value"
          />
        </Grid>
        <Grid item xs={6}>
          <Button variant="contained" onClick={handleClick}>
            Transform!
          </Button>
        </Grid>
      </Grid>
    </div>
  );
};
