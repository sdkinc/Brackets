import java.util.ArrayDeque;
import java.util.Deque;

public class CollectionsComplexity {

  public static void main(String[] args) {

    String str = "(((<<";
    System.out.println(checkBrackets(str));
  }

  public static boolean checkBrackets(String brackets) {
    Deque<Character> openedBrackets = new ArrayDeque<>();
    if(brackets.isEmpty()){
      return true;
    }
    for (int i = 0; i < brackets.length(); i++) {
      char c = brackets.charAt(i);
      switch (c) {
        case '(':
        case '{':
        case '<':
        case '[': {
          openedBrackets.offerLast(c);
          break;
        }
        case ')':
        case '}':
        case ']':
        case '>': {
          Character opened = openedBrackets.pollLast();
          if (opened == null || opened.equals(c)) {
            return false;
          }
        }
        default:
          break;
      }
    }
    return openedBrackets.isEmpty();
  }
}
