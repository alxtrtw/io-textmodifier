package pl.put.poznan.transformer.logic;

import java.util.Hashtable;

public class PolishDictionary {
    private final Hashtable<String, String> dict = new Hashtable<String, String>();
    private final Hashtable<String, String> tenDict = new Hashtable<String, String>();
    private final Hashtable<String, String> hundredDict = new Hashtable<String, String>();

    public PolishDictionary()
    {
        dict.put("0", "Zero");
        dict.put("1", "Jeden");
        dict.put("2", "Dwa");
        dict.put("3", "Trzy");
        dict.put("4", "Cztery");
        dict.put("5", "Pięć");
        dict.put("6", "Sześć");
        dict.put("7", "Siedem");
        dict.put("8", "Osiem");
        dict.put("9", "Dzwięć");

        tenDict.put("10", "Dziesięć");
        tenDict.put("11", "Jedenaście");
        tenDict.put("12", "Dwanaście");
        tenDict.put("13", "Trzynaście");
        tenDict.put("14", "Czternaście");
        tenDict.put("15", "Piętaście");
        tenDict.put("16", "Szesnaście");
        tenDict.put("17", "Siedemnaście");
        tenDict.put("18", "Osiemnaście");
        tenDict.put("19", "Dziewietnaście");
        tenDict.put("2", "Dzwadzieścia");
        tenDict.put("3", "Trzydzieści");
        tenDict.put("4", "Czterdzieści");
        tenDict.put("5", "Pięćdziesiąt");
        tenDict.put("6", "Sześćdziesiąt");
        tenDict.put("7", "Siedemdziesiąt");
        tenDict.put("8", "Osiemdziesiąt");
        tenDict.put("9", "Dziewięćdziesiąt");
        hundredDict.put("1", "Sto");
        hundredDict.put("2", "Dwieście");
        hundredDict.put("3", "Trzysta");
        hundredDict.put("4", "Czterysta");
        hundredDict.put("5", "Pięćset");
        hundredDict.put("6", "Sześćset");
        hundredDict.put("7", "Siedemset");
        hundredDict.put("8", "Osiemset");
        hundredDict.put("9", "Dziewięćset");
        hundredDict.put("1", "Tysiąc");

    }
    public Hashtable<String, String> getDict(){
        return this.dict;
    }
    public Hashtable<String, String> getTenDict(){
        return this.dict;
    }
    public Hashtable<String, String> getHundredDict(){
        return this.dict;
    }
}
