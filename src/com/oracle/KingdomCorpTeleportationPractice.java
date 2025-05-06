package com.oracle;

import java.util.*;

/**
 * @author RoySinaga
 * @created 06/05/2025 - 11:36
 * @project algorithm
 */
public class KingdomCorpTeleportationPractice {

    static class Node implements Comparable<Node> {

        int index;
        int maxJump;

        Node(int index, int maxJump){
            this.index = index;
            this.maxJump = maxJump;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.maxJump,other.maxJump);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test

        while(t-- > 0) {
            int n = sc.nextInt(); // number of new portal
            int a = sc.nextInt(); // power  level of first existing portal
            int b = sc.nextInt(); //power level of second existing portal

            int[] destinationPortals = new int[n];
            Set<Integer> portalSet = new HashSet<>();
            portalSet.add(a);
            portalSet.add(b);

           for(int i=0;i<n;i++){
               destinationPortals[i]= sc.nextInt();
               portalSet.add(destinationPortals[i]);
           }

         // sort and map portals powert level
           List<Integer> portalList = new ArrayList<>(portalSet);
           Collections.sort(portalList);
           Map<Integer,Integer> powerToIndex = new HashMap<>();
           for(int i=0;i< portalList.size();i++){
              powerToIndex.put(portalList.get(i),i);
           }

           int total = portalList.size();
           int[] minProtection = new int[total];
           Arrays.fill(minProtection,Integer.MAX_VALUE);

          PriorityQueue<Node> queue = new PriorityQueue<>();

          // start both from source portal
            int indexA = powerToIndex.get(a);
            int indexB = powerToIndex.get(b);
            minProtection[indexA]=0;
            minProtection[indexB]=0;
            queue.offer(new Node(indexA,0));
            queue.offer(new Node(indexB,0));

            //Djikstra Algorithm
             while(!queue.isEmpty()){
                 Node current  = queue.poll();
                 int idx = current.index;
                 int currPower = portalList.get(idx);
                 int curMax = current.maxJump;

                 if(curMax > minProtection[idx]){
                     continue;
                 }

                for(int dir = -1;dir <=1;dir += 2){
                    int neighborIdx = idx+ dir;
                    if(neighborIdx < 0 || neighborIdx>=total) {
                        continue;
                    }
                    int neighborPower = portalList.get(neighborIdx);
                    int jump = Math.abs(neighborPower - currPower);
                    int maxJump = Math.max(curMax, jump);

                    if(maxJump < minProtection[neighborIdx]){
                        minProtection[neighborIdx] = maxJump;
                        queue.offer(new Node(neighborIdx,maxJump));
                    }


                }

             }

            StringBuilder result = new StringBuilder();
            for(int power : destinationPortals){
                int idx = powerToIndex.get(power);
                result.append(minProtection[idx]).append(" ");
            }
           System.out.println(result.toString().trim());

        }
        sc.close();




        // Output result



        }
}
