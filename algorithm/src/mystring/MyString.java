package mystring;

import java.io.Serializable;
import java.util.Arrays;

public final class MyString implements Comparable<MyString>, Serializable {

    private final char[] value;
    public MyString(){
        this.value=new char[0];//空串
    }
    public MyString(String s){
        this.value=new char[s.length()];
        for(int i=0;i<value.length;i++){
            value[i]=s.charAt(i);
        }
    }
    public MyString(char[] value,int i,int n){
        if(i>=0&&n>=0&&i+n<=value.length){
            this.value=new char[n];
            for(int j=0;j<n;j++){
                this.value[j]=value[i+j];//从i开始，并往下移动
            }
        }else{
            throw new StringIndexOutOfBoundsException("下标越界");
        }
    }
    public MyString(char[] value){
        this.value=value;
    }
    public MyString(MyString myString){
        this(myString.value);
    }
    public int length(){
        return this.value.length;
    }
    public String toString(){
        return new String(this.value);
    }
    public char charAt(int i){
        if(i>=0&&i<this.value.length){
            return this.value[i];
        }else{
            throw new StringIndexOutOfBoundsException(i);
        }
    }
    public MyString subString(int begin,int end){
        if(begin==0&&this.value.length==end){
            return this;
        }else{
            return new MyString(this.value,begin,end-begin);
        }
    }
    public MyString subString(int begin){
        return subString(begin,this.value.length);
    }
    public MyString concat(MyString s){
        if(s==null||s.equals("")){
            s=new MyString(this.value);
        }
        char[]buffer=new char[this.value.length+s.value.length];
        int i=0;
        for(i=0;i<this.value.length;i++){
            buffer[i]=this.value[i];
        }
        for(int j=0;j<s.value.length;j++){
            buffer[i+j]=s.value[j];
        }
        return new MyString(buffer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        if(this.value.length==myString.value.length){
            for(int i=0;i<value.length;i++){
                if(this.value[i]!=myString.value[i]){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
    public int compareTo(MyString s){
        for(int i=0;i<this.value.length&&i<s.value.length;i++){
            if(this.value[i]!=s.value[i]){
                return this.value[i]-s.value[i];
            }
        }
        return this.value.length-s.value.length;
    }
    public MyString trim(){
        char[] buffer=new char[this.value.length];
        int n=0;
        for(int i=0;i<this.value.length;i++){
            if(this.value[i]!=' '){
                buffer[n++]=this.value[i];
            }
        }
        return new MyString(buffer);
    }
    public MyString insert(int i,String s){
      MyString myString=this.subString(0,i).concat(new MyString(s)).concat(subString(i));
      return myString;
    }
    public MyString delete(int begin,int end){
        MyString myString=subString(0,begin).concat(subString(end));
        return myString;
    }
    public static int[] getNext(String pattern){
        int j=0;
        int k=-1;
        int[] next=new int[pattern.length()];
        while(j<pattern.length()-1){
            if(k==-1||pattern.charAt(j)==pattern.charAt(k)){
                j++;
                k++;
                if(pattern.charAt(j)==pattern.charAt(k)){
                    next[j]=next[k];
                }else{
                    next[j]=k;
                }
                System.out.println(j+" "+k+" "+next[j]);
            }else{
                k=next[k];
            }
        }
        return next;
    }
    public static int indexOf(String target,String pattern){
        return indexOf(target,pattern,0);
    }
    public static int indexOf(String target,String pattern,int begin){
        int n=target.length();
        int m=pattern.length();
        if(begin<0){
            begin=0;
        }
        if(n==0||n<m||begin>=n){
            return -1;
        }
        int[] next=getNext(pattern);
        int i=begin;
        int j=0;
        while(i<n&&j<m){
            if(j==-1||target.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
                if(n-i+1<m-j+1){
                    break;
                }
            }
        }
        return j==m?i-m:-1;
    }
    public static String reverse(String s){
        char[] value=s.toCharArray();
        int sum=s.length()%2==0?s.length()/2+1:s.length()/2;
        char temp=' ';
        for(int i=0;i<sum;i++){
            temp=value[i];
            value[i]=value[value.length-1-i];
            value[value.length-1-i]=temp;
        }
        return new String(value);
    }
    public static String reverse2(String str){
        char[] buffer=new char[str.length()];
        for(int i=0;i<str.length();i++){
            buffer[str.length()-i-1]=str.charAt(i);
        }
        return new String(buffer);
    }
    public static String reverse1(String str){
        String temp="";
        for(int i=0;i<str.length();i++){
            temp=str.substring(i,i+1)+temp;
        }
        return temp;
    }
    public static void main(String[] args) {
        char[] value={'c','h','i','n','a'};
        MyString myString=new MyString(value);
        System.out.println(myString);
        System.out.println(myString.delete(2,3));
        String s=MyString.reverse("chinaq");
        System.out.println(s);

    }
}
