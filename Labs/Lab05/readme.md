#### Lab 05
Ref https://stackoverflow.com/questions/4959098/efficient-implementation-of-multi-dimensional-arrays-in-java

##### duration[ms]    method

2739    2D array, loop on x then y

27920   2D array, loop on y then x

25119   mapped 1D array, access trough getter/setter

25167   mapped 1D array, access through computed indexes, loop y then x

1437    mapped 1D array, access through computed indexes, loop x then y

1607    mapped 1D array, access through computed indexes, loop x then y, yIndex optimized

*****
```java
public class ObjectArrayPerformance {
    public int width;
    public int height;
    public int m[];

    public ObjectArrayPerformance(int w, int h) {
            this.width = w;
            this.height = h;
            this.m = new int[w * h];
    }

    public int get(int x, int y) {
            return this.m[y * width + x];
    }

    public void set(int x, int y, int value) {
            this.m[y * width + x] = value;
    }

    public static void main (String[] args) {
            int w = 1000, h = 2000, passes = 400;

            int matrix[][] = new int[h][];

            for (int i = 0; i < h; ++i) {
                    matrix[i] = new int[w];
            }

            long start;
            long duration;

            System.out.println("duration[ms]\tmethod");

            start = System.currentTimeMillis();
            for (int z = 0; z < passes; z++) { //2689
                    for (int y = 0; y < h; y++) {
                        for (int x = 0; x < w; x++) {
                                    matrix[y][x] = matrix[y][x] + 1;
                            }
                    }
            }
            duration = System.currentTimeMillis() - start;
            System.out.println(duration+"\t2D array, loop on x then y");

            start = System.currentTimeMillis();
            for (int z = 0; z < passes; z++) { //28100
                    for (int x = 0; x < w; x++) {
                            for (int y = 0; y < h; y++) {
                                    matrix[y][x] = matrix[y][x] + 1;
                            }
                    }
            }
            duration = System.currentTimeMillis() - start;
            System.out.println(duration+"\t2D array, loop on y then x");

            //

            ObjectArrayPerformance mt = new ObjectArrayPerformance(w, h);
            start = System.currentTimeMillis();
            for (int z = 0; z < passes; z++) {//25132
                    for (int x = 0; x < w; x++) {
                            for (int y = 0; y < h; y++) {
                                    mt.set(x, y, mt.get(x, y) + 1);
                            }
                    }
            }
            duration = System.currentTimeMillis() - start;
            System.out.println(duration+"\tmapped 1D array, access trough getter/setter");

            //

            ObjectArrayPerformance mt2 = new ObjectArrayPerformance(w, h);
            start = System.currentTimeMillis();
            for (int z = 0; z < passes; z++) { //25136
                    for (int x = 0; x < w; x++) {
                            for (int y = 0; y < h; y++) {
                                    mt2.m[y * w + x] = mt2.m[y * w + x] + 1;
                            }
                    }
            }
            duration = System.currentTimeMillis() - start;
            System.out.println(duration+"\tmapped 1D array, access through computed indexes, loop y then x");

            ObjectArrayPerformance mt3 = new ObjectArrayPerformance(w, h);
            start = System.currentTimeMillis();
            for (int z = 0; z < passes; z++) { //1437
                    for (int y = 0; y < h; y++) {
                        for (int x = 0; x < w; x++) {
                                    mt3.m[y * w + x] = mt3.m[y * w + x] + 1;
                            }
                    }
            }
            duration = System.currentTimeMillis() - start;
            System.out.println(duration+"\tmapped 1D array, access through computed indexes, loop x then y");

            ObjectArrayPerformance mt4 = new ObjectArrayPerformance(w, h);
            start = System.currentTimeMillis();
            for (int z = 0; z < passes; z++) {//1613
                    for (int y = 0; y < h; y++) {
                        int yIndex = y * w;
                        for (int x = 0; x < w; x++) {
                                    mt4.m[yIndex + x] = mt4.m[yIndex + x] + 1;
                            }
                    }
            }
            duration = System.currentTimeMillis() - start;
            System.out.println(duration+"\tmapped 1D array, access through computed indexes, loop x then y, yIndex optimized");
    }
}
```
