package listTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Polynomial {
    private PolySinglyList<Termx> list;

    public Polynomial(boolean asc) {
        list = new PolySinglyList<>(asc);
    }

    public Polynomial() {
        this(true);
    }

    public Polynomial(Termx[] terms, boolean asc) {
        list = new PolySinglyList<>(terms, asc);
    }

    public Polynomial(String polystr) {
        String[] items = conversion(polystr);
        Termx[] termxes = new Termx[items.length];
        for (int i = 0; i < items.length; i++) {
            termxes[i] = new Termx(items[i]);
        }
        list = new PolySinglyList<>(termxes, true);
    }

    public Polynomial(Polynomial poly) {
        this(poly.list.asc);
        Node<Termx> rear = this.list.head;
        for (Node<Termx> p = poly.list.head.next; p != null; p = p.next) {
            rear.next = new Node<Termx>(new Termx(p.data), null);
            rear = rear.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<Termx> p = this.list.head.next;
        while (p != null) {
            String item = p.data.toString();
            if (!item.startsWith("-")) {
                str.append("+" + item);
            } else {
                str.append(item);
            }
            p = p.next;
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        Node<Termx> p = this.list.head.next;
        Node<Termx> q = that.list.head.next;
        if (this.list.size() == that.list.size()) {
            while (p != null || q != null) {
                if (!p.data.equals(p.data)) {
                    return false;
                }
                p = p.next;
                q = q.next;
            }
        } else {
            return false;
        }
        return true;
    }

    public void addAll(Polynomial poly) {
        this.list.addAll(poly.list);
    }

    public Polynomial union(Polynomial poly) {
        Polynomial thisCopy = new Polynomial(this);
        Polynomial polyCopy = new Polynomial(poly);
        thisCopy.addAll(polyCopy);
        return thisCopy;
    }

    public void multi(Polynomial poly) {
        PolySinglyList<Termx> tempList=null;
        PolySinglyList<Termx> temp = null;
        Termx termx=null;
        Node<Termx> q = poly.list.head.next;
        while (q != null) {
            tempList=new PolySinglyList<>();
            Node<Termx> p = this.list.head.next;
            while (p!= null) {
                termx=new Termx(p.data.coef * q.data.coef,p.data.xexp +q.data.xexp);
                tempList.insert(termx);
                p = p.next;
            }
            if(temp==null){
                temp=new PolySinglyList<>(tempList);
            }else{
                temp.addAll(tempList);
            }
            q = q.next;
        }
        this.list=temp;
    }

    public String[] conversion(String regex) {
        ArrayList<String> items = new ArrayList<>();
        String[] strs = regex.split("[+]");
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            int x = 0;
            while (j < strs[i].length()) {
                j = strs[i].indexOf("-", j + 1);
                if (j != -1) {
                    String item = strs[i].substring(x, j);
                    x = j;
                    items.add(item);
                } else {
                    String item = strs[i].substring(x, strs[i].length());
                    items.add(item);
                    break;
                }
            }
        }
        return items.toArray(new String[items.size()]);
    }
    public static void main(String[] args) {
        String str1 = "2-x+x^2-9x^4+2x^7-7x^9";
        String str2 = "-1+x-x^2+10x^4-3x^8+5x^10+9x^11";
        Polynomial polynomial1 = new Polynomial(str1);
        Polynomial polynomial2 = new Polynomial(str2);
        polynomial1.multi(polynomial2);
        System.out.println(polynomial1.toString());
    }
}
