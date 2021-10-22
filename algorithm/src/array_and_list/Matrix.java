package array_and_list;

import java.util.Arrays;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] element;
    private static final int MIN_CAPACITY = 6;//最小行数和列数

    public Matrix(int m, int n) {
        if (m >= 0 && n >= 0) {
            this.rows = m;
            this.columns = n;
            if (m < MIN_CAPACITY) {
                m = MIN_CAPACITY;
            }
            if (n < MIN_CAPACITY) {
                n = MIN_CAPACITY;
            }
            element = new int[m][n];
        } else {
            throw new IllegalArgumentException("矩阵列数不能<0,m=" + m + ",n=" + n);
        }
    }

    public Matrix(int n) {
        this(n, n);
    }

    public Matrix() {
        this(0, 0);
    }

    public Matrix(int m, int n, int[][] values) {
        this(m, n);
        for (int i = 0; i < values.length && i < m; i++) {//i从零开始，m从1开始，values.length为行数
            for (int j = 0; j < values[i].length && j < n; j++) {
                element[i][j] = values[i][j];
            }
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public int get(int i, int j) {
        if (i >= 0 && i < this.rows && j >= 0 && j < columns) {
            return element[i][j];
        } else {
            throw new IndexOutOfBoundsException("i=" + i + ",j=" + j);
        }
    }

    public void set(int i, int j, int x) {
        if (i >= 0 && i < this.rows && j >= 0 && j < columns) {
            element[i][j] = x;
        } else {
            throw new IndexOutOfBoundsException("i=" + i + ",j=" + j);
        }
    }

    public String toString() {
        String str = "矩阵" + this.getClass().getName() + "(" + this.rows + "x" + this.columns + "):\n";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                str += String.format("%6d", this.element[i][j]);
            }
            str += "\n";
        }
        return str;
    }

    public void setRowsColumns(int m, int n) {
        if (m > 0 && n > 0) {
            if (m > this.element.length || n > this.element[0].length) {
                int[][] source = this.element;
                this.element = new int[m * 2][n * 2];
                for (int i = 0; i < this.rows; i++) {
                    for (int j = 0; j < this.columns; j++) {
                        this.element[i][j] = source[i][j];
                    }
                }
            }
            this.rows = m;
            this.columns = n;
        } else {
            throw new IllegalArgumentException("矩阵行列数不能<0,m=" + m + ",n=" + n);
        }
    }

    public void addAll(Matrix mat) {
        if (this.rows == mat.rows && this.columns == mat.columns) {
            for (int i = 0; i < this.element.length; i++) {
                for (int j = 0; j < this.element[0].length; j++) {
                    this.element[i][j] = this.element[i][j] + mat.element[i][j];
                }
            }
        } else {
            throw new IllegalArgumentException("相加矩阵行数和列数与目标行数不相同,无法相加");
        }
    }

    public void subtract(Matrix mat) {
        if (this.rows == mat.rows && this.columns == mat.columns) {
            for (int i = 0; i < this.element.length; i++) {
                for (int j = 0; j < this.element[0].length; j++) {
                    this.element[i][j] = this.element[i][j] - mat.element[i][j];
                }
            }
        } else {
            throw new IllegalArgumentException("相加矩阵行数和列数与目标行数不相同,无法相加");
        }
    }

    public void multiply(Matrix mat) {
        if (this.columns == mat.rows) {
            int[][] source = this.element;
            this.element = new int[this.element.length][mat.element[0].length];
            this.columns = mat.columns;
            for (int i = 0; i < this.rows; i++) {//前一个矩阵的行
                for (int j = 0; j < mat.columns; j++) {//后一个矩阵的列
                    int sum = 0;
                    for (int z = 0; z < mat.rows; z++) {//连接两个矩阵的前一个列，后一个的行
                        sum += source[i][z] * mat.element[z][j];
                    }
                    this.element[i][j] = sum;
                }
            }
        } else {
            throw new IllegalArgumentException("相乘矩阵的行数不等于目标矩阵的列数，无法相乘");
        }
    }

    public void transpose() {
        int[][] source = this.element;
        this.element = new int[this.element[0].length][this.element.length];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.element[i][j] = source[j][i];
            }
        }
    }

    public void transpose1() {
        int temp = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns && j < i; j++) {
                temp = this.element[i][j];
                this.element[i][j] = this.element[j][i];
                this.element[j][i] = temp;
            }
        }
    }
    public int[] linearCompressLow(Matrix mat){
        int count=(mat.element[0].length+1)*mat.element[0].length/2;
        int[] compress=new int[count];
        for(int i=0;i<this.element.length;i++){
            for(int j=0;j<this.element[0].length&&j<=i;j++){
                compress[i*(i+1)/2+j]=this.element[i][j];
            }
        }
        return compress;
    }
    public int[] linearCompressUp(Matrix mat){
        int count=(mat.element[0].length+1)*mat.element[0].length/2;
        int[] compress=new int[count];
        for(int j=0;j<this.element[0].length;j++){
            for(int i=0;i<this.element.length&&j>=i;i++){
                compress[j*(j+1)/2+i]=this.element[i][j];
            }
        }
        return compress;
    }
    public int[][] twoDimensionalArrayCompressLow(Matrix mat){
        int[][] compress=new int[mat.element.length][];
        for(int i=0;i<this.element.length;i++){
            int[] line=new int[i+1];
            for(int j=0;j<this.element[0].length&&j<=i;j++){
                line[j]=this.element[i][j];
            }
            compress[i]=line;
        }
        return compress;
    }
    public int[][] twoDimensionalArrayCompressUp1(Matrix mat){
        int[][] compress=new int[mat.element[0].length][];
        for(int j=0;j<this.element[0].length;j++){
            int[] line=new int[j+1];
            for(int i=0;i<this.element.length&&j>=i;i++){
                line[i]=this.element[i][j];
            }
            compress[j]=line;
        }
        return compress;
    }
    public int[][] twoDimensionalArrayCompressUp2(Matrix mat){
        int[][] compress=new int[mat.element.length][];
        for(int i=0;i<this.element.length;i++){
            int[] line=new int[mat.element[0].length-i];
            for(int j=this.element[0].length-1-i;j>=i;j--){
                line[j]=this.element[i][j];
            }
            compress[i]=line;
        }
        return compress;
    }
    public int[] symmetricCompress(Matrix mat){
        int count=(mat.element.length+1)*mat.element.length/2;
        int[] compress=new int[count];
        for(int i=0;i<mat.element.length;i++){
            for(int j=0;j<mat.element[0].length&&j<=i;j++){
                compress[i*(i+1)/2+j]=mat.element[i][j];
            }
        }
        return compress;
    }
    public static void main(String[] args) {
//        int[][] value = {{7, 8, 9}, {0, 4,5}, {0, 0, 9}};
        int[][] value = {{1,0,0}, {2,3,0}, {4,5,6}};
        Matrix matrix = new Matrix(3, 3, value);
        int[] compress=matrix.symmetricCompress(matrix);
        System.out.println(matrix.toString());
        System.out.println(Arrays.toString(compress));
//        for(int i=0;i<3;i++){
//            System.out.println(Arrays.toString(compress[i]));
//        }
    }
}
