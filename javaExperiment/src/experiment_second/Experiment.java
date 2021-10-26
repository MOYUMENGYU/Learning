package experiment_second;

import java.io.*;
import java.util.Arrays;

public class Experiment {
    FileInputStream inputStream;
    FileOutputStream outputStream;
    FileReader reader;
    FileWriter writer;
    public void userFileStream(){
        try {
            inputStream=new FileInputStream("F:\\io\\file.txt");
            byte[] buffer=new byte[1024];
            int i=0;
            String message="";
            while((i=inputStream.read(buffer))!=-1){
                message+=new String(buffer,0,i);
            }
            System.out.println(message);
            outputStream=new FileOutputStream("F:\\io\\file1.txt",true);
            outputStream.write(message.getBytes());
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void userRw(){
        try {
            reader=new FileReader("F:\\io\\file.txt");
            char[] buffer=new char[1024];
            int i=0;
            String message="";
            while((i=reader.read(buffer))!=-1){
                message+=new String(buffer,0,i);
            }
            System.out.println(message);
            writer=new FileWriter("F:\\io\\file1.txt",true);
            writer.write(message);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void userBuffer(){
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader("F:\\io\\file.txt"));
            String message="";
            String temp="";
            while((temp=bufferedReader.readLine())!=null){
                message+=temp+"\n";
            }
            System.out.println(message);
            String [] sort=message.split("[^\\d]+");
            int total=0;
            for(String item:sort){
                if(!item.equals("")){
                    total+=Integer.parseInt(item);
                }
            }
            String average="总分"+total+"分，平均分"+total/3+"分";
            System.out.println(average);
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("F:\\io\\file.txt",true));
            bufferedWriter.write(average);
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void useRandom(){
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile("F:\\io\\a.txt","r");
            long end=randomAccessFile.length();
            String message="";
            for(long i=end-1;i>=0;i--){
                randomAccessFile.seek(i);
                System.out.print((char)randomAccessFile.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Experiment exp=new Experiment();
//        exp.userFileStream();
//        exp.userRw();
//        exp.userBuffer();
        exp.useRandom();
    }


}
