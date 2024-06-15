package com.tegareyn.algorithm.leetcode.backtrack;



import java.util.*;

/**
 * 描述：重新安排行程
 *
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 *
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 * @author mocheng
 * @version 1.0
 * @see LT332
 * @since 2024/3/25 13:52
 **/
public class LT332 {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","KUL"));
        tickets.add(Arrays.asList("JFK","NRT"));
        tickets.add(Arrays.asList("NRT","JFK"));
        System.out.println(findItinerary(tickets));
    }
    static Map<String, PriorityQueue<String>> trips = new HashMap<>();
    static List<String> travels = new ArrayList<>();
    public static List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!trips.containsKey(from)) {
                trips.put(from, new PriorityQueue<>());
            }
            trips.get(from).offer(to);
        }
        travelDesign("JFK");
        Collections.reverse(travels);
        return travels;
    }

    public static void travelDesign(String from) {
        while (trips.containsKey(from) && trips.get(from).size() > 0) {
            String tmp = trips.get(from).poll();
            travelDesign(tmp);
        }
        travels.add(from);
    }

}
