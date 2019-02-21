package podstawowa;

public class Task {
  
  public int solution(String S) {
    int count = 0;
    int l = S.length();
    if (S.length() == 1){
      return 0;
    }
    int i = 0;
    while (S.charAt(i)==S.charAt(l-i-1) && (i != l-i-1)){
      count++;
      i++;
    }
    return count;
  }

  public static void main(String[] args) {
    Task t = new Task();
    System.out.println(t.solution("RACECAR"));
  }
}
