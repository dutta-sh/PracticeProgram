public class CrossWord {

    public boolean findWord(char[] word, char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(word[0] == matrix[i][j]) {
                    if(isValid(i+1, j, matrix) && word[1] == matrix[i+1][j] && recur(word, 0, matrix, i, j, 1))
                        return true;
                    if(isValid(i-1, j, matrix) && word[1] == matrix[i-1][j] && recur(word, 0, matrix, i, j, 2))
                        return true;
                    if(isValid(i, j+1, matrix) && word[1] == matrix[i][j+1] && recur(word, 0, matrix, i, j, 3))
                        return true;
                    if(isValid(i, j-1, matrix) && word[1] == matrix[i][j-1] && recur(word, 0, matrix, i, j, 4))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean recur(char[] word, int idx, char[][] matrix, int i, int j, int dir) {
        if(idx == word.length)
            return true;

        if(dir == 1)
            i++;
        if(dir == 2)
            i--;
        if(dir == 3)
            j++;
        if(dir == 4)
            j--;

        if(isValid(i, j, matrix) && word[idx] == matrix[i][j])
            return recur(word, idx+1, matrix, i, j , dir);
        else
            return false;
    }

    public boolean isValid(int i, int j, char[][] matrix) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length;
    }
}
