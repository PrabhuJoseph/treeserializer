package com.treeserialize;

import com.arrayserialize.ArraySerializer;
import com.arrayserialize.ArraySerializerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class TreeSerializer {

  private ArraySerializer arraySerializer;

  public TreeSerializer(ArraySerializer arraySerializer) {
    this.arraySerializer = arraySerializer;
  }

  // Node Structure within Tree
  static class Node {
    Node left;
    Node right;
    int data;

    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  /*
   Serializer Logic:
   1. Convert Tree to int[] using Level Order Traversal
   2. Serailize int[] using Kryo Serializer
   */
  public void serialize(Node root) throws IOException  {
    ArrayList<Integer> treeElements = getLevelOrderTraversal(root);

    int[] arr = new int[treeElements.size()];
    for (int i=0; i<treeElements.size(); i++) {
      arr[i] = treeElements.get(i);
    }

    arraySerializer.serialize(arr);
  }

  /*
  Deserializer Logic:
  1. Deserialize int[] using Kryo Serializer
  2. Convert to Tree from int[] using Level Order Traversal
  */
  public Node deserialize() throws Exception {
    int[] arr = arraySerializer.deserialize();

    if (arr[0] !=-1) {
      int i=0;
      Node root = new Node(arr[i++], null, null);
      LinkedList<Node> queue = new LinkedList();
      queue.add(root);
      while (queue.size() > 0) {
        Node cur = queue.poll();
        if (cur != null) {
          Node left = null;
          int leftVal = arr[i++];
          if (leftVal != -1) {
            left = new Node(leftVal, null, null);
          }
          cur.left = left;
          queue.add(left);

          Node right = null;
          int rightVal = arr[i++];
          if (rightVal != -1) {
            right = new Node(rightVal, null, null);
          }
          cur.right = right;
          queue.add(right);
        }
      }
      return root;
    } else {
      return null;
    }
  }

  private ArrayList<Integer> getLevelOrderTraversal(Node root) {
    ArrayList<Integer> treeElements = new ArrayList();
    LinkedList<Node> queue = new LinkedList();

    queue.add(root);

    while(queue.size() > 0) {
      Node node = queue.poll();
      if (node == null) {
        treeElements.add(-1);
      } else {
        treeElements.add(node.data);
        queue.add(node.left);
        queue.add(node.right);
      }
    }
    return treeElements;
  }

  private void printTree(Node root) {
    ArrayList<Integer> treeElements = this.getLevelOrderTraversal(root);
    for (int x: treeElements) {
      System.out.print(x + "\t");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    /* Input Tree
                1
            2        3
        4      5  -1   -1
     -1 -1  -1 -1
    */
    Node five = new Node(5, null, null);
    Node four = new Node(4, null, null);
    Node three = new Node(3, null, null);
    Node two = new Node(2, four, five);
    Node root = new Node(1, two, three);

    ArraySerializer arraySerializer = ArraySerializerFactory.getInstance("kryo");
    TreeSerializer serializer = new TreeSerializer(arraySerializer);

    System.out.println("Tree Before Serialize:");
    serializer.printTree(root);
    serializer.serialize(root);

    System.out.println("Tree After Deserialize:");
    Node newRoot = serializer.deserialize();
    serializer.printTree(newRoot);
  }
}
