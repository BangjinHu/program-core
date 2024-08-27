package theory.arrays;

public class BuildingOutLineValidate {
    public static void main(String[] args) {
        BuildingOutLine buildingOutLine = new BuildingOutLine();
        int[][] matrix = new int[][]{{2,5,6},{1,7,4},{4,6,7},{3,6,5},{10,13,2},{9,11,3},{12,14,4},{10,12,5}};

        System.out.println("轮廓线是：" + buildingOutLine.buildingOutLine(matrix));
    }

}
