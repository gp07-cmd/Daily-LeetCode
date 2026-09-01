class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr = head;
        int n = 0;
        while(curr != null) {
            ++n;
            curr = curr.next;
        }

        int[] mask = new int[n];
        int currNode = 1;

        ListNode prev = head;
        ListNode current = head.next;
        ListNode nextNode = head.next.next;

        while(nextNode != null) {
            int n1 = prev.val;
            int n2 = current.val;
            int n3 = nextNode.val;
            if((n2 < n1 && n2 < n3) || (n2 > n1 && n2 > n3)) {
                mask[currNode] = 1;
            }
            ++currNode;
            prev = current;
            current = nextNode;
            nextNode = nextNode.next;
        }

        int first = -1;
        int previous = -1;

        int min = Integer.MAX_VALUE;
        int max = -1;
        for(int i=0; i<n; i++) {
            if(mask[i] == 1) {
                if(first == -1) {
                    first = i;
                } 
                else {
                    min = Math.min(min, i - previous); 
                    max = i - first; 
                }
                previous = i;
            }
        }

        if(first == -1 || first == previous) {
            return new int[]{-1, -1}; 
        }

        return new int[]{ min, max }; 
    }
}