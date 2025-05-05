package com.oracle;

/**
 * @author RoySinaga
 * @created 04/05/2025 - 16:39
 * @project algorithm SAMSUNG SRIN interview sample
 */
import java.util.*;

public class KingdomCorpTeleportation {

    static class Node implements Comparable<Node> {
        int index;
        int maxJump;

        Node(int index, int maxJump) {
            this.index = index;
            this.maxJump = maxJump;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.maxJump, other.maxJump);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // number of new portals
            int a = sc.nextInt(); // power level of first existing portal
            int b = sc.nextInt(); // power level of second existing portal

            int[] destinationPortals = new int[n];
            Set<Integer> portalSet = new HashSet<>();
            portalSet.add(a);
            portalSet.add(b);

            for (int i = 0; i < n; i++) {
                destinationPortals[i] = sc.nextInt();
                portalSet.add(destinationPortals[i]);
            }

            // Sort and map portal power levels
            List<Integer> portalList = new ArrayList<>(portalSet);
            Collections.sort(portalList);
            Map<Integer, Integer> powerToIndex = new HashMap<>();
            for (int i = 0; i < portalList.size(); i++) {
                powerToIndex.put(portalList.get(i), i);
            }

            int total = portalList.size();
            int[] minProtection = new int[total];
            Arrays.fill(minProtection, Integer.MAX_VALUE);

            PriorityQueue<Node> queue = new PriorityQueue<>();

            // Start from both source portals
            int indexA = powerToIndex.get(a);
            int indexB = powerToIndex.get(b);
            minProtection[indexA] = 0;
            minProtection[indexB] = 0;
            queue.offer(new Node(indexA, 0));
            queue.offer(new Node(indexB, 0));

            // Dijkstra's algorithm
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                int idx = current.index;
                int currPower = portalList.get(idx);
                int currMax = current.maxJump;

                if (currMax > minProtection[idx]) {
                    continue;
                }

                for (int dir = -1; dir <= 1; dir += 2) {
                    int neighborIdx = idx + dir;
                    if (neighborIdx < 0 || neighborIdx >= total) {
                        continue;
                    }
                    int neighborPower = portalList.get(neighborIdx);
                    int jump = Math.abs(neighborPower - currPower);
                    int maxJump = Math.max(currMax, jump);

                    if (maxJump < minProtection[neighborIdx]) {
                        minProtection[neighborIdx] = maxJump;
                        queue.offer(new Node(neighborIdx, maxJump));
                    }
                }
            }

            // Output result
            StringBuilder result = new StringBuilder();
            for (int power : destinationPortals) {
                int idx = powerToIndex.get(power);
                result.append(minProtection[idx]).append("    ");
            }
            System.out.println(result.toString().trim());
        }
        sc.close();
    }
}

//sample input
//        2
//                5 2 11
//                8 4 14 1 13
//                12 5 15
//                16 18 4 9 5 10 6 13 1 0 19 1

//sample output
// 3 2 2 1 2
//         1 2 1 3 0 3 1 2 3 3 2 3

//    How It Works
//        Each portal is a node.
//
//        Edges exist between adjacent portals in sorted list, with cost = |x - y|.
//
//        Using Dijkstra's algorithm, we find paths that minimize the largest jump, which represents the minimum suit protection level required.
//

//✅ Problem Breakdown
//        You're given:
//
//        Two source portals (with power levels a and b).
//
//        Several new destination portals (each with some power level).
//
//        A teleportation suit allows you to teleport from portal x to y if |x - y| <= k, where k is the protection level of the suit.
//
//        The scientist may go through any number of intermediate portals to reach the destination.
//
//        You must find the minimum value of k that allows each destination portal to be reached from either a or b.
//
//        This is essentially a graph problem where each node is a portal (power level), and you can move from portal x to y if |x - y| <= k. Your task is to find the minimum k needed to reach a given destination from a or b.
//
//        ✅ Efficient Strategy
//        Sort all portals (including the two sources).
//
//        Model the portals as a graph where you can teleport between adjacent portals in the sorted list.
//
//        Use Dijkstra’s algorithm with a twist: cost between adjacent portals is the absolute difference in power level.
//
//        Start Dijkstra from both a and b.
//
//        For each target portal, find the minimum maximum jump required to reach it.