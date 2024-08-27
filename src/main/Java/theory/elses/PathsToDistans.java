package theory.elses;

public class PathsToDistans {
    public static void main(String[] args) {

        int[] paths = new int[]{9,1,4,9,0,4,8,9,0,1};
        pathsToDistance(paths);
    }

    public static void pathsToDistance(int[] paths){
        int cap = 0;
        for (int i = 0; i != paths.length; i++){
            //表示城市i距离首都的距离是i
            if (paths[i] == i){
                cap = i;
            }else if (paths[i] > -1){
                int curI = paths[i];
                paths[i] = -1;
                int preI = i;
                while (paths[curI] != curI){
                    if (paths[curI] > -1){
                        int nextI = paths[curI];
                        paths[curI] = preI;
                        preI = curI;
                        curI = nextI;
                    }else {
                        break;
                    }
                }
                int value = paths[curI] == curI ? 0 : paths[curI];
                while (paths[preI] != -1){
                    int lastPreI = paths[preI];
                    paths[preI] = --value;
                    curI = preI;
                    preI = lastPreI;
                }
                paths[preI] = --value;
            }
        }
        paths[cap] = 0;
    }
}
