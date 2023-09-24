//climb stairs with min moves dp 


import java.io.*;
import java.util.*;

public class dp {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      Integer[] dp = new Integer[n + 1];
      dp[n] = 0;

      for (int i = n - 1; i >= 0; i--) {
         if (arr[i] > 0) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
               if(dp[i + j] != null){
                  min = Math.min(min, dp[i + j]);
               }
            }

            if(min != Integer.MAX_VALUE){
               dp[i] = min + 1;
            }
         }
      }

      System.out.println(dp[0]);
   }

}


                        
package LRU_Cache;

import java.util.HashMap;

public class LRUCache {

	class Node {
		int data;
		int key;
		Node prev;
		Node next;
	}

	static HashMap<Integer, Node> map = new HashMap<>();

	static Node head;
	static Node tail;

	private int total;
	private int maxCap;

	public LRUCache(int cap) {

		total = 0;

		this.maxCap = cap;

		head = new Node();
		head.prev = null;

		tail = new Node();
		tail.next = null;

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {

		Node node = map.get(key);

		Boolean isNull = (node == null);

		if (isNull) {

			return -1;
		}

		moveToHead(node);

		return node.data;

	}

	public void put(int key, int value) {

		Node temp = map.get(key);

		Boolean isNull = (temp == null);

		if (isNull) {

			Node node = new Node();
			node.key = key;
			node.data = value;

			map.put(key, node);

			addNode(node);

			total++;

			if (total > maxCap) {
				removeLRUEntryFromStructure();
			}
		} else {

			temp.data = value;
			moveTohead(temp);

		}
	}

	private void moveTohead(Node node) {
		removeNode(node);
		addNode(node);
	}

	private void removeLRUEntryFromStructure() {
		Node tail = popTail();

		map.remove(tail.key);

		total--;
	}

	private Node popTail() {
		Node itemBeingRemoved = tail.prev;
		removeNode(itemBeingRemoved);
		return itemBeingRemoved;
	}

	private void moveToHead(Node node) {
		removeNode(node);
		addNode(node);
	}

	private void removeNode(Node node) {

		Node myprev = node.prev;
		Node mynext = node.next;

		myprev.next = mynext;
		mynext.prev = myprev;

	}

	private void addNode(Node node) {

		node.prev = head;
		node.next = head.next;

		head.next.prev = node;

		head.next = node;

	}

}

                        


                        
