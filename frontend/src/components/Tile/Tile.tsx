import { Grid } from '@mui/material';
import React, { FC } from 'react';

export const Tile: FC = ({ children }) => (
  <Grid
    item
    style={{
      alignItems: 'center',
      alignContent: 'center',
      justifyItems: 'center',
      justifyContent: 'center',
      width: '100%',
      height: '100%',
      padding: '10% 25% 5% 25%',
    }}
  >
    {children}
  </Grid>
);
