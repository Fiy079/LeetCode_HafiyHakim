class Solution {
    static char initial(String logs){
        String[] word = logs.split(" ");
        char initial = word[1].charAt(0);
        return initial;
    }
    static int compare(String log1, String log2) {
        String[] content1 = log1.split(" ", 2);
        String[] content2 = log2.split(" ", 2);
        return content1[1].compareTo(content2[1]);
    }

    static int compareIdentifier(String log1, String log2) {
        String[] content1 = log1.split(" ", 2);
        String[] content2 = log2.split(" ", 2);
        return content1[0].compareTo(content2[0]);
    }


    public String[] reorderLogFiles(String[] logs) {
        int length = logs.length;
        int l = 0;
        int n = 0;

        
        for(int i = 0; i<length; i++){
            if(Character.isLetter(initial(logs[i]))){
                l++;
            }else{
                n++;
            }
        }

        String[] letter = new String[l];
        String[] number = new String[n];            
        int s = 0;
        int k = 0;

        for(int i = 0;i<length;i++){

            if(Character.isLetter(initial(logs[i]))){
                letter[s] = logs[i];
                s++;
            }else{
                number[k] = logs[i];
                k++;
            }
        }
        for (int j = 0; j < letter.length; j++) {
            for (int i = 1; i < letter.length; i++) {
                if (compare(letter[i - 1], letter[i]) > 0) {
                    String temp = letter[i];
                    letter[i] = letter[i-1];
                    letter[i-1] = temp;
                }else if (compare(letter[i - 1], letter[i]) == 0){
                    if(compareIdentifier(letter[i - 1], letter[i]) > 0){
                        String temp = letter[i];
                        letter[i] = letter[i-1];
                        letter[i-1] = temp;
                    }
                }
            }
        }


        for(int i = 0; i<letter.length;i++){
           logs[i] = letter[i];
        }
        int z = 0;
        for(int i = letter.length; i<length;i++){
            logs[i] = number[z];
            z++;
        }

        return logs;
    }
}
