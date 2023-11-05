public class Main {

    public static void main(String[] args) {
        String login = "my_login123";
        String password = "my_password123";
        String confirmPassword = "my_password123";

        try {
            boolean isCredentialsValid = validateCredentials(login, password, confirmPassword);
            System.out.println("Credentials are valid: " + isCredentialsValid);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static boolean validateCredentials(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        try {
            if (!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Invalid login");
            }

            if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Invalid password");
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static class WrongLoginException extends Exception {
        public WrongLoginException() {
            super();
        }

        public WrongLoginException(String message) {
            super(message);
        }
    }

    static class WrongPasswordException extends Exception {
        public WrongPasswordException() {
            super();
        }

        public WrongPasswordException(String message) {
            super(message);
        }
    }
}

