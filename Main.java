package pack2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("D:\\m.harshitha\\one.csv"));
        StringBuilder sb = new StringBuilder();

        sb.append("Round");
        sb.append(",");
        sb.append("Player1");
        sb.append(",");
        sb.append("Player2");
        sb.append("\r\n");

        ArrayList<String> p1 = new ArrayList<>();
        ArrayList<String> p2 = new ArrayList<>();
        ArrayList<ArrayList<String>> hm=new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            String[] s = {"Head", "Tail"};
            int r1 = r.nextInt(s.length);
            p1.add(s[r1]);
        }
        for (int i = 0; i < 10; i++) {
            String[] s = {"Head", "Tail"};
            int r1 = r.nextInt(s.length);
            p2.add(s[r1]);
        }
        int l1=p1.stream().filter(x->x.equals("Head")).collect(Collectors.toList()).size();
        int l2=p2.stream().filter(x->x.equals("Head")).collect(Collectors.toList()).size();
        for(int i=0;i<=9;i++){
            sb.append("Round"+(i+1));
            sb.append(",");
            sb.append(p1.get(i));
            sb.append(",");
            sb.append(p2.get(i));
            sb.append("\r\n");

        }
        System.out.println(l1);
        System.out.println(l2);
        if(l1==l2){
            sb.append("Draw");

        }
        else{
            String winner;
            winner=(l1>l2)?"Player1":"Player2";
            sb.append(winner);
        }
        pw.write(sb.toString());
        pw.close();
    }
}