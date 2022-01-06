import axios from 'axios';
import { Transformation } from '../models';
import { parseApiResponse } from './utils';

const ApiUrl = 'http://localhost:8080/api';

interface Service {
  transform: (
    text: string,
    transformations: Transformation.AllowedRelation[],
  ) => Promise<Transformation.Model>;
}

export const TextTransformService: Service = {
  transform: (text, transformations) =>
    axios
      .post<Transformation.Model>(`${ApiUrl}/${text}`, transformations)
      .then(parseApiResponse),
};
