import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  public void test() {
    Assertions.assertTrue(Main.validateBSTV1(null));
    Assertions.assertTrue(Main.validateBSTV2(null));
    Assertions.assertTrue(Main.validateBSTV3(null));

    Node a = new Node(10);

    /**
     *    10
     */
    Assertions.assertTrue(Main.validateBSTV1(a));
    Assertions.assertTrue(Main.validateBSTV2(a));
    Assertions.assertTrue(Main.validateBSTV3(a));

    Node b = new Node(8);
    a.right = b;

    /**
     *    10
     *       8
     */
    Assertions.assertFalse(Main.validateBSTV1(a));
    Assertions.assertFalse(Main.validateBSTV2(a));
    Assertions.assertFalse(Main.validateBSTV3(a));

    a.right = null;
    a.left = b;

    /**
     *    10
     *  8
     */
    Assertions.assertTrue(Main.validateBSTV1(a));
    Assertions.assertTrue(Main.validateBSTV2(a));
    Assertions.assertTrue(Main.validateBSTV3(a));

    Node c = new Node(11);
    b.right = c;

    /**
     *       10
     *   8
     *     11
     */
    Assertions.assertFalse(Main.validateBSTV1(a));
    Assertions.assertFalse(Main.validateBSTV2(a));
    Assertions.assertFalse(Main.validateBSTV3(a));

    b.right = null;
    a.right = c;

    /**
     *       10
     *   8        11
     */
    Assertions.assertTrue(Main.validateBSTV1(a));
    Assertions.assertTrue(Main.validateBSTV2(a));
    Assertions.assertTrue(Main.validateBSTV3(a));

    Node d = new Node(9);
    c.left = d;

    /**
     *       10
     *   8        11
     *         9
     */
    Assertions.assertFalse(Main.validateBSTV1(a));
    Assertions.assertFalse(Main.validateBSTV2(a));
    Assertions.assertFalse(Main.validateBSTV3(a));

    c.left = null;
    c.right = d;

    /**
     *       10
     *   8        11
     *                9
     */
    Assertions.assertFalse(Main.validateBSTV1(a));
    Assertions.assertFalse(Main.validateBSTV2(a));
    Assertions.assertFalse(Main.validateBSTV3(a));

    c.right = null;
    b.left = d;

    /**
     *        10
     *    8        11
     * 9
     */
    Assertions.assertFalse(Main.validateBSTV1(a));
    Assertions.assertFalse(Main.validateBSTV2(a));
    Assertions.assertFalse(Main.validateBSTV3(a));

    b.left = null;
    b.right = d;

    /**
     *        10
     *    8        11
     *       9
     */
    Assertions.assertTrue(Main.validateBSTV1(a));
    Assertions.assertTrue(Main.validateBSTV2(a));
    Assertions.assertTrue(Main.validateBSTV3(a));

    Node e = new Node(6);
    b.left = e;

    /**
     *         10
     *     8        11
     * 6      9
     */
    Assertions.assertTrue(Main.validateBSTV1(a));
    Assertions.assertTrue(Main.validateBSTV2(a));
    Assertions.assertTrue(Main.validateBSTV3(a));

    Node f = new Node(3);
    e.left = f;

    /**
     *            10
     *        8        11
     *    6      9
     * 3
     */
    Assertions.assertTrue(Main.validateBSTV1(a));
    Assertions.assertTrue(Main.validateBSTV2(a));
    Assertions.assertTrue(Main.validateBSTV3(a));

    Node g = new Node(7);
    e.right = g;

    /**
     *            10
     *        8        11
     *    6      9
     * 3    7
     */
    Assertions.assertTrue(Main.validateBSTV1(a));
    Assertions.assertTrue(Main.validateBSTV2(a));
    Assertions.assertTrue(Main.validateBSTV3(a));

    Node h = new Node(15);
    c.right = h;

    /**
     *            10
     *        8        11
     *    6      9         15
     * 3    7
     */
    Assertions.assertTrue(Main.validateBSTV1(a));
    Assertions.assertTrue(Main.validateBSTV2(a));
    Assertions.assertTrue(Main.validateBSTV3(a));

    Node i = new Node(13);
    h.left = i;

    /**
     *            10
     *        8        11
     *    6      9         15
     * 3    7           13
     */
    Assertions.assertTrue(Main.validateBSTV1(a));
    Assertions.assertTrue(Main.validateBSTV2(a));
    Assertions.assertTrue(Main.validateBSTV3(a));

    Node j = new Node(17);
    h.right = j;

    /**
     *            10
     *        8        11
     *    6      9         15
     * 3    7           13    17
     */
    Assertions.assertTrue(Main.validateBSTV1(a));
    Assertions.assertTrue(Main.validateBSTV2(a));
    Assertions.assertTrue(Main.validateBSTV3(a));

  }
}
