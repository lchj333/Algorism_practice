import java.util.*;

class Solution {
    
    private static String PRINT_ENTER = "님이 들어왔습니다.";
    private static String PRINT_LEAVE = "님이 나갔습니다.";
    
    public String[] solution(String[] record) {

        Map<String, String> idMap = new HashMap<>();
        List<String[]> printList = new ArrayList<>();

        for(String input : record) {
            String[] items = input.split(" ");

            switch (items[0]) {
                case "Leave":
                    printList.add(new String[] {items[1], PRINT_LEAVE});
                    break;
                case "Enter":
                    printList.add(new String[] {items[1], PRINT_ENTER});
                case "Change":
                    idMap.put(items[1], items[2]);
                    break;
            }
        }

        int idx = 0;
        String[] answer = new String[printList.size()];
        for(String[] print : printList) {
            answer[idx++] = idMap.get(print[0]) + print[1];
        }

        return answer;
    }
}