package mystring;

public final class MyStringBuffer {
    private char[] value;
    private int n;
    public MyStringBuffer(int capacity){
        this.value=new char[capacity];
        this.n=0;
    }
    public MyStringBuffer(){
        this(16);
    }
    public MyStringBuffer(String s){
        this(s.length()+16);
        this.n=s.length();
        for(int i=0;i<this.n;i++){
            this.value[i]=s.charAt(i);
        }
    }
    public int length(){
        return this.n;
    }
    public int capacity(){
        return this.value.length;
    }
    public synchronized String toString(){
        return new String(this.value,0,this.n);
    }
    public synchronized char charAt(int i){
        char bufferChar=' ';
        if(i>=0&&i<this.value.length){
             bufferChar=this.value[i];
             return bufferChar;
        }else{
            return ' ';
        }
    }
    public void setCharAt(int i,char ch){
        if(i>=0&&i<this.value.length){
            value[i]=ch;
        }
    }
}
