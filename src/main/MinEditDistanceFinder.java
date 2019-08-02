package main;

public class MinEditDistanceFinder {
	
	public int findEditDistance(String str1, String str2) {
		if (str1 == str2) { // This saves time.
			return 0;
		}
		
		/* An nxm matrix is initialized with n and m being the
		 * lengths of the first and second strings passed as
		 * arguments.										 */
		int str1_len = str1.length();
		int str2_len = str2.length();
		int[][] D = new int[str1_len+1][str2_len+1];
		
		for (int i = 0; i < str1_len + 1; i++) {
			D[i][0] = i;
		}
		
		for (int i = 0; i < str2_len + 1; i++) {
			D[0][i] = i;
		}
		
		/* For example, for the words "BEEP" and "BOOP":
		 *    /  B  O  O  P
		 * /[[0, 1, 2, 3, 4],
		 * B [1, _, _, _, _],
		 * E [2, _, _, _, _],
		 * E [3, _, _, _, _],
		 * P [4, _, _, _, _]]
		 */
		
		/* Next, we compute the minimum edit distance D(str1, str2)
		 * by computer the minimum edit distance of every element
		 * in the matrix.										 */
		for (int i = 1; i <= str1_len; i++) {
			for (int j = 1; j <= str2_len; j++) {
				
				int d1 = D[i-1][j] + 1;
				int d2 = D[i][j-1] + 1;
				int d3 = D[i-1][j-1];
				if (str1.charAt(i-1) != str2.charAt(j-1)) {
					d3 += 2;
				}
				if ((d1 < d2) && (d1 < d3 )){
					D[i][j] = d1;
				}
				else if ((d2 < d1) && (d2 < d3)) {
					D[i][j] = d2;
				}
				else {D[i][j] = d3;}
			}

		}
		return D[str1_len][str2_len];
	}
}
