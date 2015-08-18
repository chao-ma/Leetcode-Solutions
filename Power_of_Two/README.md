Given an integer, write a function to determine if it is a power of two.
```java
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        return (n & (n - 1)) == 0;
    }
}
```
