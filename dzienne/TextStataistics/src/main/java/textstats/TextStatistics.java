package textstats;

public class TextStatistics {

    private final TextFileDocument doc;

    public TextStatistics(TextFileDocument doc){
        this.doc = doc;
    }
    
    long countSymbols(){
        return 0;
    }

    long countUniqueSymbols(){
        return 0;
    }

    //Zlicz spacje, entery, twarde spacje, itp.
    long countBlankElements(){
        return 0;
    }

    long countVowels(){
        return 0;
    }

}
