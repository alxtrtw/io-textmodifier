import { AxiosResponse } from 'axios';

export const parseApiResponse = <T>({ data }: AxiosResponse<T>) => data;

