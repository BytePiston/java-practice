package dynamicProgramming;

/**
 * Problem Statement:
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
 * <p>
 * Choosing any x with 0 < x < n and n % x == 0.
 * Replacing the number n on the chalkboard with n - x.
 * Also, if a player cannot make a move, they lose the game.
 * <p>
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * <p>
 * Example 2:
 * Input: n = 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 */
public class DivisorGame {

    /*
     *who ever has the even number of left wins. i.e. if the number is odd then alice has to pick 1 to make it
     * even for bob to win it and if n is even then alice wins since it will be divisible by 2.
     * */
    public boolean divisorGame(int n){
        return (n%2==0);
    }
}
