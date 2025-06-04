public class Game {
    public void guess(String guessNumber) {
        if ( guessNumber == null){
            throw new IllegalArgumentException("Input cannot be null");
        }
        if(guessNumber.length() != 3){
            throw new IllegalArgumentException("Input length must be 3");
        }

        for(char number : guessNumber.toCharArray()){
            if(number < '0' || number > '9');
        }
    }
}
