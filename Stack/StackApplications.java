package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackApplications {
  String text; 
  public StackApplications(String text){
    this.text = text;
  }
  public StringBuffer reverse(){
    
    var stack = new Stack<Character>();
    // stack.
    var revered  = new StringBuffer();
    for( int i =0; i< text.length(); i++){
      var c = text.charAt(i);
      stack.push(c);
    }
    while (!stack.empty()){
      revered.append(stack.pop());
    }
    return revered;
  }
  public boolean checkExpression() {
    var blocks = new ArrayList<List<String>>();
    var squareBrackets = Arrays.asList("[", "]");
    var braces = Arrays.asList("(", ")");
    var triangleBrackets = Arrays.asList("<", ">");
    blocks.add(squareBrackets);
    blocks.add(braces);
    blocks.add(triangleBrackets);

    var stack = new Stack<Character>();
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      for (var block : blocks) {
        if (String.valueOf(c).equals(block.get(0))) {
          stack.push(c);
        } else if (String.valueOf(c).equals(block.get(1))) {
          if (stack.isEmpty() || !String.valueOf(stack.peek()).equals(block.get(0))) {
            return false;
          }
          stack.pop();
        }
      }
    }
    return stack.isEmpty();
  }
}
