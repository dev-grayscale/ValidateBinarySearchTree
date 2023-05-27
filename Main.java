import java.util.ArrayList;
import java.util.List;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 *
 * By definition, a BST holds true when left nodes < root < or <= right nodes (these properties were used here as well: <link>minimum-height-bst</link>).
 * We'll assume that empty tree is a valid BST.
 */
public class Main {
  /**
   * The first solution will use one of the most common traversal methods: <link>BinarySearchTreeTraversal#in-order</link> which should visit the nodes
   * starting from the leftmost node, then parent, then right, etc... Following that order, if the tree is BST - the end collection should be sorted.
   * So, once traversed, we only need to verify the collection order.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public static boolean validateBSTV1(Node node) {
    List<Integer> elements = new ArrayList<>();

    inOrderV1(node, elements);

    for (int i = 0; i < elements.size() - 1; i++) {
      if (elements.get(i) >= elements.get(i + 1)) {
        return false;
      }
    }

    return true;
  }

  private static void inOrderV1(Node node, List<Integer> elements) {
    if (node == null) {
      return;
    }

    inOrderV1(node.left, elements);

    elements.add(node.value);

    inOrderV1(node.right, elements);
  }

  /**
   * Another more optimal solution could be achieved if we don't store the elements in any data structure but validate as we recurse.
   * For this to happen, we'll make slight modification for the in-order traversal algorithm to compare the current value with the previous one.
   * If at any point, the previous is bigger or equal to the current -> invalid, after which any further comparisons are terminated.
   *
   * Realizing this would require an object that will hold the two properties: previous & valid, so we can update and have their latest state throughout the whole
   * recursion. It has the following structure:
   *
   * static class BSTState {
   *   int previous = Integer.MIN_VALUE;
   *   boolean valid = true;
   * }
   *
   * <info>
   *  1. Primitive types are stored in Stack memory while objects are stored in Heap.
   *  2. Stack is short-lived, while heap - long-lived.
   *  3. Data is held within the stack as long as the owning frame is alive.
   *  4. Data is held within the heap as long as it's not collected by the garbage collector (GC).
   *  5. GC will only collect it once there are no references to it.
   *  6. You can access stack data as long as you're in the concrete context/frame.
   *  7. You can access heap data from everywhere, as long as you have reference to it.
   *
   *  Note: Given the specific context, what we wrote above might not hold true for each case.
   *  </info>
   *
   *  Time Complexity: O(n)
   *  Space Complexity: O(log n)
   */
  public static boolean validateBSTV2(Node node) {
    BSTState state = new BSTState();

    inOrderV2(node, state);

    return state.valid;
  }

  private static void inOrderV2(Node node, BSTState state) {
    if (node == null || !state.valid) {
      return;
    }

    inOrderV2(node.left, state);

    if (state.previous >= node.value) {
      state.valid = false;
    }

    state.previous = node.value;

    inOrderV2(node.right, state);
  }

  static class BSTState {
    int previous = Integer.MIN_VALUE;
    boolean valid = true;
  }

  /**
   * Entry point with a widest possible range
   *
   * Time Complexity: O(n)
   * Space Complexity: O(log n)
   */
  public static boolean validateBSTV3(Node node) {
    return validateBSTV3(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  /**
   * This solution recursively checks if each node satisfies the conditions of a BST,
   * considering the range of valid values for each node based on its ancestors.
   *
   * Hmm, a solution that progressively shortens the scope of the visited elements?
   * Very similar to what we did in <link>BinarySearch</link> but using an array!
   */
  private static boolean validateBSTV3(Node node, int min, int max) {
    if (node == null) {
      return true;
    }

    // If the node's value is outside the valid range, it's not a binary search tree
    if (node.value < min || node.value > max) {
      return false;
    }

    // Recursively check the left and right subtrees with updated ranges
    return validateBSTV3(node.left, min, node.value - 1) && validateBSTV3(node.right, node.value + 1, max);
  }
}
