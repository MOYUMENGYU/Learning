package stack;

public class Match {
    //检查left和rigth是否匹配
    public static String check(String target,String left,String right){
        //创建空栈
        Stack<String> stack=new SeqStack<>();
        int i=0;
        char ch=' ';
        //遍历完字符串对象
        while(i<target.length()){
            while(i<target.length()&&(ch=target.charAt(i))!=left.charAt(0)&&ch!=right.charAt(0)){
                i++;
                System.out.println(i);
            }
            if(target.indexOf(left,i)==i){
                stack.push(left);
                i+=left.length();
            }else if(target.startsWith(right,i)){
                if(stack.isEmpty()||!stack.pop().equals(left)){
                    return "语法错误，i="+i+",多余"+right;
                }
                i+=right.length();
            }
        }
        return (stack.isEmpty())?"匹配":"语法错误，i"+i+",缺少"+right;
    }
    public static void main(String[] args) {
        String target="if1+2else*3+4";
        String left="if";
        String right="else";
        System.out.println(Match.check(target,left,right));
    }
}
