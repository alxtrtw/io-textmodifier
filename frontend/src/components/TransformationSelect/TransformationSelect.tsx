import { Autocomplete, Chip, TextField } from '@mui/material';
import { transformationOptions } from './values';
import { Option } from './utils';
import { Transformation } from '../../models';
import RemoveIcon from '@mui/icons-material/DeleteOutline';
import { VFC } from 'react';

interface Props {
  chips: Option<Transformation.AllowedRelation>[];
  setChips: (chips: Option<Transformation.AllowedRelation>[]) => void;
}

export const TransformationSelect: VFC<Props> = ({ chips, setChips }) => {
  const renderChips = () =>
    chips.map(({ value, title }: Option<Transformation.AllowedRelation>) => (
      <Chip
        key={title}
        label={title}
        onDelete={() => setChips(chips.filter((chip) => chip.value !== value))}
        deleteIcon={<RemoveIcon />}
      />
    ));

  return (
    <Autocomplete
      options={transformationOptions}
      getOptionLabel={(option) => option.title}
      renderTags={renderChips}
      onChange={(_, chips) => {
        setChips(chips as Option<Transformation.AllowedRelation>[]);
      }}
      value={chips}
      renderInput={(params) => (
        <TextField
          {...params}
          variant="outlined"
          placeholder="Transformations"
          fullWidth
        />
      )}
      multiple
      fullWidth
      freeSolo
      filterSelectedOptions
    />
  );
};
