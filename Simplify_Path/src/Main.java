import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        String retValue = "";
        for (String dir: dirs) {
            if (dir.length() > 0) {
                if (dir.equals(".")) {
                    continue;
                } else if (dir.equals("..")) {
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                } else {
                    stack.push(dir);
                }
            }
        }
        while (stack.size() > 0) {
            retValue = "/" + stack.pop() + retValue;
        }
        if (retValue.length() == 0) {
            retValue = "/";
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String path = "/a/b/c/../../..";
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath(path));
    }

}
