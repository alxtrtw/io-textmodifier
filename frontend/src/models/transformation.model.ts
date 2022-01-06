export module Transformation {
  export interface Model {
    transformations: string[];
    source: string;
    result: string;
  }

  export enum AllowedRelation {
    Identity = 'identity',
    Uppercase = 'uppercase',
    Lowercase = 'lowercase',
    NumberToWord = 'number-to-word',
    ShortcutExpander = 'shortcut-ex',
    ShortcutCollapser = 'shortcut-co',
    Capitalize = 'capitalize',
    RepeatRemoval = 'repeat-removal',
    Inverse = 'inverse',
    CesarCipher = 'cesar-cipher',
  }
}
