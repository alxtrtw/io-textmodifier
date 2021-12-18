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
        dict.put("10", "Dziesięć");
        dict.put("11", "Jedenaście");
        dict.put("12", "Dwanaście");
        dict.put("13", "Trzynaście");
        dict.put("14", "Czternaście");
        dict.put("15", "Piętaście");
        dict.put("16", "Szesnaście");
        dict.put("17", "Siedemnaście");
        dict.put("18", "Osiemnaście");
        dict.put("19", "Dziewietnaście");

        tenDict.put("20", "Dzwadzieścia");
        tenDict.put("30", "Trzydzieści");
        tenDict.put("40", "Czterdzieści");
        tenDict.put("50", "Pięćdziesiąt");
        tenDict.put("60", "Sześćdziesiąt");
        tenDict.put("70", "Siedemdziesiąt");
        tenDict.put("80", "Osiemdziesiąt");
        tenDict.put("90", "Dziewięćdziesiąt");
        hundredDict.put("100", "Sto");
        hundredDict.put("200", "Dwieście");
        hundredDict.put("300", "Trzysta");
        hundredDict.put("400", "Czterysta");
        hundredDict.put("500", "Pięćset");
        hundredDict.put("600", "Sześćset");
        hundredDict.put("700", "Siedemset");
        hundredDict.put("800", "Osiemset");
        hundredDict.put("900", "Dziewięćset");
        hundredDict.put("1000", "Tysiąc");

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
