import java.util.*;

class Solution {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extBy = getIndexByName(ext);
        int sortBy = getIndexByName(sort_by);

        return Arrays.stream(data).filter(D -> D[extBy] < val_ext).sorted((A, B) -> A[sortBy] - B[sortBy]).toArray(int[][]::new);
    }
    
    public int getIndexByName(String name) {
        return switch (name) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> -1;
        };
    }
}