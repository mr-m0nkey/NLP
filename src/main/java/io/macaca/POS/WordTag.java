package io.macaca.POS;

public class WordTag {

    private String word;
    private String tag;
    public String suggestedWord;

    public WordTag(String word, String tag) {
        this.word = word;
        this.tag = tag;
        suggestedWord = word;
    }

    public String getWord() {
        return word;
    }

    public String getTag() {
        return tag;
    }
}
