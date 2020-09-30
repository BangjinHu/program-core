package LeetCodeProblem.Else_Problem;

public class TopKRecordValidate {
    public static void main(String[] args) {
        int size = 5;
        String[] arr = new String[]{"a", "b", "c", "d", "b", "c", "d"};
        String str = "bangjinhu";
        TopKRecord topKRecord = new TopKRecord(size);
        topKRecord.add(str);
        topKRecord.printTopK();
    }
}
