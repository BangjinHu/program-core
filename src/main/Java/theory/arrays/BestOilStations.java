package theory.arrays;

public class BestOilStations {

    public static void main(String[] args) {

    }

//    public boolean[] bestOilStations(int[] dis, int[] oil){
//        if (dis == null || oil == null || dis.length < 2 || dis.length != oil.length){
//            return null;
//        }
//
//        int init = changeDisArrayGetInit(dis, oil);
//        return init == -1 ? new boolean[dis.length] : enlargeArea(dis, init);
//    }
//
//    public int changeDisArrayGetInit(int[] dis, int[] oil){
//        int init = -1;
//        for (int i = 0; i < dis.length; i++){
//            //表示上一个加油站加的油能够跑到下一个加油站
//            dis[i] = oil[i] - dis[i];
//            if (dis[i] >= 0){
//                //这一个加油站可以作为良好出发点
//                init = 1;
//            }
//        }
//        return init;
//    }

//    public boolean[] enlargeArea(int[] dis, int init){
//        boolean[] result = new boolean[dis.length];
//        int start = init;
//        int end = nextIndex(init, dis.length);
//        int need = 0;
//        int rest = 0;
//        do {
//            //当前来到的start已经在连通区域中，可以确定后续的开始点一定无法转一圈
//            if (start != init && start == lastIndex(end, dis.length)){
//                break;
//            }
//
//            //当前来到的start不在连通区域中，就扩充连通区域
//            if (dis[start] < need){
//
//            }
//        }
//    }
}
