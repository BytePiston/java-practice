package dsa_problems;

/**
 * In a tournament teams are marked from a to z. We are given a sequence of wining teams in a tournament.
 * Find the team with just one win in he entire tournament and return its index.
 * If there are multiple such teams return the one with first occurrence in the string.
 * If there are no such teams return -1;
 */
public class FindTeamWithOneWin {
    public static int findTeamWithOneWin(String sequence) {
        int[] winCounts = new int[26]; // Array to store the win counts of each team

        for (int i = 0; i < sequence.length(); i++) {
            char team = sequence.charAt(i);
            winCounts[team - 'a']++; // Increment the win count of the corresponding team
        }

        for (int i = 0; i < sequence.length(); i++) {
            char team = sequence.charAt(i);
            if (winCounts[team - 'a'] == 1) {
                return i; // Return the index of the first team with one win
            }
        }

        return -1; // No team with one win found
    }

    public static void main(String[] args) {
        String sequence = "acabsecs"; // Example sequence of winning teams

        int index = findTeamWithOneWin(sequence);

        if (index != -1) {
            char team = sequence.charAt(index);
            System.out.println("Team " + team + " has just one win at index " + index);
        } else {
            System.out.println("No team with just one win found.");
        }
    }
}
