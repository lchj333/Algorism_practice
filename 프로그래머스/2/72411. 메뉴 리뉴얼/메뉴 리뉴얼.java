import java.util.*;

class Solution {
    
    private static Map<String, Integer> courseMap = new HashMap<>();
    private static int[] maxCntArray;

    public String[] solution(String[] orders, int[] course) {
        maxCntArray = new int[course[course.length - 1] + 1];
        List<String> reusltCourseList = new ArrayList<>();

        for(String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);

            dfs("", course, chars, 0);
        }

        // System.out.println(courseMap);
        // System.out.println(Arrays.toString(maxCntArray));

        Iterator<String> its;
        for(int i = 0; i < course.length; i++) {
            its = courseMap.keySet().iterator();
            int maxCnt = maxCntArray[course[i]];
            if(maxCnt > 1) {
                while(its.hasNext()) {
                    String it = its.next();
                    int cnt =  courseMap.get(it);

                    if(cnt < 2) {
                        its.remove();
                    }

                    if(it.length() == course[i] && maxCnt == cnt) {
                        reusltCourseList.add(it);
                        its.remove();
                    }

                }
            }
        }

        String[] answer = reusltCourseList.toArray(new String[] {});
        Arrays.sort(answer);
        return answer;
    }

    public void dfs(String result, int[] course, char[] order, int idx) {
        
        for(int c : course) {
            if (result.length() == c) {
                //System.out.println(result);
                courseMap.put(result, courseMap.getOrDefault(result, 0) + 1);
                maxCntArray[c] = Math.max(maxCntArray[c], courseMap.get(result));
            }
        }

        if(result.length() >= course[course.length - 1]) {
            return;
        }

        for(int i = idx; i < order.length; i++) {
            dfs(result+order[i], course, order, i+1);
        }
    }
}