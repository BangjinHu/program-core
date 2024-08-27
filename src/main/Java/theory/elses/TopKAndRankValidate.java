package theory.elses;

public class TopKAndRankValidate {

    public static void main(String[] args) {
        TopKAndRank topKAndRank = new TopKAndRank();
        String[] arr = new String[]{"a", "b", "c", "d", "b", "c", "d"};
        int topK = 3;
        topKAndRank.topKAndRank(arr, topK);
    }
}
