import { Transformation } from '../../models';
import { Option } from './utils';

export const transformationOptions: Option<Transformation.AllowedRelation>[] = [
  {
    title: 'Identity',
    value: Transformation.AllowedRelation.Identity,
  },
  {
    title: 'Uppercase',
    value: Transformation.AllowedRelation.Uppercase,
  },
  {
    title: 'Lowercase',
    value: Transformation.AllowedRelation.Lowercase,
  },
  {
    title: 'Capitalize',
    value: Transformation.AllowedRelation.Capitalize,
  },
  {
    title: 'Shortcut expander',
    value: Transformation.AllowedRelation.ShortcutExpander,
  },
  {
    title: 'Shortcut collapser',
    value: Transformation.AllowedRelation.ShortcutCollapser,
  },
  {
    title: 'Repeat removal',
    value: Transformation.AllowedRelation.RepeatRemoval,
  },
  {
    title: 'Number to word',
    value: Transformation.AllowedRelation.NumberToWord,
  },
  {
    title: 'Cesar cipher',
    value: Transformation.AllowedRelation.CesarCipher,
  },
  {
    title: 'Inverse',
    value: Transformation.AllowedRelation.Inverse,
  },
];
