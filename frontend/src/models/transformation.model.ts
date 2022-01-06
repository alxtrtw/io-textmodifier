export module Transformation {
  export interface Model {
    transformations: string[];
    source: string;
    result: string;
  }

  export enum AllowedRelation {
    Identity = 'identity',
    Inverse = 'inverse',
    Uppercase = 'uppercase',
    Lowercase = 'lowercase',
    Capitalize = 'capitalize',
    ShortcutExpander = 'shortcut',
    RepeatRemoval = 'repeat-removal',
    NumberToWord = 'number-to-word',
  }
}
