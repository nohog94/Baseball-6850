public class Game {
    public String question;

    public GuessResult guess(String guessNumber) {
        assertIllegalArgument(guessNumber);
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            char c = question.charAt(i);
            if (c == guessNumber.charAt(i)) {
                strike++;
            } else if (guessNumber.contains(String.valueOf(c))) {
                ball++;
            }
        }
        boolean solved = (strike == 3);
        return new GuessResult(solved, strike, ball);
    }

    private static void assertIllegalArgument(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char number : guessNumber.toCharArray()) {
            if (number < '0' || number > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (isDuplicatedNumber(guessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicatedNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(2) == guessNumber.charAt(1)
                || guessNumber.charAt(0) == guessNumber.charAt(2);
    }
}
