package listTwo;

import java.util.Objects;

public class Termx implements Comparable<Termx>, Addible<Termx> {

    protected int coef;
    protected int xexp;

    public Termx(int coef, int xexp) {
        this.coef = coef;
        this.xexp = xexp;
    }

    public Termx(Termx term) {
        this(term.coef, term.xexp);
    }

    public Termx(String termstr) {
        if (termstr != "") {
            int x = termstr.indexOf("x");
            int mark = termstr.indexOf("^");
            String conef = "";
            String xexf = "";
            if (x != -1) {
                conef = termstr.substring(0, x);
                if (mark != -1) {
                    xexf = termstr.substring(x + 2, termstr.length());
                } else {
                    xexf = "1";
                }

                if (conef.equals("-")) {
                    conef = "-1";
                } else if (conef.equals("")) {
                    conef = "1";
                }
            }
            if (x == -1) {
                conef = termstr.substring(0);
                xexf = "0";
            }
            this.coef = Integer.parseInt(conef);
            this.xexp = Integer.parseInt(xexf);
        }
    }

    public String toString() {
        String term = "";
        if (coef != 0) {
            if (xexp != 0) {
                if(coef==1){
                    term+="x";
                }else if(coef==-1){
                    term+="-x";
                }else{
                    term+=coef+"x";
                }
                if(xexp!=1){
                    term+="^"+xexp;
                }
            } else {
                term += coef;
            }
        } else {
            term = "";
        }
        return term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Termx termx = (Termx) o;
        return coef == termx.coef && xexp == termx.xexp;
    }

    @Override
    public int compareTo(Termx o) {
        return this.xexp-o.xexp;
    }

    @Override
    public void add(Termx tobj) {
        if(this.xexp==tobj.xexp){
            this.coef=this.coef+tobj.coef;
        }
    }
    @Override
    public boolean removable() {
        if(this.coef==0){
            return true;
        }else{
            return false;
        }
    }
}
