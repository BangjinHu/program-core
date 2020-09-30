package LeetCodeProblem.Else_Problem;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFindSet {
    public static void main(String[] args) {

    }

    public class Element<V> {
        private V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public class UnionFoundSet<V> {
        public HashMap<V, Element<V>> elementHashMap;
        public HashMap<Element<V>, Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> rankMap;

        public UnionFoundSet(List<V> list) {
            elementHashMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            //首先遍历整个list集合
            for (V value : list){
                //然后重新建立Element集合，value = value
                Element<V> element = new Element<>(value);
                elementHashMap.put(value, element);
                fatherMap.put(element, element);
                rankMap.put(element, 1);
            }
        }

        private Element<V> findHead(Element<V> element){
            Stack<Element<V>> path = new Stack<>();
            //该节点还存在父节点，则将该节点push到path中去
            while (element != fatherMap.get(element)){
                path.push(element);
                element = fatherMap.get(element);
            }
            //将所有的根节点的子节点压入map中
            while (!path.isEmpty()){
                fatherMap.put(path.pop(), element);
            }
            //返回根节点
            return element;
        }

        public boolean isSameSet(V a, V b){
            if (elementHashMap.containsKey(a) && elementHashMap.containsKey(b)){
                //那么就看两者是否是有同一个根节点
                return findHead(elementHashMap.get(a)) == findHead(elementHashMap.get(b));
            }
            return false;
        }
        //表示两个集合的联合
        public void union(V a, V b){
            //两节点是否在elementHashMap中，如果在的话再看两者是否是同一个头结点
            if (elementHashMap.containsKey(a) && elementHashMap.containsKey(b)){
                Element<V> aF = findHead(elementHashMap.get(a));
                Element<V> bF = findHead(elementHashMap.get(b));
                //如果两个的代表头结点不一致，则不再同一个集合里面
                if (aF != bF){
                    //比较两个代表头结点的集合节点个数
                    Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    //将两者联结到大的那个根下面
                    rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                    //然后移除小的那个子集合
                    rankMap.remove(small);
                }
            }
        }
    }


}
