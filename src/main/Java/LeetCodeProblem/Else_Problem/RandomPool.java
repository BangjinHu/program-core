package LeetCodeProblem.Else_Problem;

import java.util.HashMap;

public class RandomPool<K> {
    private HashMap<K, Integer> keyIndexMap;
    private HashMap<Integer, K> indexKeyMap;
    private int size;

    public RandomPool() {
        this.keyIndexMap = new HashMap<>();
        this.indexKeyMap = new HashMap<>();
        this.size = 0;
    }

    public void insert(K key){
        if (!this.keyIndexMap.containsKey(key)){
            this.keyIndexMap.put(key, this.size);
            this.indexKeyMap.put(this.size++, key);
        }
    }

    public void delete(K key){
        //keyIndexMap中包括key，则拿到key对应map中的下标
        if (this.keyIndexMap.containsKey(key)){
            int deleteIndex = this.keyIndexMap.get(key);
            //然后最后的下标值减一
            int lastIndex = --this.size;

            //最后下标值所对应的key
            K lastKey = this.indexKeyMap.get(lastIndex);
            //将要删除的index放到最后的key位置
            this.keyIndexMap.put(lastKey, deleteIndex);
            this.indexKeyMap.put(deleteIndex, lastKey);

            //分别在两个数组中删除
            this.keyIndexMap.remove(key);
            this.indexKeyMap.remove(lastIndex);
        }
    }

    public K getRandom(){
        if (this.size == 0){
            return null;
        }
        //随机的index，然后拿到该index对应的indexKeyMap中的数
        int randomIndex = (int) (Math.random() * this.size);
        return this.indexKeyMap.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomPool<Integer> randomPool = new RandomPool<>();

    }
}
