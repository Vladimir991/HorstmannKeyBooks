package ChapterTwelve.GenericProgramming.PairOne;

public class PairTestOne {
    public static void main(String[] args) {
        String[] words = {"I", "love", "to", "teach", "English!"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}
