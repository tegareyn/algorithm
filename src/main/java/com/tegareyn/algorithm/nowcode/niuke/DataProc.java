package com.tegareyn.algorithm.nowcode.niuke;
import java.util.*;

public class DataProc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] l1 = scanner.nextLine().split(" ");
            String[] l2 = scanner.nextLine().split(" ");
            String[] line1 = decorate(l1, 1);
            String[] line2 = decorate(l2, 1);
            Map<String, List<Integer>> map = new LinkedHashMap<>();
            List<String> var1 = Arrays.asList(line1);
            List<String> var2 = Arrays.asList(line2);
            Set<String> set = new TreeSet<>(var2);
            var2 = new ArrayList<>(set);
            Collections.sort(var2, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.parseInt(o1) - Integer.parseInt(o2);
                }
            });
            for (String s : var2) {
                List<Integer> list = map.get(s);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(s, list);
                }
                for (int i = 0; i < var1.size(); i++) {
                    String s1 = var1.get(i);
                    if (s1.contains(s)) {
                        list.add(i);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, List<Integer>> m : map.entrySet()) {
                List<Integer> value = m.getValue();
                int size = value.size();
                if(size==0) continue;
                sb.append(m.getKey()).append(",").append(size).append(",").append(p(value, var1)).append(",");

            }
            String result = sb.toString();
            result = result.substring(0, result.endsWith(",")? result.length()-1:0);
            int total = result.split(",").length;
            result = total + "," + result;
            System.out.println(result.replaceAll(",", " "));
        }
    }

    public static String[] decorate(String[] s, int from){
        String[] ss = new String[s.length-from];
        for(int i=from; i<s.length;i++) {
            ss[i-from] = s[i];
        }
        return ss;
    }

    public static String p(List<Integer> i, List<String> s) {
        StringBuilder sb = new StringBuilder();
        for(Integer n: i){
            sb.append(n+",").append(s.get(n)).append(",");
        }
        return sb.toString().substring(0,sb.toString().lastIndexOf(","));
    }
}
