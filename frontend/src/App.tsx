import './App.scss';
import { useState } from 'react';
import { Transformation } from './models';
import { TextTransformService } from './services';
import {
  Button,
  createTheme,
  Grid,
  TextField,
  ThemeProvider,
} from '@mui/material';
import { Option } from './components/TransformationSelect/utils';
import { TransformationSelect } from './components/TransformationSelect';
import { Tile } from './components/Tile';
import { Typography } from '@mui/material';

const theme = createTheme({
  typography: {
    fontFamily: ['Source Code Pro', 'monospace'].join(','),
  },
});

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
      <Tile>
        <Grid
          container
          spacing={2}
          style={{
            display: 'flex',
            flexDirection: 'column',
          }}
        >
          <Grid container item style={{ alignSelf: 'center' }}>
            <ThemeProvider theme={theme}>
              <Typography
                sx={{
                  fontSize: '2em',
                  color: 'black',
                }}
              >
                {'Text transformer'}
              </Typography>{' '}
              <Typography
                sx={{
                  fontSize: '2em',
                  color: 'rgb(86, 114, 96)',
                }}
              >
                .gamma
              </Typography>
            </ThemeProvider>
          </Grid>
          <Grid item>
            <TransformationSelect
              chips={selectedTransformationOptions}
              setChips={setSelectedTransformationOptions}
            />
          </Grid>
          <Grid item>
            <TextField
              fullWidth
              multiline={true}
              variant="outlined"
              placeholder="Put your text"
              onChange={({ target: { value } }) => setTransformee(value)}
            />
          </Grid>

          <Grid item>
            <TextField
              fullWidth
              disabled
              value={transformed}
              variant="outlined"
              placeholder="Result of transformation"
              multiline={true}
            />
          </Grid>
          <Grid item style={{ alignSelf: 'center' }}>
            <Button
              variant="contained"
              sx={{
                backgroundColor: 'rgb(61, 87, 70)',
                boxShadow: 'none',
                textTransform: 'none',
              }}
              onClick={handleClick}
            >
              <ThemeProvider theme={theme}>
                <Typography
                  sx={{
                    fontSize: '1em',
                    color: 'rgb(178, 191, 183)',
                  }}
                >
                  Let's transform
                </Typography>
              </ThemeProvider>
            </Button>
          </Grid>
        </Grid>
      </Tile>
    </div>
  );
};
